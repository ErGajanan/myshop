package com.apnaShopping.controller;

import com.apnaShopping.dto.ProductResponseDTO;
import com.apnaShopping.entity.Product;
import com.apnaShopping.repository.ProductRepository;
import com.apnaShopping.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import springfox.documentation.annotations.Cacheable;

import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@Api(tags = "Product Management API")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    ProductRepository productRepository;

    @ApiOperation(value = "Add a new product")//this is swagger annotation
    @PostMapping("/add")
    public String addProduct(@RequestParam("name") String name,
                             @RequestParam("price") double price,
                             @RequestParam("discount") double discount,
                             @RequestParam("image") MultipartFile image) {
        try {
            productRepository.addProduct(name, price, discount, image.getBytes());
            return "Product added successfully!";
        } catch (IOException e) {
            e.printStackTrace();
            return "Failed to add product";
        }
    }

    @ApiOperation(value = "Get all products with pagination support")//this is swagger annotation
//   @Cacheable(value="products")
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
        ProductResponseDTO productResponseDTO = new ProductResponseDTO();
        productResponseDTO.setImage(product.getImage());
        productResponseDTO.setName(product.getName());
        productResponseDTO.setDiscount((int) product.getDiscount());
        productResponseDTO.setPrice((int) product.getPrice());
        return productResponseDTO;
    }
}
