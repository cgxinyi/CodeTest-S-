package com.example.demo.restapi;

import static org.springframework.http.ResponseEntity.created;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.employee;
import java.util.*;





@RestController
@RequestMapping("/employee")
public class employeeEndPoint {
	@GetMapping("/postpayload")
    public String response(@RequestBody String payload) {
		ArrayList<String> employee = new ArrayList<String>();
		String [] singleEmployee = payload.split(",");
		for(int i = 0 ; i < singleEmployee.length ; i++)
		{
			employee.add(singleEmployee[i]);
		}
	   return "s";
	}
}
