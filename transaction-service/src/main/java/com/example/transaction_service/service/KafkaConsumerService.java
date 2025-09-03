package com.example.transaction_service.service;

import com.example.transaction_service.dto.WalletCreatedDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.kafka.annotation.KafkaListener;

import java.math.BigDecimal;


@Service
@RequiredArgsConstructor
public class KafkaConsumerService {


    private final WalletService walletService;

    private final ObjectMapper objectMapper;


    @KafkaListener(topics = "wallet-created", groupId = "transaction-group")
    @Transactional
    public void listen(String event) {
        try {
            WalletCreatedDTO walletEvent = objectMapper.readValue(event, WalletCreatedDTO.class);
            Long walletId = walletEvent.getWalletId();
            BigDecimal balance = walletEvent.getBalance();
            walletService.completePendingWallet(walletId, balance);
        } catch (Exception e){
            e.printStackTrace();
        }
    }


}
