package com.inspired.io.SpringData.JPA_2;

import com.inspired.io.SpringData.JPA_2.Model.Employee;
import com.inspired.io.SpringData.JPA_2.Model.Product;
import com.inspired.io.SpringData.JPA_2.Repositories.EmployeeRepository;
import com.inspired.io.SpringData.JPA_2.Repositories.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SpringDataJpa2ApplicationTests {

	ProductRepository productRepository;
	EmployeeRepository employeeRepository;

	@Autowired
   public SpringDataJpa2ApplicationTests(ProductRepository productRepository, EmployeeRepository employeeRepository){
   	this.productRepository = productRepository;
   	this.employeeRepository = employeeRepository;
   }

	@Test
	void contextLoads() {
	}

	@Test
	public void testCreate(){
		Product product = new Product();
		product.setId(1);
		product.setName("Vita Milk");
		product.setDesc("Awesome Product");
		product.setPrice(1500.0);
		productRepository.save(product);
	}

	@Test
	public void findOne(){
		Optional<Product> product = productRepository.findById(1);
		if(product.isPresent()){
		 Product testProduct =	product.get();
			assertNotNull(testProduct);
			assertEquals("Coke",testProduct.getName());
		}
	}

	@Test
	public void testUpdate(){
		Optional<Product> product = productRepository.findById(1);
		if(product.isPresent()){
			Product testProduct = product.get();
			testProduct.setName("Minute Maid");
			productRepository.save(testProduct);

		}

	}


	@Test
	public void testDelete(){
		if(productRepository.existsById(1)){
			System.out.println("Deleting product");
			productRepository.deleteById(1);
		}

//	Iterable<Product> products =productRepository.findAll();
//	Optional<Product> product = productRepository.findById(1);
//	assertNull();
	}

	@Test
	public void testCreateEmployee(){
		Employee employee = new Employee();
		employee.setName("Erastus Doh");
		employeeRepository.save(employee);
	}

	@Test
	public void testFindByName(){
		List<Product> productList = productRepository.findByName("Tesla");
		productList.forEach(p -> System.out.println(p.getDesc()));
	}

	@Test
	public void testFindByNameAndPrice(){
		List<Product> products = productRepository.findByNameAndPrice("Tesla",125.5);
		for (Product product : products) {
			System.out.println(product.getName());
		}
	}

	@Test
	public void testFindByPriceGreaterThan(){
		List<Product> productList = productRepository.findByPriceGreaterThan(12.0);
		productList.forEach(product -> System.out.println(product.getPrice()));
	}

	@Test
	public void testFindByDescContains(){
		List<Product> productList = productRepository.findByDescContains("es");
		productList.forEach(product -> System.out.println(product.getName()));
	}

	@Test
	public void testFindByPriceBetweenPrice1AndPrice2(){
		List<Product> productList = productRepository.findByPriceBetween(30.0, 1500.0);
		productList.forEach(product -> System.out.println(product.getName()));
	}

	@Test
	public void testFindByDescLike(){
		Pageable pageable = PageRequest.of(0,3);
		List<Product> productList = productRepository.findByDescLike("%best%", pageable);
		productList.forEach(product -> System.out.println(product.getName()));
	}

	@Test
	public void testFindByIdsIn(){
		List<Product> productList = productRepository.findByIdIn(Arrays.asList(1,3,3));
		productList.forEach(product -> System.out.println(product.getName()));
	}

	@Test
	public void testFindAllPaging(){
		Pageable pageable = PageRequest.of(0,3);
		Iterable<Product> results = productRepository.findAll(pageable);
		results.forEach( result -> System.out.println(result.getName()
		));
	}

	@Test
	public void testFindAllPagingAndSorting(){
		Pageable pageable = PageRequest.of(0,3, Sort.by("name").descending().and(Sort.by("price").descending()));
		Iterable<Product> results = productRepository.findAll(pageable);
		results.forEach(result -> System.out.println(result.getName()+" -----> "+result.getPrice()));
	}

}





