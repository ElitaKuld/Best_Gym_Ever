import java.time.LocalDate;

public class TrainingSession implements Printable {

    private Customer customer;
    private LocalDate dateOfTraining;

    public TrainingSession(Customer customer) {
        this.customer = customer;
        this.dateOfTraining = LocalDate.now();
    }

    public Customer getCustomer() { /// OBS!! Fixa!!!
        return customer;
    }

    public LocalDate getDateOfTraining() {
        return dateOfTraining;
    }

    @Override
    public String printInfoAboutMe() {
        return "Namn: " + getCustomer().getName() + ", personnummer: " + getCustomer().getPersonalNumber() +
                ", datumet när tränat: " + getDateOfTraining().toString();
    }
}