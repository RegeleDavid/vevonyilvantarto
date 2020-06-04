/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package privat.mkdir;

import java.io.File;

/**
 *
 * @author Dávid
 */
public class mkdir_folder {
    
    private  String root(String a, String b){
        return System.getProperty(a)+"/"+b;
    }
    
    public String dectopnew_mkdir_new_folder(String new_folder){
        String des=root("user.home","Desktop" )+ "/"+new_folder;
        File f=new File(des);
        f.mkdir();
        System.out.println(des);
        return des;
    }
    public String asztal(){
        String des=root("user.home","Desktop" );
        return des;
    }
    public String root_new_folder(String root, String new_folder){
        String des=root+"/"+new_folder;
        File f=new File(des);
        f.mkdir();
        return des;
        
    }
}
