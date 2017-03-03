/*
 * This is free and unencumbered software released into the public domain.
 */

package afpa.ecf.objet;

/**
 * 
 * @author gwenole
 */
public class Proprietaire extends Personne {

    /**
     * 
     * @param nom le nom du propriétaire
     * @param prenom le prénom du propriétaire
     * @param email l'email du proriétaire
     * @param anneeNaissance l'année de naissance du propriétaire
     */
    public Proprietaire(String nom, String prenom, String email, int anneeNaissance) {
        super(nom, prenom, email, anneeNaissance);
    }
    
    /**
     * 
     * @return le propriétaire au format String
     */
    @Override
    public String toString() {
        return "Proprietaire [" + super.toString() + "]";
    }
}
