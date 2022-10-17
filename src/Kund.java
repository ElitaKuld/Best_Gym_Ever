import java.time.LocalDate;

public class Kund extends Person {

    private LocalDate dateOfPaidFee;

    public Kund() {
    }

    public Kund(String name, String personnummer) {
        super.setName(name);
        super.setPersonnummer(personnummer);
    }

    public Kund(LocalDate dateOfPaidFee) {
        this.dateOfPaidFee = dateOfPaidFee;
    }

    public Kund(String name, String personnummer, LocalDate dateOfPaidFee) {
        super(name, personnummer);
        this.dateOfPaidFee = dateOfPaidFee;
    }

    public LocalDate getDateOfPaidFee() { //OBS!!!!! FIXA!!!
        return dateOfPaidFee;
    }

    public void setDateOfPaidFee(LocalDate dateOfPaidFee) {
        this.dateOfPaidFee = dateOfPaidFee;
    }

    @Override
    public String printInfoAboutMe(){
        return "Namn: " + getName() + ", personnummer: " + getPersonnummer() + ", har betalt årsavgiften: " + getDateOfPaidFee().toString();
    }
}