package com.entidades.entidades.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entidades.entidades.entity.ProductoEntity;
import com.entidades.entidades.service.ProductoService;



@RestController
@RequestMapping("/productos")
public class ProductController {
    private final ProductoService productoService;

    public ProductController(ProductoService productoService) {
        this.productoService = productoService;
    }
    @GetMapping
    public List<ProductoEntity> getAllProducts(){
        return productoService.getAll();
    }
    @GetMapping("/{id}")
    public Optional<ProductoEntity> getProduct(@PathVariable("id") Long id){
        return productoService.findById(id);
    }
    @PostMapping
    public ProductoEntity saveProduct(@RequestBody ProductoEntity productoEntity){
        return productoService.saveProduct(productoEntity);
    }
    @PutMapping
    public ProductoEntity updateProduct(@RequestBody ProductoEntity productoEntity){
        return productoService.updateProduct(productoEntity);
    }
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable("id") Long id){
        productoService.deleteProduct(id);
    }
}
