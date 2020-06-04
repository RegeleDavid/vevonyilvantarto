/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package privat.sqlite;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import privat.alert.alert;

/**
 *
 * @author Dávid
 */
public class Delete extends connectoin{

    public Delete() throws ClassNotFoundException, SQLException {
        super();
    }
    
    public void letoltes(){
        try {
            //DELETE FROM `conf` WHERE neve="asd"
            PreparedStatement stmt=conn.prepareStatement("DELETE FROM `conf` WHERE neve=?");
            stmt.setString(1, "letoltes");
            stmt.executeUpdate();
        } catch (Exception e) {
            new alert().db(e);
        }
    }
    
}
