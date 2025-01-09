package luchthaven.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import luchthaven.model.Passagier;
import luchthaven.model.Vliegtuig;

public class FileUtils {

    // Methode om vluchtinformatie naar een bestand te schrijven
    public static void schrijfVluchtInfoNaarBestand(Vliegtuig vliegtuig) {
        File bestand = new File(vliegtuig.getVluchtCode() + "_info.txt");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(bestand))) {
            // Schrijf de vluchtinformatie
            writer.write("Vluchtcode: " + vliegtuig.getVluchtCode() + "\n");
            writer.write("Bestemming: " + vliegtuig.getBestemming() + "\n");
            writer.write("Aantal passagiers: " + vliegtuig.getPassagiers().size() + "\n");
            writer.write("Aantal personeel: " + vliegtuig.getPersoneel().size() + "\n");

            writer.write("\n--- Passagiers ---\n");
            for (Passagier passagier : vliegtuig.getPassagiers()) {
                writer.write(passagier.getNaam() + " (" + passagier.getTicket().getKlasse() + ")\n");
            }

            System.out.println("Vluchtinformatie succesvol opgeslagen in " + bestand.getName());
        } catch (IOException e) {
            System.out.println("Er is een fout opgetreden bij het opslaan van vluchtinformatie: " + e.getMessage());
        }
    }
}
