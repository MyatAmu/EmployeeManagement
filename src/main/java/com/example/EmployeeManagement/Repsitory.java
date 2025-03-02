package com.example.EmployeeManagement;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class Repsitory {
    private JdbcTemplate template;
    public Repsitory(JdbcTemplate template){
        this.template = template;
    }


}
