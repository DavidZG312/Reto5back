/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Reto2.Reto2.services;

import com.Reto2.Reto2.models.Orders;
import com.Reto2.Reto2.repositories.OrdersRepository;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author David
 */
@Service
public class OrdersService {

    @Autowired
    private OrdersRepository ordersRepository;

       public List<Orders> getAll() {
        return ordersRepository.getAll();
    }

    public Optional<Orders> getOrder(int id) {
        return ordersRepository.getOrder(id);
    }

    public Orders create(Orders order) {
        if (order.getId() == null) {
            return order;
        } else {
            return ordersRepository.create(order);
        }
    }

    public Orders update(Orders order) {

        if (order.getId() != null) {
            Optional<Orders> orderDb = ordersRepository.getOrder(order.getId());
            if (!orderDb.isEmpty()) {
                if (order.getStatus() != null) {
                    orderDb.get().setStatus(order.getStatus());
                }
                ordersRepository.update(orderDb.get());
                return orderDb.get();
            } else {
                return order;
            }
        } else {
            return order;
        }
    }

    public boolean delete(int id) {
        Boolean aBoolean = getOrder(id).map(order -> {
            ordersRepository.delete(order);
            return true;
        }).orElse(false);
        return aBoolean;
    }

    //Ordenes de pedido asociadas a los asesores de una zona
    public List<Orders> findByZone(String zona) {
        return ordersRepository.findByZone(zona);
    }

    //Reto 4: Ordenes de un asesor
    public List<Orders> ordersSalesManByID(int id) {
        return ordersRepository.ordersSalesManByID(id);
    }
    
    //Reto 4: Ordenes de un asesor x Fecha
    public List<Orders> ordersSalesManByDate(String dateStr, int id) {
        return ordersRepository.ordersSalesManByDate(dateStr, id);
    }
    
    //Reto 4: Ordenes de un asesor x Estado
    public List<Orders> ordersSalesManByState(String state, Integer id) {
        return ordersRepository.ordersSalesManByState(state, id);
    }

}
