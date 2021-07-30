package Main;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

public class payslipUnitTest {
    private payslip payslip = new payslip();

    @Test
    @DisplayName("test gross income getters and setters")
    public void testGrossIncomeGetterAndSetter() {
        payslip.setGrossIncome(60000);
        assertEquals(payslip.getGrossIncome(),5000);
    }

    @Test
    @DisplayName("test gross income round up when decimal is >0.5")
    public void testGrossIncomeMathRoundUp() {
        payslip.setGrossIncome(50807);
        assertEquals(payslip.getGrossIncome(),4234);
    }

    @Test
    @DisplayName("test gross income round down when decimal is <0.5")
    public void testGrossIncomeMathRoundDown() {
        payslip.setGrossIncome(52000);
        assertEquals(payslip.getGrossIncome(),4333);
    }

    @Test
    @DisplayName("test income tax getters and setters")
    public void testIncomeTaxGetterAndSetter() {
        payslip.setIncomeTax(60000);
        assertEquals(payslip.getIncomeTax(),11047);
    }

    @Test
    @DisplayName("test income tax phase 1(0-18200) returning as intended")
    public void testIncomeTaxPhase1() {
        payslip.setIncomeTax(15000);
        assertEquals(payslip.getIncomeTax(),0);
    }

    @Test
    @DisplayName("test income tax phase 2(18201-37000) returning as intended round up")
    public void testIncomeTaxPhase2Up() {
        payslip.setIncomeTax(25624);
        assertEquals(payslip.getIncomeTax(),1411);
    }

    @Test
    @DisplayName("test income tax phase 2(18201-37000) returning as intended round down")
    public void testIncomeTaxPhase2Down() {
        payslip.setIncomeTax(24596);
        assertEquals(payslip.getIncomeTax(),1215);
    }

    @Test
    @DisplayName("test income tax phase 3(37001-87000) returning a correct number and round up as intended")
    public void testIncomeTaxPhase3Up() {
        payslip.setIncomeTax(75624);
        assertEquals(payslip.getIncomeTax(),16125);
    }

    @Test
    @DisplayName("test income tax phase 3(37001-87000) returning a correct number and round down as intended")
    public void testIncomeTaxPhase3Down() {
        payslip.setIncomeTax(37161);
        assertEquals(payslip.getIncomeTax(),3624);
    }

    @Test
    @DisplayName("test income tax phase 4(87001-180000) returning a correct number and round up as intended")
    public void testIncomeTaxPhase4Up() {
        payslip.setIncomeTax(95624);
        assertEquals(payslip.getIncomeTax(),23013);
    }

    @Test
    @DisplayName("test income tax phase 4(87001-180000) returning a correct number and round down as intended")
    public void testIncomeTaxPhase4Down() {
        payslip.setIncomeTax(87163);
        assertEquals(payslip.getIncomeTax(),19882);
    }

    @Test
    @DisplayName("test income tax phase 5(>180001) returning a correct number and round up as intended")
    public void testIncomeTaxPhase5Up() {
        payslip.setIncomeTax(185624);
        assertEquals(payslip.getIncomeTax(),56763);
    }

    @Test
    @DisplayName("test income tax phase 5(>180001) returning a correct number and round down as intended")
    public void testIncomeTaxPhase5Down() {
        payslip.setIncomeTax(181601);
        assertEquals(payslip.getIncomeTax(),54952);
    }

    @Test
    @DisplayName("test net income getters and setters")
    public void testNetIncomeGetterAndSetter() {
        payslip.setNetIncome(60000,3000);
        assertEquals(payslip.getNetIncome(),57000);
    }

    @Test
    @DisplayName("test super amount getters and setters")
    public void testSuperAmountGetterAndSetter() {
        payslip.setSuperAmount(3.3,30000);
        assertEquals(payslip.getSuperAmount(),990);
    }

    @Test
    @DisplayName("test super amount round down")
    public void testSuperAmountRoundDown() {
        payslip.setSuperAmount(3.75,12571);
        assertEquals(payslip.getSuperAmount(),471);
    }

    @Test
    @DisplayName("test super amount round up")
    public void testSuperAmountRoundUp() {
        payslip.setSuperAmount(3.75,9622);
        assertEquals(payslip.getSuperAmount(),361);
    }
}
