package com.apnaShopping.controller;

import com.apnaShopping.dto.ProductResponseDTO;
import com.apnaShopping.entity.Product;
import com.apnaShopping.repository.ProductRepository;
import com.apnaShopping.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

@RestController
//this is for change connect ui to backend so cors annotation required
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/products")
//This is productController
public class ProductController {

    @Autowired
    private ProductService productService;
 @Autowired
    ProductRepository productRepository;
    @PostMapping("/add")
    public String addProduct(@RequestParam("name") String name,
                             @RequestParam("price") double price,
                             @RequestParam("discount") double discount,
                             @RequestParam("image") MultipartFile image) {
        try {
            productService.addProduct(name, price, discount, image.getBytes());
            return "Product added successfully!";
        } catch (IOException e) {
            e.printStackTrace();
            return "Failed to add product";
        }
    }
//    @GetMapping("/getproducts")
//    public List<ProductResponseDTO> getAllProducts()
//    {
////        List<Product> product=productRepository.findAll();
////        List<ProductResponseDTO> productResponseDTOS=new ArrayList<>();
////        for (Product prod : product) {
////            productResponseDTOS.add(convertToProductResponseDTO(prod));
////        }
////
////        return productResponseDTOS;
//    }
//    }

    @GetMapping("/getproducts")
    public List<ProductResponseDTO> getAllProducts(@RequestParam(defaultValue = "0") int page,
                                                   @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Product> productsPage = productRepository.findAll(pageable);
        List<ProductResponseDTO> productResponseDTOS = productsPage.getContent().stream()
                .map(this::convertToProductResponseDTO)
                .collect(Collectors.toList());
        return productResponseDTOS;
    }

    private ProductResponseDTO convertToProductResponseDTO(Product product) {
        // Assuming the image is stored as byte[] and you want to convert it to Base64 for simplicity
//        String base64Image = Base64.getEncoder().encodeToString(product.getImage());
            ProductResponseDTO productResponseDTO=new ProductResponseDTO();
            productResponseDTO.setImage(product.getImage());
        productResponseDTO.setName(product.getName());
        productResponseDTO.setDiscount((int) product.getDiscount());
        productResponseDTO.setPrice((int) product.getPrice());
        return  productResponseDTO;
    }
}
