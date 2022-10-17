import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class InputOutputMetoderTest {

    InputOutputMetoder iom = new InputOutputMetoder();

    Path inFile = Paths.get("src/customers.txt");
    Path outFile = Paths.get("src/customers_who_paid.txt");

    Kund testKundA = new Kund("Alhambra Aromes", "7703021234", LocalDate.parse("2022-07-01"));
    Kund testKundB = new Kund("Bear Belle", "8204021234", LocalDate.parse("2019-12-02"));
    Kund testKundC = new Kund("Chamade Coriola", "8512021234", LocalDate.parse("2018-03-12"));
    List<Kund> testKunder = new ArrayList<>();


    @Test
    void readFromFileToListTest() {
        List<Kund> peopleInTheFile = iom.readFromFileToList(inFile);
        assertEquals(14, peopleInTheFile.size());
        assertNotEquals(10, peopleInTheFile.size());
        assert (peopleInTheFile.get(5).getName().equals("Fritjoff Flacon"));
        assert (peopleInTheFile.get(1).getPersonnummer().equals("8204021234"));
        assert (peopleInTheFile.get(7).getDateOfPaidFee().toString().equals("2019-08-18"));
    }

    @Test
    void WriteToFileTest() {
        testKunder.add(testKundA);
        testKunder.add(testKundB);
        testKunder.add(testKundC);
        iom.WriteToFile(outFile, testKunder);
        assertEquals(3, countRowsInFile(outFile));
        assert (countRowsInFile(outFile) != 2);
        assert (countRowsInFile(outFile) != 0);
    }

    public final int countRowsInFile(Path utFil) {
        int antalRader = 0;
        try (BufferedReader buffRead = Files.newBufferedReader(utFil)) {
            while (buffRead.readLine() != null)
                antalRader++;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return antalRader;
    }
}