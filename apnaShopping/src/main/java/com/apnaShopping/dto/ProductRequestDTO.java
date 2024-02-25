package com.apnaShopping.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class ProductRequestDTO
{
    private int id;

    private String name;

    private int price;


    private int quantity;

    private int weight;
    private String color;
    private int discount;
    private byte[] image;
    private String expdate;
    private String manufacturedate;


}
