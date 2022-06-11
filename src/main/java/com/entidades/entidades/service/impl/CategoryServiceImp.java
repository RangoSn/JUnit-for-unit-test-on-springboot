package com.entidades.entidades.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.entidades.entidades.entity.CategoryEntity;
import com.entidades.entidades.repository.CategoryRepository;
import com.entidades.entidades.service.CategoryService;

@Service
public class CategoryServiceImp implements CategoryService{
    private final CategoryRepository categoryRepository;
    
    public CategoryServiceImp(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<CategoryEntity> getAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Optional<CategoryEntity> findById(Long id) {
        return categoryRepository.findById(id);
    }

    @Override
    public CategoryEntity saveCategory(CategoryEntity categoryEntity) {
        return categoryRepository.save(categoryEntity);
    }

    @Override
    public CategoryEntity updateCategory(CategoryEntity categoryEntity) {
        return categoryRepository.save(categoryEntity);
    }

    @Override
    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }
    
}
