/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package afpa.ecf.physicalregatta.spark;

import afpa.ecf.physicalregatta.Settings;
import afpa.ecf.physicalregatta.Utils;
import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.staticFiles;

/**
 *
 * @author lionel
 */
public class Main {
        
    public static void main(String[] args) {
        
        port(Settings.PORT);
        staticFiles.location("/public"); // Static files
        
        get(Settings.getURIRegattas(), "application/json", (request, response) -> {
            return Utils.getCurrentChallenge();
        }, new JsonTransformer());
      
    }
}