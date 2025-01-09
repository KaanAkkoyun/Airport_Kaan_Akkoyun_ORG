package luchthaven.service;

import luchthaven.model.Vliegtuig;
import luchthaven.model.Personeel;

public class VluchtService {
    // Methode om personeel toe te wijzen aan een vlucht
    public void wijsPersoneelToe(Vliegtuig vliegtuig, Personeel persoon) {
        vliegtuig.voegPersoneelToe(persoon);
    }

    // Methode om vluchtinformatie te tonen (bijv. vluchtcode, bestemming, aantal passagiers)
    public void toonVluchtInfo(Vliegtuig vliegtuig) {
        System.out.println("Vluchtinformatie:");
        System.out.println(vliegtuig);
        System.out.println("Aantal passagiers: " + vliegtuig.getPassagiers().size());
        System.out.println("Aantal personeel: " + vliegtuig.getPersoneel().size());
    }
}
