package luchthaven.service;

import luchthaven.model.Passagier;
import luchthaven.model.Vliegtuig;

public class BoardingService {
    // Methode om een passagier aan boord van een vlucht te laten
    public boolean boardPassagier(Passagier passagier, Vliegtuig vliegtuig) {
        return vliegtuig.voegPassagierToe(passagier);
    }
}
