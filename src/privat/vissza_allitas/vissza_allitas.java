/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package privat.vissza_allitas;

import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafxtableviewaddrows.FXMLDocumentController;
import privat.InterFace.alapalapot_interface;

/**
 *
 * @author Dávid
 */
public class vissza_allitas implements alapalapot_interface {

    
    
    
    public void user_add(TextField nev_user_insert,TextField email_user_insert, TextField cim_user_insert,  TextField tars_user_insert, TextField teloszam_user_insert, DatePicker szuletesi_ido_user_insert, DatePicker elsodatum_user_inserts, TextField targy_user_insert){
        alapallapot(nev_user_insert);
        alapallapot(email_user_insert);
        alapallapot(cim_user_insert);
        alapallapot(tars_user_insert, "Just Nahrin");
        alapallapot(teloszam_user_insert);
        alapallapot(szuletesi_ido_user_insert);
        alapallapot(elsodatum_user_inserts);
        alapallapot(targy_user_insert);
    }
    @Override
    public void alapallapot(TextField a){
//        System.out.println(a.toString());
        a.setStyle(null);
        a.setText(null);
    }
    @Override
    public void alapallapot(TextField a, String szo){
        a.setStyle(null);
        a.setText(szo);
    }
    @Override
    public void alapallapot(DatePicker a){
        a.setStyle(null);
        a.setValue(null);
    }
}
