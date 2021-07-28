

public class Main {
    private static employee employee;

    public static void main(String[] args) {
        payslip pay = new payslip();
        pay.getIncomeTax(87000);
        System.out.println("=====================================");
        System.out.println("                     Welcome to Monthly Employee PaySlip Calculator                ");
        System.out.println("=====================================");
        setEmployee();
        
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

        employee employee = new employee(firstName,lastName,annualSalary,superRate,start);
        employee.displayEmployee();


        

    }

    
    

}