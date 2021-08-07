package com.example.demo.restapi;

import org.springframework.http.MediaType;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.ListOfTaxthreshold;
import com.example.demo.employee;
import com.example.demo.payslip;

import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import net.minidev.json.JSONValue;

import java.time.LocalDate;
import java.time.Month;
import java.util.*;



@RestController

public class employeeEndPoint {
	private ListOfTaxthreshold taxthresholds = new ListOfTaxthreshold();
	
	@PostMapping(value="/postpayslip", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public JSONArray response(@RequestBody String payload){
		
		JSONArray jArray = (JSONArray) JSONValue.parse(payload);
		payslip payslip=new payslip();
		LocalDate currentdate = LocalDate.now();
		
		ArrayList<employee> employee = new ArrayList<employee>();
		ArrayList<payslip> emppayslip = new ArrayList<payslip>();
		
		
		for(int i = 0 ; i < jArray.size() ; i++)
		{
			JSONObject jObj = (JSONObject) jArray.get(i);
			String firstName = jObj.get("firstName").toString();
			String lastName = jObj.get("lastName").toString();
			int annualSalary = Integer.parseInt(jObj.get("annualSalary").toString());		
			int superRate = Integer.parseInt(jObj.get("superRate").toString());
			int paymentMonth = Integer.parseInt(jObj.get("paymentMonth").toString());
			employee employeeadd = new employee(firstName,lastName,annualSalary,superRate,paymentMonth);
			employee.add(employeeadd);
		}
		
		for(int i = 0 ; i < employee.size() ; i++)
		{
			
	        payslip.setGrossIncome(employee.get(i).getAnnualSalary());
	        payslip.setSuperAmount(employee.get(i).getSuperRate(),payslip.getGrossIncome());
	        payslip.setIncomeTax(calculateIncomeTax(payslip.getGrossIncome()));
	        payslip.setNetIncome(payslip.getGrossIncome(), payslip.getIncomeTax());
	        Month currentMonth = currentdate.getMonth();
	        int lastDay = Calendar.getInstance().getActualMaximum(Calendar.DATE);
	        String lastD = String.valueOf(lastDay);
	        String fromDate="01 "+ currentMonth;
	        String toDate = lastD + " " + currentMonth;
	        payslip = new payslip(fromDate,toDate,payslip.getIncomeTax(),payslip.getNetIncome(),payslip.getSuperAmount(),payslip.getGrossIncome());
	        emppayslip.add(payslip);	        
		}
		
		JSONObject obj = new JSONObject();
		JSONObject employeeobj = new JSONObject();
		JSONObject employeepayobj = new JSONObject();
		obj.put("employee", employeeobj);
		obj.put("payslip",employeepayobj);
	
		JSONArray result = new JSONArray();
	
		for(int i = 0 ; i < employee.size() ; i++)
		{	
			employeeobj.put("firstName",employee.get(i).getFirstName());
			employeeobj.put("lastName",employee.get(i).getLastName());
			employeeobj.put("annualSalary",employee.get(i).getAnnualSalary());
			employeeobj.put("paymentMonth",employee.get(i).getPaymentMonth());
			employeeobj.put("superRate",employee.get(i).getSuperRate());
			employeepayobj.put("fromDate", emppayslip.get(i).getFromDate());
			employeepayobj.put("toDate", emppayslip.get(i).getToDate());
			employeepayobj.put("grossIncome", emppayslip.get(i).getGrossIncome());
			employeepayobj.put("superannuation", emppayslip.get(i).getSuperAmount());
			employeepayobj.put("netIncome", emppayslip.get(i).getNetIncome());
			result.add(obj);
		}
		
		
	   return result;
	}
	
	public ListOfTaxthreshold loadTaxthreshold()
	{
		taxthresholds.addTaxthreshold(0, 0, 0);
		taxthresholds.addTaxthreshold(18200, 0.19, 0);
		taxthresholds.addTaxthreshold(37000, 0.325, 3572);
		taxthresholds.addTaxthreshold(87000, 0.37, 19822);
		taxthresholds.addTaxthreshold(180000, 0.45, 54232);
		return taxthresholds;
	}
	
	public int calculateIncomeTax(int grossIncome)
	{
		int incomeTax=0;
		loadTaxthreshold();
		int rangeCheck=1;
		for(int i=0;i<taxthresholds.getNumberOfTaxthreshold();i++)
		{
			int lastIndex = taxthresholds.getNumberOfTaxthreshold()-1;
			int calc = grossIncome - taxthresholds.getTaxthreshold(i).getTaxMax();
			while (i != lastIndex && rangeCheck>0 && calc>0)
			{
				rangeCheck = grossIncome - taxthresholds.getTaxthreshold(i+1).getTaxMax();	
				break;
			}
			
			while(i==lastIndex)
			{
				rangeCheck=-1;
				break;
			}
			double taxCent = taxthresholds.getTaxthreshold(i).getTaxCent();
			int taxLump = taxthresholds.getTaxthreshold(i).getTaxLump();
			
			while(calc>0 && rangeCheck<0)
			{
				double tempGross = (double) calc*taxCent;
	            incomeTax = (int) Math.round(tempGross)+taxLump;
	            break;
			}
		}
		return incomeTax;
	}

	@GetMapping("/welcome")
	public String welcome() {
		return "welcome cg";
	}	
}