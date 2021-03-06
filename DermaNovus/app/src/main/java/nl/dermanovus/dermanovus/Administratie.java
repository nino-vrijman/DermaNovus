package nl.dermanovus.dermanovus;

import java.sql.SQLException;

/**
 * @author Nino Vrijman
 */
public class Administratie {
    private static Administratie instance = null;
    private static Database db = Database.getInstance();

    public Administratie(Database db) {

    }
    public static Administratie getInstance() {
        if (instance == null) {
            instance = new Administratie(db);
        }
        return instance;
    }

    /**
     * Controleert via de database klasse of de opgegeven inloggegevens correct zijn.
     *
     * @param gebruikersnaam De opgegeven gebruikersnaam van de gebruiker.
     * @param wachtwoord Het opgegeven wachtwoord van de gebruiker.
     * @return Return 'true' als de inloggegevens correct zijn, return 'false' als de inloggegevens
     * niet correct zijn
     */
    public Gebruiker logIn(String gebruikersnaam, String wachtwoord) throws SQLException {
        return db.logIn(gebruikersnaam, wachtwoord);
    }

    public Patient getPatient(int patientID) throws SQLException {
        return db.getPatient(patientID);
    }
    public Behandeling getBehandeling(int behandelingID) throws SQLException{
        return db.getBehandeling(behandelingID);
    }
    /**
     * Zet via de database klasse de status of een bericht dat tot een behandeling behoort gelezen
     * is door de patiënt.
     *
     * @param b Het bericht waarvan de status verandert moet worden.
     * @return Return 'true' als de status van het bericht succesvol gewijzigd is, return 'false' als
     * de status van het bericht niet gewijzigd is.
     */
    public boolean setBerichtGelezen(Bericht b) {
        return db.setBerichtGelezen(b);
    }

    /**
     * Wijzigt via de database klasse de adresgegevens van een patiënt.
     *
     * @param p De patiënt waarvan de adresgegevens gewijzigd moeten worden.
     * @return Return 'true' als de adresgegevens van de patiënt succesvol gewijzigd zijn, return
     * 'false' als de adresgegevens niet gewijzigd zijn.
     */
    public boolean wijzigAdresGegevens(Patient p) {
        return db.wijzigAdresGegevens(p);
    }

    /**
     * Wijzigt via de database klasse het telefoonnummer van een gebruiker.
     *
     * @param g De gebruiker waarvan het telefoonnummer gewijzigd moet worden.
     * @return Return 'true' als het telefoonnummer van de gebruiker succesvol gewijzigd is, return
     * 'false' als het telefoonnummer niet gewijzigd is.
     */
    public boolean wijzigTelefoonnummer(Gebruiker g) {
        return db.wijzigTelefoonnummer(g);
    }

    /**
     * Wijzigt via de database klasse het emailadres van een gebruiker.
     *
     * @param g De gebruiker waarvan het e-mailadres gewijzigd moet worden.
     * @return Return 'true' als het e-mailadres van de gebruiker succesvol gewijzigd is, return
     * 'false' als het e-mailadres niet gewijzigd is.
     */
    public boolean wijzigEmailadres(Gebruiker g) {
        return db.wijzigEmailadres(g);
    }

    /**
     * Wijzigt via de database klasse de avatar van een gebruiker.
     *
     * @param g De gebruiker waarvan de avatar gewijzigd moet worden.
     * @return Return 'true' als de avatar van de gebruiker succesvol gewijzigd is, return 'false'
     * als de avatar niet gewijzigd is.
     */
    public boolean wijzigAvatar(Gebruiker g) {
        return db.wijzigAvatar(g);
    }

    /**
     * Wijzigt via de database klasse de beoordeling van een expert.
     *
     * @param b De behandeling op basis waarvan een expert beoordeeld is.
     * @return Return 'true' als de beoordeling van de expert succesvol gewijzigd is, return 'false'
     * als de beoordeling van de expert niet gewijzigd is.
     */
    public boolean beoordeelExpert(Behandeling b) {
        return db.beoordeelExpert(b);
    }

    /**
     * Wijzigt via de database klasse de status van een behandeling.
     *
     * @param b De behandeling waarvan de status aangepast moet worden.
     * @return Return 'true' als de status van een behandeling succesvol gewijzigd is, return 'false'
     * als de status van een behandeling niet gewijzigd is.
     */
    public boolean wijzigBehandelingStatus(Behandeling b) {
        return db.wijzigBehandelingStatus(b);
    }

    /**
     * Plaatst via de database klasse een nieuw bericht.
     *
     * @param ber Het nieuwe bericht dat geplaatst moet worden.
     * @param beh De behandeling waar het nieuwe bericht bij hoort.
     * @return Return 'true' als het nieuwe bericht succesvol is geplaatst, return 'false' als het
     * nieuwe bericht niet is geplaatst.
     */
    public boolean plaatsBericht(Bericht ber, Behandeling beh) throws SQLException {
        return db.plaatsBericht(ber, beh);
    }

    /**
     * Schrijft via de database klasse een nieuw recept uit.
     *
     * @param rec Het recept dat uitgeschreven moet worden.
     * @param beh De behandeling waar het uit te schrijven recept toe behoort.
     * @return Return 'true' als het recept correct aan de database is toegevoegd, return 'false' als
     * het recept niet is toegevoegd.
     */
    public boolean schrijfReceptUit(Recept rec, Behandeling beh) {
        return db.schrijfReceptUit(rec, beh);
    }

    /**
     * Verandert via de database klasse de goedkeuringstatus van een recept.
     *
     * @param rec Het recept waarvan de status gewijzigd moet worden.
     * @param beh De behandeling waar het recept toe behoort.
     * @return Return 'true' als de status van het recept succesvol is gewijzigd, return 'false' als
     * de status van het recept niet is gewijzigd.
     */
    public boolean veranderGoedkeurigRecept(Recept rec, Behandeling beh) {
        return db.veranderGoedkeurigRecept(rec, beh);
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
        return db.voegVoorraadToe(voorraad, apotheek);
    }

    public Medicijn getMedicijn(int medicijnID) throws SQLException {
        return db.getMedicijn(medicijnID);
    }

    public Expert getExpert(int expertID) throws SQLException {
        return db.getExpert(expertID);
    }
}
