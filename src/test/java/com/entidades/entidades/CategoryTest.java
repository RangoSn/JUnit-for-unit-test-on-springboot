package com.entidades.entidades;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.entidades.entidades.entity.CategoryEntity;
import com.entidades.entidades.repository.CategoryRepository;

@DataJpaTest
//Para switchear entre base de datos H2 y PgSQL
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class CategoryTest {
    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    @Rollback(false)
    public void testGuardarCategory(){
        CategoryEntity category = new CategoryEntity(1,"snoopperez",90);
        categoryRepository.save(category);
        //Test como valido si category es != null
        assertNotNull(category);
    }
    @Test
    public void testBuscarCategoryid(){
        long id = 1;
        Optional<CategoryEntity> category = categoryRepository.findById(id);
        assertNotNull(category);
    }
    @Test
    @Rollback(false)
    public void testActualizarcategory(){
        CategoryEntity category = new CategoryEntity(5,"lalolalolalo",10);
        categoryRepository.save(category);
        //Test como valido si category es != null
        assertNotNull(category);
    }
    @Test    
    public void testListarcategorys(){
        List<CategoryEntity> categorys = (List<CategoryEntity>) categoryRepository.findAll();
        for (CategoryEntity category : categorys) {
            System.out.println(category);
        }
        assertThat(categorys).size().isGreaterThan(0);
    }
    @Test
    @Rollback(false)
    public void testEliminarcategory(){
        long id = 1;
        boolean productExist = categoryRepository.findById(id).isPresent();
        categoryRepository.deleteById(id);
        boolean productNotExist = categoryRepository.findById(id).isPresent();
        assertTrue(productExist);
        assertFalse(productNotExist);   
    }   
}
