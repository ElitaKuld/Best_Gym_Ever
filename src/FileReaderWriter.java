import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FileReaderWriter {

    public static List<Customer> readFromFileToList(Path inFilePath) {
        List<Customer> peopleInTheFile = new ArrayList<>();

        File newFile = new File(inFilePath.toUri());
        if (newFile.length() == 0) {
            JOptionPane.showMessageDialog(null, "Felmeddelande!\nFilen är tom.");
            System.exit(-1);
        }

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
        } catch (NoSuchFileException e) {
            JOptionPane.showMessageDialog(null, "Felmeddelande!\nIngen fil hittades.");
            e.printStackTrace();
            System.exit(0);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Fel inträffade vid läsning från fil");
            e.printStackTrace();
            System.exit(0);
        }
        return peopleInTheFile;
    }

    public static void writeTrainingSessionToFile(TrainingSession session) {
        String outFileName = TextMetoder.createFileNameFromCustomerName(session.getCustomer().getName());
        try (PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(outFileName, true)))) {
            pw.write(session.printInfoAboutMe() + "\n");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Det gick inte att skriva till fil");
            e.printStackTrace();
            System.exit(0);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Något gick fel");
            e.printStackTrace();
            System.exit(0);
        }
    }
}