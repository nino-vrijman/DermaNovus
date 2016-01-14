package nl.dermanovus.dermanovus;

/**
 * @author Nino Vrijman
 */
public class Medicijn {
    private int id;
    private String naam;
    private String bijsluiter;
    private double prijs;
    private String eenheid;
    private int hoeveelheid;
    private String imageJSON;
    private boolean bestellingGoedgekeurd;
    /**
     * Creëert een nieuw medicijn.
     *
     * @param id De unieke identifier van een medicijn.
     * @param naam De naam van een medicijn.
     * @param bijsluiter De bijsluiter van een medicijn.
     * @param prijs De prijs van een medicijn.
     * @param eenheid De eenheid waarin een medicijn geleverd wordt.
     * @param hoeveelheid De hoeveelheid (van de eenheid) van een medicijn.
     * @param imageJSON De JSON string van een afbeelding van een medicijn.
     */
    public Medicijn(int id, String naam, String bijsluiter, double prijs, String eenheid, int hoeveelheid, String imageJSON, boolean bestellingGoedgekeurd) {
        this.id = id;
        this.naam = naam;
        this.bijsluiter = bijsluiter;
        this.prijs = prijs;
        this.eenheid = eenheid;
        this.hoeveelheid = hoeveelheid;
        this.imageJSON = imageJSON;
        this.bestellingGoedgekeurd = bestellingGoedgekeurd;
    }
    public String getNaam(){
        return naam;
    }
    public String getEenheid(){
        return eenheid;
    }
    public int getHoeveelheid(){
        return hoeveelheid;
    }
    public String getBijsluiter(){
        return bijsluiter;
    }
    public double getPrijs(){
        return prijs;
    }
    public boolean isBestellingGoedgekeurd(){
        return bestellingGoedgekeurd;
    }
    public void isBestellingGoedgekeurd(boolean bestellingGoedgekeurd){
        this.bestellingGoedgekeurd = bestellingGoedgekeurd;
    }
}
