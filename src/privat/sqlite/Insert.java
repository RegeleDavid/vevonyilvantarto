/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package privat.sqlite;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import javax.swing.JOptionPane;
import privat.alert.alert;

/**
 *
 * @author Dávid
 */
public class Insert extends Connectoin{
    public int key;

    public Insert() throws ClassNotFoundException, SQLException {
        super();
    }
    public void beszuras() throws SQLException{
        Statement stmt  = conn.createStatement();
        stmt.executeUpdate("INSERT INTO people (id,first_name,last_name) VALUES(NULL,'éáűőúöüóé','Smith');");
        //id();
    }
    
   int id( String name) {
        try {
           String query = "SELECT last_insert_rowid() AS LAST FROM `"+name+"`";
            PreparedStatement pst1 = conn.prepareStatement(query);
            ResultSet  rs1 = pst1.executeQuery();
            while (rs1.next()) {           
                return  rs1.getInt(1);

           }
            pst1.execute();
       } catch (Exception e) {
            System.err.println("íasdasdas");
       }
        return -1; 
    }
    public void letoltes_inser(String letoltes){
        //
        try {
             //Statement stmt  = conn.createStatement();
             //INSERT INTO `szemelyes_adatok` (`id`, `szponzor`, `nev`, `teloszam`, `email`, `tars`, `szuletes_ido`, `cim`, `elso_tallkozas_datuma`, `targy`) VALUES (NULL, '0', ?, ?,?, ?, ?,?,  '2020-05-05'  , ?)
            PreparedStatement stmt=conn.prepareStatement("INSERT INTO `conf` (`neve`, `szoveg`) VALUES (?, ?)");
            stmt.setString(1, "letoltes");
            stmt.setString(2, letoltes);
           
            stmt.executeUpdate();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            new alert().db(e);
        }
       
    }
    public void user_inser(String nev, String teloszom, String email,String tars, String szuletes_ido, String cim, String elso_tallkozas_datuma, String targy){
        //
        try {
             //Statement stmt  = conn.createStatement();
             //INSERT INTO `szemelyes_adatok` (`id`, `szponzor`, `nev`, `teloszam`, `email`, `tars`, `szuletes_ido`, `cim`, `elso_tallkozas_datuma`, `targy`) VALUES (NULL, '0', ?, ?,?, ?, ?,?,  '2020-05-05'  , ?)
            PreparedStatement stmt=conn.prepareStatement("INSERT INTO szemelyes_adatok ( id, `szponzor`, `nev`, `teloszam`, `email`, `tars`, `szuletes_ido`, `cim`, `elso_tallkozas_datuma`, `targy`) VALUES ( NULL ,'0', ?, ?,?, ?, ?,?,  ?  , ?)");
            stmt.setString(1, nev);
            stmt.setString(2, teloszom);
            stmt.setString(3, email);
            stmt.setString(4, tars);
            stmt.setString(5, szuletes_ido);
            stmt.setString(6, cim);
            stmt.setString(7, elso_tallkozas_datuma);
            stmt.setString(8, targy);
            stmt.executeUpdate();
           
            System.out.println("sqlite");
        } catch (Exception e) {
            System.err.println(e.getMessage());
            new alert().db(e);
        }
       
    }
    
    public void user_update(int id,String nev, String teloszom, String email,String tars, String szuletes_ido, String cim, String elso_tallkozas_datuma, String targy){
        try {
             //Statement stmt  = conn.createStatement();
             //INSERT INTO `szemelyes_adatok` (`id`, `szponzor`, `nev`, `teloszam`, `email`, `tars`, `szuletes_ido`, `cim`, `elso_tallkozas_datuma`, `targy`) VALUES (NULL, '0', ?, ?,?, ?, ?,?,  '2020-05-05'  , ?)
            PreparedStatement stmt=conn.prepareStatement("UPDATE szemelyes_adatok SET nev=?, teloszam=?, email=?, tars=?, szuletes_ido=?, cim=?, elso_tallkozas_datuma=?, targy=? WHERE id=?");
            stmt.setString(1, nev);
            stmt.setString(2, teloszom);
            stmt.setString(3, email);
            stmt.setString(4, tars);
            stmt.setString(5, szuletes_ido);
            stmt.setString(6, cim);
            stmt.setString(7, elso_tallkozas_datuma);
            stmt.setString(8, targy);            
            stmt.setInt(9, id);

            stmt.executeUpdate();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            new alert().db(e);
        }

    }
    public void term_insert(int id,String add_term_datum,  String add_term_mikor_hivjam, String targy, String megyjegyzes){
        try {
            
             //Statement stmt  = conn.createStatement();
             //INSERT INTO `szemelyes_adatok` (`id`, `szponzor`, `nev`, `teloszam`, `email`, `tars`, `szuletes_ido`, `cim`, `elso_tallkozas_datuma`, `targy`) VALUES (NULL, '0', ?, ?,?, ?, ?,?,  '2020-05-05'  , ?)
            PreparedStatement stmt=conn.prepareStatement("INSERT INTO `termekek_adatai` (`id`, `user_id`, `datum`, `kovetkezo_hivas`, `targy`, `megyjegyzes`) VALUES (NULL, ?, ?, ?, ?, ?)");
            stmt.setInt(1, id);
            stmt.setString(2,  add_term_datum);
            stmt.setString(3, add_term_mikor_hivjam);
            stmt.setString(4, targy);
            stmt.setString(5, megyjegyzes);
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            if ( rs.next() ) {
                // Retrieve the auto generated key(s).
                key = rs.getInt(1);
                System.out.println(key);
            }
            //id("termekek_adatai");
        } catch (Exception e) {
            System.err.println(e.getMessage());
            new alert().db(e);
        }

    }
    
    public void  term_name_inser(String nev ){
         try {
             //Statement stmt  = conn.createStatement();
             //INSERT INTO `szemelyes_adatok` (`id`, `szponzor`, `nev`, `teloszam`, `email`, `tars`, `szuletes_ido`, `cim`, `elso_tallkozas_datuma`, `targy`) VALUES (NULL, '0', ?, ?,?, ?, ?,?,  '2020-05-05'  , ?)
            PreparedStatement stmt=conn.prepareStatement("INSERT INTO `termek_neve` (`id`, `termek_id`, `nev`) VALUES (0, ?, ?)");
            stmt.setString(2, nev);
                        
            stmt.setInt(1, key);

            stmt.executeUpdate();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            new alert().db(e);
        }
    }
    
    public void log_email_insert(String nev, String email){
        try {
            PreparedStatement stmt=conn.prepareStatement("INSERT INTO `log_email` (`id`, `datetime`, `nev`, `Email`) VALUES (null,datetime('now'), ?, ?)");
            stmt.setString(1, nev);
            stmt.setString(2, email);            
            stmt.executeUpdate();
        } catch (Exception e) {
            new alert().db(e);
        }
    }
}
