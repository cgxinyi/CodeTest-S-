package Main;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

public class validationUnitTest {
    private validation validation = new validation();

    @Test
    @DisplayName("Input string cannot be null")
    public void validInputStringCannotBeNull() {
        assertThrows(NullPointerException.class, () -> validation.acceptStringInput(null));
    }

    @Test
    @DisplayName("Input integer cannot be null")
    public void validInputIntegerCannotBeNull() {
        assertThrows(NullPointerException.class, () -> validation.acceptIntegerInput(null));
    }

    @Test
    @DisplayName("Input string cannot be empty")
    public void inputStringCannotBeEmpty() {
        assertThrows(NullPointerException.class, () -> validation.acceptStringInput(""));
    }

    @Test
    @DisplayName("Input string cannot be blank")
    public void inputStringCannotBeBlank() {
        assertThrows(NullPointerException.class, () -> validation.acceptStringInput(" "));
    }

    @Test
    @DisplayName("Check the validation of input string returning correct output")
    public void checkValidationNotEmptyInputString() {
        boolean answer = validation.checkStringNotEmptyOrBlank("Cheline");
        assertTrue(answer);
    }

    @Test
    @DisplayName("Check the validation of input string returning correct output")
    public void checkValidationEmptyInputString() {
        boolean answer = validation.checkStringNotEmptyOrBlank(" ");
        assertFalse(answer);
    }

    @Test
    @DisplayName("Check the validation of input string should not contain number")
    public void checkValidationInputStringShouldNotContainsNumber() {
        boolean answer = validation.checkStringNotContainsNumber("abc123");
        assertFalse(answer);
    }

    @Test
    @DisplayName("Check the validation of input integer within range")
    public void checkValidationInputIntegerWithinRange() {
        boolean answer = validation.checkIntegerWithinRange(51, 0, 50);
        assertFalse(answer);
    }

    @Test
    @DisplayName("Check the validation of input string with correct length")
    public void checkValidationInputStringLength() {
        boolean answer = validation.checkStringLength("month", "asdasd");
        assertFalse(answer);
    }

    @Test
    @DisplayName("Check the correct return the string of pay period")
    public void checkCorrectReturnMonth() {
        String answer = validation.validMonth("Mar");
        assertEquals(answer,"01 Mar - 31 Mar");
    }

    @Test
    @DisplayName("Check the validation of input string is month")
    public void checkValidationInputStringIsMonth() {
        boolean answer = validation.checkInputIsMonth("mar");
        assertTrue(answer);
    }

}
