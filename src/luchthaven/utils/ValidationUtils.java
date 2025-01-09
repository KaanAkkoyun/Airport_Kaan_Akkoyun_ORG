package luchthaven.utils;

public class ValidationUtils {

    // Methode om te controleren of een vluchtcode geldig is (bijv. niet leeg en in het juiste formaat)
    public static boolean isVluchtCodeGeldig(String vluchtCode) {
        // In dit voorbeeld controleren we of de vluchtcode niet leeg is en minstens 3 tekens bevat
        return vluchtCode != null && !vluchtCode.isEmpty() && vluchtCode.length() >= 3;
    }

    // Methode om de leeftijd van een passagier te valideren
    public static boolean isLeeftijdGeldig(int leeftijd) {
        // Bijvoorbeeld, de leeftijd moet tussen 0 en 120 liggen
        return leeftijd >= 0 && leeftijd <= 120;
    }

    // Methode om te controleren of de ingevoerde klasse geldig is
    public static boolean isKlasseGeldig(String klasse) {
        return klasse.equalsIgnoreCase("economy") || klasse.equalsIgnoreCase("business");
    }
}
