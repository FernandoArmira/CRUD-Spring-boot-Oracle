package com.app.CRUDOracle.service;

import com.app.CRUDOracle.dto.RequestDTO;
import com.app.CRUDOracle.model.Employee;
import com.app.CRUDOracle.repo.EmployeeRepo;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

    public Object saveEmployee(Employee employee){
        Employee newEmployee = employeeRepo.save(employee);

        RequestDTO newRequestDTO = mapperToRequestDTO(newEmployee);

        return response(employee);
    }

    private RequestDTO mapperToRequestDTO(Employee employee) {
        RequestDTO request= new RequestDTO();

        request.setId(employee.getId());
        request.setName(employee.getName());

        return request;

    }

    public Map<String, Object> response(Employee employee) {
        LinkedHashMap<String, Object> map = new LinkedHashMap<>();
        map.put("code", 0);
        map.put("faultDetails", details(employee));
        map.put("hasError", "false");
        map.put("message", "Cliente registrado correctamente para envío de encuesta");
        return map;
    }

    public Map<String, Object> details(Employee employee) {
        LinkedHashMap<String, Object> mapd = new LinkedHashMap<>();
        mapd.put("errorCode", 0);
        mapd.put("errorDetails", "Ok");
        String employeeData = "Id " + employee.getId() + ", Name " + employee.getName() + ", Salary " + employee.getSalary();
        mapd.put("errorMessage", employeeData);
        return mapd;
    }

}
