package com.empapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.empapp.entity.Employee;

@Controller
public class EmployeeController {
	
	//http://localhost:8080/viewAddEmployee
	@RequestMapping("/viewAddEmployee")//@WebServlet
	public String viewAddEmployeePage() {
		return "add_employee";//RequestDispatcher
			
		}
	@RequestMapping("/addAddEmployee")
	public String addEmployee(Employee emp) {
		System.out.print(emp.getName());
		System.out.println(emp.getName());
		System.out.println(emp.getMobile());
		System.out.println(emp.getEmail());
		return "add_employee";
		
	}
		
	}

