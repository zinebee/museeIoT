/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package museeiot;

/**
 *
 * @author zineb
 */
import DB.capteurtemperature.hmiBijoux;
import DB.capteurtemperature.hmicostume;
import DB.capteurtemperature.hmisculpture;
import DB.capteurtemperature.infbihoux;
import DB.capteurtemperature.infcostume;
import DB.capteurtemperature.infsculpture;
import DB.hmitableau;
import DB.inftableau;
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
public class infrarouge extends JPanel implements Runnable{
    infbihoux p11;
            inftableau p21;
               infsculpture p31;
                infcostume p41;      
    public infrarouge(){
      //JPanel p11=new JPanel();
      
      p11=new infbihoux(Color.red);
       p11.add(new JLabel("Salle des Bijoux"),BorderLayout.WEST);
      
     // JPanel p22=new JPanel();
       p21=new inftableau(Color.GREEN);
       p21.add(new JLabel("Salle des Tableaux"),BorderLayout.WEST);
      //JPanel p33=new JPanel();
      p31=new infsculpture(Color.BLUE);
       p31.add(new JLabel("Salle des sculpture"),BorderLayout.WEST);
     // JPanel p44=new JPanel();
      p41=new infcostume(Color.BLACK);
       p41.add(new JLabel("Salle des Costumes"),BorderLayout.WEST);
      setLayout(new GridLayout(2,2));
      add(p11);
      add(p21);
      add(p31);
      add(p41);
      p11.setBackground(Color.red);
      p21.setBackground(Color.BLACK);
      p31.setBackground(Color.YELLOW);
      p41.setBackground(Color.GREEN);
    
    }
  @Override
 public void run(){
     Thread a1=p11.serveurhum();
     a1.start();
     
     Thread a2=p21.serveurhum();
     a2.start();
     
     Thread a3=p31.serveurhum();
     a3.start();
     Thread a4=p41.serveurhum();
     a4.start();
    
 }
}
