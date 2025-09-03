package com.example.transaction_service.mapper;

import com.example.transaction_service.dto.TransactionDTO;
import com.example.transaction_service.model.Transaction;
import org.modelmapper.ModelMapper;

public class TransactionMapper {


    public static Transaction toEntity(TransactionDTO transactionDTO){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(transactionDTO, Transaction.class);
    }

}
