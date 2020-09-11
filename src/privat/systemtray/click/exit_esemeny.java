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
 * @author Dávid
 */
public class exit_esemeny implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
        System.exit(0);
    }
    
}
