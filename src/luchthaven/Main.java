package luchthaven;

import java.util.Scanner;
import luchthaven.model.*;
import luchthaven.service.*;
import luchthaven.utils.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Initialiseer de service objecten
        BoardingService boardingService = new BoardingService();
        VluchtService vluchtService = new VluchtService();

        // Maak een paar voorbeeldobjecten
        Vliegtuig vliegtuig1 = new Vliegtuig("VL123", "Amsterdam", 100, 20);
        Vliegtuig vliegtuig2 = new Vliegtuig("VL456", "Berlijn", 80, 10);

        // Initialiseer een paar personeelsleden
        Personeel piloot = new Personeel("Jan de Vries", 35, "Kerkstraat 12", "Piloot");
        Personeel stewardess = new Personeel("Maria Jansen", 28, "Lindelaan 5", "Stewardess");

        // Voeg personeel toe aan vluchten
        vluchtService.wijsPersoneelToe(vliegtuig1, piloot);
        vluchtService.wijsPersoneelToe(vliegtuig1, stewardess);

        // Keuzemenu
        while (true) {
            System.out.println("\n--- Luchthaven Systeem ---");
            System.out.println("1. Maak een nieuwe passagier aan");
            System.out.println("2. Maak een nieuwe vlucht aan");
            System.out.println("3. Maak een nieuw ticket aan");
            System.out.println("4. Board een passagier");
            System.out.println("5. Wijs personeel toe aan een vlucht");
            System.out.println("6. Toon vluchtinformatie");
            System.out.println("7. Stop het programma");

            System.out.print("Maak een keuze (1-7): ");
            int keuze = scanner.nextInt();
            scanner.nextLine(); // Consumeert de newline

            switch (keuze) {
                case 1:
                    // Maak een nieuwe passagier aan
                    System.out.print("Voer naam van passagier in: ");
                    String naam = scanner.nextLine();
                    System.out.print("Voer leeftijd van passagier in: ");
                    int leeftijd = scanner.nextInt();
                    scanner.nextLine(); // Consumeert de newline
                    System.out.print("Voer adres van passagier in: ");
                    String adres = scanner.nextLine();
                    System.out.print("Voer vluchtcode in: ");
                    String vluchtCode = scanner.nextLine();

                    // Validatie van de vluchtcode
                    if (!ValidationUtils.isVluchtCodeGeldig(vluchtCode)) {
                        System.out.println("Ongeldige vluchtcode. Probeer het opnieuw.");
                        break;
                    }

                    System.out.print("Voer klasse (economy/business) in: ");
                    String klasse = scanner.nextLine();

                    // Ticket aanmaken
                    Ticket ticket = new Ticket(vluchtCode, klasse, null); // Ticket zonder passagier
                    Passagier passagier = new Passagier(naam, leeftijd, adres, ticket);
                    ticket.setPassagier(passagier);  // Koppel ticket aan passagier

                    System.out.println("Passagier aangemaakt: " + passagier);
                    break;

                case 2:
                    // Maak een nieuwe vlucht aan
                    System.out.print("Voer vluchtcode in: ");
                    String nieuweVluchtCode = scanner.nextLine();

                    // Validatie van de vluchtcode
                    if (!ValidationUtils.isVluchtCodeGeldig(nieuweVluchtCode)) {
                        System.out.println("Ongeldige vluchtcode. Probeer het opnieuw.");
                        break;
                    }

                    System.out.print("Voer bestemming in: ");
                    String bestemming = scanner.nextLine();
                    System.out.print("Voer aantal economy plaatsen in: ");
                    int economyPlaatsen = scanner.nextInt();
                    System.out.print("Voer aantal business plaatsen in: ");
                    int businessPlaatsen = scanner.nextInt();

                    Vliegtuig nieuweVlucht = new Vliegtuig(nieuweVluchtCode, bestemming, economyPlaatsen, businessPlaatsen);
                    System.out.println("Vlucht aangemaakt: " + nieuweVlucht);
                    break;

                case 3:
                    // Maak een nieuw ticket aan (je kunt al passagiers aanmaken in case 1)
                    System.out.print("Voer naam van passagier in: ");
                    String passagierNaam = scanner.nextLine();
                    System.out.print("Voer vluchtcode voor ticket in: ");
                    String ticketVluchtCode = scanner.nextLine();
                    System.out.print("Voer klasse (economy/business) in: ");
                    String ticketKlasse = scanner.nextLine();

                    // Zoek de passagier (je zou hier een database kunnen gebruiken, maar we doen het simpel)
                    Passagier gevondenPassagier = null; // Zoek passagier
                    for (Vliegtuig v : new Vliegtuig[]{vliegtuig1, vliegtuig2}) {
                        for (Passagier p : v.getPassagiers()) {
                            if (p.getNaam().equals(passagierNaam)) {
                                gevondenPassagier = p;
                                break;
                            }
                        }
                    }

                    if (gevondenPassagier != null) {
                        Ticket nieuwTicket = new Ticket(ticketVluchtCode, ticketKlasse, gevondenPassagier);
                        gevondenPassagier.setTicket(nieuwTicket);
                        System.out.println("Nieuw ticket aangemaakt voor passagier " + gevondenPassagier.getNaam());
                    } else {
                        System.out.println("Passagier niet gevonden.");
                    }
                    break;

                case 4:
                    // Board een passagier
                    System.out.print("Voer naam van passagier in: ");
                    String boardNaam = scanner.nextLine();
                    System.out.print("Voer vluchtcode in: ");
                    String boardVluchtCode = scanner.nextLine();

                    Passagier passagierBoarding = null;
                    for (Vliegtuig v : new Vliegtuig[]{vliegtuig1, vliegtuig2}) {
                        for (Passagier p : v.getPassagiers()) {
                            if (p.getNaam().equals(boardNaam) && p.getTicket().getVluchtCode().equals(boardVluchtCode)) {
                                passagierBoarding = p;
                                break;
                            }
                        }
                    }

                    if (passagierBoarding != null) {
                        if (boardingService.boardPassagier(passagierBoarding, vliegtuig1)) {
                            System.out.println("Passagier " + passagierBoarding.getNaam() + " succesvol aan boord.");
                        } else {
                            System.out.println("Er is geen plek voor de passagier.");
                        }
                    } else {
                        System.out.println("Passagier of vlucht niet gevonden.");
                    }
                    break;

                case 5:
                    // Wijs personeel toe aan een vlucht
                    System.out.print("Voer naam van personeel in: ");
                    String personeelNaam = scanner.nextLine();
                    System.out.print("Voer functie van personeel in: ");
                    String functie = scanner.nextLine();
                    System.out.print("Voer vluchtcode van vlucht in: ");
                    String vluchtCodePersoneel = scanner.nextLine();

                    Personeel nieuwPersoneel = new Personeel(personeelNaam, 30, "Onbekend", functie);
                    if (vluchtCodePersoneel.equals(vliegtuig1.getVluchtCode())) {
                        vluchtService.wijsPersoneelToe(vliegtuig1, nieuwPersoneel);
                        System.out.println("Personeel toegevoegd aan vlucht " + vliegtuig1.getVluchtCode());
                    } else {
                        System.out.println("Vluchtcode niet geldig.");
                    }
                    break;

                case 6:
                    // Toon vluchtinformatie en schrijf naar bestand
                    vluchtService.toonVluchtInfo(vliegtuig1);
                    FileUtils.schrijfVluchtInfoNaarBestand(vliegtuig1);  // Schrijf vluchtinformatie naar bestand
                    break;

                case 7:
                    // Stop het programma
                    System.out.println("Programma gestopt.");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Ongeldige keuze. Kies een nummer tussen 1 en 7.");
            }
        }
    }
}
