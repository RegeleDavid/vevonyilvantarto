/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxtableviewaddrows;

import java.awt.Dimension;
import java.sql.ResultSet;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import privat.sqlite.Insert;
import privat.sqlite.select;

/**
 *
 * @author Cool IT Help
 */
public class JavaFXTableViewAddRows extends Application {
    
    @Override
    public void start(Stage stage) throws Exception { 
        
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        
        Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        double width = screenSize.getWidth();
        double height = screenSize.getHeight()-50;
        Scene scene = new Scene(root/*,(int)width, (int)height*/);
        
        stage.getIcons().add(new Image("file:img/elitnyit.jpg"));
        stage.setTitle("Vevőnyilvántartó");
        
       
        //stage.initStyle(StageStyle.TRANSPARENT);

        //scene.setFill(Color.TRANSPARENT);
        
        scene.getStylesheets().add("CSS/newCascadeStyleSheet.css");       
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
