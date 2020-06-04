/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package privat.sqlite;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import privat.sqlite.connectoin;

/**
 *
 * @author Dávid
 */
public class select extends connectoin{

    public select() throws ClassNotFoundException, SQLException {
        super();
    }
    public String valasz() throws SQLException{
        String s="";
        Statement stmt  = conn.createStatement();
        ResultSet rs    = stmt.executeQuery(" SELECT * FROM people ;");
        while (rs.next()) {
            s+=rs.getInt("id")+" "+rs.getString("first_name")+"|";
        }
        return s;
    }
    
    public ResultSet  select_user() throws  Exception{
        Statement stmt  = conn.createStatement();
        ResultSet rs    = stmt.executeQuery(" SELECT * FROM szemelyes_adatok ;");
        return rs; 
    }
    public ResultSet  select_term_name() throws  Exception{
        Statement stmt  = conn.createStatement();
        ResultSet rs    = stmt.executeQuery(" SELECT * FROM termek_neve ;");
        return rs; 
    }
    public ResultSet  select_term() throws  Exception{
        Statement stmt  = conn.createStatement();
        ResultSet rs    = stmt.executeQuery("SELECT szemelyes_adatok.teloszam AS teloszam ,  szemelyes_adatok.nev as nev, termekek_adatai.kovetkezo_hivas as datum, termek_neve.nev as termek_id, termekek_adatai.megyjegyzes as megjegyzes, termekek_adatai.targy AS targy FROM `termekek_adatai` INNER JOIN szemelyes_adatok ON termekek_adatai.user_id=szemelyes_adatok.id left JOIN termek_neve ON termek_neve.termek_id=termekek_adatai.id where strftime('%d', termekek_adatai.kovetkezo_hivas)= strftime('%d',date('now')) and strftime('%Y', termekek_adatai.kovetkezo_hivas)= strftime('%Y',date('now')) and strftime('%m', termekek_adatai.kovetkezo_hivas)= strftime('%m',date('now'))");
        return rs; 
    }
    public ResultSet  select_term_tabla() throws  Exception{
        Statement stmt  = conn.createStatement();
        ResultSet rs    = stmt.executeQuery("SELECT szemelyes_adatok.nev as nev, termekek_adatai.datum as datum, termek_neve.nev as termek_id, termekek_adatai.megyjegyzes as megjegyzes , termekek_adatai.targy AS targy , termekek_adatai.id as id, termekek_adatai.kovetkezo_hivas as mikor_hivjam FROM `termekek_adatai` INNER JOIN szemelyes_adatok ON termekek_adatai.user_id=szemelyes_adatok.id left JOIN termek_neve ON termek_neve.termek_id=termekek_adatai.id WHERE termek_neve.termek_id is not null");
        return rs; 
    }
    
    
    public ResultSet  letoltes() throws  Exception{
        Statement stmt  = conn.createStatement();
        ResultSet rs    = stmt.executeQuery("SELECT * FROM conf where neve='letoltes'");
        return rs; 
    }
}
