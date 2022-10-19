import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class TrainingSessionTest {

    Customer testCustomer = new Customer("David Ljunggren", "8801011825", LocalDate.parse("2022-10-17"));
    TrainingSession testSession = new TrainingSession(testCustomer);
    LocalDate today = LocalDate.now();

    @Test
    void printInfoAboutMeTest() {
        assert (testCustomer.printInfoAboutMe().equals("Namn: David Ljunggren, personnummer: 8801011825, datumet när tränat: " + today));
        assert (testCustomer.printInfoAboutMe().length() == 79);
        assert (testCustomer.printInfoAboutMe().length() != 0);
    }
}