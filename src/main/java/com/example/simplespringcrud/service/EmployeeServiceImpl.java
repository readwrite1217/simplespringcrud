package com.example.simplespringcrud.service;

import com.example.simplespringcrud.dao.EmployeeDao;
import com.example.simplespringcrud.model.Employee;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeDao employeeDao;

    public EmployeeServiceImpl(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @Override
    public List<Employee> findAll() {
        return employeeDao.findAll();
    }

    @Override
    public Employee findById(int id) {
        return employeeDao.findById(id);
    }

    @Override
    @Transactional
    public Employee add(Employee employee) {
        return employeeDao.add(employee);
    }

    @Override
    @Transactional
    public void update(Employee employee) {
        employeeDao.update(employee);

    }

    @Override
    @Transactional
    public void delete(int id) {
        employeeDao.delete(id);

    }

    @Override
    @Transactional
    public void deleteAll() {
        employeeDao.deleteAll();
    }
}
