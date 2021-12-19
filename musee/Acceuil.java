/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package museeiot;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author zineb
 */
public class Acceuil extends JFrame implements ActionListener{
    JButton a;
    JButton b;
    public Acceuil(){
      setTitle("Acceuil");
      setVisible(true);
      a=new JButton("Directeur");
      b=new JButton("Responsable");
      a.addActionListener(this);
      b.addActionListener(this);
      setDefaultCloseOperation(3);
      setLocationRelativeTo(null);
      setResizable(false);
      JPanel f=new JPanel();
      f.setLayout(new GridLayout(1,2));
      f.add(a);
      f.add(b);
      add(f);
      pack();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
         if(ae.getSource()==a){
           this.setVisible(false);
          login f=new login();
         }if(ae.getSource()==b){
             this.setVisible(false);
          direclogin f=new direclogin();
          
         }
         }
    
}
