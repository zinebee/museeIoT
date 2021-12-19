/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package museeiot;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 * @author zineb
 */
public class ecouteur implements ActionListener{
    JButton u;
    public ecouteur(JButton u){
        this.u=u;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
       if(ae.getActionCommand().equals("inserer")){
         System.out.println("vous appuyez sur le bouton inserer du formualire");
       }
    
    }
    
}
