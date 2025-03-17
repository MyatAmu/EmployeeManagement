package com.example.EmployeeManagement;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.util.List;

@Component
public class Repository {
    private JdbcTemplate template;
    public Repository(JdbcTemplate template){
        this.template = template;
    }

    public List<Employee> getAllEmployees(){
        String sql = "SELECT * FROM employees";
        return template.query(sql, new EmployeeMapper());
    }

    public Employee getByID(int id){
        String sql = "SELECT * FROM employees WHERE id = ?";
        List<Employee> employees = template.query(sql, new EmployeeMapper(), id);
        return employees.stream().findFirst().orElse(null);
    }

    public void deleteEmployee(int id){
        String sql = "DELETE FROM employees where id = ?";
        template.update(sql, id);
    }

    public Employee createEmployee(Employee employee){
        String sql = "INSERT INTO employees (id, name, designation, department) values(?, ?, ?, ?)";
        template.update(sql, employee.getId(), employee.getName(), employee.getDesignation(), employee.getDepartment());
        return employee;
    }

    private class EmployeeMapper implements RowMapper<Employee>{
        @Override
        public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
            Employee employee = new Employee();
            employee.setId(rs.getInt("id"));
            employee.setName(rs.getString("name"));
            employee.setDesignation(rs.getString("designation"));
            employee.setDepartment(rs.getString("department"));
            return employee;
        }
    }
}
