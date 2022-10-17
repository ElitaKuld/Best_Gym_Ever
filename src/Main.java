import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Kund kund = new Kund("Eliku", "123456", LocalDate.parse("2022-02-07"));
        System.out.println(kund.getDateOfPaidFee().toString());


        System.out.println("Hello world!");
    }
}