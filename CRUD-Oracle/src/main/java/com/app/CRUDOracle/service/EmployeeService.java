package com.app.CRUDOracle.service;

import com.app.CRUDOracle.dto.RequestDTO;
import com.app.CRUDOracle.model.Employee;
import com.app.CRUDOracle.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

    public Object saveEmployee(Employee employee){
        Employee newEmployee = employeeRepo.save(employee);

        RequestDTO newRequestDTO = mapperToRequestDTO(newEmployee);

        return newRequestDTO;
    }

    private RequestDTO mapperToRequestDTO(Employee employee) {
        RequestDTO request= new RequestDTO();

        request.setId(employee.getId());
        request.setName(employee.getName());

        return request;

    }

}
