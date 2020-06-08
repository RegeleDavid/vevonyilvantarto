/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package privat.vissza_allitas;

import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import privat.InterFace.alapalapot_interface;

/**
 *
 * @author Dávid
 */
public class vissza_allitas_term implements alapalapot_interface{
    
    public void term(DatePicker datum1, TextField targy, TextField megjegyzes) {
            alapallapot(datum1);
            alapallapot(targy);
            alapallapot(megjegyzes);
            
    } 

    @Override
    public void alapallapot(TextField a) {
        a.setText(null);
        a.setStyle(null);
    }

    @Override
    public void alapallapot(TextField a, String szo) {
        
    }

    @Override
    public void alapallapot(DatePicker a) {
        a.setValue(null);
        a.setStyle(null);
    }
    
    
    
}
