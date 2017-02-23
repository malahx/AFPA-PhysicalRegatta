/*
 * This is free and unencumbered software released into the public domain.
 */

package afpa.ecf.algo;

import java.util.regex.Pattern;

/**
 * @author gwenole
 *
 */
public class Algo {
    /**
     * 
     * @param email
     * @return true si le paramètre est un email
     */
    public static boolean isEmail(String email) {
        // Décomposition des @
        String[] e = email.split("@");
        
        // Vérification du nombre de @
        if (e.length == 2) {
            
            // Inverser l'host (nécessaire pour limiter le nombre de split)
            String revHost = new StringBuilder(e[1]).reverse().toString();
            
            // Décomposition des points
            String[] f = revHost.split("\\.", 2);
            
            // Test que toutes les longueurs soient respectée
            return e[0].length() > 1 && f.length > 1 && f[0].length() > 1 && f[1].length() > 1;
        }
        return false;
    }
    
    /**
     * 
     * @param email
     * @return true si le paramètre est un email
     */
    public static boolean isEmailReg(String email) {
        return Pattern.matches("^[^@]{2,}?@[^@]{2,}\\.[^@.]{2,}$", email); // Vérification du pattern
    }
}
