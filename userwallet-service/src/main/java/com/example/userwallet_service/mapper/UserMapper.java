package com.example.userwallet_service.mapper;

import com.example.userwallet_service.dto.UserDTO;
import com.example.userwallet_service.model.User;
import org.modelmapper.ModelMapper;


public class UserMapper {

    public static User toEntity(UserDTO userDTO){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(userDTO, User.class);
    }

}
