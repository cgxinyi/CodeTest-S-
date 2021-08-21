package com.example.demo.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import com.example.demo.model.Employee;

public interface EmployeeServiceDAO {
	HashMap<Object, Object> insertEmployee(List<Employee> Employee);
	
}
