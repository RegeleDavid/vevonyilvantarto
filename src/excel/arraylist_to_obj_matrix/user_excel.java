/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excel.arraylist_to_obj_matrix;

import java.util.ArrayList;
import javafx.collections.ObservableList;
import privat.datas.user_data;

/**
 *
 * @author Dávid
 */
public class user_excel {
    ObservableList<user_data> list;
    int hossz;
    public user_excel(ObservableList<user_data> list) {
        this.list = list;
        hossz=list.size();
        
    }
    public Object[][] user_obj(){
        Object[][] t=new Object[hossz+1][9];
        Object[] a={"Id", "Név","Telefon szám", "E-mail", "Társ", "születési idő", "Cím", "Első találkozás idelyes", "Tárgy"};
        int i=0;
        t[i++]=a;
        for (user_data li : list) {
            t[i++]=li.array_data();
        }
        return  t;
    }
}
