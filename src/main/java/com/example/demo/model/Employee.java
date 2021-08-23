package com.example.demo.model;

import java.math.BigDecimal;
import java.util.UUID;

import org.springframework.lang.Nullable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Employee {
	 private String firstName;
	 private String lastName;
	 private BigDecimal annualSalary;
	 private int superRate;
	 private int paymentMonth;
	 private Payslip payslip;
	    
	  public Employee(@JsonProperty("firstName") String first,
			  			@JsonProperty("lastName") String last,
			  			@JsonProperty("annualSalary") BigDecimal annual,
			  			@JsonProperty("superRate") int superrate,
			  			@JsonProperty("paymentMonth") int month,
			  			 Payslip paysl)
	  
	  {
	      firstName = first;
	      lastName = last;
	      annualSalary = annual;
	      superRate = superrate;
	      paymentMonth = month;
	      payslip = paysl;
	  }

	     public String getFirstName() {
	        return firstName;
	     }

	     public String getLastName() {
	        return lastName;
	     }

	     public BigDecimal getAnnualSalary() {
	        return annualSalary;
	     }

	     public int getSuperRate() {
	         return superRate;
	     }

	     public int getPaymentMonth() {
	         return paymentMonth;
	     }
	     
	     public Payslip getPayslip()
	     {
	    	 return payslip;
	     }

	     public void setFirstName(String firstName) {
	        this.firstName = firstName;
	     }

	     public void setLastName(String lastName) {
	         this.lastName = lastName;
	     }

	     public void setAnnualSalary(BigDecimal annualSalary) {
	         this.annualSalary = annualSalary;
	     }

	     public void setSuperRate(int superRate) {
	     
	         this.superRate = superRate;
	         
	     }
	     
	     public void setPayslip(Payslip payslip)
	     {
	    	 this.payslip = payslip;
	     }

	     public void setPaymentStartDate(int paymentMonth) {
	         this.paymentMonth = paymentMonth;
	     }

	     public void displayEmployee()
	     {
	        
	         System.out.println("First name: " + firstName);
	         System.out.println("Last name: " + lastName);
	         System.out.println("Annual Salary: " + annualSalary);
	         System.out.println("Super Rate: " + superRate);
	         System.out.println("Payment Month: " + paymentMonth);
	     }

	     public String toString()
	     {
	         return firstName + lastName + annualSalary + superRate + paymentMonth;
	     }

	    

	 }