package com.example.EmployeeManagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Service {
    @Autowired
    private Repository repositroy;

    public List<Employee> allEmployees(){
        return repositroy.getAllEmployees();
    }

    public void delete(int id){
        repositroy.deleteEmployee(id);
    }

    public Employee byID(int id){
        return repositroy.getByID(id);
    }

    public Employee create(Employee employee){
        return repositroy.createEmployee(employee);
    }
}
