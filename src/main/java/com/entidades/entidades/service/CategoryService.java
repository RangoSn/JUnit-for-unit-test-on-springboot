package com.entidades.entidades.service;

import java.util.List;
import java.util.Optional;

import com.entidades.entidades.entity.CategoryEntity;

public interface CategoryService {
    List<CategoryEntity> getAll();
    Optional<CategoryEntity> findById(Long id);
    CategoryEntity saveCategory(CategoryEntity categoryEntity);
    CategoryEntity updateCategory(CategoryEntity categoryEntity);
    void deleteCategory(Long id);
}
