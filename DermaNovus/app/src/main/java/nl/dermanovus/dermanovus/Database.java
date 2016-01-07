package nl.dermanovus.dermanovus;

/**
 * @author Nino Vrijman
 */
public class Database {
    public static Database instance = null;

    public Database() {

    }

    public static Database getInstance() {
        if (instance == null) {
            instance = new Database();
        }
        return instance;
    }


    /**
     * Legt verbinding met de database en controleert of de opgegeven inloggegevens correct zijn.
     *
     * @param gebruikersnaam De opgegeven gebruikersnaam van de gebruiker.
     * @param wachtwoord Het opgegeven wachtwoord van de gebruiker.
     * @return Return 'true' als de inloggegevens correct zijn, return 'false' als de inloggegevens
     * niet correct zijn
     */
    public boolean logIn(String gebruikersnaam, String wachtwoord) {
        return false;
    }

    /**
     * Legt verbinding met de database en zet de status of een bericht dat tot een behandeling
     * behoort gelezen is door de patiënt.
     *
     * @param b Het bericht waarvan de status verandert moet worden.
     * @return Return 'true' als de status van het bericht succesvol gewijzigd is, return 'false' als
     * de status van het bericht niet gewijzigd is.
     */
    public boolean setBerichtGelezen(Bericht b) {
        return false;
    }

    /**
     * Legt verbinding met de database en wijzigt de adresgegevens van een patiënt.
     *
     * @param p De patiënt waarvan de adresgegevens gewijzigd moeten worden.
     * @return Return 'true' als de adresgegevens van de patiënt succesvol gewijzigd zijn, return
     * 'false' als de adresgegevens niet gewijzigd zijn.
     */
    public boolean wijzigAdresGegevens(Patient p) {
        return false;
    }

    /**
     * Legt verbinding met de database en wijzigt het telefoonnummer van een gebruiker.
     *
     * @param g De gebruiker waarvan het telefoonnummer gewijzigd moet worden.
     * @return Return 'true' als het telefoonnummer van de gebruiker succesvol gewijzigd is, return
     * 'false' als het telefoonnummer niet gewijzigd is.
     */
    public boolean wijzigTelefoonnummer(Gebruiker g) {
        return false;
    }

    /**
     * Legt verbinding met de database en wijzigt het emailadres van een gebruiker.
     *
     * @param g De gebruiker waarvan het e-mailadres gewijzigd moet worden.
     * @return Return 'true' als het e-mailadres van de gebruiker succesvol gewijzigd is, return
     * 'false' als het e-mailadres niet gewijzigd is.
     */
    public boolean wijzigEmailadres(Gebruiker g) {
        return false;
    }

    /**
     * Legt verbinding met de database en wijzigt de avatar van een gebruiker.
     *
     * @param g De gebruiker waarvan de avatar gewijzigd moet worden.
     * @return Return 'true' als de avatar van de gebruiker succesvol gewijzigd is, return 'false'
     * als de avatar niet gewijzigd is.
     */
    public boolean wijzigAvatar(Gebruiker g) {
        return false;
    }

    /**
     * Legt verbinding met de database en wijzigt de beoordeling van een expert.
     *
     * @param b De behandeling op basis waarvan een expert beoordeeld is.
     * @return Return 'true' als de beoordeling van de expert succesvol gewijzigd is, return 'false'
     * als de beoordeling van de expert niet gewijzigd is.
     */
    public boolean beoordeelExpert(Behandeling b) {
        return false;
    }

    /**
     * Legt verbinding met de database en wijzigt de status van een behandeling.
     *
     * @param b De behandeling waarvan de status aangepast moet worden.
     * @return Return 'true' als de status van een behandeling succesvol gewijzigd is, return 'false'
     * als de status van een behandeling niet gewijzigd is.
     */
    public boolean wijzigBehandelingStatus(Behandeling b) {
        return false;
    }

    /**
     * Legt verbinding met de database en plaatst een nieuw bericht.
     *
     * @param ber Het nieuwe bericht dat geplaatst moet worden.
     * @param beh De behandeling waar het nieuwe bericht bij hoort.
     * @return Return 'true' als het nieuwe bericht succesvol is geplaatst, return 'false' als het
     * nieuwe bericht niet is geplaatst.
     */
    public boolean plaatsBericht(Bericht ber, Behandeling beh) {
        return false;
    }

    /**
     * Legt verbinding met de database en schrijf een nieuw recept uit.
     *
     * @param rec Het recept dat uitgeschreven moet worden.
     * @param beh De behandeling waar het uit te schrijven recept toe behoort.
     * @return Return 'true' als het recept correct aan de database is toegevoegd, return 'false' als
     * het recept niet is toegevoegd.
     */
    public boolean schrijfReceptUit(Recept rec, Behandeling beh) {
        return false;
    }

    /**
     * Legt verbinding met de database en verandert de goedkeuringstatus van een recept.
     *
     * @param rec Het recept waarvan de status gewijzigd moet worden.
     * @param beh De behandeling waar het recept toe behoort.
     * @return Return 'true' als de status van het recept succesvol is gewijzigd, return 'false' als
     * de status van het recept niet is gewijzigd.
     */
    public boolean veranderGoedkeurigRecept(Recept rec, Behandeling beh) {
        return false;
    }

    /**
     * Voegt een nieuwe voorraad van een medicijn toe aan de bijbehorende apotheek.
     *
     * @param voorraad De voorraad die toegevoegd moet worden.
     * @param apotheek De apotheek waaraan de voorraad toegevoegd moet worden.
     * @return Return 'true' als de voorraad aan de database is toegevoegd. Return 'false' als de
     * voorraad niet aan de database is toegevoegd.
     */
    public boolean voegVoorraadToe(Voorraad voorraad, Apotheek apotheek) {
        return false;
    }
}
