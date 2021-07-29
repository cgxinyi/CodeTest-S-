package Main;

public class Main {
    private static employee employee;
    private static payslip payslip;

    public static void main(String[] args) {

        System.out.println("=======================================================================");
        System.out.println("                     Welcome to Monthly Employee PaySlip Calculator                ");
        System.out.println("=======================================================================");
        setEmployee();
        getPayslip();   
    }

    public employee getEmployee() {
        return employee;
    }

    public static void setEmployee() {
        validation valid = new validation();

        String firstName = valid.acceptStringInput("Please enter your first name:");
        String lastName = valid.acceptStringInput("Please enter your last name:");
        int annualSalary = valid.acceptIntegerInput("Please enter your annual salary:");;
        int superRate = valid.acceptIntegerInput("Please enter your super rate:");
        String start = valid.acceptStringInput("Please enter your payment start date:");;
        employee = new employee(firstName,lastName,annualSalary,superRate,start);
        
    }

    public static void getPayslip()
    {
        payslip = new payslip();
        payslip.setGrossIncome(employee.getAnnualSalary());
        payslip.setSuperAmount(employee.getSuperRate(),payslip.getGrossIncome());
        payslip.setIncomeTax(payslip.getGrossIncome());
        payslip.setNetIncome(payslip.getGrossIncome(), payslip.getIncomeTax());
        payslip.setPayPeriod("");
        System.out.println("===========Your Monthly Payslip===========");
        System.out.println("Name: " + employee.getFirstName()+ " " + employee.getLastName());
        payslip.displayPayslip();
    }

}