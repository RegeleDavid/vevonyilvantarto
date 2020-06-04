package privat.table.builder;

import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import privat.alert.alert;
import privat.datas.product_data;
import privat.sqlite.select;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dávid
 */
public class produst_bulider extends select{

    public produst_bulider() throws ClassNotFoundException, SQLException {
        super();
    }
    
    
    public ObservableList<product_data> table(){
        ObservableList<product_data> dataList_tem=FXCollections.observableArrayList();
        try {
            ResultSet rs=select_term_tabla();
            while (rs.next()) {                
                dataList_tem.add(new product_data(rs.getInt("id"), rs.getString("nev"), rs.getString("termek_id"), rs.getString("datum"), rs.getString("mikor_hivjam"), rs.getString("targy"), rs.getString("megjegyzes")));
                System.out.println(rs.getString("nev"));
            }
            rs.close();
        } catch (Exception e) {
            new alert().db(e);
        }
        
        return  dataList_tem;
    }
}
