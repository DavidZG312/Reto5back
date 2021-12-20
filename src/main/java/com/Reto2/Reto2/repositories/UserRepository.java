package com.Reto2.Reto2.repositories;

import com.Reto2.Reto2.models.Users;
import com.Reto2.Reto2.repositories.CRUD.iUsersRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author David
 */
@Repository
public class UserRepository {

    @Autowired
    private iUsersRepository userCrudRepository;

    public List<Users> getAll() {
        return (List<Users>) userCrudRepository.findAll();
    }

    public Optional<Users> getUser(int id) {
        return userCrudRepository.findById(id);
    }

    public Users create(Users user) {
        return userCrudRepository.save(user);
    }

    public void update(Users user) {
        userCrudRepository.save(user);
    }

    public void delete(Users user) {
        userCrudRepository.delete(user);
    }

    public boolean emailExists(String email) {
        Optional<Users> usuario = userCrudRepository.findByEmail(email);

        return !usuario.isEmpty();
    }

    public List<Users> findByMonthBirthtDay(String monthBirthtDay) {
        return userCrudRepository.findByMonthBirthtDay(monthBirthtDay);
    }

    public Optional<Users> authenticateUser(String email, String password) {
        return userCrudRepository.findByEmailAndPassword(email, password);
    }

    public Optional<Users> lastUserId() {
        return userCrudRepository.findTopByOrderByIdDesc();
    }

}
