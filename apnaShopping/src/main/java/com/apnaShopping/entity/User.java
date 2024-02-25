package com.apnaShopping.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.boot.autoconfigure.domain.EntityScan;
@Entity
@Data
@Table(name="Customer")
public class User
{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    @NotNull(message="field should not be null")

    @NotNull
    private String customerfname;
    private String customerlname;
    private String dateofbirth;
    private String phonenumber;

    private String password;
    private String confirmpassword;
}
