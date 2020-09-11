/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package privat.systemtray.click;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;
import javax.swing.JOptionPane;

/**
 *
 * @author Dávid
 */
public class kiir_esemeny implements ActionListener{
    private  String nev, telo, datum, targy, termek, megjegyzes;

    public kiir_esemeny(String nev, String telo, String datum, String targy, String termek, String megjegyzes) {
        this.nev = nev;
        this.telo = telo;
        this.datum = datum;
        this.targy = targy;
        this.termek = termek;
        this.megjegyzes = megjegyzes;
    }

    

    @Override
    public void actionPerformed(ActionEvent e) {
//        try {
//            Process process = Runtime.getRuntime().exec("notepad.exe");
//        } catch (IOException ex) {
//            Logger.getLogger(kiir_esemeny.class.getName()).log(Level.SEVERE, null, ex);
//        }
        JOptionPane.showMessageDialog(null, kiir());
    }
    private  String kiir(){
        return  "Név:"+nev+" Telefonszam:"+telo+" Dátum:"+datum+" Tárgy:"+targy+" termek(ek):"+termek+" Megjegyzés:"+megjegyzes;
    }
}
