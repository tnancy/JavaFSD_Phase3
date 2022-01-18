package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController 
{
	@Autowired
	private ProductService service;
	
	//post
	@PostMapping("/addProduct")
	public Product addProduct(@RequestBody Product product)
	{
		return service.saveProduct(product);
	}
	
	@PostMapping("/addProducts")
	public List<Product> addProducts(@RequestBody List<Product> products)
	{
		return service.saveProducts(products);
	}
	
	@GetMapping("/products")
	public List<Product> findAllProducts()
	{
		return service.getProducts();
	}
	
	@GetMapping("/productId/{id}")
	public Product findProductById(@PathVariable int id)
	{
		return service.getProductById(id);
	}
	
	@GetMapping("/productName/{name}")
	public List<Product> findByName(@PathVariable String name)
	{
		return (List<Product>) service.getProductByName(name);
	}
	
	/*@GetMapping("/productSeason/{season}")
	public Product findProductBySeason(@PathVariable String season)
	{
		return service.getProductBySeason(season);
	}*/
	
	@GetMapping("/productSeason/{season}")
	public List<Product> findAllBySeason(@PathVariable String season)
	{
		return (List<Product>) service.getProductBySeason(season);
	}
	
	@GetMapping("/productBrand/{brand}")
	public List<Product> findAllByBrand(@PathVariable String brand)
	{
		return (List<Product>) service.getProductByBrand(brand);
	}
	
	@GetMapping("/productCategory/{category}")
	public List<Product> findAllByCategory(@PathVariable String category)
	{
		return (List<Product>) service.getProductByCategory(category);
	}
	
	@GetMapping("/productPrice/{price}")
	public List<Product> findAllByPrice(@PathVariable double price)
	{
		return (List<Product>) service.getProductByPrice(price);
	}
	
	@GetMapping("/productColor/{color}")
	public List<Product> findAllByColor(@PathVariable String color)
	{
		return (List<Product>) service.getProductByColor(color);
	}
	
	/*//@GetMapping("/productDate/{createdDate}")
	@RequestMapping(value="/productDate/{createdDate}", method=RequestMethod.GET)
	public List<Product> findAllByCreatedDate(@PathVariable("createdDate") String createdDate)
	{
		return (List<Product>) service.getProductByCreatedDate(createdDate);
	}*/
	
	@GetMapping("/productDate")
	public List<Product> findAllByOrderByCreatedDateDesc()
	{
		return (List<Product>) service.getProductByCreatedDate();
	}
	
	@PutMapping("/update")
	public Product updateProduct(@RequestBody Product product)
	{
		return service.updateProduct(product);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteProduct(@PathVariable int id)
	{
		return service.deleteProduct(id);
	}
	
	@DeleteMapping("/delete")
	public String deleteProducts()
	{
		return service.deleteProducts();
	}
}
