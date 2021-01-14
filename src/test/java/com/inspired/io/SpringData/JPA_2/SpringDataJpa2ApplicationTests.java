package com.inspired.io.SpringData.JPA_2;

import com.inspired.io.SpringData.JPA_2.Model.Employee;
import com.inspired.io.SpringData.JPA_2.Model.Product;
import com.inspired.io.SpringData.JPA_2.Model.Student;
import com.inspired.io.SpringData.JPA_2.Repositories.EmployeeRepository;
import com.inspired.io.SpringData.JPA_2.Repositories.ProductRepository;
import com.inspired.io.SpringData.JPA_2.Repositories.StudentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
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
	StudentRepository studentRepository;

	@Autowired
   public SpringDataJpa2ApplicationTests(ProductRepository productRepository, EmployeeRepository employeeRepository, StudentRepository studentRepository){
   	this.productRepository = productRepository;
   	this.employeeRepository = employeeRepository;
   	this.studentRepository = studentRepository;
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
		results.forEach( result -> System.out.println(result.getName()));
	}

	@Test
	public void testFindAllPagingAndSorting(){
		Pageable pageable = PageRequest.of(0,3, Sort.by("name").descending().and(Sort.by("price").descending()));
		Iterable<Product> results = productRepository.findAll(pageable);
		results.forEach(result -> System.out.println(result.getName()+" -----> "+result.getPrice()));
	}

	@Test
	public void testStudentCreate(){
		Student student = new Student();
		student.setFirstname("Erastus");
		student.setLastname("Doh");
		student.setScore(89.0);
		studentRepository.save(student);

		Student student1 = new Student();
		student1.setFirstname("Francis");
		student1.setLastname("Deh");
		student1.setScore(98.1);
		studentRepository.save(student1);

		Student student2 = new Student();
		student2.setFirstname("Vicent");
		student2.setLastname("Tetteh");
		student2.setScore(90);
		studentRepository.save(student2);

		Student student3 = new Student();
		student3.setFirstname("Juliet");
		student3.setLastname("Ilupeju");
		student3.setScore(87);
		studentRepository.save(student3);

	}

	@Test
	public void	testFindAllStudents(){
		System.out.println(studentRepository.findAllStudents());;
//		students.forEach(student-> System.out.println(student.getFirstname() + " " + student.getLastname()));
	}



}





