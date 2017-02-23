package afpa.ecf.objet;

public class Commissaire extends Personne {
    String commite;

    public Commissaire(String nom, String prenom, String email, int anneeNaissance, String commite) {
        super(nom, prenom, email, anneeNaissance);
        this.commite = commite;
    }
    
    @Override
    public String toString() {
        return "Commissaire [commite=" + commite  + ", " + super.toString() + "]";
    }
   
}
