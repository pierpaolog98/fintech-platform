package com.example.transaction_service.controller;

import com.example.transaction_service.dto.TransactionDTO;
import com.example.transaction_service.dto.TransactionResponseDTO;
import com.example.transaction_service.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;


@RestController
@RequestMapping("/transaction")
@RequiredArgsConstructor
public class TransactionController {

    private final TransactionService transactionService;


    @PostMapping("/create")
    public ResponseEntity<TransactionResponseDTO> createTransaction(@RequestBody @Valid TransactionDTO transactionDTO){
        return ResponseEntity.ok(transactionService.createTransaction(transactionDTO));
    }


}
