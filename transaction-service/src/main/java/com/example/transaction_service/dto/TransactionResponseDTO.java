package com.example.transaction_service.dto;

import com.example.transaction_service.enumeration.TransactionStatus;
import com.example.transaction_service.enumeration.TransactionType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransactionResponseDTO {

    private Long id;
    //private BigDecimal amount;
    //private TransactionType type;
    //private TransactionStatus status;
    //private Long sourceWalletId;
    //private Long destinationWalletId;
    //private LocalDateTime createdAt;
    //private String description;

}
