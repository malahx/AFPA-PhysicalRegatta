package afpa.ecf.objet;

public class Proprietaire extends Personne {

    public Proprietaire(String nom, String prenom, String email, int anneeNaissance) {
        super(nom, prenom, email, anneeNaissance);
    }
    
    @Override
    public String toString() {
        return "Proprietaire [" + super.toString() + "]";
    }
}
