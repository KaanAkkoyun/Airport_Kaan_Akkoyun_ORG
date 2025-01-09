package luchthaven.model;

public class Ticket {
    private String vluchtCode;
    private String klasse;  // Economy of Business
    private Passagier passagier;

    // Constructor
    public Ticket(String vluchtCode, String klasse, Passagier passagier) {
        this.vluchtCode = vluchtCode;
        this.klasse = klasse;
        this.passagier = passagier;
    }

    // Getters en Setters
    public String getVluchtCode() {
        return vluchtCode;
    }

    public void setVluchtCode(String vluchtCode) {
        this.vluchtCode = vluchtCode;
    }

    public String getKlasse() {
        return klasse;
    }

    public void setKlasse(String klasse) {
        this.klasse = klasse;
    }

    public Passagier getPassagier() {
        return passagier;
    }

    public void setPassagier(Passagier passagier) {
        this.passagier = passagier;
    }

    // String representatie van een Ticket
    @Override
    public String toString() {
        return "Vluchtcode: " + vluchtCode + ", Klasse: " + klasse;
    }
}
