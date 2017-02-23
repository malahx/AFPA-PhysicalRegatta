package afpa.ecf.objet;

import java.util.Calendar;

public class Personne {
    String nom, prenom, email;
    int anneeNaissance;
    
    public Personne(String nom, String prenom, String email, int anneeNaissance) {
        super();
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.anneeNaissance = anneeNaissance;
    }
    
    public int getAge() {
        return Calendar.getInstance().get(Calendar.YEAR) - anneeNaissance;
    }
    
    @Override
    public String toString() {
        return "Personne [nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", age=" + getAge() + "]";
    }
}
