/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package privat.alert;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

/**
 *
 * @author Dávid
 */
public class alert {
    public void db(Exception e){
        Alert alert = new Alert(AlertType.WARNING);
        alert.setTitle("Database");
        alert.setHeaderText("Look, a Warning Dialog");
        alert.setContentText(e.getMessage());

        alert.showAndWait();
    }
    public void excel(){
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Excel");
        alert.setHeaderText("Sikeres volt");
        

        alert.showAndWait();
    }
    
}
