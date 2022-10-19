import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class CustomerTest {

    LocalDate testDate = LocalDate.parse("2022-10-17");
    Customer testCustomer = new Customer("David Ljunggren", "8801011825", testDate);


    @Test
    void printInfoAboutMeTest() {
        assert (testCustomer.printInfoAboutMe().equals("Namn: David Ljunggren, personnummer: 8801011825, har betalt årsavgiften: 2022-10-17"));
        assert (testCustomer.printInfoAboutMe().length() == 83);
        assert (testCustomer.printInfoAboutMe().length() != 0);
    }
}