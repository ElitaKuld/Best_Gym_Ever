import java.time.LocalDate;
import java.time.Period;

public class Comparator {

    public static Period getPeriod(LocalDate dateOfPaidFee, LocalDate today) {
        return Period.between(dateOfPaidFee, today);
    }

    public static boolean isUpToOneYear(Period period) {
        boolean trueOrNot;
        if (period.getYears() < 1)
            trueOrNot = true;
        else if (period.getYears() == 1 && period.getMonths() == 0 && period.getDays() == 0)
            trueOrNot = true;
        else
            trueOrNot = false;
        return trueOrNot;
    }
}