/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package privat.insert;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import privat.Empty;
import privat.InterFace.Empty_interface;
import privat.InterFace.db_insert;
import privat.sqlite.*;

/**
 *
 * @author Dávid
 */
public class user_insert extends Empty implements db_insert, Empty_interface{
    private  TextField nev, cim, tars, tragy, telosza, email;
    private  DatePicker elso_talalkozo, szuletesi_ido;
    
    //nev_user_insert.setStyle("-fx-border-color: red ; -fx-border-width: 2px ;");
    
    

    public user_insert(TextField nev, TextField cim, TextField tars, TextField tragy, TextField telosza, TextField email, DatePicker szuletesi_ido, DatePicker elso_talalkozo) {
        this.nev = nev;
        this.cim = cim;
        this.tars = tars;
        this.tragy = tragy;
        this.telosza = telosza;
        this.email = email;
        this.szuletesi_ido = szuletesi_ido;
        this.elso_talalkozo = elso_talalkozo;
        emptyall();
        
    }
    @Override
    public void  emptyall(){
        empty(nev);
        empty(cim);
        empty(tars);
        empty(tragy);
        empty(telosza);
        empty(email);
        empty(szuletesi_ido);
        empty(elso_talalkozo);
    }

    @Override
    public void insert() {
        if(to_be_inser){
            try {
                new Insert().user_inser(nev.getText(),telosza.getText(),email.getText(),tars.getText(),szuletesi_ido.getValue().toString(),cim.getText(),elso_talalkozo.getValue().toString(),tragy.getText());
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
            nev.setText("");
            cim.setText("");
            tars.setText("");
            email.setText("");
            telosza.setText("");
            tragy.setText("");
            szuletesi_ido.setValue(LocalDate.now());
            elso_talalkozo.setValue(LocalDate.now());
           
        }
       
    }  
}
