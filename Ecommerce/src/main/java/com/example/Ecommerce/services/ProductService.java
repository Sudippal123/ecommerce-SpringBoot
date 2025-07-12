package com.example.Ecommerce.services;

import com.example.Ecommerce.dto.ProductWithCategoryDTO;
import com.example.Ecommerce.dto.controllerDTO.Response.CategoryResponseDTO;
import com.example.Ecommerce.dto.controllerDTO.Response.CreateProductResponse;
import com.example.Ecommerce.dto.ProductDTO;
import com.example.Ecommerce.dto.controllerDTO.Resquest.CreateProductRequest;
import com.example.Ecommerce.entity.Category;
import com.example.Ecommerce.entity.Product;
import com.example.Ecommerce.exception.CategoryNotFoundException;
import com.example.Ecommerce.exception.ProductNotFoundException;
import com.example.Ecommerce.exception.ServiceException;
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
            throw new ServiceException("Database error occurred while fetching the products by category name.",dae);
        }
    }

    @Override
    public ProductDTO getProductById(Long id) {
        Product product = repository.findById(id)
                .orElseThrow(
                        () -> new ProductNotFoundException("Product not found with id: " + id)
                );
        return ProductMapper.ToProductDTO(product);
    }

    @Override
    public CreateProductResponse createProduct(CreateProductRequest request) {
        Category category = categoryRepo.findById(request.getCategory_id()).orElseThrow(()-> new CategoryNotFoundException("Category not found with id : "+request.getCategory_id()));
        Product productEntity = ProductMapper.ToEntity(request,category);
        Product savedProduct = repository.save(productEntity);
        ProductDTO productDTO = ProductMapper.ToProductDTO(savedProduct);
        return CreateProductResponse.builder()
                .product(productDTO)
                .status("Success")
                .message("I am able to create a data for you")
                .build();
    }

    @Override
    public ProductWithCategoryDTO getProductWithCategory(Long id) {
        Product product = repository.findById(id).orElseThrow(()->new CategoryNotFoundException("Category not found with id : "+id));
        return ProductMapper.toProductWithCategoryDTO(product);
    }

    @Override
    public List<ProductDTO> getAllExpensiveProducts(double price) {
        try {
            List<Product> products = repository.getAllExpensiveProducts(price);
            return products.stream().map(ProductMapper::ToProductDTO).toList();
        }
        catch (DataAccessException dae){
            throw new ServiceException("Database error occurred while fetching the expensive products.",dae);
        }
    }

    @Override
    public List<ProductDTO> searchFullText(String keyword) {
        try {
            List<Product> products = repository.searchFullText(keyword);
            return products.stream().map(ProductMapper::ToProductDTO).toList();
        }
        catch (DataAccessException dae){
            throw new ServiceException("Database error occurred while fetching the matched products.",dae);
        }
    }
}
