import javax.swing.*;

public class InputDataReader {
    static String testData = "David Ljunggren";

    public static String readInputData(boolean testMode) {
        String nameOrPersonalNumber = null;
        if (testMode) {
            nameOrPersonalNumber = testData;
        } else {
            try {
                nameOrPersonalNumber = JOptionPane.showInputDialog("Ange fullständigt namn (namn och efternamn) " +
                        "eller personnummer (10 siffror) på personen som har kommit till gymmet.").trim();
                while (nameOrPersonalNumber.equals("")) {
                    nameOrPersonalNumber = JOptionPane.showInputDialog("Inmatningen kan inte vara tom." +
                            "\nAnge fullständigt namn (namn och efternamn) " +
                            "eller personnummer (10 siffror) på personen som har kommit till gymmet.").trim();
                }
            } catch (NullPointerException e) {
                JOptionPane.showMessageDialog(null, "Du har avbrutit programmet.");
                System.exit(-1);
            }
        }
        return nameOrPersonalNumber;
    }
}