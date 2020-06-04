/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mail.pl;

import java.awt.Desktop;
import static java.awt.SystemColor.desktop;
import java.io.IOException;
import java.net.URI;

/**
 *
 * @author Dávid
 */
public class run {
    public static void main(String[] args) throws IOException {
        Desktop desktop = Desktop.getDesktop(); 
        String message = "mailto:regele.david@gmail.com?subject=asdasdasdas&body=seeAttachment"; 
        URI uri = URI.create(message); 
        desktop.mail(uri);
    }
}
