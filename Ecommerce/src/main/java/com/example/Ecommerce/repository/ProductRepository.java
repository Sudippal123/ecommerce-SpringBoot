package com.example.Ecommerce.repository;

import com.example.Ecommerce.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {
    List<Product> getProductByCategoryName(String categoryName);

    @Query("SELECT p from Product p WHERE p.price > :minPrice")
    List<Product> getAllExpensiveProducts(double minPrice);

}
