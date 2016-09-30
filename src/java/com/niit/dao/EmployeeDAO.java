
package com.niit.dao;

import com.niit.entity.Employee;
import java.util.List;

public interface EmployeeDAO {
    
    Employee get(int id);
    List<Employee> getAll();
    void delete(int id);
    void insert(Employee employee);
    void update(Employee employee);
    
    
    
}
