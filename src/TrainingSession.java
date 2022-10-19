import java.time.LocalDate;

public class TrainingSession implements Printable {

    private Customer customer;
    private LocalDate dateOfTraining;

    public TrainingSession() {
    }

    public TrainingSession(Customer customer) {
        this.customer = customer;
        this.dateOfTraining = LocalDate.now();
    }

    public Customer getCustomer() { /// OBS!! Fixa!!!
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public LocalDate getDateOfTraining() {
        return dateOfTraining;
    }

    public void setDateOfTraining(LocalDate dateOfTraining) {
        this.dateOfTraining = dateOfTraining;
    }

    @Override
    public String printInfoAboutMe() {
        return "Namn: " + getCustomer().getName() + ", personnummer: " + getCustomer().getPersonalNumber() +
                ", datumet när tränat: " + getDateOfTraining().toString();
    }
}