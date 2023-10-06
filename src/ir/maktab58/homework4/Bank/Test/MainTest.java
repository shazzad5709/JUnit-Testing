package ir.maktab58.homework4.Bank.Test;
import ir.maktab58.homework4.Bank.Main;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MainTest {

    @Test
    @DisplayName("Test to check validity of a valid integer")
    void isIntegerTest() {
        String input = "123";
        boolean result = Main.isItValidInt(input);
        Assertions.assertTrue(result);
    }

    @Test
    @DisplayName("Test to check validity of an invalid integer")
    void isInvalidIntegerTest() {
        String input = "123a";
        boolean result = Main.isItValidInt(input);
        Assertions.assertFalse(result);
    }

    @Test
    @DisplayName("Test to check validity of an empty integer")
    void isEmptyIntegerTest() {
        String input = "";
        boolean result = Main.isItValidInt(input);
        Assertions.assertFalse(result);
    }

    @Test
    @DisplayName("Test to convert an String array to integer")
    void convertStringArrayToIntTest() {
        String[] input = {"123", "456"};
        int[] result = Main.convertStrArrayToInt(input);
        Assertions.assertArrayEquals(new int[]{123, 456}, result);
    }

    @Test
    @DisplayName("Test to convert an empty String array to integer")
    void convertEmptyStringArrayToIntTest() {
        String[] input = {};
        int[] result = Main.convertStrArrayToInt(input);
        Assertions.assertArrayEquals(new int[]{}, result);
    }
}
