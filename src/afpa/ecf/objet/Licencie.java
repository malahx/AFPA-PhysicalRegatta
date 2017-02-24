package afpa.ecf.objet;

import java.util.Calendar;

public class Licencie extends Personne {

    int numLicence, anneeLicence;
    double pointsFFV;
    
    public Licencie(String nom, String prenom, String email, int anneeNaissance, int numLicence, int anneeLicence, double pointsFFV) {
        super(nom, prenom, email, anneeNaissance);
        this.numLicence = numLicence;
        this.anneeLicence = anneeLicence;
        this.pointsFFV = pointsFFV;
    }
    
    public void calculPoints(int nombre, Calendar cal) throws Exception {
        if (anneeLicence != cal.get(Calendar.YEAR)) {
            System.out.println(cal.get(Calendar.YEAR));
            throw new Exception();
        }
        pointsFFV += nombre;
    }
    
    @Override
    public String toString() {
        return "Licencie [numLicence=" + numLicence  + ", anneeLicence=" + anneeLicence  + ", pointsFFV=" + pointsFFV  + ", " + super.toString() + "]";
    }
    
}
