import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class KundTest {

    Kund testKund = new Kund("David Ljunggren", "8801011825");
    LocalDate testDate = LocalDate.parse("2022-10-17");

    @Test
    void printInfoAboutMeTest(){
        testKund.setDateOfPaidFee(testDate);
        assert(testKund.printInfoAboutMe().equals("Namn: David Ljunggren, personnummer: 8801011825, har betalt årsavgiften: 2022-10-17"));
        assert(testKund.printInfoAboutMe().length() == 83);
        assert(testKund.printInfoAboutMe().length() != 0);
    }
}