package com.example.EmployeeManagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @DeleteMapping("/delete/{id}")
    public void deleteEmployeeByID(@PathVariable int id){
        service.delete(id);
    }

    @PostMapping("/create")
    public ResponseEntity<Employee> createEmp(@RequestBody Employee employee){
        Employee createdEmployee = service.create(employee);
        return ResponseEntity.ok(createdEmployee);
    }
}
