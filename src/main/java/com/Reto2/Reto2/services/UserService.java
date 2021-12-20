/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Reto2.Reto2.services;

import com.Reto2.Reto2.repositories.UserRepository;
import com.Reto2.Reto2.models.Users;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author David
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<Users> getAll() {
        return userRepository.getAll();
    }

    public Optional<Users> getUser(int id) {

        return userRepository.getUser(id);
    }

    public Users create(Users user) {

        //obtiene el maximo id existente en la coleccion
        Optional<Users> userIdMaximo = userRepository.lastUserId();

        //si el id del Usaurio que se recibe como parametro es nulo, entonces valida el maximo id existente en base de datos
        if (user.getId() == null) {
            //valida el maximo id generado, si no hay ninguno aun el primer id sera 1
            if (userIdMaximo.isEmpty()) {
                user.setId(1);
            } //si retorna informacion suma 1 al maximo id existente y lo asigna como el codigo del usuario
            else {
                user.setId(userIdMaximo.get().getId() + 1);
            }
        }

        Optional<Users> e = userRepository.getUser(user.getId());
        if (e.isEmpty()) {
            if (emailExists(user.getEmail()) == false) {
                return userRepository.create(user);
            } else {
                return user;
            }
        } else {
            return user;
        }

    }

    public Users update(Users user) {

        if (user.getId() != null) {
            Optional<Users> userDb = userRepository.getUser(user.getId());
            if (!userDb.isEmpty()) {
                if (user.getIdentification() != null) {
                    userDb.get().setIdentification(user.getIdentification());
                }
                if (user.getName() != null) {
                    userDb.get().setName(user.getName());
                }
                if (user.getAddress() != null) {
                    userDb.get().setAddress(user.getAddress());
                }
                if (user.getCellPhone() != null) {
                    userDb.get().setCellPhone(user.getCellPhone());
                }
                if (user.getEmail() != null) {
                    userDb.get().setEmail(user.getEmail());
                }
                if (user.getPassword() != null) {
                    userDb.get().setPassword(user.getPassword());
                }
                if (user.getZone() != null) {
                    userDb.get().setZone(user.getZone());
                }
                if (user.getType() != null) {
                    userDb.get().setType(user.getType());
                }
                userRepository.update(userDb.get());
                return userDb.get();
            } else {
                return user;
            }
        } else {
            return user;
        }
    }

    public boolean delete(int userId) {
        Boolean aBoolean = getUser(userId).map(user -> {
            userRepository.delete(user);
            return true;
        }).orElse(false);
        return aBoolean;
    }

    public boolean emailExists(String email) {
        return userRepository.emailExists(email);
    }

    public List<Users> findByMonthBirthtDay(String monthBirthtDay) {
        return userRepository.findByMonthBirthtDay(monthBirthtDay);
    }

    public Users authenticateUser(String email, String password) {
        Optional<Users> usuario = userRepository.authenticateUser(email, password);

        if (usuario.isEmpty()) {
            return new Users();
        } else {
            return usuario.get();
        }
    }
}
