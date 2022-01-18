package com.example.demo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {

	List<Product> findAllBySeason(String season);

	List<Product> findAllByBrand(String brand);

	List<Product> findAllByColor(String color);

	List<Product> findAllByCategory(String category);

	List<Product> findAllByCreatedDate(String createdDate);

	List<Product> findAllByPrice(double price);

	List<Product> findAllByName(String productName);

	List<Product> findByOrderByCreatedDateDesc();
}
