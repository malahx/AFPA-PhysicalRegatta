/*
 * This is free and unencumbered software released into the public domain.
 */
package afpa.ecf.objet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author gwenole
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Proprietaire pro1 = new Proprietaire("Duchou", "Jean", "jean@duchou.fr", 1965);
        Proprietaire pro2 = new Proprietaire("Duduche", "Fred", "fred@duduche.fr", 1955);
        Proprietaire pro3 = new Proprietaire("Kikoo", "Pierre", "pierre@kikoo.fr", 1945);
        Licencie lic1 = new Licencie("Le Cléac’h", "Armel", "armel@lechleach.fr", 1977, 123456, 2017, 0);
        Licencie lic2 = new Licencie("Thomson", "Alex", "alex@thomson.uk", 1974, 123457, 2017, 0);
        Licencie lic3 = new Licencie("Beyou", "Jérémie", "jeremie@beyou.fr", 1976, 123458, 2017, 0);
        Commissaire com = new Commissaire("Squarcini", "Bernard", "bernard@squarcini.fr", 1955, "Corse");
        
        try {
            lic1.calculPoints(100, 2017);
            lic1.calculPoints(50, 2017);
            lic1.calculPoints(100, 1917);
        } catch (Exception e) {
            System.out.println(e);
        }
        
        List<Personne> personnes = new ArrayList<>();
        personnes.add(pro1);
        personnes.add(pro2);
        personnes.add(pro3);
        personnes.add(lic1);
        personnes.add(lic2);
        personnes.add(lic3);
        personnes.add(com);
        
        for (Personne p : personnes) {
            System.out.println(p);
        }
        
        System.out.println("Moyenne d'age : " + moyAge(personnes));
        System.out.println("Médiane d'age : " + medAge(personnes));
    }
    
    public static double moyAge(List<Personne> personnes) {
        double ageTot = 0;
        for (Personne p : personnes) {
            ageTot += p.getAge();
        }
        return ageTot / personnes.size();
    }
    
    public static double medAge(List<Personne> personnes) {
        int[] ages = new int[personnes.size()];
        
        for (int i = personnes.size() -1; i >= 0; i--) {
            ages[i] = personnes.get(i).getAge();
        }
        Arrays.sort(ages);
        int demi = ages.length / 2;
        
        if (ages.length%2 == 1) {
            return ages[demi];
        } else {
            return (ages[demi-1] + ages[demi]) / 2.0;
        }
    }
    
}
