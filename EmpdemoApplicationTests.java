package com.demo;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.demo.entity.Employee;
import com.demo.repository.EmployeeRepository;

@SpringBootTest
class EmpdemoApplicationTests {
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@Test
	void saveEmployee() {
		Employee emp = new Employee();
		emp.setName("adam");
		emp.setEmail("adam@gmail.com");
		emp.setMobile("9632629066");
		emp.setSalary(10000);
		
		employeeRepository.save(emp);
			

	}
	
	@Test
	void deleteEmployeeById() {
		employeeRepository.deleteById(3L);
		
	}
	
	@Test
	void findEmployeeById() {
		Optional<Employee> byId = employeeRepository.findById(4L);
		if(byId.isPresent()) {
			Employee employee = byId.get();
			System.out.println(employee.getId());
			System.out.println(employee.getName());
			System.out.println(employee.getMobile());
		}else {
			System.out.println("No Record Found");
		}
	}
	@Test
	void getAllEmployee() {
		Iterable<Employee> empItr = employeeRepository.findAll();
		for(Employee employee : empItr) {
			System.out.println(employee.getId());
			System.out.println(employee.getName());
			System.out.println(employee.getMobile());
			System.out.println(employee.getEmail());
			System.out.println(employee.getSalary());
		}
		
		}
	
	@Test
	void findEmployeeByEmail() {
		Optional<Employee> byEmail = employeeRepository.findByEmail("mike@gmail.com");
		if(byEmail.isPresent()) {
			Employee employee = byEmail.get();
			System.out.println(employee.getId());
			System.out.println(employee.getName());
			System.out.println(employee.getMobile());
		}else {
			System.out.println("No Record Found");
		}
	
	}
	
	@Test
	void findEmployeeByMobile() {
		Optional<Employee> byMobile = employeeRepository.findByMobile("9632629033");
		if(byMobile.isPresent()) {
			Employee employee = byMobile.get();
			System.out.println(employee.getId());
			System.out.println(employee.getName());
			System.out.println(employee.getMobile());
		}else {
			System.out.println("No Record Found");
		}
	
	}
	
	@Test
	void findEmployeeByEmailAndMobile() {
		Optional<Employee> byMobile = employeeRepository.findByEmailAndMobile("mike@gmail.com","9632629033");
		if(byMobile.isPresent()){
			Employee employee = byMobile.get();
			System.out.println(employee.getId());
			System.out.println(employee.getName());
			System.out.println(employee.getMobile());
		}else {
			System.out.println("No Record Found");
		}
		
			
	
	}
	
	@Test
	void findEmployeeByEmailOrMobile() {
		List<Employee> byMobile = employeeRepository.findByEmailOrMobile("stallin@gmail.com","9632629033");
		for(Employee employee : byMobile) {
			System.out.println(employee.getId());
			System.out.println(employee.getName());
			System.out.println(employee.getMobile());
		}
			
	}
	@Test
	void existsEmployeeByEmail() {
		boolean val = employeeRepository.existsByEmail("stallin@gmail.com");
			System.out.println(val);
		}
	
	@Test
	void existsEmployeeByMobile() {
		boolean val = employeeRepository.existsByMobile("9632629033");
			System.out.println(val);
		}
	@Test
	void updateEmployee() {
		Employee emp = new Employee();
		emp.setId(8);
		emp.setName("adam");
		emp.setEmail("adam.a@gmail.com");
		emp.setMobile("9632629066");
		emp.setSalary(20000);
		
		employeeRepository.save(emp);
	}
	@Test
	void findQueryByEmailEmployee() {
		Employee emp = employeeRepository.findEmployeeByEmail("mike@gmail.com");
		System.out.println(emp.getId());
		System.out.println(emp.getName());
		System.out.println(emp.getMobile());
		
	}
	@Test
	void findQueryByMobileEmployee() {
		Employee emp = employeeRepository.findEmployeeByMobile("9632629033");
		System.out.println(emp.getId());
		System.out.println(emp.getName());
		System.out.println(emp.getMobile());
		
		
	}
	
	@Test
	void findEmployeeByEmailAndMobileQuery() {
		Employee employee = employeeRepository.findEmployeeEmailAndMobile("mike@gmail.com","9632629033");
			System.out.println(employee.getId());
			System.out.println(employee.getName());
			System.out.println(employee.getMobile());
	}
	
	
	
}

