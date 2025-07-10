package com.example.Ecommerce.repository;

import com.example.Ecommerce.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {
    List<Product> getProductByCategoryName(String categoryName);

    @Query("SELECT p from Product p WHERE p.price > :minPrice")
    List<Product> getAllExpensiveProducts(@Param("minPrice") double minPrice);

    @Query("SELECT p from Product p WHERE LOWER(p.title) LIKE LOWER(CONCAT('%',:keyword,'%')) OR LOWER(p.description) LIKE LOWER(CONCAT('%',:keyword,'%'))")
    List<Product> searchFullText(@Param("keyword") String keyword);

}
