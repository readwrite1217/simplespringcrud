package com.example.simplespringcrud.rest;


import com.example.simplespringcrud.model.Employee;
import com.example.simplespringcrud.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {


    //@Autowired (disabling it since spring recommends to use constructor injection or setter)
    //if we donot need to apply any business logic to the db entry, having a dao is ok
    //else we can make use of service architecture
    // get a dao object / service object to access db / service methods.
    //    private EmployeeDao employeeDao;
    private EmployeeService employeeService;

    //commenting below because if we have only one construtor , we do not need to pass the autowired annotation
//    @Autowired
//    public EmployeeController(EmployeeDao employeeDao) {
//        this.employeeDao = employeeDao;
//    }

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // get all employee

    @GetMapping("/employees")
    List<Employee> getAllEmployees() {

        //if we donot need to apply any business logic to the db entry, having a dao is ok
        //else we can make use of service architecture
//        List<Employee> employees = employeeDao.findAll();
        List<Employee> employees = employeeService.findAll();
        return employees;
    }

    @GetMapping("/employees/{id}")
    Employee getEmployeeById(@PathVariable("id") String id) {

        return employeeService.findById(Integer.valueOf(id));
    }

    @PostMapping("/employees")
    Employee addEmployee(@RequestBody Employee employee) {
        return employeeService.add(employee);
    }

    @DeleteMapping("/employees/{id}")
    public void deleteEmployee(@PathVariable("id") int id) {
        employeeService.delete(id);
    }

    @PutMapping("/employees")
    public void updateEmployee(@RequestBody Employee employee) {
        employeeService.update(employee);

    }


}
