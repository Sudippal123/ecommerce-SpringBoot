package com.example.Ecommerce.services;

import com.example.Ecommerce.dto.CategoryWithProductsDTO;
import com.example.Ecommerce.dto.controllerDTO.Response.CategoryResponseDTO;
import com.example.Ecommerce.dto.controllerDTO.Resquest.CategoryRequestDTO;
import com.example.Ecommerce.entity.Category;
import com.example.Ecommerce.exception.CategoryNotFoundException;
import com.example.Ecommerce.exception.ServiceException;
import com.example.Ecommerce.mapper.CategoryMapper;
import com.example.Ecommerce.repository.CategoryRepository;
import org.springframework.dao.DataAccessException;
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
            throw new ServiceException("Database error occurred while fetching all categories." , dae);
        }

    }

    @Override
    public CategoryResponseDTO createCategory(CategoryRequestDTO request) {
        try {
            Category category = categoryRepository.save(CategoryMapper.toCategoryEntity(request));
            return CategoryMapper.toCategoryDTO(category);
        }
        catch (DataAccessException dae){
            throw new ServiceException("Database error occurred while creating category record.",dae);
        }
    }

    @Override
    public CategoryResponseDTO getCategoryById(Long id) {
        Category category = categoryRepository.findById(id).orElseThrow(
                ()-> new CategoryNotFoundException("Category not found with id : "+id));
        return CategoryMapper.toCategoryDTO(category);
    }

    @Override
    public CategoryWithProductsDTO getCategoryWithProducts(Long id) {
        Category category = categoryRepository.findById(id).orElseThrow(
                    () -> new CategoryNotFoundException("Category not found with id : " + id));
        return CategoryMapper.toCategoryWithProductsDTO(category);
    }

}
