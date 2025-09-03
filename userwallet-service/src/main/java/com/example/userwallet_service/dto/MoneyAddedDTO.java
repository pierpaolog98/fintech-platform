package com.example.userwallet_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MoneyAddedDTO {

    Long walletId;

    BigDecimal moneyAdded;

}
