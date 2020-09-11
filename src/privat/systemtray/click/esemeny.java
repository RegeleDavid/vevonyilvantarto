/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package click;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author David
 */
public class esemeny implements ActionListener{
    String szo="alma";

    public esemeny() {
    }

    public esemeny(String szo) {
        this.szo = szo;
    }
    
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        System.out.println("siker siker "+szo);
    }
    
}
