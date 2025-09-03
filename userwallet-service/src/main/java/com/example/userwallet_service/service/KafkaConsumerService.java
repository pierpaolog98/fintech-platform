package com.example.userwallet_service.service;

import com.example.userwallet_service.dto.TransactionDTO;
import com.example.userwallet_service.model.Wallet;
import com.example.userwallet_service.repository.WalletRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
public class KafkaConsumerService {

    private final WalletService walletService;

    private final WalletRepository walletRepository;

    private final ObjectMapper objectMapper;


    @KafkaListener(topics = "transaction-completed", groupId = "userwallet-group")
    @Transactional
    public void listen(String event) {
        try {
            TransactionDTO transactionEvent = objectMapper.readValue(event, TransactionDTO.class);
            Wallet sourceWallet = walletRepository.findById(transactionEvent.getSourceWallet()).orElseThrow();
            Wallet destinationWallet = walletRepository.findById(transactionEvent.getDestinationWallet()).orElseThrow();
            sourceWallet.setBalance(sourceWallet.getBalance().subtract(transactionEvent.getAmount()));
            destinationWallet.setBalance(sourceWallet.getBalance().add(transactionEvent.getAmount()));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }


}
