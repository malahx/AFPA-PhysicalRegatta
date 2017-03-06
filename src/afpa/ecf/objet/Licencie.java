/*
 * This is free and unencumbered software released into the public domain.
 */
package afpa.ecf.objet;

import java.util.Calendar;

/**
 *
 * @author gwenole
 */
public class Licencie extends Personne {

    int numLicence, anneeLicence;
    double pointsFFV;

    /**
     *
     * @param nom le nom du licencié
     * @param prenom le prénom du licencié
     * @param email l'email du licencié
     * @param anneeNaissance l'année de naissance du licencié
     * @param numLicence le numéro de licence du licencié
     * @param anneeLicence l'année de licence du licencié
     * @param pointsFFV le nombre de points FFV du licencié
     */
    public Licencie(String nom, String prenom, String email, int anneeNaissance, int numLicence, int anneeLicence, double pointsFFV) {
        super(nom, prenom, email, anneeNaissance);
        this.numLicence = numLicence;
        this.anneeLicence = anneeLicence;
        this.pointsFFV = pointsFFV;
    }

    /**
     *
     * @param nombre le nombre de points à ajouter
     * @param cal la date ou il faut ajouter le nombre de points
     * @throws Exception
     */
    public void calculPoints(int nombre, Calendar cal) throws Exception {
        if (anneeLicence != cal.get(Calendar.YEAR)) {
            throw new Exception();
        }
        pointsFFV += nombre;
    }

    /**
     *
     * @return le licencié au format String
     */
    @Override
    public String toString() {
        return "Licencie [numLicence=" + numLicence + ", anneeLicence=" + anneeLicence + ", pointsFFV=" + pointsFFV + ", " + super.toString() + "]";
    }
}
