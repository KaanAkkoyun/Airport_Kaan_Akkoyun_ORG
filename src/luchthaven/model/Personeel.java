package luchthaven.model;

public class Personeel extends Persoon {
    private String functie;  // bijv. piloot, stewardess, bagagepersoneel

    // Constructor
    public Personeel(String naam, int leeftijd, String adres, String functie) {
        super(naam, leeftijd, adres);  // Oproep naar de superklasse Persoon
        this.functie = functie;
    }

    // Getter en Setter
    public String getFunctie() {
        return functie;
    }

    public void setFunctie(String functie) {
        this.functie = functie;
    }

    // String representatie van Personeel
    @Override
    public String toString() {
        return super.toString() + ", Functie: " + functie;
    }
}
