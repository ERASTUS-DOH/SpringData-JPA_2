package com.inspired.io.SpringData.JPA_2.Repositories;

import com.inspired.io.SpringData.JPA_2.Model.Employeee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeeRepository extends CrudRepository<Employeee, Integer> {
}
