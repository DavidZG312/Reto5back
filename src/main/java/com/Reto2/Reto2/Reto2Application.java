package com.Reto2.Reto2;

import com.Reto2.Reto2.repositories.CRUD.iOrdersRepository;
import com.Reto2.Reto2.repositories.CRUD.iProductosRepository;
import com.Reto2.Reto2.repositories.CRUD.iUsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Reto2Application implements CommandLineRunner {

    @Autowired
    private iProductosRepository crudRepository;
    @Autowired
    private iUsersRepository userCrudRepository;
    @Autowired
    private iOrdersRepository orderCrudRepository;

    public static void main(String[] args) {
        SpringApplication.run(Reto2Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        //crudRepository.deleteAll();
        //userCrudRepository.deleteAll();
        //orderCrudRepository.deleteAll();
    }
}
