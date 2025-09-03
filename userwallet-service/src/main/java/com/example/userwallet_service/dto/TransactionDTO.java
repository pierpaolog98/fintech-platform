package com.example.userwallet_service.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransactionDTO {

    private BigDecimal amount;

    //private TransactionType type;

    //private TransactionStatus status;

    private Long sourceWallet;

    private Long destinationWallet;

    private String description;

}
