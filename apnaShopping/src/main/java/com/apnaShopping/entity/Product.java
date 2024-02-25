package com.apnaShopping.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Lob
    @Column(length = 1048576) // Adjust the length as needed

    private byte[] image;

    private double price;

    private double discount;

    // Getters and setters
}
