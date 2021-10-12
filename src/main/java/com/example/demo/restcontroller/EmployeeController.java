package com.example.demo.restcontroller;

import org.apache.tomcat.util.json.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;

import com.example.demo.model.Employee;
import com.example.demo.model.Payslip;
import com.example.demo.model.Taxthreshold;
import com.example.demo.service.EmployeeService;
import com.example.demo.service.EmployeeServiceImpl;

import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import net.minidev.json.JSONValue;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.util.*;


@RestController
@ComponentScan
public class EmployeeController {
	
	@Autowired
	private EmployeeService empService = new EmployeeServiceImpl();

	
	@PostMapping(value="/postpayslip", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public  ArrayList<Employee>  response(@RequestBody ArrayList<Employee> employee){
	
		return this.empService.insertEmployee(employee);

	}
	


	/*@GetMapping("/welcome")
	public String welcome() {
		return "welcome cg";
	}	*/
}