package luchthaven.model;

import java.util.ArrayList;
import java.util.List;

public class Vliegtuig {
    private String vluchtCode;
    private String bestemming;
    private int aantalEconomyPlaatsen;
    private int aantalBusinessPlaatsen;
    private List<Passagier> passagiers;
    private List<Personeel> personeel;

    // Constructor
    public Vliegtuig(String vluchtCode, String bestemming, int aantalEconomyPlaatsen, int aantalBusinessPlaatsen) {
        this.vluchtCode = vluchtCode;
        this.bestemming = bestemming;
        this.aantalEconomyPlaatsen = aantalEconomyPlaatsen;
        this.aantalBusinessPlaatsen = aantalBusinessPlaatsen;
        this.passagiers = new ArrayList<>();
        this.personeel = new ArrayList<>();
    }

    // Getters en Setters
    public String getVluchtCode() {
        return vluchtCode;
    }

    public void setVluchtCode(String vluchtCode) {
        this.vluchtCode = vluchtCode;
    }

    public String getBestemming() {
        return bestemming;
    }

    public void setBestemming(String bestemming) {
        this.bestemming = bestemming;
    }

    public int getAantalEconomyPlaatsen() {
        return aantalEconomyPlaatsen;
    }

    public void setAantalEconomyPlaatsen(int aantalEconomyPlaatsen) {
        this.aantalEconomyPlaatsen = aantalEconomyPlaatsen;
    }

    public int getAantalBusinessPlaatsen() {
        return aantalBusinessPlaatsen;
    }

    public void setAantalBusinessPlaatsen(int aantalBusinessPlaatsen) {
        this.aantalBusinessPlaatsen = aantalBusinessPlaatsen;
    }

    public List<Passagier> getPassagiers() {
        return passagiers;
    }

    public List<Personeel> getPersoneel() {
        return personeel;
    }

    // Voeg een passagier toe aan het vliegtuig (controleer of er plaatsen zijn)
    public boolean voegPassagierToe(Passagier passagier) {
        if (passagier.getTicket().getVluchtCode().equals(this.vluchtCode)) {
            if (passagier.getTicket().getKlasse().equals("business") && aantalBusinessPlaatsen > 0) {
                passagiers.add(passagier);
                aantalBusinessPlaatsen--;
                return true;
            } else if (passagier.getTicket().getKlasse().equals("economy") && aantalEconomyPlaatsen > 0) {
                passagiers.add(passagier);
                aantalEconomyPlaatsen--;
                return true;
            }
        }
        return false;
    }

    // Voeg personeel toe aan het vliegtuig
    public void voegPersoneelToe(Personeel persoon) {
        personeel.add(persoon);
    }

    // String representatie van Vliegtuig
    @Override
    public String toString() {
        return "Vluchtcode: " + vluchtCode + ", Bestemming: " + bestemming +
                ", Economy Plaatsen: " + aantalEconomyPlaatsen + ", Business Plaatsen: " + aantalBusinessPlaatsen;
    }
}
