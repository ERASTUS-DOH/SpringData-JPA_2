package com.inspired.io.SpringData.JPA_2.Repositories;

import com.inspired.io.SpringData.JPA_2.Model.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer,Integer> {
}
