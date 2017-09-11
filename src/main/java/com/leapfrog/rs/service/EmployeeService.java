package com.leapfrog.rs.service;

import com.leapfrog.rs.model.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAll();
    Employee getById(int id);
    void add(Employee employee);
    Employee update(Employee employee);
    void delete(int id);
    int count();
}
