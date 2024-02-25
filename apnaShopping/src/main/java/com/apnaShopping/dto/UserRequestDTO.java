package com.apnaShopping.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserRequestDTO {
    private String customerFName;
    private String customerLname;
    private String dateOfBirth;
    private String phoneNumber;
    private String password;
    private String confirmPassword;
}