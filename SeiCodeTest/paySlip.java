public class payslip {
    int payPeriod;
    int incomeTax;
    int netIncome;
    int superAmount;
    int grossIncome;
    

    public int getPayPeriod(int month)
    {
        payPeriod = month * grossIncome;
        return payPeriod;
    }

    public int getGrossIncome(int annualSalary) {
        grossIncome = annualSalary/12;
        return grossIncome;
    }

    public int getIncomeTax() {
        if(grossIncome>=18201 && grossIncome<=37000)
        {
            double tempGross = (grossIncome-18200)*0.19;
            incomeTax = (int) tempGross;
        }
        if(grossIncome>=37001 && grossIncome<=87000)
        {
            double tempGross = (grossIncome-37000)*0.325;
            incomeTax = (int) tempGross+3572;
        }
        if(grossIncome>=87001 && grossIncome<=180000)
        {
            double tempGross = (grossIncome-87000)*0.37;
            incomeTax = (int) tempGross+19822;
        }
        if(grossIncome>=180001)
        {
            double tempGross = (grossIncome-180000)*0.45;
            incomeTax = (int) tempGross+54232;
        }
        return incomeTax;
    }

    public int getNetIncome() {
        netIncome = grossIncome-incomeTax;
        return netIncome;
    }

    public int getSuperAmount(int superRate) {
        superAmount = superRate * grossIncome;
        return superAmount;
    }

    public void setPayPeriod(int payPeriod) {
        this.payPeriod = payPeriod;
    }

    public void setGrossIncome(int grossIncome) {
        this.grossIncome = grossIncome;
    }

    public void setIncomeTax(int incomeTax) {
        this.incomeTax = incomeTax;
    }

    public void setNetIncome(int netIncome) {
        this.netIncome = netIncome;
    }

    public void setSuperAmount(int superAmount) {
        this.superAmount = superAmount;
    }

}
