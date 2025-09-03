package com.example.transaction_service.model;

import com.example.transaction_service.enumeration.TransactionStatus;
import com.example.transaction_service.enumeration.TransactionType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "transaction")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal amount;

    @Enumerated(EnumType.STRING)
    private TransactionType type;  // es. DEPOSIT, TRANSFER, etc.

    @Enumerated(EnumType.STRING)
    private TransactionStatus status; // PENDING, COMPLETED, FAILED

    private Long sourceWallet;

    private Long destinationWallet;

    @CreationTimestamp
    private LocalDateTime createdAt;

    private String description;

}
