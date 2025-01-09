package luchthaven.model;

public class Passagier extends Persoon {
    private Ticket ticket;

    // Constructor
    public Passagier(String naam, int leeftijd, String adres, Ticket ticket) {
        super(naam, leeftijd, adres);  // Oproep naar de superklasse Persoon
        this.ticket = ticket;
    }

    // Getter en Setter
    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    // String representatie van Passagier
    @Override
    public String toString() {
        return super.toString() + ", Ticket: " + ticket;
    }
}
