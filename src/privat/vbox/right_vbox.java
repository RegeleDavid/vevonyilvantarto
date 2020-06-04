/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package privat.vbox;


import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import privat.sqlite.select;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
/**
 *
 * @author Dávid
 */
public class right_vbox {
    VBox term_select_most;
    ResultSet  rs;
    
    public right_vbox(VBox term_select_most) throws ClassNotFoundException, SQLException, Exception {
        this.term_select_most = term_select_most;
        rs=new select().select_term();
    }
    
    public void select() throws SQLException{
        
        while (rs.next()) {  
            Pane b=new Pane();
            VBox c=new VBox();
           
            label_top(c, "Név", rs.getString("nev"));
            label_datum(c, "Dátum", rs.getString("datum"));
            label(c, "Telefon szám", rs.getString("teloszam"));
            label(c, "Tárgy", rs.getString("targy"));
            label(c, "Termék", rs.getString("termek_id"));
            label_bottom(c, "Megjegyzés", rs.getString("megjegyzes"));

            
            b.getChildren().add(c);
            
            String cssLayout = "fx-border-insets: 5;\n" +
                   "-fx-border-width: 3;\n";
            c.setStyle(cssLayout);
            Separator separator2 = new Separator();
            separator2.setOrientation(Orientation.HORIZONTAL);
            c.getChildren().add(separator2);
            term_select_most.getChildren().add(c);
            
        }
    }
    
    void label_top( VBox c, String title, String rs){
        Label a=new Label(title+":"+rs);
        a.setFont(Font.font ("Verdana", 20));
        a.setPadding(new Insets(10,10,0,10));
        c.getChildren().addAll(a);
    }
    void label_bottom( VBox c, String title, String rs){
        Label a=new Label(title+":"+rs);
        a.setFont(Font.font ("Verdana", 20));
        a.setPadding(new Insets(0,10,10,10));
        c.getChildren().addAll(a);
    }
    void label( VBox c, String title, String rs){
        Label a=new Label(title+":"+rs);
        a.setFont(Font.font ("Verdana", 20));
        a.setPadding(new Insets(0,10,0,10));
        c.getChildren().addAll(a);
    }
    void label_datum( VBox c, String title, String rs){
        HBox h=new HBox();
        Label a=new Label(title+":");
        a.setFont(Font.font ("Verdana", 20));
        a.setPadding(new Insets(0,0,0,10));
        h.getChildren().add(a);
        
        a=new Label(rs);
        a.setFont(Font.font ("Verdana", 20));
        a.setPadding(new Insets(0,10,0,0));
        a.setStyle("-fx-text-fill: rgba(188,57,50, 1);");
        h.getChildren().add(a);
        c.getChildren().addAll(h);
    }
    
}
