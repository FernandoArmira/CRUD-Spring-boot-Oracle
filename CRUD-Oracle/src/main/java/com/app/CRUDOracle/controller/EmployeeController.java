package com.app.CRUDOracle.controller;

import com.app.CRUDOracle.model.Employee;
import com.app.CRUDOracle.repo.EmployeeRepo;
import com.app.CRUDOracle.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/save")
    public ResponseEntity<Object> saveEmployee(@Valid @RequestBody Employee employee){
        //try {
            //employeeRepo.save(employee);
            return new ResponseEntity<>(employeeService.saveEmployee(employee), HttpStatus.OK);
        //} catch (Exception e){
            //return new ResponseEntity<>(employee, HttpStatus.INTERNAL_SERVER_ERROR);
        //}

    }

    @GetMapping("/select")
    public ResponseEntity<List<Employee>> getEmployees(){
        List<Employee> list = null;
        try {
            list = employeeRepo.findAll();
        } catch (Exception e){
            return new ResponseEntity<List<Employee>>(list, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<List<Employee>>(list, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") int id){
        try {
            employeeRepo.deleteById(id);
        } catch (Exception e){
            return new ResponseEntity<>("Not delete", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("Successfully delete", HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateEmployee(@RequestBody Employee employee){
        Optional<Employee> temp = employeeRepo.findById(employee.getId());
        Employee employeeUpdate = temp.get();
        employeeUpdate.setName(employee.getName());
        employeeUpdate.setSalary(employee.getSalary());
        employeeRepo.save(employeeUpdate);

        return new ResponseEntity<>("Successfully updated", HttpStatus.OK);
    }
}
