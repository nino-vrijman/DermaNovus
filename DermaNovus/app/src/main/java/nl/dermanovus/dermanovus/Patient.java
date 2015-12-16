package nl.dermanovus.dermanovus;

import java.util.Date;

/**
 * @author Nino Vrijman
 */
public class Patient extends Gebruiker {
    private String adres;
    private String postcode;
    private int huisnummer;
    private String toevoeging;

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public int getHuisnummer() {
        return huisnummer;
    }

    public void setHuisnummer(int huisnummer) {
        this.huisnummer = huisnummer;
    }

    public String getToevoeging() {
        return toevoeging;
    }

    public void setToevoeging(String toevoeging) {
        this.toevoeging = toevoeging;
    }

    /**
     * Creëert een nieuwe gebruiker.
     *
     * @param id             De unieke identifier van een gebruiker.
     * @param voornaam       De voornaam van een gebruiker.
     * @param achternaam     De achternaam van een gebruiker.
     * @param geboortedatum  De geboortedatum van een gebruiker.
     * @param telefoonnummer Het telefoonnummer van een gebruiker.
     * @param emailadres     Het e-mailadres van een gebruiker.
     * @param imageJSON      De JSON string van de avatar van een gebruiker.
     * @param adres          Het adres van een patiënt.
     * @param postcode       De postcode van een patiënt.
     * @param huisnummer     Het huisnummer van een patiënt.
     * @param toevoeging     De toevoeging van het huisnummer van een patiënt.
     */
    public Patient(int id, String voornaam, String achternaam, Date geboortedatum, String telefoonnummer, String emailadres, String imageJSON, String adres, String postcode, int huisnummer, String toevoeging) {
        super(id, voornaam, achternaam, geboortedatum, telefoonnummer, emailadres, imageJSON);
        this.adres = adres;
        this.postcode = postcode;
        this.huisnummer = huisnummer;
        this.toevoeging = toevoeging;
    }
}
