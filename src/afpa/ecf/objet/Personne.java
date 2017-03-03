/*
 * This is free and unencumbered software released into the public domain.
 */

package afpa.ecf.objet;

import java.util.Calendar;

/**
 * 
 * @author gwenole
 */
public class Personne {
    String nom, prenom, email;
    int anneeNaissance;
    
    /**
     * 
     * @param nom le nom de la personne
     * @param prenom le prénom de la personne
     * @param email l'email de la personne
     * @param anneeNaissance  l'année de naissance de la personne
     */
    public Personne(String nom, String prenom, String email, int anneeNaissance) {
        super();
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.anneeNaissance = anneeNaissance;
    }
    
    /**
     * 
     * @return l'age de la personne en fonction de l'année courante
     */
    public int getAge() {
        return Calendar.getInstance().get(Calendar.YEAR) - anneeNaissance;
    }
    
    /**
     * 
     * @return la personne en format String
     */
    @Override
    public String toString() {
        return "Personne [nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", age=" + getAge() + "]";
    }
}
