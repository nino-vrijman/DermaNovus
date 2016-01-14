package nl.dermanovus.dermanovus;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Nino Vrijman
 */
public class Database {
    public static Database instance = null;
    private static Connection conn = null;

    public Database() {
        connect();
    }

    public static Database getInstance() {
        if (instance == null) {
            instance = new Database();
        }
        return instance;
    }


    public static boolean connect() {

        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
        } catch (Exception e) {
            System.err.println("Cannot create connection");
        }
        try {
            conn = DriverManager.getConnection("jdbc:mysql://janvandijk.me/janvaye117_derma", "janvaye117_derma", "stoeptegel");
            return true;
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
            return false;
        }
    }
    /**
     * Legt verbinding met de database en controleert of de opgegeven inloggegevens correct zijn.
     *
     * @param gebruikersnaam De opgegeven gebruikersnaam van de gebruiker.
     * @param wachtwoord Het opgegeven wachtwoord van de gebruiker.
     * @return Return 'true' als de inloggegevens correct zijn, return 'false' als de inloggegevens
     * niet correct zijn
     */
    public Gebruiker logIn(String gebruikersnaam, String wachtwoord) throws SQLException {
        Patient patient = null;
        try {
            connect();
            ResultSet rs = conn.prepareStatement("SELECT * FROM Patient WHERE emailadres = \""+gebruikersnaam+ "\" AND wachtwoord = \""+wachtwoord+"\"").executeQuery();
                while (rs.next()) {
                    int id = rs.getInt(1);
                    String voornaam = rs.getString(2);
                    String achternaam = rs.getString(3);
                    Date geboorteDatum = rs.getDate(4);
                    String adres = rs.getString(5);
                    String postcode = rs.getString(6);
                    int huisnummer = rs.getInt(7);
                    String toevoeging = rs.getString(8);
                    String telefoon = rs.getString(9);
                    String email = rs.getString(10);
                    String imgUrl = rs.getString(12);
                    patient = new Patient(id,voornaam,achternaam,geboorteDatum,telefoon,email,imgUrl,adres,postcode,huisnummer,toevoeging);
                }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conn.close();
        }
        return patient;
    }

    public Patient getPatient(int PatientID) throws SQLException {
        Patient patient = null;
        try {
            connect();
            ResultSet rs = conn.prepareStatement("SELECT * FROM Patient WHERE id = \""+PatientID+ "\"").executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String voornaam = rs.getString(2);
                String achternaam = rs.getString(3);
                Date geboorteDatum = rs.getDate(4);
                String adres = rs.getString(5);
                String postcode = rs.getString(6);
                int huisnummer = rs.getInt(7);
                String toevoeging = rs.getString(8);
                String telefoon = rs.getString(9);
                String email = rs.getString(10);
                String imgUrl = rs.getString(12);
                patient = new Patient(id,voornaam,achternaam,geboorteDatum,telefoon,email,imgUrl,adres,postcode,huisnummer,toevoeging);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conn.close();
        }
        return patient;
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

    public Behandeling getBehandeling(int behandelingID) throws SQLException {
        Behandeling behandeling = null;
        try {
            connect();
            ResultSet rs = conn.prepareStatement("SELECT * FROM Behandeling WHERE id = "+behandelingID+"").executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String titel = rs.getString(2);
                java.util.Date startDatum = rs.getDate(5);
                 String symptoomOmschrijving = rs.getString(6);
                 String overzichtImageJSON = rs.getString(7);
                 String middelImageJSON = rs.getString(8);
                 String closeUpImageJSON = rs.getString(9);

                behandeling = new Behandeling(id,titel,startDatum,symptoomOmschrijving,overzichtImageJSON,middelImageJSON,closeUpImageJSON);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conn.close();
        }
        return behandeling;
    }

    public Medicijn  getMedicijn(int medicijnID) throws SQLException {
        Medicijn medicijn = null;
        try {
            connect();
            ResultSet rs = conn.prepareStatement("SELECT * FROM Medicijn WHERE id = "+medicijnID+"").executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                 String naam = rs.getString(2);
                 String bijsluiter = rs.getString(3);
                 double prijs = rs.getDouble(4);
                 String eenheid = rs.getString(5);
                 int hoeveelheid = rs.getInt(6);
                 String imageJSON = rs.getString(7);
                 boolean bestellingGoedgekeurd = false;

                medicijn = new Medicijn(id,naam,bijsluiter,prijs,eenheid,hoeveelheid,imageJSON,bestellingGoedgekeurd);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conn.close();
        }
        return medicijn;
    }

    public Expert getExpert(int expertID) throws SQLException {
        Expert expert = null;
        try {
            connect();
            ResultSet rs = conn.prepareStatement("SELECT * FROM Expert WHERE id = "+expertID+"").executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String titel = rs.getString(2);
                String voornaam = rs.getString(3);
                String achternaam = rs.getString(4);
                java.util.Date geboortedatum = rs.getDate(5);
                String infoOver = rs.getString(6);
                String telefoonnummer = rs.getString(7);
                String emailadres = rs.getString(8);
                String imageJSON = rs.getString(10);
                expert = new Expert(id,voornaam,achternaam,geboortedatum,telefoonnummer,emailadres,imageJSON,infoOver,titel);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conn.close();
        }
        return expert;
    }
}
