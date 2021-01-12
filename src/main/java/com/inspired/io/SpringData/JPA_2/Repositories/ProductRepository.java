package com.inspired.io.SpringData.JPA_2.Repositories;

import com.inspired.io.SpringData.JPA_2.Model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;


public interface ProductRepository extends PagingAndSortingRepository<Product, Integer> {
    List<Product> findByName(String name);
    List<Product> findByNameAndPrice(String name, Double price);
    List<Product> findByPriceGreaterThan(Double price);
    List<Product> findByDescContains(String word);
    List<Product> findByPriceBetween(Double price1, Double price2);
    List<Product> findByDescLike(String desc);
    List<Product> findByIdIn(List<Integer> ids);
}
