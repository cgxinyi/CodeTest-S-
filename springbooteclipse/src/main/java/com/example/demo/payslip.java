package com.example.demo;

public class payslip {
    String fromDate;
    String toDate;
    int incomeTax;
    int netIncome;
    int superAmount;
    int grossIncome;
    
    public payslip()
    {
    	
    }
    
    public payslip(String fromD,String toD, int income,int net,int superA, int gross)
    {
    	fromDate = fromD;
    	toDate = toD;
    	incomeTax = income;
    	netIncome = net;
    	superAmount = superA;
    	grossIncome = gross;
    }

    public void setGrossIncome(int annualSalary) {
        double temp = (double) annualSalary/12;
        grossIncome = (int) Math.round(temp);
    }

    public void setIncomeTax(int grossIncome) {
    	int num = (grossIncome >= 0) && (grossIncome <=18200) ? -1 : -1;
    	num = (grossIncome >= 18201) && (grossIncome <=37000 ) ? 1 : num;
    	num = (grossIncome >= 37001) && (grossIncome <=87000 ) ? 2 : num;
    	num = (grossIncome >= 87001) && (grossIncome <=180000 ) ? 3 : num;
    	num = (grossIncome >= 180001) ? 4 : num;
    	
    	double tempGross;
    	switch (num) {
        case 1 :
        	tempGross = (double)(grossIncome-18200)*0.19;
            incomeTax = (int) Math.round(tempGross);
            System.out.println("1");
           break;
        case 2 :
        	tempGross = (double)(grossIncome-37000)*0.325;
            incomeTax = (int) Math.round(tempGross)+3572;
            System.out.println("2");
           break;
        case 3 :
        	tempGross = (double)(grossIncome-87000)*0.37;
            incomeTax = (int) Math.round(tempGross)+19822;
            System.out.println("3");
           break;
        case 4 :
        	tempGross = (double)(grossIncome-180000)*0.45;
            incomeTax = (int) Math.round(tempGross+54232);
            System.out.println("4");
            break;
        default :
        	 System.out.println("-1");
          //for -1 do nothing;
    }
    	
      /*  if(grossIncome>=18201 && grossIncome<=37000)
        {
            double tempGross = (double)(grossIncome-18200)*0.19;
            incomeTax = (int) Math.round(tempGross);
        }
        if(grossIncome>=37001 && grossIncome<=87000)
        {
            double tempGross = (double)(grossIncome-37000)*0.325;
            incomeTax = (int) Math.round(tempGross)+3572;
        }
        if(grossIncome>=87001 && grossIncome<=180000)
        {
            double tempGross = (double)(grossIncome-87000)*0.37;
            incomeTax = (int) Math.round(tempGross)+19822;
        }
        if(grossIncome>=180001)
        {
            double tempGross = (double)(grossIncome-180000)*0.45;
            incomeTax = (int) Math.round(tempGross+54232);
        }
     */
    }

    public void setNetIncome(int grossIncome, int incomeTax) {
        netIncome = grossIncome-incomeTax;
      
    }

    public void setSuperAmount(double superRate, int grossIncome) {
        superRate = superRate / 100;
        double tempAmount = (double) superRate * grossIncome;
        superAmount = (int) Math.round(tempAmount);
  
    }

    public void setFromDate(String date)
    {
    	fromDate = date;
    }
    
    public void setToDate(String date)
    {
    	toDate = date;
    }

    
    public String getFromDate()
    {
    	return fromDate;
    }
    
    public String getToDate()
    {
    	return toDate;
    }
    public int getGrossIncome() {
        return grossIncome;
    }

    public int getIncomeTax() {
        return incomeTax;
    }

    public int getNetIncome() {
        return netIncome;
    }

   

    public int getSuperAmount() {
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