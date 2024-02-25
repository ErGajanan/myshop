package com.apnaShopping.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Catergory
{
    @Id
    private int id;
}
