package com.example.demo.model;

import java.math.BigDecimal;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Payslip {
    String fromDate;
    String toDate;
    BigDecimal incomeTax;
    BigDecimal netIncome;
    BigDecimal superAmount;
    BigDecimal grossIncome;
    
    public Payslip()
    {
    	
    }
    
    public Payslip(@JsonProperty("fromDate") String fromD,
    				@JsonProperty("toDate") String toD, 
    				@JsonProperty("incomeTax") BigDecimal income,
    				@JsonProperty("netIncome") BigDecimal net,
    				@JsonProperty("superAmount") BigDecimal superA,
    				@JsonProperty("grossIncome") BigDecimal gross)
    {
    	fromDate = fromD;
    	toDate = toD;
    	incomeTax = income;
    	netIncome = net;
    	superAmount = superA;
    	grossIncome = gross;
    }
    
   
    public void setGrossIncome(BigDecimal annualSalary) {
    	BigDecimal divNum = BigDecimal.valueOf(12);
        grossIncome = annualSalary.divide(divNum);
    }

    public void setIncomeTax(BigDecimal incomeT) {
    	
    	incomeTax=incomeT;
    	
    }

    public void setNetIncome(BigDecimal grossIncome, BigDecimal incomeTax) {
        netIncome = grossIncome.subtract(incomeTax);
      
    }

    public void setSuperAmount(BigDecimal superRate, BigDecimal grossIncome) {
        superRate = superRate.divide(BigDecimal.valueOf(100));
        superAmount = superRate.multiply(grossIncome);
    }

    public void setFromDate(String date)
    {
    	this.fromDate = date;
    }
    
    public void setToDate(String date)
    {
    	this.toDate = date;
    }

    
    public String getFromDate()
    {
    	return fromDate;
    }
    
    public String getToDate()
    {
    	return toDate;
    }
    public BigDecimal getGrossIncome() {
        return grossIncome;
    }

    public BigDecimal getIncomeTax() {
        return incomeTax;
    }

    public BigDecimal getNetIncome() {
        return netIncome;
    }



    public BigDecimal getSuperAmount() {
        return superAmount;
    }


    public void displayPayslip()
    {
        System.out.println("From Date: " + fromDate);
        System.out.println("To Date: " + toDate);
        System.out.println("Gross Income: " + grossIncome);
        System.out.println("Income Tax: " + incomeTax);
        System.out.println("Net Income: " + netIncome);
        System.out.println("Super Amount: " + superAmount);
    }

    public String toString()
    {
        return fromDate + toDate + grossIncome + incomeTax + netIncome + superAmount;
    }
}