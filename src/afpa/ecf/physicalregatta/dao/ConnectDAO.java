/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package afpa.ecf.physicalregatta.dao;

import java.sql.Connection;
import java.util.List;

/**
 *
 * @author gwenole
 */
public class ConnectDAO extends DAO {

    private static ConnectDAO instance = null;

    public static ConnectDAO Instance() {
        if (instance == null) {
            instance = new ConnectDAO();
        }
        return instance;
    }
    
    public Connection get() {
        return getConnection();
    }
}
