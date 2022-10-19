import javax.swing.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Huvudprogram {

    public static void main(String[] args) {
        Path inFilePath = Paths.get("src/customers.txt");
        List<Customer> peopleInTheFile = FileReaderWriter.readFromFileToList(inFilePath);

        String nameOrPersonalNumber = JOptionPane.showInputDialog("Ange namn eller personnummer (10 siffror) på personen som har kommit till gymmet.").trim();

        JOptionPane.showMessageDialog(null, Finder.findPersonOnList(peopleInTheFile,nameOrPersonalNumber));
    }
}