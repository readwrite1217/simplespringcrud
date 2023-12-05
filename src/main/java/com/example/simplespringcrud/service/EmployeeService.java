package com.example.simplespringcrud.service;

import com.example.simplespringcrud.model.Employee;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface EmployeeService {

    //findAll
    List<Employee> findAll();

    //find by Id
    Employee findById(int id);

    //add employee
    Employee add(Employee employee);

    //update employee
    void update(Employee employee);

    //delete employee
    void delete(int id);

    // delete all
    public void deleteAll();
}
