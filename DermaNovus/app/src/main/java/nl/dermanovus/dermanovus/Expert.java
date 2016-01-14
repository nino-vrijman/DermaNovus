package nl.dermanovus.dermanovus;

import java.util.Date;

/**
 * @author Nino Vrijman
 */
public class Expert extends Gebruiker {
    public String getTitel() {
        return titel;
    }

    private String infoOver;
    public String titel;
    public String getInfoOver() {
        return infoOver;
    }

    public void setInfoOver(String infoOver) {
        this.infoOver = infoOver;
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
     * @param infoOver Informatie over een expert.
     */
    public Expert(int id, String voornaam, String achternaam, Date geboortedatum, String telefoonnummer, String emailadres, String imageJSON, String infoOver,String titel) {
        super(id, voornaam, achternaam, geboortedatum, telefoonnummer, emailadres, imageJSON);
        this.infoOver = infoOver;
        this.titel = titel;
    }
}
