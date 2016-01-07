package nl.dermanovus.dermanovus;

/**
 * @author Nino Vrijman
 */
public class Bericht {
    private int id;
    private String inhoud;
    private String overzichtImageJSON;
    private String middelImageJSON;
    private String closeUpImageJSON;
    private boolean gelezen;
    private Gebruiker geplaatstDoor;
    private Administratie adm;

    public Gebruiker getGeplaatstDoor() {
        return geplaatstDoor;
    }

    public void setGeplaatstDoor(Gebruiker geplaatstDoor) {
        this.geplaatstDoor = geplaatstDoor;
    }

    /**
     * Creëert een nieuw bericht.
     *
     * @param id De unieke identifier van een bericht.
     * @param inhoud De inhoud van een bericht.
     * @param overzichtImageJSON De JSON string van de overzicht afbeelding van een bericht.
     * @param middelImageJSON De JSON string van de middel afbeelding van een bericht.
     * @param closeUpImageJSON De JSON string van de close-up afbeelding van een bericht.
     * @param gelezen De leesstatus van een bericht.
     * @param geplaatstDoor De gebruiker die een bericht geplaatst heeft.
     */
    public Bericht(int id, String inhoud, String overzichtImageJSON, String middelImageJSON, String closeUpImageJSON, boolean gelezen, Gebruiker geplaatstDoor) {
        this.id = id;
        this.inhoud = inhoud;
        this.overzichtImageJSON = overzichtImageJSON;
        this.middelImageJSON = middelImageJSON;
        this.closeUpImageJSON = closeUpImageJSON;
        this.gelezen = gelezen;
        this.geplaatstDoor = geplaatstDoor;
        this.adm = Administratie.getInstance();
    }
}
