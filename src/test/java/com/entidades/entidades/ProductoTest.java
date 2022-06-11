package com.entidades.entidades;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.entidades.entidades.entity.ProductoEntity;
import com.entidades.entidades.repository.ProductoRepository;


@DataJpaTest
//Para switchear entre base de datos H2 y PgSQL
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class ProductoTest {
    @Autowired
    private ProductoRepository productoRepository;

    @Test
    @Rollback(false)
    public void testGuardarProducto(){
        ProductoEntity producto = new ProductoEntity(11,"snoopperez",90);
        productoRepository.save(producto);
        //Test como valido si producto es != null
        assertNotNull(producto);
    }
    @Test
    public void testBuscarProductid(){
        long id = 1;
        Optional<ProductoEntity> producto = productoRepository.findById(id);
        assertNotNull(producto);
    }
    @Test
    @Rollback(false)
    public void testActualizarProducto(){
        ProductoEntity producto = new ProductoEntity(5,"lalolalolalo",10);
        productoRepository.save(producto);
        //Test como valido si producto es != null
        assertNotNull(producto);
    }
    @Test    
    public void testListarProductos(){
        List<ProductoEntity> productos = (List<ProductoEntity>) productoRepository.findAll();
        for (ProductoEntity producto : productos) {
            System.out.println(producto);
        }
        assertThat(productos).size().isGreaterThan(0);
    }
    @Test
    @Rollback(false)
    public void testEliminarProducto(){
        long id = 1;
        boolean productExist = productoRepository.findById(id).isPresent();
        productoRepository.deleteById(id);
        boolean productNotExist = productoRepository.findById(id).isPresent();
        assertTrue(productExist);
        assertFalse(productNotExist);   
    }
}
