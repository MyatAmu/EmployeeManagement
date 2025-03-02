package com.example.EmployeeManagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {
    @Autowired
    private Service service;

    @GetMapping("/employees")
    public List<Employee> findAllEmployees(){
        return service.allEmployees();
    }

    @GetMapping("/{id}")
    public Employee findByID(@PathVariable int id){
        return service.byID(id);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployeeByID(@PathVariable int id){
        service.delete(id);
    }
}
