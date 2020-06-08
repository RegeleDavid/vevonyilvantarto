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
public class log_email implements datas{
    private final SimpleIntegerProperty id;
    private final SimpleStringProperty nev, email, datum;

    public log_email(Integer id, String nev,String email,  String datum) {
        this.id = new SimpleIntegerProperty(id);
        this.nev = new SimpleStringProperty(nev);
        
        this.email = new SimpleStringProperty(email);
        
        this.datum = new SimpleStringProperty(datum);
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
    public String getDatum() {
        return datum.get();
    }
    public void setDatum(String firstname) {
        datum.set(firstname);
    }
    public String getEmail() {
        return email.get();
    }
    public void setEmail(String firstname) {
        email.set(firstname);
    }
    
    @Override
    public Object[] array_data(){
        Object[] t=new Object[9];
        t[0]=this.id.get();
        t[2]=this.datum.get();
        t[1]=this.nev.get();
        t[3]=this.email.get();
        return  t;
    }
}
