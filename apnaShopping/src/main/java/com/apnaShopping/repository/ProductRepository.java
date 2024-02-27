package com.apnaShopping.repository;

import com.apnaShopping.entity.Product;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Integer>
{
    String deleteByName(String name);
//
    List<Product> findByName(String name);

    @Modifying
    @Transactional
    @Query(value = "CALL add_product(:name, :price, :discount, :image)", nativeQuery = true)
    void addProduct(@Param("name") String name, @Param("price") double price,
                    @Param("discount") double discount, @Param("image") byte[] image);
        //query for getting the data
        @Query(value = "CALL get_products(:page, :size)", nativeQuery = true)
        List<Product> getProducts(@Param("page") int page, @Param("size") int size);


}
