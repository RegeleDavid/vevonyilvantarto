/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package privat.systemtray.tray;

import java.awt.Menu;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import privat.systemtray.click.kiir_esemeny;

/**
 *
 * @author David
 */
public class MySystemTray {
    private PopupMenu popup;
    private MenuItem displayMenu;
    private Menu menu;


    public MySystemTray(PopupMenu popup) {
        this.popup = popup;
    }
    
    public void addmenu(String nev){
        menu = new Menu(nev);
        popup.add(menu);
    }
    public void additem(String nev, ActionListener e, boolean  v){
        displayMenu  = new MenuItem(nev);
        if (v) {
            menu.add(displayMenu);
        } else {
            popup.add(displayMenu);
        }
        
        displayMenu.addActionListener(e);
    }
    public void additemrs(ResultSet  rs, boolean  v) throws SQLException{
         while (rs.next()){
             additem(rs.getString("nev"), new kiir_esemeny(rs.getString("nev"),rs.getString("teloszam"),rs.getString("datum"),rs.getString("targy"), rs.getString("termek_id"),rs.getString("megjegyzes")), v);
         }
    }
    
    
}
