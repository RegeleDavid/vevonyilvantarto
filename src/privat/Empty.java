/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package privat;

import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 *
 * @author Dávid
 */
public class Empty {
    protected  boolean  to_be_inser=true;
    
    public void empty(TextField e){
        if(e.getText().isEmpty()){
            e.setStyle("-fx-border-color: red ; -fx-border-width: 2px ;");
            to_be_inser = false;
        }
    }
    public void empty(TextArea e){
        if(e.getText().isEmpty()){
            e.setStyle("-fx-border-color: red ; -fx-border-width: 2px ;");
            to_be_inser = false;
        }
    }
    public void empty(DatePicker e){
        if(e.getValue()==null){
            e.setStyle("-fx-border-color: red ; -fx-border-width: 2px ;");
            to_be_inser = false;
        }
    }
}
