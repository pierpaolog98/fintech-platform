package com.example.transaction_service.service;


import com.example.transaction_service.dto.NotificationDTO;
import com.example.transaction_service.dto.TransactionDTO;
import com.example.transaction_service.dto.TransactionResponseDTO;
import com.example.transaction_service.enumeration.NotificationType;
import com.example.transaction_service.enumeration.TransactionStatus;
import com.example.transaction_service.mapper.TransactionMapper;
import com.example.transaction_service.model.Transaction;
import com.example.transaction_service.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class TransactionService {

    private final TransactionRepository transactionRepository;

    private final WalletService walletService;

    private final KafkaProducerService kafkaProducerService;


    @Transactional
    public TransactionResponseDTO createTransaction(TransactionDTO transactionDTO){
        Transaction transaction = TransactionMapper.toEntity(transactionDTO);
        transaction.setStatus(TransactionStatus.PENDING);
        walletService.getBalance(transactionDTO.getSourceWallet());
        transactionRepository.save(transaction);
        try {
            if (transaction.getAmount().compareTo(BigDecimal.ZERO) > 0) {
                transaction.setStatus(TransactionStatus.COMPLETED);
                kafkaProducerService.sendMessage("transaction-completed", transactionDTO);
                kafkaProducerService.sendMessage("notification-event", new NotificationDTO(NotificationType.TRANSACTION_COMPLETED));
            } else {
                transaction.setStatus(TransactionStatus.FAILED);
            }
        } catch (Exception e) {
            transaction.setStatus(TransactionStatus.FAILED);
        }
        transactionRepository.save(transaction);
        return new TransactionResponseDTO(transaction.getId());
    }


}
