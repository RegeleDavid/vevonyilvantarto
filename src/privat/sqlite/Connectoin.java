/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package privat.sqlite;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import privat.alert.alert;

/**
 *
 * @author Dávid
 */
class Connectoin {
    public Connection conn;
    
    public Connectoin() throws ClassNotFoundException, SQLException {


        try {
            File f=new File("/SQL");
            f.mkdir();
            Class.forName("org.sqlite.JDBC");
            String url = "jdbc:sqlite:/SQL/vevo_nyilvantarto_1.db";
            conn = DriverManager.getConnection(url);
            System.out.println(":)");
        } catch (Exception e) {
            new alert().db(e);
        }
        
        
    }

    public Connection getConn() {
        return conn;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }
    
}
