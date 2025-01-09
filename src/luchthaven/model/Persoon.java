package luchthaven.model;

public class Persoon {
    private String naam;
    private int leeftijd;
    private String adres;

    // Constructor
    public Persoon(String naam, int leeftijd, String adres) {
        this.naam = naam;
        this.leeftijd = leeftijd;
        this.adres = adres;
    }

    // Getters en Setters
    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public int getLeeftijd() {
        return leeftijd;
    }

    public void setLeeftijd(int leeftijd) {
        this.leeftijd = leeftijd;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    // String representatie van een Persoon
    @Override
    public String toString() {
        return "Naam: " + naam + ", Leeftijd: " + leeftijd + ", Adres: " + adres;
    }
}
