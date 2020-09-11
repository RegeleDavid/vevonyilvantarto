/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package privat.systemtray.tray;


import click.esemeny;
import click.exit_esemeny;
import java.awt.Image;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import privat.alert.alert;
import privat.sqlite.select;

/**
 *
 * @author Dávid
 */
public class tray_builder {
    private  static  ResultSet  rs;
     public static Image getImage(String path) {
        ImageIcon icon = new ImageIcon(path, "omt");
        return icon.getImage();
    }
     public static void TrayBuild() throws SQLException{
         try {
             rs=new select().select_term();
         } catch (Exception e) {
             new alert().db(e);
         }
         if (SystemTray.isSupported()) {

            final SystemTray systemTray = SystemTray.getSystemTray();
            final TrayIcon trayIcon = new TrayIcon(getImage("img\\elitnyit.jpg"), "omt is running");
            trayIcon.setImageAutoSize(true);
            
            PopupMenu popup = new PopupMenu();
            MySystemTray mst=new MySystemTray(popup);
//            mst.additem("siker", new esemeny("koert"), false);
//            mst.addmenu("a");
//            mst.additem("a.1", new esemeny(), true);
            
            mst.addmenu("nevek");
            mst.additemrs(rs, true);
            mst.additem("exit", new exit_esemeny(), false);
            trayIcon.setPopupMenu(popup);

 
            try {
                systemTray.add(trayIcon);
            } catch (Exception e) {
                e.printStackTrace();
            }
 
        }
     }

    
}
