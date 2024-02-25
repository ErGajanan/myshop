package com.apnaShopping.repository;

import com.apnaShopping.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Integer>
{
    String deleteByName(String name);

    List<Product> findByName(String name);
}
