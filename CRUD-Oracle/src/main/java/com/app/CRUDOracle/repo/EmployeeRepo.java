package com.app.CRUDOracle.repo;

import com.app.CRUDOracle.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository<Employee,Integer> {

}
