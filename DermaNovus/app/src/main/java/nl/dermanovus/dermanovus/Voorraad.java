package nl.dermanovus.dermanovus;

/**
 * @author Nino Vrijman
 */
public class Voorraad {
    private int voorraad;
    private Medicijn medicijn;

    public int getVoorraad() {
        return voorraad;
    }

    public void setVoorraad(int voorraad) {
        this.voorraad = voorraad;
    }

    /**
     * Creëert een nieuwe voorraad van een apotheek van een bepaald medicijn.
     *
     * @param voorraad De voorraad van een medicijn.
     * @param medicijn Een medicijn dat een apotheek in voorraad heeft.
     */
    public Voorraad(int voorraad, Medicijn medicijn) {
        this.voorraad = voorraad;
        this.medicijn = medicijn;
    }
}
