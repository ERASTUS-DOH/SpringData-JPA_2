package com.inspired.io.SpringData.JPA_2.Repositories;

import com.inspired.io.SpringData.JPA_2.Model.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
}
