/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Reto2.Reto2.repositories.CRUD;

import com.Reto2.Reto2.models.Orders;
import java.util.List;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;
/**
 *
 * @author David
 */
public interface iOrdersRepository extends CrudRepository<Orders, Integer> {

    @Query("{'salesMan.zone': ?0}")
    List<Orders> findByZone(final String zone);
    
    @Query("{status: ?0}")
    List<Orders> findByStatus(final String status);
}
