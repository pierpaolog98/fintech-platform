package com.example.userwallet_service.service;


import com.example.userwallet_service.dto.MoneyAddedDTO;
import com.example.userwallet_service.dto.NotificationDTO;
import com.example.userwallet_service.enumeration.NotificationType;
import com.example.userwallet_service.model.User;
import com.example.userwallet_service.model.Wallet;
import com.example.userwallet_service.repository.WalletRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class WalletService {


    private final WalletRepository walletRepository;

    private final KafkaProducerService kafkaProducerService;

    private final ObjectMapper objectMapper;


    public Wallet createWallet(User user) {
        Wallet wallet = new Wallet(user, BigDecimal.ZERO);
        walletRepository.save(wallet);
        System.out.println("Wallet: " + wallet);
        try {
            kafkaProducerService.sendMessage("wallet-created",wallet);
            kafkaProducerService.sendMessage("notification-event", new NotificationDTO(NotificationType.WALLET_CREATED));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return wallet;
    }


    @Transactional
    public void updateWallet(Long walletId, BigDecimal balance) {
        Wallet wallet = walletRepository.findById(walletId).orElseThrow();
        wallet.setBalance(balance);
        walletRepository.save(wallet);
    }


    @Transactional
    public void addMoneyToWallet(MoneyAddedDTO moneyAddedDTO) {
        Wallet wallet = walletRepository.findById(moneyAddedDTO.getWalletId()).orElseThrow();
        wallet.setBalance(wallet.getBalance().add(moneyAddedDTO.getMoneyAdded()));/*
        WalletUpdatedEvent walletUpdatedEvent = new WalletUpdatedEvent(wallet.getWalletId(), wallet.getBalance());
        try {
            String walletUpdatedEventJson = objectMapper.writeValueAsString(walletUpdatedEvent);
            kafkaProducerService.sendMessage("money-added-update", walletUpdatedEventJson);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }*/
    }


}
