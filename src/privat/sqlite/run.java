/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package privat.sqlite;

import java.sql.ResultSet;

/**
 *
 * @author Dávid
 */
public class run {
    public static void main(String[] args) {
        try {
            Insert i=new Insert();
            i.user_inser("nev", "teloszom", "email", "tars", "2002-01-01", "cim", "2020-01-01", "targy");
            select s=new select();
            ResultSet rs=s.select_user();
            while (rs.next()) { 
                for (int j = 1; j <= 10; j++) {
                    System.out.print(rs.getString(j)+"");
                }
    
                    
               
                System.out.println("");
            }
            System.out.println("aSDASD");        
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
