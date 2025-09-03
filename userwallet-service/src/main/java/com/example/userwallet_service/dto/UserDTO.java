package com.example.userwallet_service.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    @NotNull
    private String name;

    @NotNull
    private String surname;

    @Email
    private String email;

    @NotNull
    private String password;

}
