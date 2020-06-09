/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package privat.insert;

import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import privat.InterFace.db_insert;
import privat.Empty;
import privat.InterFace.Empty_interface;
import privat.sqlite.Insert;
/**
 *
 * @author Dávid
 */
public class user_update extends Empty implements db_insert,Empty_interface{
    
    private  TextField nev, cim, tars, tragy, telosza, email, id;
    private  DatePicker elso_talalkozo, szuletesi_ido;

    public user_update(TextField nev, TextField cim, TextField tars, TextField tragy, TextField telosza, TextField email, TextField id, DatePicker elso_talalkozo, DatePicker szuletesi_ido) {
        this.nev = nev;
        this.cim = cim;
        this.tars = tars;
        this.tragy = tragy;
        this.telosza = telosza;
        this.email = email;
        this.id = id;
        this.elso_talalkozo = elso_talalkozo;
        this.szuletesi_ido = szuletesi_ido;
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

    public boolean  getTo_be_install(){
        return this.to_be_inser;
    }

    @Override
    public void insert() {
       if(to_be_inser){
            try {
                //System.out.println("nev:"+this.nev.getText() +" cim:"+this.cim.getText() +" tras:"+this.tars.getText()+" targy"+this.tragy.getText()+" targy:"+this.telosza.getText()+" email:"+this.email.getText()+" id_"+this.id.getText()+" elso:"+this.elso_talalkozo.getValue().toString()+" sz:"+this.szuletesi_ido.getValue().toString());
                new Insert().user_update(Integer.valueOf(id.getText()),nev.getText(),telosza.getText(),email.getText(),tars.getText(),szuletesi_ido.getValue().toString(),cim.getText(),elso_talalkozo.getValue().toString(),tragy.getText());
            } catch (Exception e) {
                System.err.println(e.getMessage()+" ASDASDAS");
            }
        }
    }
    
}
