package com.app.CRUDOracle.controller;

import com.app.CRUDOracle.model.Employee;
import com.app.CRUDOracle.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeRepo employeeRepo;

    @PostMapping("/save")
    public ResponseEntity<String> saveEmployee(@RequestBody Employee employee){
        try {
            employeeRepo.save(employee);
        } catch (Exception e){
            return new ResponseEntity<String>("Not inserted", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<String>("Successfully entered", HttpStatus.OK);
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
