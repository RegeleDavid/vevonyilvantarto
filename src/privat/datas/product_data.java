/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package privat.datas;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import privat.InterFace.datas;

/**
 *
 * @author Dávid
 */
public class product_data implements datas{
    private final SimpleIntegerProperty id;
    private final SimpleStringProperty nev, termek, datum, mikor_hivjam, targy , megjegyzes; 

    public product_data(int id, String nev, String termek, String datum, String mikor_hivjam, String targy, String megjegyzes) {
        this.id = new SimpleIntegerProperty(id);
        this.nev = new SimpleStringProperty(nev);
        this.termek = new SimpleStringProperty(termek);
        this.datum = new SimpleStringProperty(datum);
        this.mikor_hivjam = new SimpleStringProperty(mikor_hivjam);
        this.targy = new SimpleStringProperty(targy);
        this.megjegyzes=new SimpleStringProperty(megjegyzes);
    }
    
    public Integer getId() {
        return id.get();
    }
    
    public void setId(int id) {
        this.id.set(id);
    }
    public String getNev() {
        return nev.get();
    }
    public void setNev(String firstname) {
        nev.set(firstname);
    }
    
    public String getTermek() {
        return termek.get();
    }
    public void setTermek(String firstname) {
        termek.set(firstname);
    }
    public String getDatum() {
        return datum.get();
    }
    public void setDatum(String firstname) {
        datum.set(firstname);
    }
    public String getMikor_hivjam() {
        return mikor_hivjam.get();
    }
    public void setMikor_hivjam(String firstname) {
        mikor_hivjam.set(firstname);
    }
    public String getTargy() {
        return targy.get();
    }
    public void setTargy(String firstname) {
        targy.set(firstname);
    }
    public String getMegjegyzes() {
        return megjegyzes.get();
    }
    public void setMegjegyzes(String firstname) {
        megjegyzes.set(firstname);
    }        

    @Override
    public Object[] array_data() {
        Object[] t=new Object[7];
        
        return t;
    }
    
    


}
