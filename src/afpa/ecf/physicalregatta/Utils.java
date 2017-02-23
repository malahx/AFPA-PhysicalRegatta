/*
 * This is free and unencumbered software released into the public domain.
 */

package afpa.ecf.physicalregatta;

import java.util.regex.Pattern;

/**
 * @author gwenole
 *
 */
public class Utils {
    
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
            
            // décomposition des points
            String[] f = e[1].split("\\.");
            
            // Vérification du nombre de point
            if (f.length > 1) {
                
                // Test que toutes les longueurs soient respectée
                return e[0].length() > 1 && f.length > 1 && f[0].length() > 1 && f[1].length() > 1;
            }
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
