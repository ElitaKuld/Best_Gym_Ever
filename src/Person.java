public abstract class Person implements Printable{

    private String name;
    private String personnummer;

    public Person(){}

    public Person(String name, String personnummer) {
        this.name = name;
        this.personnummer = personnummer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPersonnummer() {
        return personnummer;
    }

    public void setPersonnummer(String personnummer) {
        this.personnummer = personnummer;
    }

    public abstract String printInfoAboutMe();
}