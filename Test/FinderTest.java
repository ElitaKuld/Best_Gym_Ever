import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FinderTest {

    Customer testCustomerA = new Customer("Alhambra Aromes", "7703021234", LocalDate.parse("2022-07-01"));
    Customer testCustomerB = new Customer("Bear Belle", "8204021234", LocalDate.parse("2019-12-02"));
    Customer testCustomerC = new Customer("Chamade Coriola", "8512021234", LocalDate.parse("2018-03-12"));
    List<Customer> testCustomers = new ArrayList<>();

    String testNameTrue = "Alhambra Aromes";
    String testNameFalse = "Bear Belle";
    String testNameFalse2 = "Sevilla Flores";
    String testPersonalNumberTrue = "7703021234";
    String testPersonalNumberFalse = "8204021234";
    String testPersonalNumberFalse2 = "8604071234";

    @Test
    void findPersonOnListTest() {
        testCustomers.add(testCustomerA);
        testCustomers.add(testCustomerB);
        testCustomers.add(testCustomerC);
        assert (Finder.findPersonOnList(testCustomers, testNameTrue).equals("Denna kund är en nuvarande medlem." +
                "\nFör att denna person har kommit för att träna har vi sparat detta träningstillfälle i hens fil." +
                "\nFilen har namnet \"" + TextMetoder.createFileNameFromCustomerName(testCustomerA.getName()) + "\""));
        assert (Finder.findPersonOnList(testCustomers, testPersonalNumberTrue).length() == 187);
        assert (Finder.findPersonOnList(testCustomers, testNameFalse).equals("Denna person är en före detta kund."));
        assert (Finder.findPersonOnList(testCustomers, testPersonalNumberFalse).length() == 35);
        assert (Finder.findPersonOnList(testCustomers, testNameFalse2).equals("Okänt namn eller personnummer. Denna person är obehörig."));
        assert (Finder.findPersonOnList(testCustomers, testPersonalNumberFalse2).length() == 56);
    }
}