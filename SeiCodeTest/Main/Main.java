package Main;

public class Main {
    private static employee employee;
    private static payslip payslip;

    public static void main(String[] args) {

        System.out.println("=======================================================================");
        System.out.println("            Welcome to Monthly Employee PaySlip Calculator            ");
        System.out.println("=======================================================================");
        setEmployee();
        getPayslip();   
    }

    public employee getEmployee() {
        return employee;
    }

    public static void setEmployee() {   
        validation valid = new validation();
        boolean validUserInput=false;
        boolean validUserInput1=false;
        boolean validUserInput2=false;
        int superRate=0;
        int annualSalary=0;
        String start = "";

        String firstName = valid.acceptStringInput("Please enter your first name:");
        String lastName = valid.acceptStringInput("Please enter your last name:");
        while(validUserInput==false)
        {
            annualSalary = valid.acceptIntegerInput("Please enter your annual salary:");
            validUserInput=valid.checkIntegerWithinRange(annualSalary,0,1000000000);
        }
    
        while(validUserInput1==false)
        {
            superRate = valid.acceptIntegerInput("Please enter your super rate:");
            validUserInput1=valid.checkIntegerWithinRange(superRate,0,50);
        }

        while(validUserInput2==false)
        {
            start = valid.acceptStringInput("Please enter your payment start month:");
            validUserInput2 = valid.checkStringLength("month", start);
            validUserInput2 = valid.checkInputIsMonth(start);
        }
        employee = new employee(firstName,lastName,annualSalary,superRate,start);  
    }

    public static void getPayslip()
    {
        validation valid = new validation();
        payslip = new payslip();
        payslip.setGrossIncome(employee.getAnnualSalary());
        payslip.setSuperAmount(employee.getSuperRate(),payslip.getGrossIncome());
        payslip.setIncomeTax(payslip.getGrossIncome());
        payslip.setNetIncome(payslip.getGrossIncome(), payslip.getIncomeTax());
        String payperiod = employee.getPaymentStartDate();
        payslip.setPayPeriod(valid.validMonth(payperiod));
        System.out.println("===========Your Monthly Payslip===========");
        System.out.println("Name: " + employee.getFirstName()+ " " + employee.getLastName());
        payslip.displayPayslip();
    }

}