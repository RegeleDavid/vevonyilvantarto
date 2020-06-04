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
public class user_data implements datas{
    private final SimpleIntegerProperty id;
    private final SimpleStringProperty nev, teledoszam, email, tars, szuletesi_ido, cim, elso_talalkozo, targy;

    public user_data(Integer id, String nev, String teledoszam, String email, String tars, String szuletesi_ido, String cim, String elso_talalkozo, String targy) {
        this.id = new SimpleIntegerProperty(id);
        this.nev = new SimpleStringProperty(nev);
        this.teledoszam = new SimpleStringProperty(teledoszam);
        this.email = new SimpleStringProperty(email);
        this.tars = new SimpleStringProperty(tars);
        this.szuletesi_ido = new SimpleStringProperty(szuletesi_ido);
        this.cim = new SimpleStringProperty(cim);
        this.elso_talalkozo = new SimpleStringProperty(elso_talalkozo);
        this.targy = new SimpleStringProperty(targy);
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
    public String getTeloszam() {
        return teledoszam.get();
    }
    public void setTeloszam(String firstname) {
        teledoszam.set(firstname);
    }
    public String getEmail() {
        return email.get();
    }
    public void setEmail(String firstname) {
        email.set(firstname);
    }
    public String getTars() {
        return tars.get();
    }
    public void setTars(String firstname) {
        tars.set(firstname);
    }
    public String getSzuletesi_ido() {
        return szuletesi_ido.get();
    }
    public void setSzuletesi_ido(String firstname) {
        szuletesi_ido.set(firstname);
    }
    public String getCim() {
        return cim.get();
    }
    public void setCim(String firstname) {
        cim.set(firstname);
    }
    public String getElso_talalkozo() {
        return elso_talalkozo.get();
    }
    public void setElso_talalkozo(String firstname) {
        elso_talalkozo.set(firstname);
    }
    public String getTargy() {
        return targy.get();
    }
    public void setTargy(String firstname) {
        targy.set(firstname);
    }
    @Override
    public Object[] array_data(){
        Object[] t=new Object[9];
        t[0]=this.id.get();
        t[1]=this.nev.get();
        t[2]=this.teledoszam.get();
        t[3]=this.email.get();
        t[4]=this.tars.get();
        t[5]=this.szuletesi_ido.get();
        t[6]=this.cim.get();
        t[7]=this.elso_talalkozo.get() ;
        t[8]=this.targy.get();
        return  t;
    }
}
