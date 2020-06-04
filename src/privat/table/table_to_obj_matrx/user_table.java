/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package privat.table.table_to_obj_matrx;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import privat.datas.user_data;

/**
 *
 * @author Dávid
 */
public class user_table {
    TableView<user_data> table;

    public user_table(TableView<user_data> table) {
        this.table = table;
    }
   
    
    public  Object[][] sout_matrx(){
        int h=0;
        for ( user_data u: table.getItems()) {
            h++;
            
        }
        Object[][] t=new Object[h+1][9];
        Object[] a={"Id", "Név","Telefon szám", "E-mail", "Társ", "születési idő", "Cím", "Első találkozás idelyes", "Tárgy"};
        h=0;
        t[h++]=a;
        for ( user_data u: table.getItems()) {
           
            a=u.array_data();
            t[h++]=a;
            
        }
        return t;
    }
    
    
}
