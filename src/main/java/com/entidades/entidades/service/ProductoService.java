package com.entidades.entidades.service;

import java.util.List;
import java.util.Optional;

import com.entidades.entidades.entity.ProductoEntity;

public interface ProductoService {
    List<ProductoEntity> getAll();
    Optional<ProductoEntity> findById(Long id);
    ProductoEntity saveProduct(ProductoEntity productoEntity);
    ProductoEntity updateProduct(ProductoEntity productoEntity);
    void deleteProduct(Long id);
}
