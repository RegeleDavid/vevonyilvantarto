/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excel;

/**
 *
 * @author Dávid
 */
public class xslx {
    private  String download, file_name, ear;
    private  Object[][] o;

    public xslx(String download, String file_name, String ear, Object[][] o) {
        this.download = download;
        this.file_name = file_name;
        this.ear = ear;
        this.o = o;
    }
    
}
