package nl.dermanovus.dermanovus;

/**
 * @author Nino Vrijman
 */
public class Ziekenhuis {
    private int id;
    private String naam;
    private String adres;
    private String postcode;
    private int huisnummer;
    private String telefoonnummer;

    /**
     * Creëert een nieuw ziekenhuis.
     *
     * @param id De unieke identifier van een ziekenhuis.
     * @param naam De naam van een ziekenhuis.
     * @param adres Het adres van een ziekenhuis.
     * @param postcode De postcode van een ziekenhuis.
     * @param huisnummer Het huisnummer van een ziekenhuis.
     * @param telefoonnummer Het telefoonnummer van een ziekenhuis.
     */
    public Ziekenhuis(int id, String naam, String adres, String postcode, int huisnummer, String telefoonnummer) {
        this.id = id;
        this.naam = naam;
        this.adres = adres;
        this.postcode = postcode;
        this.huisnummer = huisnummer;
        this.telefoonnummer = telefoonnummer;
    }
}
