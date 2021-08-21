package com.example.demo.model;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Employee {
	 private String firstName;
	 private String lastName;
	 private int annualSalary;
	 private int superRate;
	 private int paymentMonth;

	    
	  public Employee(@JsonProperty("firstName") String first,
			  			@JsonProperty("lastName") String last,
			  			@JsonProperty("annualSalary") int annual,
			  			@JsonProperty("superRate") int superrate,
			  			@JsonProperty("paymentMonth") int month)
	  {
	      firstName = first;
	      lastName = last;
	      annualSalary = annual;
	      superRate = superrate;
	      paymentMonth = month;
	  }

	     public String getFirstName() {
	        return firstName;
	     }

	     public String getLastName() {
	        return lastName;
	     }

	     public int getAnnualSalary() {
	        return annualSalary;
	     }

	     public int getSuperRate() {
	         return superRate;
	     }

	     public int getPaymentMonth() {
	         return paymentMonth;
	     }

	     public void setFirstName(String firstName) {
	        this.firstName = firstName;
	     }

	     public void setLastName(String lastName) {
	         this.lastName = lastName;
	     }

	     public void setAnnualSalary(int annualSalary) {
	         this.annualSalary = annualSalary;
	     }

	     public void setSuperRate(int superRate) {
	     
	         this.superRate = superRate;
	         
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