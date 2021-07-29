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

    

}
