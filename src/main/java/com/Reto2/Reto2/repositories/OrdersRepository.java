/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Reto2.Reto2.repositories;

import com.Reto2.Reto2.models.Orders;
import com.Reto2.Reto2.repositories.CRUD.iOrdersRepository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author David
 */
@Repository
public class OrdersRepository {

    @Autowired
    private iOrdersRepository crudRepository;

   @Autowired
    private MongoTemplate mongoTemplate;

    public List<Orders> getAll() {
        return (List<Orders>) crudRepository.findAll();
    }

    public Optional<Orders> getOrder(int id) {
        return crudRepository.findById(id);
    }

    public Orders create(Orders order) {
        return crudRepository.save(order);
    }

    public void update(Orders order) {
        crudRepository.save(order);
    }

    public void delete(Orders order) {
        crudRepository.delete(order);
    }

    public List<Orders> findByZone(String zona) {
        return crudRepository.findByZone(zona);
    }
    
    //Reto 4: Ordenes de un asesor
    public List<Orders> ordersSalesManByID(Integer id) {

        Query query = new Query();
        Criteria dateCriteria = Criteria.where("salesMan.id").is(id);

        query.addCriteria(dateCriteria);
        List<Orders> orders = mongoTemplate.find(query, Orders.class);

        return orders;
    }

    //Reto 4: Ordenes de un asesor x Fecha
    public List<Orders> ordersSalesManByDate(String dateStr, Integer id) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        Query query = new Query();
        Criteria dateCriteria = Criteria.where("registerDay")
                .gte(LocalDate.parse(dateStr, dtf).minusDays(1).atStartOfDay())
                .lt(LocalDate.parse(dateStr, dtf).plusDays(2).atStartOfDay())
                .and("salesMan.id").is(id);

        query.addCriteria(dateCriteria);
        List<Orders> orders = mongoTemplate.find(query, Orders.class);

        return orders;
    }
    
    //Reto 4: Ordenes de un asesor x Estado
    public List<Orders> ordersSalesManByState(String state, Integer id) {

        Query query = new Query();
        Criteria dateCriteria = Criteria.where("salesMan.id").is(id)
                .and("status").is(state);

        query.addCriteria(dateCriteria);
        List<Orders> orders = mongoTemplate.find(query, Orders.class);

        return orders;
    }
}
