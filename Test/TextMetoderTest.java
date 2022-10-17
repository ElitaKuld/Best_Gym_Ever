import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class TextMetoderTest {

    TextMetoder tm = new TextMetoder();

    String testText = "7703021234, Alhambra Aromes";

    @Test
    void getPersonalNumberOutOfStringTest() {
        assert (tm.getPersonalNumberOutOfString(testText).equals("7703021234"));
        assertFalse(tm.getPersonalNumberOutOfString(testText).equals("7703021234,"));
        assertNotEquals("", tm.getPersonalNumberOutOfString(testText)); // ett enklare sätt
    }

    @Test
    void getNameOutOfStringTest() {
        assert (tm.getNameOutOfString(testText).equals("Alhambra Aromes"));
        assertFalse(tm.getNameOutOfString(testText).equals(" Alhambra Aromes"));
        assertNotEquals("", tm.getNameOutOfString(testText));
    }
}