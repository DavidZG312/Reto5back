/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Reto2.Reto2.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author David
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "productos")
public class Productos {

    @Id
    private String reference;
    private String brand;
    private String category;
    private String materiales;
    private String dimensiones;
    private String description;
    private boolean availability;
    private double price;
    private int quantity;
    private String photography;
    
}
