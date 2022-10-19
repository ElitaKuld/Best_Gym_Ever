import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class TextMetoderTest {

    String testText = "7703021234, Alhambra Aromes";
    String customerName = "Alhambra Aromes";

    @Test
    void getPersonalNumberOutOfStringTest() {
        assert (TextMetoder.getPersonalNumberOutOfString(testText).equals("7703021234"));
        assertFalse(TextMetoder.getPersonalNumberOutOfString(testText).equals("7703021234,"));
        assertNotEquals("", TextMetoder.getPersonalNumberOutOfString(testText));
    }

    @Test
    void getNameOutOfStringTest() {
        assert (TextMetoder.getNameOutOfString(testText).equals("Alhambra Aromes"));
        assertFalse(TextMetoder.getNameOutOfString(testText).equals(" Alhambra Aromes"));
        assertNotEquals("", TextMetoder.getNameOutOfString(testText));
    }

    @Test
    void createFileNameFromCustomerNameTest() {
        assert (TextMetoder.createFileNameFromCustomerName(customerName).equals("alhambra_aromes_training_sessions.txt"));
        assert (!TextMetoder.createFileNameFromCustomerName(customerName).equals("alhambraaromes_training_sessions.txt"));
        assert (!TextMetoder.createFileNameFromCustomerName(customerName).equals(""));
    }
}