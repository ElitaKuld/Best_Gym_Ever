import java.time.LocalDate;

public class Customer extends Person {

    private LocalDate dateOfPaidFee;

    public Customer(String name, String personalNumber, LocalDate dateOfPaidFee) {
        super(name, personalNumber);
        this.dateOfPaidFee = dateOfPaidFee;
    }

    public LocalDate getDateOfPaidFee() { //OBS!!!!! FIXA!!!
        return dateOfPaidFee;
    }

    @Override
    public String printInfoAboutMe() {
        return "Namn: " + getName() + ", personnummer: " + getPersonalNumber() + ", har betalt årsavgiften: " + getDateOfPaidFee().toString();
    }
}