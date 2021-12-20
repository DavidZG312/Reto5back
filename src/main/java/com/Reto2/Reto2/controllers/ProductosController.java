/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Reto2.Reto2.controllers;

import com.Reto2.Reto2.models.Productos;
import com.Reto2.Reto2.services.ProductosService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author David
 */
@RestController
@RequestMapping("/api/cookware")
@CrossOrigin("*")
public class ProductosController {

    @Autowired
    private ProductosService productosService;

    @GetMapping("/all")
    public List<Productos> getAll() {
        return productosService.getAll();
    }

    @GetMapping("/{reference}")
    public Optional<Productos> getAccesory(@PathVariable("reference") String reference) {
        return productosService.getProductos(reference);
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Productos create(@RequestBody Productos gadget) {
        return productosService.create(gadget);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Productos update(@RequestBody Productos gadget) {
        return productosService.update(gadget);
    }

    @DeleteMapping("/{reference}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("reference") String reference) {
        return productosService.delete(reference);
    }

    @GetMapping("/price/{price}")
    public List<Productos> productByPrice(@PathVariable("price") double price) {
        return productosService.productByPrice(price);
    }

    //Reto 5
    @GetMapping("/description/{description}")
    public List<Productos> findByDescriptionLike(@PathVariable("description") String description) {
        return productosService.findByDescriptionLike(description);
    }
}
