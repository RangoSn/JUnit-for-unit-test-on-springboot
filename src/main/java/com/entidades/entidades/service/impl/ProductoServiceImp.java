package com.entidades.entidades.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.entidades.entidades.entity.ProductoEntity;
import com.entidades.entidades.repository.ProductoRepository;
import com.entidades.entidades.service.ProductoService;

@Service
public class ProductoServiceImp implements ProductoService{
    private final ProductoRepository productoRepository;

    public ProductoServiceImp(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    @Override
    public List<ProductoEntity> getAll() {        
        return productoRepository.findAll();
    }

    @Override
    public Optional<ProductoEntity> findById(Long id) {
        return productoRepository.findById(id);
    }

    @Override
    public ProductoEntity saveProduct(ProductoEntity productoEntity) {        
        return productoRepository.save(productoEntity);
    }

    @Override
    public ProductoEntity updateProduct(ProductoEntity productoEntity) {        
        return productoRepository.save(productoEntity);
    }

    @Override
    public void deleteProduct(Long id) {        
        productoRepository.deleteById(id);
    }
    
}
