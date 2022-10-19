public abstract class Person implements Printable {

    private String name;
    private String personalNumber;

    public Person() {
    }

    public Person(String name, String personalNumber) {
        this.name = name;
        this.personalNumber = personalNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPersonalNumber() {
        return personalNumber;
    }

    public void setPersonalNumber(String personalNumber) {
        this.personalNumber = personalNumber;
    }

    public abstract String printInfoAboutMe();
}