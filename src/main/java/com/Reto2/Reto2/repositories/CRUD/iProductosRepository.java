/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Reto2.Reto2.repositories.CRUD;

import com.Reto2.Reto2.models.Productos;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

/**
 *
 * @author David
 */
public interface iProductosRepository extends MongoRepository<Productos, String> {

    public List<Productos> findByPriceLessThanEqual(double price);

    @Query("{'description':{'$regex':'?0','$options':'i'}}")
    public List<Productos> findByDescriptionLike(String description);

}
