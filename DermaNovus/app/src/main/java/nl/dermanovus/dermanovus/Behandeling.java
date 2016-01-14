package nl.dermanovus.dermanovus;

import java.util.ArrayList;
import java.util.Date;

/**
 * @author Nino Vrijman
 */
public class Behandeling {
    private int id;
    private String titel;

    public int getId() {
        return id;
    }

    public Date getStartDatum() {
        return startDatum;
    }

    public String getSymptoomOmschrijving() {
        return symptoomOmschrijving;
    }

    public String getOverzichtImageJSON() {
        return overzichtImageJSON;
    }

    public String getMiddelImageJSON() {
        return middelImageJSON;
    }

    public String getCloseUpImageJSON() {
        return closeUpImageJSON;
    }

    public double getBeoordelingExpert() {
        return beoordelingExpert;
    }

    public Expert getExpert() {
        return expert;
    }

    public Patient getPatient() {
        return patient;
    }

    public ArrayList<Recept> getRecepten() {
        return recepten;
    }

    public ArrayList<Bericht> getBerichten() {
        return berichten;
    }

    private Date startDatum;
    private String symptoomOmschrijving;
    private String overzichtImageJSON;
    private String middelImageJSON;
    private String closeUpImageJSON;
    private double beoordelingExpert;
    private EBehandelingStatus status;
    private Expert expert;
    private Patient patient;
    private ArrayList<Recept> recepten;
    private ArrayList<Bericht> berichten;
    private Administratie adm;

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public void setBeoordelingExpert(double beoordelingExpert) {
        this.beoordelingExpert = beoordelingExpert;
    }

    public EBehandelingStatus getStatus() {
        return status;
    }

    public void setStatus(EBehandelingStatus status) {
        this.status = status;
    }

    /**
     * Creëert een nieuwe behandeling.
     *
     * @param id De unieke identifier van een behandeling.
     * @param titel De titel van een behandeling.
     * @param startDatum De startdatum van een behandeling.
     * @param symptoomOmschrijving De symptoomomschrijving van een behandeling.
     * @param overzichtImageJSON De JSON string van de overzicht afbeelding van een bericht.
     * @param middelImageJSON De JSON string van de middel afbeelding van een bericht.
     * @param closeUpImageJSON De JSON string van de close-up afbeelding van een bericht.
     * @param status De status van een behandeling.
     * @param expert De expert die een behandeling geeft.
     * @param patient De patiënt die een behandeling ondergaat.
     */
    public Behandeling(int id, String titel, Date startDatum, String symptoomOmschrijving, String overzichtImageJSON, String middelImageJSON, String closeUpImageJSON, EBehandelingStatus status, Expert expert, Patient patient) {
        this.id = id;
        this.titel = titel;
        this.startDatum = startDatum;
        this.symptoomOmschrijving = symptoomOmschrijving;
        this.overzichtImageJSON = overzichtImageJSON;
        this.middelImageJSON = middelImageJSON;
        this.closeUpImageJSON = closeUpImageJSON;
        this.status = status;
        this.expert = expert;
        this.patient = patient;
        this.recepten = new ArrayList<>();
        this.berichten = new ArrayList<>();
        this.adm = Administratie.getInstance();
    }
    public Behandeling(int id, String titel, Date startDatum, String symptoomOmschrijving, String overzichtImageJSON, String middelImageJSON, String closeUpImageJSON) {
        this.id = id;
        this.titel = titel;
        this.startDatum = startDatum;
        this.symptoomOmschrijving = symptoomOmschrijving;
        this.overzichtImageJSON = overzichtImageJSON;
        this.middelImageJSON = middelImageJSON;
        this.closeUpImageJSON = closeUpImageJSON;
    }
    /**
     * Plaats een nieuw bericht dat bij een behandeling hoort.
     *
     * @param nieuwBericht Het nieuwe bericht dat geplaatst moet worden.
     * @return Return true als het bericht geplaatst is. Return false als het bericht niet geplaatst is.
     */
    public boolean plaatsBericht(Bericht nieuwBericht) {
        if (adm.plaatsBericht(nieuwBericht, this)) {
            this.berichten.add(nieuwBericht);
            return true;
        }
        return false;
    }

    /**
     * Schrijft een nieuw recept uit dat bij een behandeling hoort.
     *
     * @param nieuwRecept Het nieuwe recept dat bij een behandeling hoort.
     * @return Return true als het recept uitgeschreven is. Return false als het recept niet uitgeschreven is.
     */
    public boolean schrijfReceptUit(Recept nieuwRecept) {
        if (adm.schrijfReceptUit(nieuwRecept, this)) {
            this.recepten.add(nieuwRecept);
            return true;
        }
        return false;
    }
}
