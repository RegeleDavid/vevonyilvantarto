/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package privat.insert;

import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import privat.Empty;
import privat.InterFace.Empty_interface;
import privat.InterFace.db_insert;
import privat.alert.alert;
import privat.sqlite.Insert;
import privat.sqlite.select;
import privat.vissza_allitas.vissza_allitas_term;

/**
 *
 * @author Dávid
 */
;public class term_inser extends Empty implements db_insert,Empty_interface{
    DatePicker  add_term_datum, add_term_mikor_hivjam;
    TextField targy;
    Label id;
    TextArea megyjegyzes;
    ArrayList<TextField> input;

    public term_inser(DatePicker add_term_datum, DatePicker add_term_mikor_hivjam, TextField targy, Label id, TextArea megyjegyzes,ArrayList<TextField> input) {
        this.add_term_datum = add_term_datum;
        this.add_term_mikor_hivjam = add_term_mikor_hivjam;
        this.targy = targy;
        this.id = id;
        this.megyjegyzes = megyjegyzes;
        this.input=input;
        emptyall();
    }
    
    
    
    @Override
    public void insert() {
        if(to_be_inser){
            try {
                Insert i=new Insert();
                //System.out.println(Integer.valueOf(id.getText())+"  "+add_term_datum.getValue().toString()+" "+add_term_mikor_hivjam.getValue().toString()+"  "+targy.getText()+"  "+megyjegyzes.getText());
                i.term_insert(Integer.valueOf(id.getText()), add_term_datum.getValue().toString(),add_term_mikor_hivjam.getValue().toString() , targy.getText(), megyjegyzes.getText());
                for (TextField textField : input) {
                    i.term_name_inser(textField.getText());
                }
                

            } catch (Exception e) {
                new alert().db(e);
                System.err.println("asdasdas");
            }
            not_settext();
        }
    }

    @Override
    public void emptyall() {
        empty(add_term_datum);
        empty(add_term_mikor_hivjam);
        empty(targy);
        empty(megyjegyzes);
    }
    
    private  void not_settext(){
        add_term_datum.setValue(LocalDate.now());
        new vissza_allitas_term().term(add_term_mikor_hivjam, targy, targy);
        
    }
    
}
