package nl.dermanovus.dermanovus;

import java.util.ArrayList;

/**
 * @author Nino Vrijman
 */
public class Apotheek {
    private int id;
    private String naam;
    private String adres;
    private String postcode;
    private String huisnummer;
    private String webadres;
    private ArrayList<Voorraad> voorraad;
    private Ziekenhuis isAangeslotenBij;
    private Administratie adm;

    /**
     * Creëert een nieuwe apotheek.
     *
     * @param id De unieke identifier van een apotheek.
     * @param naam De naam van een apotheek.
     * @param adres Het adres van een apotheek.
     * @param postcode De postcode van een apotheek.
     * @param huisnummer Het huisnummer van een apotheek.
     * @param webadres Het webadres van een apotheek.
     * @param isAangeslotenBij Het ziekenhuis waarbij een apotheek is aangesloten.
     */
    public Apotheek(int id, String naam, String adres, String postcode, String huisnummer, String webadres, Ziekenhuis isAangeslotenBij) {
        this.id = id;
        this.naam = naam;
        this.adres = adres;
        this.postcode = postcode;
        this.huisnummer = huisnummer;
        this.webadres = webadres;
        this.voorraad = new ArrayList<>();
        this.isAangeslotenBij = isAangeslotenBij;
        this.adm = Administratie.getInstance();
    }

    /**
     * Voegt een nieuwe voorraad van een medicijn toe aan de bijbehorende apotheek.
     *
     * @param voorraad De voorraad die toegevoegd moet worden.
     * @return Return 'true' als de voorraad aan de database is toegevoegd. Return 'false' als de
     * voorraad niet aan de database is toegevoegd.
     */
    public boolean voegVoorraadToe(Voorraad voorraad) {
        if (adm.voegVoorraadToe(voorraad, this)) {
            this.voorraad.add(voorraad);
            return true;
        }
        return false;
    }
}
