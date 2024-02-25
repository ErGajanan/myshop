package com.apnaShopping.controller;

import com.apnaShopping.dto.UserRequestDTO;
import com.apnaShopping.dto.UserResponseDTO;
import com.apnaShopping.exception.EmptyNameException;
import com.apnaShopping.exception.PasswordInputCheck;
import com.apnaShopping.service.UserService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/register")
    public UserResponseDTO createUser(@RequestBody UserRequestDTO userRequestDTO) throws PasswordInputCheck, EmptyNameException {
        log.info(String.valueOf("@@@@@@@@@@@@"+userRequestDTO));
//        int passwordLength=userRequestDTO.getPassword().length();
//        if(passwordLength<6)
//        {
//           throw new PasswordInputCheck("password should not be less than 6 digits") ;
//        }
//
//       else if(userRequestDTO.getCustomerFName().trim().isEmpty())
//       {
//           throw new EmptyNameException("Name should not be empty please enter name ");
//       }
            return userService.createUser(userRequestDTO);
    }
}
