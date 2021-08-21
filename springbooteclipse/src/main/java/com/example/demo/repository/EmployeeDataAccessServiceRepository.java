package com.example.demo.repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

import org.springframework.stereotype.Repository;

import com.example.demo.model.Employee;
import com.example.demo.model.Payslip;
import com.example.demo.service.EmployeeService;
import com.example.demo.service.EmployeeServiceImpl;

@Repository("main")
public class EmployeeDataAccessServiceRepository implements EmployeeServiceDAO {
	private ArrayList<Employee> empDatabase = new ArrayList<>();
	private Payslip payslip = new Payslip();
	private EmployeeService taxthreshold = new EmployeeServiceImpl();
	
	@Override
	public HashMap<Object, Object> insertEmployee(List<Employee> employee)
	{
		ArrayList<Payslip> empPayslip = new ArrayList<Payslip>();
		LocalDate currentdate = LocalDate.now();
		for(int i = 0 ; i < empDatabase.size() ; i++)
		{
			empDatabase.add(new Employee(employee.get(i).getFirstName(),employee.get(i).getLastName(),employee.get(i).getAnnualSalary(),employee.get(i).getSuperRate(),employee.get(i).getPaymentMonth()));
				
		}
	
		for(int i = 0 ; i < empDatabase.size() ; i++)
		{
	        payslip.setGrossIncome(BigDecimal.valueOf(empDatabase.get(i).getAnnualSalary()));
	        payslip.setSuperAmount(BigDecimal.valueOf(empDatabase.get(i).getSuperRate()),payslip.getGrossIncome());
	        payslip.setIncomeTax(taxthreshold.calculateIncomeTax(payslip.getGrossIncome()));
	        payslip.setNetIncome(payslip.getGrossIncome(), payslip.getIncomeTax());
	        Month currentMonth = currentdate.getMonth();
	        int lastDay = Calendar.getInstance().getActualMaximum(Calendar.DATE);
	        String lastD = String.valueOf(lastDay);
	        String fromDate="01 "+ currentMonth;
	        String toDate = lastD + " " + currentMonth;
	        payslip = new Payslip(fromDate,toDate,payslip.getIncomeTax(),payslip.getNetIncome(),payslip.getSuperAmount(),payslip.getGrossIncome()); 	        
	        empPayslip.add(payslip);
		}
	        
		HashMap<Object, Object> result = new HashMap<>();
		for(int i = 0; i < empDatabase.size(); i++) {
		    result.put(empDatabase.get(i), empPayslip.get(i));
		}
		
		return result;
	}

	 
}
