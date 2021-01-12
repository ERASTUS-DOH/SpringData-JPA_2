package com.inspired.io.SpringData.JPA_2.Repositories;

import com.inspired.io.SpringData.JPA_2.Model.Student;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Integer> {
}
