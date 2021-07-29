package Main;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;


public class employeeUnitTest {
    private employee employee;

    @Before
    public void setUp() {
        employee = new employee("Cheline","Gan",197500, 3, "01-March-2020");
    }

    @Test
    @DisplayName("Employee first name cannot be null")
    public void employeeFirstNameCannotBeNull() {
        assertThrows(NullPointerException.class, () -> employee.setFirstName(null));
    }

    @Test
    @DisplayName("Employee last name cannot be null")
    public void employeeLastNameCannotBeNull() {
        assertThrows(NullPointerException.class, () -> employee.setLastName(null));
    }

    @Test
    @DisplayName("test employee first name getters and setters")
    public void testFirstNameGetterAndSetter() {
        employee.setFirstName("first");
        assertEquals(employee.getFirstName(),"first");
    }

    @Test
    @DisplayName("test employee last name getters and setters")
    public void testLastNameGetterAndSetter() {
        employee.setLastName("last");
        assertEquals(employee.getLastName(),"last");
    }

    @Test
    @DisplayName("test employee annual salary getters and setters")
    public void testAnnualSalaryGetterAndSetter() {
        employee.setAnnualSalary(30000);
        assertEquals(employee.getAnnualSalary(),30000);
    }

    @Test
    @DisplayName("test employee super rate getters and setters")
    public void testSuperRateGetterAndSetter() {
        employee.setSuperRate(3);
        assertEquals(employee.getSuperRate(),3);
    }
}
