import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class FileReaderWriterTest {

    Path inFilePath = Paths.get("src/customers.txt");
    String outFileName = "alhambra_aromes_training_sessions.txt";

    Customer testCustomer = new Customer("Alhambra Aromes", "7703021234", LocalDate.parse("2022-07-01"));
    TrainingSession testSession = new TrainingSession(testCustomer);


    @Test
    void readFromFileToListTest() {
        List<Customer> peopleInTheFile = FileReaderWriter.readFromFileToList(inFilePath);
        assertEquals(14, peopleInTheFile.size());
        assertNotEquals(10, peopleInTheFile.size());
        assert (peopleInTheFile.get(5).getName().equals("Fritjoff Flacon"));
        assert (peopleInTheFile.get(1).getPersonalNumber().equals("8204021234"));
        assert (peopleInTheFile.get(7).getDateOfPaidFee().toString().equals("2019-08-18"));
    }

    public int countNumberOfTokens(String outFileName) {
        int numberOfTokens = 0;
        String rowOfText;
        try (BufferedReader buffR = new BufferedReader(new FileReader(outFileName))) {
            rowOfText = buffR.readLine();
            numberOfTokens = rowOfText.length();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return numberOfTokens;
    }

    @Test
    void writeTrainingSessionToFileTest() {
        FileReaderWriter.writeTrainingSessionToFile(testSession);
        assert (outFileName.startsWith("alhambra_aromes"));
        assert (countNumberOfTokens(outFileName) == 79);
        assert (countNumberOfTokens(outFileName) != 0);
        assert (countNumberOfTokens(outFileName) != 78);
    }
}