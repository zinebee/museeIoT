/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package museeiot;

import DB.capteurtemperature.hmiBijoux;
import DB.capteurtemperature.hmicostume;
import DB.capteurtemperature.hmisculpture;
import DB.hmitableau;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.net.Socket;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author zineb
 */
public class humidite extends JPanel implements Runnable{
    hmiBijoux p1;
            hmitableau p2;
               hmisculpture p3;
                hmicostume p4;      
    public humidite(){
      JPanel p11=new JPanel();
      
      p1=new hmiBijoux(Color.red);
       p1.add(new JLabel("Salle des Bijoux"),BorderLayout.WEST);
      
      JPanel p22=new JPanel();
       p2=new hmitableau(Color.GREEN);
       p2.add(new JLabel("Salle des Tableaux"),BorderLayout.WEST);
      JPanel p33=new JPanel();
      p3=new hmisculpture(Color.BLUE);
       p3.add(new JLabel("Salle des sculpture"),BorderLayout.WEST);
      JPanel p44=new JPanel();
      p4=new hmicostume(Color.BLACK);
       p4.add(new JLabel("Salle des Costumes"),BorderLayout.WEST);
      setLayout(new GridLayout(2,2));
      add(p1);
      add(p2);
      add(p3);
      add(p4);
      p1.setBackground(Color.red);
      p2.setBackground(Color.BLACK);
      p3.setBackground(Color.YELLOW);
      p4.setBackground(Color.GREEN);
    
    }
  @Override
 public void run(){
     Thread a1=p1.serveurhum();
     a1.start();
     
     Thread a2=p2.serveurhum();
     a2.start();
     
     Thread a3=p3.serveurhum();
     a3.start();
     Thread a4=p4.serveurhum();
     a4.start();
    
 }
}
