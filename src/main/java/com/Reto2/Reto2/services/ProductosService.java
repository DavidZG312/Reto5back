/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Reto2.Reto2.services;

import com.Reto2.Reto2.models.Productos;
import com.Reto2.Reto2.repositories.ProductosRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

/**
 *
 * @author David
 */
@Service
public class ProductosService {

    @Autowired
    private ProductosRepository productoRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    public List<Productos> getAll() {
        return productoRepository.getAll();
    }

    public Optional<Productos> getProductos(String reference) {
        return productoRepository.getProductos(reference);
    }

    public Productos create(Productos producto) {
        if (producto.getReference() == null) {
            return producto;
        } else {
            return productoRepository.create(producto);
        }
    }

    public Productos update(Productos producto) {

        if (producto.getReference() != null) {
            Optional<Productos> productoDb = productoRepository.getProductos(producto.getReference());
            if (!productoDb.isEmpty()) {
                if (producto.getBrand() != null) {
                    productoDb.get().setBrand(producto.getBrand());
                }

                if (producto.getCategory() != null) {
                    productoDb.get().setCategory(producto.getCategory());
                }

                if (producto.getMateriales() != null) {
                    productoDb.get().setMateriales(producto.getMateriales());
                }

                if (producto.getDescription() != null) {
                    productoDb.get().setDescription(producto.getDescription());
                }
                if (producto.getPrice() != 0.0) {
                    productoDb.get().setPrice(producto.getPrice());
                }
                if (producto.getQuantity() != 0) {
                    productoDb.get().setQuantity(producto.getQuantity());
                }
                if (producto.getPhotography() != null) {
                    productoDb.get().setPhotography(producto.getPhotography());
                }
                productoDb.get().setAvailability(producto.isAvailability());
                productoRepository.update(productoDb.get());
                return productoDb.get();
            } else {
                return producto;
            }
        } else {
            return producto;
        }
    }

    public boolean delete(String reference) {
        Boolean aBoolean = getProductos(reference).map(producto -> {
            productoRepository.delete(producto);
            return true;
        }).orElse(false);
        return aBoolean;
    }

    //Reto 5
    public List<Productos> productByPrice(double price) {
        return productoRepository.productByPrice(price);
    }

    //Reto 5
    public List<Productos> findByDescriptionLike(String description) {
        return productoRepository.findByDescriptionLike(description);
    }
}
