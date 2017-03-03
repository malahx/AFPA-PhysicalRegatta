/*
 * This is free and unencumbered software released into the public domain.
 */
package afpa.ecf.objet;

/**
 *
 * @author gwenole
 */
public class Commissaire extends Personne {

    String commite;

    /**
     *
     * @param nom le nom du commissaire
     * @param prenom le prénom du commissaire
     * @param email l'email du commissaire
     * @param anneeNaissance l'année de naissance du commissaire
     * @param commite le commité du commissaire
     */
    public Commissaire(String nom, String prenom, String email, int anneeNaissance, String commite) {
        super(nom, prenom, email, anneeNaissance);
        this.commite = commite;
    }

    /**
     *
     * @return le commissaire au format String
     */
    @Override
    public String toString() {
        return "Commissaire [commite=" + commite + ", " + super.toString() + "]";
    }
}
