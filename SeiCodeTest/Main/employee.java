package Main;

public class employee {
    
   String firstName;
   String lastName;
   int annualSalary;
   int superRate;
   String paymentStartDate;

    
    public employee(String first, String last, int annual,int superrate,String start)
    {
       firstName = first;
       lastName = last;
       annualSalary = annual;
       superRate = superrate;
       paymentStartDate = start;
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

    public String getPaymentStartDate() {
        return paymentStartDate;
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

    public void setPaymentStartDate(String paymentStartDate) {
        this.paymentStartDate = paymentStartDate;
    }

    public void displayEmployee()
    {
       
        System.out.println("First name: " + firstName);
        System.out.println("Last name: " + lastName);
        System.out.println("Annual Salary: " + annualSalary);
        System.out.println("Super Rate: " + superRate);
        System.out.println("Payment Start Date: " + paymentStartDate);
    }

    public String toString()
    {
        return firstName + lastName + annualSalary + superRate + paymentStartDate;
    }

   

}