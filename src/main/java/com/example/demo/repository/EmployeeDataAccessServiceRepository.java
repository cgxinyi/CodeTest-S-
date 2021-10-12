package com.example.demo.repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Stream;

import org.springframework.stereotype.Repository;

import com.example.demo.model.Employee;
import com.example.demo.model.Payslip;
import com.example.demo.service.EmployeeService;
import com.example.demo.service.EmployeeServiceImpl;


public class EmployeeDataAccessServiceRepository {
	private ArrayList<Employee> empDatabase = new ArrayList<Employee>();
	private Payslip payslip = new Payslip();


	public ArrayList<Employee> insertEmployee(ArrayList<Employee> employee)
	{
		EmployeeService taxthreshold = new EmployeeServiceImpl();
		ArrayList<Payslip> empPayslip = new ArrayList<Payslip>();
		LocalDate currentdate = LocalDate.now();
		for(int i = 0 ; i < employee.size() ; i++)
		{
	        payslip.setGrossIncome(employee.get(i).getAnnualSalary());
	        payslip.setSuperAmount(BigDecimal.valueOf(employee.get(i).getSuperRate()),payslip.getGrossIncome());
	        payslip.setIncomeTax(taxthreshold.calculateIncomeTax(payslip.getGrossIncome()));
	        payslip.setNetIncome(payslip.getGrossIncome(), payslip.getIncomeTax());
	        Month currentMonth = currentdate.getMonth();
	        int lastDay = Calendar.getInstance().getActualMaximum(Calendar.DATE);
	        String lastD = String.valueOf(lastDay);
	        String fromDate="01 "+ currentMonth;
	        String toDate = lastD + " " + currentMonth;
	        payslip = new Payslip(fromDate,toDate,payslip.getIncomeTax(),payslip.getNetIncome(),payslip.getSuperAmount(),payslip.getGrossIncome()); 	        
	    
	        empPayslip.add(payslip);
	        empDatabase.add(new Employee(employee.get(i).getFirstName(),employee.get(i).getLastName(),employee.get(i).getAnnualSalary(),employee.get(i).getSuperRate(),employee.get(i).getPaymentMonth(),empPayslip.get(i)));
		}
		
		return empDatabase;
	}

	 
}
