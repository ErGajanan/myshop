package com.apnaShopping.dto;

import lombok.Data;

@Data
public class ProductResponseDTO
{
   private byte[] image;
   private String name;
   private int price;
   private int discount;
}
