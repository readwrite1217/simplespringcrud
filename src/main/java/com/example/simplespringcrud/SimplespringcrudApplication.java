package com.example.simplespringcrud;

import com.example.simplespringcrud.dao.EmployeeDao;
import com.example.simplespringcrud.model.Employee;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SimplespringcrudApplication {

    public static void main(String[] args) {
        SpringApplication.run(SimplespringcrudApplication.class, args);
    }


}
