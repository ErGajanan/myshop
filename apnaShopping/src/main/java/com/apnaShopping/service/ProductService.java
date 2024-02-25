package com.apnaShopping.service;

import com.apnaShopping.dto.ProductResponseDTO;
import com.apnaShopping.entity.Product;
import com.apnaShopping.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.sql.SQLException;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Transactional
    public void addProduct(String name, double price, double discount, byte[] image) {
        Product product = new Product();
        product.setName(name);
        product.setPrice(price);
        product.setDiscount(discount);
        product.setImage(image);
        productRepository.save(product);
    }


}
