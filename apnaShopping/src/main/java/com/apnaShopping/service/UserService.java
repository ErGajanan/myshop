package com.apnaShopping.service;

import com.apnaShopping.dto.UserRequestDTO;
import com.apnaShopping.dto.UserResponseDTO;
import com.apnaShopping.entity.User;
import com.apnaShopping.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepo userRepo;
    public UserResponseDTO createUser(UserRequestDTO userRequestDTO) {
        User user = new User();
        user.setCustomerfname(userRequestDTO.getCustomerFName());
        user.setCustomerlname(userRequestDTO.getCustomerLname());
        user.setDateofbirth(userRequestDTO.getDateOfBirth());
        user.setPhonenumber(userRequestDTO.getPhoneNumber());
        user.setPassword(userRequestDTO.getPassword());
        user.setConfirmpassword(userRequestDTO.getConfirmPassword());
        userRepo.save(user);
        UserResponseDTO userResponseDTO=new UserResponseDTO();
        userResponseDTO.setId(user.getId());
        userResponseDTO.setCustomerFName(user.getCustomerfname());
        userResponseDTO.setCustomerLname(user.getCustomerlname());
        userResponseDTO.setDateOfBirth(user.getDateofbirth());
        userResponseDTO.setPhoneNumber(user.getPhonenumber());
        userResponseDTO.setPassword(user.getPassword());
        return userResponseDTO;
    }
}
