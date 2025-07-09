package com.example.Ecommerce.services;

import com.example.Ecommerce.dto.controllerDTO.Response.CategoryResponseDTO;
import com.example.Ecommerce.dto.controllerDTO.Response.CreateProductResponse;
import com.example.Ecommerce.dto.ProductDTO;
import com.example.Ecommerce.dto.controllerDTO.Resquest.CreateProductRequest;
import com.example.Ecommerce.entity.Category;
import com.example.Ecommerce.entity.Product;
import com.example.Ecommerce.mapper.CategoryMapper;
import com.example.Ecommerce.mapper.ProductMapper;
import com.example.Ecommerce.repository.CategoryRepository;
import com.example.Ecommerce.repository.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class ProductService implements IProductService {
    private final ProductRepository repository;
    private final CategoryRepository categoryRepo;
    public ProductService(ProductRepository repository, CategoryRepository categoryRepo) {
        this.repository = repository;
        this.categoryRepo = categoryRepo;
    }

    @Override
    public List<ProductDTO> getProductByCategory(String type) {
        try {
            List<Product> products = repository.getProductByCategoryName(type);
            return products.stream().map(ProductMapper::ToProductDTO).toList();
        }
        catch (DataAccessException dae){
            throw new RuntimeException("Database error occurred while fetching the products by category name.",dae);
        }
        catch (Exception e){
            throw new RuntimeException("Unexpected error while fetching the products by category name.",e);
        }
    }

    @Override
    public ProductDTO getProductById(Long id) {
        try {
            Product product = repository.findById(id)
                    .orElseThrow(
                            () -> new EntityNotFoundException("Product not found with id: " + id)
                    );
            return ProductMapper.ToProductDTO(product);
        }
        catch (DataAccessException dae) {
            // Handle database issues (e.g., query failure, connection issue)
            throw new RuntimeException("Database error occurred while fetching product with id: " + id, dae);

        } catch (Exception ex) {
            // Catch-all for any other runtime exceptions
            throw new RuntimeException("Unexpected error while retrieving product with id: " + id, ex);
        }
    }

    @Override
    public CreateProductResponse createProduct(CreateProductRequest request) {
        try {
            //Get the category if it exists
            Category category = categoryRepo.findById(request.getCategory_id()).orElseThrow(()-> new EntityNotFoundException("Category not found with id : "+request.getCategory_id()));

            // converts the request DTO structure to Product Entity Structure
            Product productEntity = ProductMapper.ToEntity(request,category);
            // create the product record
            Product savedProduct = repository.save(productEntity);
            // converts the Product Entity structure to response DTO Structure
            ProductDTO productDTO = ProductMapper.ToProductDTO(savedProduct);
            return CreateProductResponse.builder()
                    .product(productDTO)
                    .status("Success")
                    .message("I am able to create a data for you")
                    .build();
        }
        catch (DataAccessException dae) {
            // Handle database-related errors
            return CreateProductResponse.builder()
                    .status("Failure")
                    .message("Database error occurred while creating product: " + dae.getMessage())
                    .build();

        } catch (Exception ex) {
            // Handle generic errors
            return CreateProductResponse.builder()
                    .status("Failure")
                    .message("An unexpected error occurred: " + ex.getMessage())
                    .build();
        }
    }
}
