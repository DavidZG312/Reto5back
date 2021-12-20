/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Reto2.Reto2.controllers;

import com.Reto2.Reto2.models.Orders;
import com.Reto2.Reto2.services.OrdersService;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author David
 */
@RestController
@RequestMapping("/api/order")
@CrossOrigin("*")
public class OrdersController {

    @Autowired
    private OrdersService ordersService;

 @GetMapping("/all")
    public List<Orders> getAll() {
        return ordersService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Orders> getOrder(@PathVariable("id") int id) {
        return ordersService.getOrder(id);
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Orders create(@RequestBody Orders gadget) {
        return ordersService.create(gadget);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Orders update(@RequestBody Orders gadget) {
        return ordersService.update(gadget);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id) {
        return ordersService.delete(id);
    }

    //Reto 3:Ordenes de pedido asociadas a los asesores de una zona
    @GetMapping("/zona/{zona}")

    public List<Orders> findByZone(@PathVariable("zona") String zona) {
        return ordersService.findByZone(zona);
    }

    //Reto 4: Ordenes de un asesor
    @GetMapping("/salesman/{id}")
    public List<Orders> ordersSalesManByID(@PathVariable("id") int id) {
        return ordersService.ordersSalesManByID(id);
    }

    //Reto 4: Ordenes de un asesor x Fecha
    @GetMapping("/date/{date}/{id}")
    public List<Orders> ordersSalesManByDate(@PathVariable("date") String date, @PathVariable("id") int id) {
        return ordersService.ordersSalesManByDate(date, id);
    }

    //Reto 4: Ordenes de un asesor x Estado
    @GetMapping("/state/{state}/{id}")
    public List<Orders> ordersSalesManByState(@PathVariable("state") String date, @PathVariable("id") int id) {
        return ordersService.ordersSalesManByState(date, id);
    }
}
