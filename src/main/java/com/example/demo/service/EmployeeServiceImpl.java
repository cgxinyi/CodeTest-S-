package com.example.demo.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.demo.model.Employee;
import com.example.demo.model.Taxthreshold;
import com.example.demo.repository.EmployeeDataAccessServiceRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	private ArrayList<Taxthreshold> taxthresholds;
	private EmployeeDataAccessServiceRepository empDao = new EmployeeDataAccessServiceRepository() ;

	
	@Override
	public ArrayList<Taxthreshold> loadTaxthreshold()
	{
		taxthresholds= new ArrayList<Taxthreshold>();
		taxthresholds.add(new Taxthreshold(BigDecimal.valueOf(0), BigDecimal.valueOf(0), BigDecimal.valueOf(0)));
		taxthresholds.add(new Taxthreshold(BigDecimal.valueOf(18200), BigDecimal.valueOf(0.19), BigDecimal.valueOf(0)));
		taxthresholds.add(new Taxthreshold(BigDecimal.valueOf(37000), BigDecimal.valueOf(0.325), BigDecimal.valueOf(3572)));
		taxthresholds.add(new Taxthreshold(BigDecimal.valueOf(87000), BigDecimal.valueOf(0.37), BigDecimal.valueOf(19822)));
		taxthresholds.add(new Taxthreshold(BigDecimal.valueOf(180000), BigDecimal.valueOf(0.45), BigDecimal.valueOf(54232)));
		return taxthresholds;
	}
	
	@Override
	public BigDecimal calculateIncomeTax(BigDecimal grossIncome)
	{
		loadTaxthreshold();
		BigDecimal incomeTax=null;
		for(int i=0;i<taxthresholds.size();i++)
		{
			if(grossIncome.compareTo(taxthresholds.get(i).getTaxMin())>0 || incomeTax==null)
			{
				incomeTax = (taxthresholds.get(i).getTaxLump()).add(((grossIncome.subtract(taxthresholds.get(i).getTaxMin())).multiply(taxthresholds.get(i).getTaxCent())));
			}
		}
		
		return incomeTax;
	}
	
	public ArrayList<Employee> insertEmployee(ArrayList<Employee> employee)
	{
	
		return empDao.insertEmployee(employee);
	}
	
	
	
	
	

}
