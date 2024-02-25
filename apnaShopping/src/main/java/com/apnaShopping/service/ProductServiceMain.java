package com.apnaShopping.service;

import com.apnaShopping.dto.ProductRequestDTO;
import com.apnaShopping.entity.Product;
import com.apnaShopping.repository.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class ProductServiceMain
{
    @Autowired
    private ProductRepository productRepo;

    @Transactional
    public ResponseEntity<String> deleteProduct(String name) {
        try {
            productRepo.deleteByName(name);
            return ResponseEntity.ok("Product deleted successfully");
        } catch (EmptyResultDataAccessException ex) {
            return ResponseEntity.notFound().build();        }
    }

    @Transactional
    public ResponseEntity<String> updateProduct(String name, ProductRequestDTO productRequestDTO) throws IOException {
        // Retrieve the product from the database based on its name
        List<Product> products = productRepo.findByName(name);
        if (!products.isEmpty()) {
            // Assuming only one product is found with the given name, update the first one
            Product productToUpdate = products.get(0);
            // Update the product attributes with the new values
            productToUpdate.setImage(productRequestDTO.getImage());
            productToUpdate.setName(productRequestDTO.getName());
            productToUpdate.setPrice(productRequestDTO.getPrice());
            productToUpdate.setDiscount(productRequestDTO.getDiscount());
            // Set other attributes as needed
            // Save the updated product back to the database
            productRepo.save(productToUpdate);
            return ResponseEntity.ok("Product updated successfully");
        } else {
            // Product not found
            return ResponseEntity.notFound().build();
        }
    }
}