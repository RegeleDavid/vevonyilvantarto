/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package privat.insert;

import java.awt.Insets;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import privat.InterFace.db_insert;
import privat.alert.alert;
import privat.sqlite.Insert;
/**
 *
 * @author Dávid
 */
public class log_inser implements db_insert{
    private  String nev, email;

    public log_inser(String nev, String email) {
        this.nev = nev;
        this.email = email;
    }
    
    @Override
    public void insert() {
        try {
            new Insert().log_email_insert(nev, email);
        } catch (Exception ex) {
            new alert().db(ex);
        } 
    }
    
    
}
