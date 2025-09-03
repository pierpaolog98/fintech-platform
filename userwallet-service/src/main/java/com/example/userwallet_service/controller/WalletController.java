package com.example.userwallet_service.controller;

import com.example.userwallet_service.dto.MoneyAddedDTO;
import com.example.userwallet_service.service.WalletService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;




@RestController
@RequestMapping("wallet")
@RequiredArgsConstructor
public class WalletController {

    private final WalletService walletService;

    /*
    @PatchMapping("add")
    public ResponseEntity<String> addWalletMoney(@RequestBody @Valid MoneyAddedDTO moneyAddedDTO) {
        walletService.addMoneyToWallet(moneyAddedDTO);
        return ResponseEntity.ok("Money added");
    }*/



}
