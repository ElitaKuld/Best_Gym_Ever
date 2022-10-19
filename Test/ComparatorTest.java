import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Period;

public class ComparatorTest {

    LocalDate testDate = LocalDate.parse("2020-05-17");
    LocalDate testDate2 = LocalDate.parse("2022-10-18");
    Period testPeriodTrue = Period.of(1, 0, 0);
    Period testPeriodFalse = Period.of(2, 5, 1);
    Period testPeriodFalse2 = Period.of(1, 0, 1);


    @Test
    void getPeriodTest() {
        assert (Comparator.getPeriod(testDate, testDate2).getYears() == 2);
        assert (Comparator.getPeriod(testDate, testDate2).getMonths() == 5);
        assert (Comparator.getPeriod(testDate, testDate2).getDays() == 1);
        assert (Comparator.getPeriod(testDate, testDate2).getYears() != 3);
        assert (Comparator.getPeriod(testDate, testDate2).getMonths() != 7);
        assert (Comparator.getPeriod(testDate, testDate2).getDays() != 0);
    }

    @Test
    void isUpToOneYearTest() {
        assert (Comparator.isUpToOneYear(testPeriodTrue));
        assert (!Comparator.isUpToOneYear(testPeriodFalse));
        assert (!Comparator.isUpToOneYear(testPeriodFalse2));
    }
}