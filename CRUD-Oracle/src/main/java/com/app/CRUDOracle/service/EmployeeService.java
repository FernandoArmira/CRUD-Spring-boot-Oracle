package com.app.CRUDOracle.service;

import com.app.CRUDOracle.model.Employee;
import com.app.CRUDOracle.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

    public Employee saveEmployee(Employee employee){
        Employee newEmployee = employeeRepo.save(employee);
        return newEmployee;
    }

}
