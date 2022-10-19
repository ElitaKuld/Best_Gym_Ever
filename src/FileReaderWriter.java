import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FileReaderWriter {

    public static List<Customer> readFromFileToList(Path inFilePath) {
        List<Customer> peopleInTheFile = new ArrayList<>();

        try (BufferedReader buffRead = Files.newBufferedReader(inFilePath)) {

            while (true) { // läs infilen och kopiera till listan
                String personalNumberAndName = buffRead.readLine(); // läs personnummer och namn
                if (personalNumberAndName == null) // är filen slut?
                    break; // ja!
                String personalNumber = TextMetoder.getPersonalNumberOutOfString(personalNumberAndName);
                String name = TextMetoder.getNameOutOfString(personalNumberAndName);

                LocalDate dateOfPaidFee = LocalDate.parse(buffRead.readLine());

                peopleInTheFile.add(new Customer(name, personalNumber, dateOfPaidFee));
            }
        } catch (IOException e) {
            System.out.println("Fel inträffade vid läsning från fil");
            e.printStackTrace();
            System.exit(0);
        }
        return peopleInTheFile;
    }

    public static void writeTrainingSessionToFile(TrainingSession session) {
        String outFileName = TextMetoder.createFileNameFromCustomerName(session.getCustomer().getName());
        try (PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(outFileName, true)))) {
            pw.write(session.printInfoAboutMe() + "\n");
        } catch (FileNotFoundException e) {
            System.out.println("Filen kunde inte hittas");
            e.printStackTrace();
            System.exit(0);
        } catch (IOException e) {
            System.out.println("Det gick inte att skriva till fil");
            e.printStackTrace();
            System.exit(0);
        } catch (Exception e) {
            System.out.println("Något gick fel");
            e.printStackTrace();
            System.exit(0);
        }
    }
}