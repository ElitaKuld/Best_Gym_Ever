import javax.swing.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Huvudprogram {

    boolean testMode = false;

    public static void main(String[] args) {
        Huvudprogram hp = new Huvudprogram();
        Path inFilePath = Paths.get("src/customers.txt");
        List<Customer> peopleInTheFile = FileReaderWriter.readFromFileToList(inFilePath);
        String nameOrPersonalNumber = InputDataReader.readInputData(hp.testMode);
        JOptionPane.showMessageDialog(null, Finder.findPersonOnList(peopleInTheFile, nameOrPersonalNumber));
    }
}