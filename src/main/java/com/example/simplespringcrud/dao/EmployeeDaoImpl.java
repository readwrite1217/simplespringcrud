package com.example.simplespringcrud.dao;

import com.example.simplespringcrud.Exception.EmployeeNotFoundException;
import com.example.simplespringcrud.model.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class EmployeeDaoImpl implements EmployeeDao {

    // for the db operation we make use of entity manager that handles all db queries

    private EntityManager entityManager;

    //commenting autowired since it is optional since we will be using only one constructor
//    @Autowired
    public EmployeeDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {

        List<Employee> employees = getEmployees();
        return employees;
    }

    private List<Employee> getEmployees() {
        TypedQuery<Employee> typedQuery = entityManager.createQuery("FROM Employee", Employee.class);
        List<Employee> employees = typedQuery.getResultList();
        return employees;
    }

    @Override
    public Employee findById(int id) {
        // get the actual size of employee, if client sends more than the size throw runtime exception // some error message

        if (id < 0 || id > getEmployees().size()) {
            throw new EmployeeNotFoundException("NOT FOUND");
        }
        return entityManager.find(Employee.class, id);
    }

    @Override
    public Employee add(Employee employee) {
//        employee.setId(0); // if we pass id in the request payload / for autoincrement we should not pass id , so set it to zero here (if it is addition and not update)
        Employee e = entityManager.merge(employee);
        return e;
    }

    @Override
    public void update(Employee employee) {
        entityManager.merge(employee);
    }

    @Override
    public void delete(int id) {

        entityManager.remove(findById(id));

    }

    @Override
    public void deleteAll() {
        Query query = entityManager.createQuery("DELETE FROM employee", Employee.class);
        query.executeUpdate();
    }
}
