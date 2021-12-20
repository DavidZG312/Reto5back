/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Reto2.Reto2.repositories.CRUD;

import com.Reto2.Reto2.models.Users;
import java.util.Optional;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author David
 */
public interface iUsersRepository extends MongoRepository<Users, Integer> {

    Optional<Users> findByEmail(String email);

    List<Users> findByMonthBirthtDay(String monthBirthtDay);

    Optional<Users> findByEmailAndPassword(String email, String password);

    //Para seleccionar el usuario con el id maximo
    Optional<Users> findTopByOrderByIdDesc();
}
