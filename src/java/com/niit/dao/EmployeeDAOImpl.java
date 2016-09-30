/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.niit.dao;

import com.niit.entity.Employee;
import com.niit.util.DBUtil;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author MRuser
 */
public class EmployeeDAOImpl implements EmployeeDAO{
    private Connection con = DBUtil.getConnection();
    @Override
    public Employee get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Employee> getAll() {
        List<Employee> employees = new ArrayList<>();
        Employee employee = null;        
        String selectQuery = "SELECT * FROM  employee";
        
        try (Statement stmt = con.createStatement() ) {
        // fetch the records from table
            ResultSet rs = stmt.executeQuery(selectQuery);
            
            // for all the records loop through it
            while(rs.next()) {
                // got the record from the table 
                // and assigned it to a employee object
                employee = new Employee();
                employee.setId(rs.getInt("employee_id"));
                employee.setEmployeeName(rs.getString("employee_name"));
                employee.setDepartment(rs.getString("department"));
                
                // add it inside the collection
                employees.add(employee);
                
            }                        
            
            rs.close();
            
            return employees;
        
        }
        catch(SQLException ex) {
            System.out.println("SQL Error: " + ex.getMessage());
        }
        
        return null;
        
    }

    @Override
    public void delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void save(Employee employee) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Employee employee) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
