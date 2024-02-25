package com.apnaShopping.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserResponseDTO {
    private int id;
    private String customerFName;
    private String customerLname;
    private String dateOfBirth;
    private String phoneNumber;
    private byte[] image;
    private String password;
    private String confirmPassword;
}