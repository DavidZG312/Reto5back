/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Reto2.Reto2.repositories;

import com.Reto2.Reto2.models.Productos;
import com.Reto2.Reto2.repositories.CRUD.iProductosRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author David
 */
@Repository
public class ProductosRepository {

    @Autowired
    private iProductosRepository crudRepository;

    public List<Productos> getAll() {
        return crudRepository.findAll();
    }

    public Optional<Productos> getProductos(String reference) {
        return crudRepository.findById(reference);
    }

    public Productos create(Productos productos) {
        return crudRepository.save(productos);
    }

    public void update(Productos productos) {
        crudRepository.save(productos);
    }

    public void delete(Productos productos) {
        crudRepository.delete(productos);
    }

    //Reto 5
    public List<Productos> productByPrice(double price) {
        return crudRepository.findByPriceLessThanEqual(price);
    }

    //Reto 5
    public List<Productos> findByDescriptionLike(String description) {
        return crudRepository.findByDescriptionLike(description);
    }
}
