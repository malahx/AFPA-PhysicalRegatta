/*
 * This is free and unencumbered software released into the public domain.
 */
package afpa.ecf.objet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
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

        // Instanciation du jeu d'essai
        Proprietaire pro1 = new Proprietaire("Duchou", "Jean", "jean@duchou.fr", 1965);
        Proprietaire pro2 = new Proprietaire("Duduche", "Fred", "fred@duduche.fr", 1955);
        Proprietaire pro3 = new Proprietaire("Kikoo", "Pierre", "pierre@kikoo.fr", 1945);
        Licencie lic1 = new Licencie("Le Cléac’h", "Armel", "armel@lechleach.fr", 1977, 123456, 2017, 0);
        Licencie lic2 = new Licencie("Thomson", "Alex", "alex@thomson.uk", 1974, 123457, 2017, 0);
        Licencie lic3 = new Licencie("Beyou", "Jérémie", "jeremie@beyou.fr", 1976, 123458, 2017, 0);
        Commissaire com = new Commissaire("Squarcini", "Bernard", "bernard@squarcini.fr", 1955, "Corse");

        // Préparation des dates du calculPoints
        Calendar cal1 = Calendar.getInstance();
        cal1.set(2017, 01, 01);

        Calendar cal2 = Calendar.getInstance();
        cal2.set(1917, 01, 01);

        // Test de la méthode calculPoints avec la bonne date
        try {
            lic1.calculPoints(100, cal1);
            lic1.calculPoints(50, cal1);
        } catch (Exception e) {
            System.out.println(e);
        }

        // Test de la méthode calculPoints avec la mauvaise date
        try {
            lic1.calculPoints(100, cal2);
        } catch (Exception e) {
            System.out.println(e);
        }

        // Ajout du jeu d'essai dans une collection
        List<Personne> personnes = new ArrayList<>();
        personnes.add(pro1);
        personnes.add(pro2);
        personnes.add(pro3);
        personnes.add(lic1);
        personnes.add(lic2);
        personnes.add(lic3);
        personnes.add(com);

        // Affichage de la collection
        for (Personne p : personnes) {
            System.out.println(p);
        }

        // Calcul de l'age moyen et de l'age médian
        System.out.println("Age moyen : " + moyAge(personnes));
        System.out.println("Age médian : " + medAge(personnes));
    }

    /**
     * *
     *
     * @param personnes
     * @return l'age moyen
     */
    public static double moyAge(List<Personne> personnes) {
        double ageTot = 0;
        for (Personne p : personnes) {
            ageTot += p.getAge();
        }
        return ageTot / personnes.size();
    }

    /**
     * *
     *
     * @param personnes
     * @return l'age médian
     */
    public static double medAge(List<Personne> personnes) {

        // Passage en tableau d'age
        int[] ages = new int[personnes.size()];

        for (int i = personnes.size() - 1; i >= 0; i--) {
            ages[i] = personnes.get(i).getAge();
        }

        // Triage des ages
        Arrays.sort(ages);

        // Récupération de l'index du centre
        int i = ages.length / 2;

        // Calcul de l'age médian
        if (ages.length % 2 == 1) {
            return ages[i];
        } else {
            return (ages[i - 1] + ages[i]) / 2.0;
        }
    }
}
