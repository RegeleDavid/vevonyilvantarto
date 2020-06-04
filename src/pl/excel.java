/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl;
import excel.write.write_xlsx;
/**
 *
 * @author Dávid
 */
public class excel {
    public static void main(String[] args) throws Exception {
        write_xlsx w_x=new write_xlsx("asd");
        Object[][] bookData = {
                {"Head First Java", "Kathy Serria", 79},
                {"Effective Java", "Joshua Bloch", 36},
                {"Clean Code", "Robert martin", 42},
                {"Thinking in Java", "Bruce Eckel", 35},
        };
        w_x.ear("a",bookData );
        w_x.ear("b",bookData );
        w_x.write();
    }
}
