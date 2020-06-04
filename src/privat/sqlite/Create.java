/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package privat.sqlite;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import privat.alert.alert;

/**
 *
 * @author Dávid
 */
public class Create extends connectoin{

    public Create() throws ClassNotFoundException, SQLException {
        super();
    }
    public void teremt() throws SQLException{
        try {
            Statement stmt  = conn.createStatement();
            stmt.executeUpdate(" CREATE TABLE people (\n" +
                                    "   id INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                                    "   first_name text NOT NULL,\n" +
                                    "   last_name text NOT NULL\n" +
                                    ");");
        } catch (Exception e) {
            
        }
        
        sql_create("CREATE TABLE szemelyes_adatok  ( `id` INTEGER PRIMARY KEY AUTOINCREMENT , `szponzor` INT(100) NOT NULL , `nev` VARCHAR(255) NOT NULL , `teloszam` VARCHAR(255) NOT NULL , `email` VARCHAR(255) NOT NULL , `tars` VARCHAR(255) NOT NULL , `szuletes_ido` VARCHAR(255) NOT NULL , `cim` VARCHAR(255) NOT NULL , `elso_tallkozas_datuma` DATE NOT NULL ,`targy` VARCHAR(255) NOT NULL)", false);
        sql_create("CREATE TABLE termekek_adatai ( `id` INTEGER PRIMARY KEY AUTOINCREMENT , `user_id` INT(100) NOT NULL , `datum` DATE NOT NULL , `kovetkezo_hivas` DATE NOT NULL ,`targy` VARCHAR(255) NOT NULL , `megyjegyzes` VARCHAR(500) NOT NULL ) ",false);
        sql_create("CREATE TABLE termek_neve ( `id` INT NULL , `termek_id` INT(100) NOT NULL , `nev` VARCHAR(100) NOT NULL )", false);
        sql_create("CREATE TABLE conf ( `neve` VARCHAR(500) NOT NULL , `szoveg` VARCHAR(500) NOT NULL )", false);
    }
    
    
    void sql_create( String sql, boolean v ){
        try {
            Statement stmt  = conn.createStatement();
            stmt.executeUpdate(sql);
            stmt.close();
        } catch (Exception e) {
            if(v){
                System.err.println(e.getMessage());
                new alert().db(e);
            }
        }
    }
}
