package com.entidades.entidades.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entidades.entidades.entity.CategoryEntity;
import com.entidades.entidades.service.CategoryService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/categorys")
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }
    @GetMapping
    public List<CategoryEntity> getAllCategories(){
        return categoryService.getAll();
    }
    @GetMapping("/{id}")
    public Optional<CategoryEntity> getCategory(@PathVariable("id") Long id){
        return categoryService.findById(id);
    }
    @PostMapping
    public CategoryEntity saveCategory(@RequestBody CategoryEntity categoryEntity) {        
        return categoryService.saveCategory(categoryEntity);
    }
    @PutMapping
    public CategoryEntity updateCategory(@RequestBody CategoryEntity categoryEntity) {        
        return categoryService.updateCategory(categoryEntity);
    }
    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable("id") Long id){
        categoryService.deleteCategory(id);
    }
    
    
}
