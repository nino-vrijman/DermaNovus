package nl.dermanovus.dermanovus;

import java.util.Date;

/**
 * @author Nino Vrijman
 */
public abstract class Gebruiker {
    private int id;
    private String voornaam;
    private String achternaam;
    private Date geboortedatum;
    private String telefoonnummer;
    private String emailadres;
    private String imageJSON;
    private Administratie adm;

    public Date getGeboortedatum() {
        return geboortedatum;
    }

    public String getAchternaam() {
        return achternaam;
    }

    public String getVoornaam() {
        return voornaam;
    }

    public int getId() {
        return id;
    }

    public String getTelefoonnummer() {
        return telefoonnummer;
    }

    public void setTelefoonnummer(String telefoonnummer) {
        this.telefoonnummer = telefoonnummer;
    }

    public String getEmailadres() {
        return emailadres;
    }

    public void setEmailadres(String emailadres) {
        this.emailadres = emailadres;
    }

    public String getImageJSON() {
        return imageJSON;
    }

    public void setImageJSON(String imageJSON) {
        this.imageJSON = imageJSON;
    }

    /**
     * Creëert een nieuwe gebruiker.
     *
     * @param id De unieke identifier van een gebruiker.

     * @param voornaam De voornaam van een gebruiker.
     * @param achternaam De achternaam van een gebruiker.
     * @param geboortedatum De geboortedatum van een gebruiker.
     * @param telefoonnummer Het telefoonnummer van een gebruiker.
     * @param emailadres Het e-mailadres van een gebruiker.
     * @param imageJSON De JSON string van de avatar van een gebruiker.
     */
    public Gebruiker(int id, String voornaam, String achternaam, Date geboortedatum, String telefoonnummer, String emailadres, String imageJSON) {
        this.id = id;
        this.voornaam = voornaam;
        this.achternaam = achternaam;
        this.geboortedatum = geboortedatum;
        this.telefoonnummer = telefoonnummer;
        this.emailadres = emailadres;
        this.imageJSON = imageJSON;
        this.adm = Administratie.getInstance();
    }
}
