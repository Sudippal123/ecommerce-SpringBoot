package com.example.Ecommerce.services;

import com.example.Ecommerce.dto.CategoryWithProductsDTO;
import com.example.Ecommerce.dto.controllerDTO.Response.CategoryResponseDTO;
import com.example.Ecommerce.dto.controllerDTO.Resquest.CategoryRequestDTO;
import com.example.Ecommerce.entity.Category;
import com.example.Ecommerce.mapper.CategoryMapper;
import com.example.Ecommerce.mapper.ProductMapper;
import com.example.Ecommerce.repository.CategoryRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.dao.DataAccessException;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryService{
    private final CategoryRepository categoryRepository;

    public CategoryService( CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<CategoryResponseDTO> getAllCategories() {
        try {
            List<Category> categories = categoryRepository.findAll();
            return categories.stream().map(CategoryMapper::toCategoryDTO).toList();
        }
        catch (DataAccessException dae){
            // Handle database issues (e.g., query failure, connection issue)
            throw new RuntimeException("Database error occurred while fetching all categories." , dae);

        }
        catch (Exception ex){
            // Catch-all for any other runtime exceptions
            throw new RuntimeException("Unexpected error while retrieving all categories." , ex);
        }
    }

    @Override
    public CategoryResponseDTO createCategory(CategoryRequestDTO request) {
        try {
            Category category = categoryRepository.save(CategoryMapper.toCategoryEntity(request));
            return CategoryMapper.toCategoryDTO(category);
        }
        catch (DataAccessException dae){
            throw new RuntimeException("Database error occurred while creating category record.",dae);
        }
        catch (Exception ex){
            throw new RuntimeException("Unexpected error occur while creating category record.",ex);
        }
    }

    @Override
    public CategoryResponseDTO getCategoryById(Long id) {
        try {
            Category category = categoryRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Category not found with id : "+id));
            return CategoryMapper.toCategoryDTO(category);
        }
        catch (DataAccessException dae){
            throw new RuntimeException("Database error occurred while fetching category by Id",dae);
        }
        catch (RuntimeException e) {
            throw new RuntimeException("Unexpected error occur while fetching for category.",e);
        }
    }

    @Override
    public CategoryWithProductsDTO getCategoryWithProducts(Long id) {
        try {
            Category category = categoryRepository.findById(id).orElseThrow(
                    () -> new EntityNotFoundException("Category not found with id : " + id));
            return CategoryMapper.toCategoryWithProductsDTO(category);
        }
        catch (DataAccessException dae){
            throw new RuntimeException("Database error occurred while fetching category by Id",dae);
        }
        catch (RuntimeException e) {
            throw new RuntimeException("Unexpected error occur while fetching for category.",e);
        }
    }

}
