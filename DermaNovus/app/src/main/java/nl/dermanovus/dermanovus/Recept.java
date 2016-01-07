package nl.dermanovus.dermanovus;

import java.util.Date;

/**
 * @author Nino Vrijman
 */
public class Recept {
    private int id;
    private Date besteldatum;
    private Date leverdatum;
    private Date looptijd;
    private int hoeveelheid;
    private EReceptStatus goedgekeurd;
    private Medicijn medicijn;
    private Administratie adm;

    public void setGoedgekeurd(EReceptStatus goedgekeurd) {
        this.goedgekeurd = goedgekeurd;
    }

    /**
     * Creëert een nieuw recept.
     *
     * @param id De unieke identifier van een recept.
     * @param besteldatum De besteldatum van een recept.
     * @param leverdatum De leverdatum van een recept.
     * @param looptijd De looptijd van een recept.
     * @param hoeveelheid De hoeveelheid van een medicijn dat bij een recept hoort.
     * @param goedgekeurd De status van een recept.
     * @param medicijn Het medicijn waarvoor een recept is uitgeschreven.
     */
    public Recept(int id, Date besteldatum, Date leverdatum, Date looptijd, int hoeveelheid, EReceptStatus goedgekeurd, Medicijn medicijn) {
        this.id = id;
        this.besteldatum = besteldatum;
        this.leverdatum = leverdatum;
        this.looptijd = looptijd;
        this.hoeveelheid = hoeveelheid;
        this.goedgekeurd = goedgekeurd;
        this.medicijn = medicijn;
        this.adm = Administratie.getInstance();
    }
}
