package com.example.simplespringcrud.dao;

import com.example.simplespringcrud.model.Employee;

import java.util.List;

public interface EmployeeDao {

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

    //delete all
    void deleteAll();
}
