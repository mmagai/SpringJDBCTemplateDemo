package com.example.springJdbcDemo.repo;

import com.example.springJdbcDemo.model.Employee;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class PostRepo {


    private JdbcTemplate jdbcTemplate;

    public PostRepo(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(Employee employee){

        String sql = "insert into employee (id,firstname,lastname) values(?,?,?)";
        jdbcTemplate.update(sql, employee.getId(),employee.getFirstName(),employee.getLastName());


    }
    public List<Employee> findAll(){

        String sql = "select * from employee";
       RowMapper<Employee> rowMapper = new RowMapper<Employee>() {
            @Override
            public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {

                Employee employee = new Employee();
                employee.setId(rs.getInt(1));
                employee.setFirstName(rs.getString(2));
                employee.setLastName(rs.getString(3));
                return employee;
            }
        };

        List<Employee> result = jdbcTemplate.query(sql, rowMapper);
        return result;
    }
}
