package com.example.userwallet_service.service;

import com.example.userwallet_service.dto.UserDTO;
import com.example.userwallet_service.mapper.UserMapper;
import com.example.userwallet_service.model.User;
import com.example.userwallet_service.repository.UserRepository;
import com.example.userwallet_service.repository.WalletRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final WalletRepository walletRepository;
    private final WalletService walletService;


    @Transactional
    public Long createUser(UserDTO userDTO){
        User user = UserMapper.toEntity(userDTO);
        userRepository.save(user);
        walletService.createWallet(user);
        return user.getId();
    }


}
