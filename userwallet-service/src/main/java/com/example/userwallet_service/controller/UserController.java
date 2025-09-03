package com.example.userwallet_service.controller;

import com.example.userwallet_service.dto.UserDTO;
import com.example.userwallet_service.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
@RequiredArgsConstructor
public class UserController {


    private final UserService userService;


    @PostMapping("/create")
    public ResponseEntity<Long> createUser(@RequestBody @Valid UserDTO userDTO){
        Long id = userService.createUser(userDTO);
        return ResponseEntity.ok(id);
    }


}
