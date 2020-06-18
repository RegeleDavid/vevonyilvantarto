/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package privat.sqlite;

import privat.sqlite.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import privat.sqlite.Connectoin;
/**
 *
 * @author Dávid
 */
public class colum_string extends Connectoin{
    
    private String table_name;
    
    public colum_string() throws ClassNotFoundException, SQLException {
    }

    public colum_string(String table_name) throws ClassNotFoundException, SQLException {
        this.table_name = table_name;
    }
    private ArrayList<String> array_colum() throws Exception{
        ArrayList<String> t=new ArrayList<>();
        Statement stmt  = conn.createStatement();
        ResultSet rs    = stmt.executeQuery("pragma table_info('"+this.table_name+"')");
        while (rs.next()) {                
            t.add(rs.getString(2));
        }
        return  t;
    }
    public boolean van_e(String colum) throws Exception{
        boolean v=true;
        ArrayList<String> t=this.array_colum();
        for (String string : t) {
            if(colum.equals(string)){
                v=false;
            }
        }
        return  v;
    }
}
