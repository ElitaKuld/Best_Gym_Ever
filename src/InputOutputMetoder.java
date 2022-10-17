import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class InputOutputMetoder {

    TextMetoder tm = new TextMetoder();

    public List<Kund> readFromFileToList(Path inFilePath) {
        List<Kund> peopleInTheFile = new ArrayList<>();

        try (BufferedReader buffRead = Files.newBufferedReader(inFilePath)) {

            while (true) { // läs infilen och kopiera till listan
                String namnPersonnummer = buffRead.readLine(); // läs personnummer och namn
                if (namnPersonnummer == null) // är filen slut?
                    break; // ja!
                String personnummer = tm.getPersonalNumberOutOfString(namnPersonnummer);
                String namn = tm.getNameOutOfString(namnPersonnummer);

                LocalDate dateOfPaidFee = LocalDate.parse(buffRead.readLine());

                peopleInTheFile.add(new Kund(namn, personnummer, dateOfPaidFee));
            }
        } catch (IOException e) {
            System.out.println("Fel inträffade vid läsning från fil");
            e.printStackTrace();
            System.exit(0);
        }
        return peopleInTheFile;
    }

    public void WriteToFile(Path outFile, List<Kund> ourCustomers) {
        try {
            if (!Files.exists(outFile))
                Files.createFile(outFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try (BufferedWriter buffW = Files.newBufferedWriter(outFile)) {
            for (Person person : ourCustomers) {
                buffW.write(person.toString());
                buffW.newLine();
            }
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