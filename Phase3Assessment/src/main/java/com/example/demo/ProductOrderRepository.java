package com.example.demo;

import org.springframework.data.repository.CrudRepository;

public interface ProductOrderRepository extends CrudRepository<Product, Integer>  {

}
