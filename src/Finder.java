import java.time.LocalDate;
import java.util.List;

public class Finder {

    public static String findPersonOnList(List<Customer> peopleInTheFile, String nameOrPersonalNumber) {
        String result = "";
        for (Customer customer : peopleInTheFile) {
            if (nameOrPersonalNumber.equals(customer.getName()) ||
                    nameOrPersonalNumber.equals(customer.getPersonalNumber())) {
                if (Comparator.isUpToOneYear(Comparator.getPeriod(customer.getDateOfPaidFee(), LocalDate.now()))) {
                    TrainingSession session = new TrainingSession(customer);
                    FileReaderWriter.writeTrainingSessionToFile(session);
                    result = "Denna kund är en nuvarande medlem." +
                            "\nFör att denna person har kommit för att träna har vi sparat detta träningstillfälle i hens fil." +
                            "\nFilen har namnet \"" + TextMetoder.createFileNameFromCustomerName(customer.getName()) + "\"";
                    break;
                } else {
                    result = "Denna person är en före detta kund.";
                    break;
                }
            } else
                result = "Denna person är obehörig.";
        }
        return result;
    }
}