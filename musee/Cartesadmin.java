/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package museeiot;
import DB.CRUD_BIJOUX;
import DB.CRUD_COSTUME;
import DB.CRUD_SCULPTURE;
import DB.CRUD_TABLEAU;
import DB.capteurtemperature.hmiBijoux;
import DB.information;
import DB.receptiontableau;
import DB.servbihoux;
import DB.servcostume;
import DB.servsculpture;
import DB.servtableau;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import static museeiot.Tableau.bb;

/**
 *
 * @author zineb
 */
public class Cartesadmin extends JFrame implements ActionListener,WindowListener{
    JButton bijoux = new JButton("Bijoux");
 JButton costume = new JButton("Costume");
 JButton sculpture = new JButton("Sculpture");
 JButton tableau = new JButton("Tableau");
 JButton Directeurs=new JButton("Directeurs");
 JButton humidite=new JButton("humidite");
 JButton infrarouge=new JButton("infrarouge");
 CardLayout gestionnaireDesCartes = new CardLayout();
 JPanel jeuCartes = new JPanel();
humidite h1;
infrarouge infra1;
 public Cartesadmin() throws SQLException {
 JPanel p = new JPanel();
 this.addWindowListener(this);
 //JTextArea zone = new JTextArea("Vous pouvez ecrie ici.");
 //JLabel message = new JLabel("Bonjour", SwingConstants.CENTER);
 VoirCercle voirCercle = new VoirCercle();
Tableau j1=new Tableau();
//code tableau
 int delay = 1000; //milliseconds
        ActionListener taskPerformer;
     taskPerformer = (ActionEvent evt) -> {
         
           
        try {
               
           CRUD_TABLEAU hh=new CRUD_TABLEAU();
          
           if(hh.getlignes()!=0){
          
           try {
              
            Socket socket = new Socket("127.0.0.1", 3000);
            ObjectInputStream oin = new ObjectInputStream(socket.getInputStream());
            information product = (information) oin.readObject();
            System.out.println(product);
            String[] ress=product.gettit();
           
            int fg=hh.getlastline();
          
            if(j1.tablee.getRowCount()>=1 || fg!=0){
         
           if(j1.bb<j1.tablee.getRowCount()){
               System.out.println("La taille du tableau est  "+j1.tablee.getRowCount());
              j1.tablee.setValueAt(ress[j1.bb], j1.bb, 3);
           }
             
            
            
            }
            
            if(j1.bb==hh.getlignes()){
              System.out.print("le tableau est empty");
            }
         
           //System.out.println(b); 
          
           
        } catch (IOException ex) {
           // Logger.getLogger(receptiontableau.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            //Logger.getLogger(receptiontableau.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("ssssss");
        }
        
           
           j1.bb++;
           int sir=hh.getlignes();
               if(j1.bb>=sir && sir!=0){
                   
                   j1.bb=0;
                  
               }
           }
           
           } catch (SQLException ex) {
               //Logger.getLogger(Tableaud.class.getName()).log(Level.SEVERE, null, ex);
           }
           //System.out.println(b);
            
        };
       Timer  t = new Timer(delay, taskPerformer);
      
       CRUD_TABLEAU hhA=new CRUD_TABLEAU();
       
      
          if(hhA.getlignes()!=0 || hhA.getlastline()!=0){
              System.out.println("wxc  :"+hhA.getlignes());
               t.start();
             
          }
//code tableau
Bijoux j2=new Bijoux();
//code bijoux
int delay1 = 1000; //milliseconds
        ActionListener taskPerformer1;
     taskPerformer1 = (ActionEvent evt) -> {
         
           
        try {
               
           CRUD_BIJOUX hhb=new CRUD_BIJOUX();
          
           if(hhb.getlignes()!=0){
          
           try {
              
            Socket socket = new Socket("127.0.0.1", 4000);
            ObjectInputStream oin = new ObjectInputStream(socket.getInputStream());
            information product = (information) oin.readObject();
            System.out.println(product);
            String[] ress=product.gettit();
           
            int fg=hhb.getlastline();
          
            if(j2.tableb.getRowCount()>=1 || fg!=0){
         
           if(j2.bi<j2.tableb.getRowCount()){
               System.out.println("La taille du tableau est  "+j2.tableb.getRowCount());
              j2.tableb.setValueAt(ress[j2.bi], j2.bi, 3);
           }
             
            
            
            }
            
            if(j2.bi==hhb.getlignes()){
              System.out.print("le tableau est empty");
            }
         
           //System.out.println(b); 
          
           
        } catch (IOException ex) {
           // Logger.getLogger(receptiontableau.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            //Logger.getLogger(receptiontableau.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("ssssss");
        }
        
           
           j2.bi++;
           int sir=hhb.getlignes();
               if(j2.bi>=sir && sir!=0){
                   
                   j2.bi=0;
                  
               }
           }
           
           } catch (SQLException ex) {
               //Logger.getLogger(Tableaud.class.getName()).log(Level.SEVERE, null, ex);
           }
           //System.out.println(b);
            
        };
       Timer  t1 = new Timer(delay1, taskPerformer1);
      
       CRUD_BIJOUX hhAb=new CRUD_BIJOUX();
       
      
          if(hhAb.getlignes()!=0 || hhAb.getlastline()!=0){
              System.out.println("wxc  :"+hhA.getlignes());
               t1.start();
             
          }
//code bijoux
        
        Sculpture j3=new Sculpture();
        //code sculpture
        int delay2 = 1000; //milliseconds
        ActionListener taskPerformer2;
     taskPerformer2 = (ActionEvent evt) -> {
         
           
        try {
               
           CRUD_SCULPTURE hhs=new CRUD_SCULPTURE();
          
           if(hhs.getlignes()!=0){
          
           try {
              
            Socket socket = new Socket("127.0.0.1", 5000);
            ObjectInputStream oin = new ObjectInputStream(socket.getInputStream());
            information product = (information) oin.readObject();
            System.out.println(product);
            String[] ress=product.gettit();
           
            int fg=hhs.getlastline();
          
            if(j3.tables.getRowCount()>=1 || fg!=0){
         
           if(j3.bs<j3.tables.getRowCount()){
               System.out.println("La taille du tableau est  "+j3.tables.getRowCount());
              j3.tables.setValueAt(ress[j3.bs], j3.bs, 3);
           }
             
            
            
            }
            
            if(j3.bs==hhs.getlignes()){
              System.out.print("le tableau est empty");
            }
         
           //System.out.println(b); 
          
           
        } catch (IOException ex) {
            //Logger.getLogger(receptiontableau.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            //Logger.getLogger(receptiontableau.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("ssssss");
        }
        
           
           j3.bs++;
           int sir=hhs.getlignes();
               if(j3.bs>=sir && sir!=0){
                   
                   j3.bs=0;
                  
               }
           }
           
           } catch (SQLException ex) {
               //Logger.getLogger(Tableaud.class.getName()).log(Level.SEVERE, null, ex);
           }
           //System.out.println(b);
            
        };
       Timer  t2 = new Timer(delay2, taskPerformer2);
      
       CRUD_SCULPTURE hhAs=new CRUD_SCULPTURE();
       
      
          if(hhAs.getlignes()!=0 || hhAs.getlastline()!=0){
              System.out.println("wxc  :"+hhAs.getlignes());
               t2.start();
             
          }
        //code sculpture
        Costume j4=new Costume();
        //code costume
         int delay4 = 1000; //milliseconds
        ActionListener taskPerformer4;
     taskPerformer4 = (ActionEvent evt) -> {
         
           
        try {
               
           CRUD_COSTUME hhc=new CRUD_COSTUME();
          
           if(hhc.getlignes()!=0){
          
           try {
              
            Socket socket = new Socket("127.0.0.1", 6000);
            ObjectInputStream oin = new ObjectInputStream(socket.getInputStream());
            information product = (information) oin.readObject();
            System.out.println(product);
            String[] ress=product.gettit();
           
            int fg=hhc.getlastline();
          
            if(j4.tablec.getRowCount()>=1 || fg!=0){
         
           if(j4.bc<j3.tables.getRowCount()){
               System.out.println("La taille du tableau est  "+j4.tablec.getRowCount());
              j4.tablec.setValueAt(ress[j4.bc], j4.bc, 3);
           }
             
            
            
            }
            
            if(j4.bc==hhc.getlignes()){
              System.out.print("le tableau est empty");
            }
         
           //System.out.println(b); 
          
           
        } catch (IOException ex) {
           // Logger.getLogger(receptiontableau.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            //Logger.getLogger(receptiontableau.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("ssssss");
        }
        
           
           j4.bc++;
           int sir=hhc.getlignes();
               if(j4.bc>=sir && sir!=0){
                   
                   j4.bc=0;
                  
               }
           }
           
           } catch (SQLException ex) {
              // Logger.getLogger(Tableaud.class.getName()).log(Level.SEVERE, null, ex);
           }
           //System.out.println(b);
            
        };
       Timer  t4 = new Timer(delay4, taskPerformer4);
      
       CRUD_COSTUME hhAc=new CRUD_COSTUME();
       
      
          if(hhAc.getlignes()!=0 || hhAc.getlastline()!=0){
              System.out.println("wxc  :"+hhAc.getlignes());
               t4.start();
             
          }
        //code costume
        //code humidite
        int delay5 = 1000; //milliseconds
        ActionListener taskPerformer5;
        taskPerformer5 = (ActionEvent evt) ->{
             Thread a11=new Thread(h1.p1);
     a11.start();
     Thread a22=new Thread(h1.p2);
     a22.start();
    Thread a33=new Thread(h1.p3);
     a33.start(); 
     Thread a44=new Thread(h1.p4);
     a44.start();
        };
        Timer t5 = new Timer(delay5, taskPerformer5);
        t5.start();
        //code humidite
        //code infrarouge
        int delay6 = 1000; //milliseconds
        ActionListener taskPerformer6;
        taskPerformer6 = (ActionEvent evt) ->{
             Thread a11=new Thread(infra1.p11);
     a11.start();
     Thread a22=new Thread(infra1.p21);
     a22.start();
    Thread a33=new Thread(infra1.p31);
     a33.start(); 
     Thread a44=new Thread(infra1.p41);
     a44.start();
        };
        Timer t6 = new Timer(delay6, taskPerformer6);
        t6.start();
        //code infrarouge
 directors d1=new directors(); 
 h1=new humidite();
 infra1=new infrarouge();
 jeuCartes.setLayout(gestionnaireDesCartes); 
 jeuCartes.setPreferredSize(new Dimension(800, 900));
 //jeuCartes.add(zone, "zone");
 jeuCartes.add(j1,"Tableauv");
 jeuCartes.add(j2, "Bijoux");
 jeuCartes.add(j3, "Sculpture");
 jeuCartes.add(j4, "Costume");
 jeuCartes.add(d1, "directeur");
 jeuCartes.add(h1, "humidite");
 jeuCartes.add(infra1, "infrarouge");
 //jeuCartes.add(voirCercle, "voir un cercle");
 //message.setOpaque(true);
 //jeuCartes.add(message, "message");
 add(jeuCartes, BorderLayout.CENTER);
 tableau.addActionListener(this);
 bijoux.addActionListener(this);
 costume.addActionListener(this);
 sculpture.addActionListener(this);
 Directeurs.addActionListener(this);
 humidite.addActionListener(this);
 infrarouge.addActionListener(this);
 p.setLayout(new GridLayout(4,2));
 p.add(bijoux);
 p.add(costume);
 p.add(sculpture);
 p.add(tableau);
 p.add(Directeurs);
 p.add(humidite);
 p.add(infrarouge);
 add(p,BorderLayout.WEST);
//setLocationRelativeTo(null);
 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 setSize(300, 250);
 setVisible(true);
 pack();
 //codehumidite
 
 //codehumidite
 } 
 
@Override
 public void actionPerformed(ActionEvent e) {
 Object obj = e.getSource();

 if (obj == tableau) {
	gestionnaireDesCartes.show(jeuCartes,"Tableauv");
       // Thread g1=new Thread(new servtableau());
      //g1.start();
      //code
      
}
else if (obj == bijoux) {
	gestionnaireDesCartes.show(jeuCartes,"Bijoux");
}else if (obj == costume) {
	gestionnaireDesCartes.show(jeuCartes,"Costume");
}else if (obj == sculpture) {
	gestionnaireDesCartes.show(jeuCartes,"Sculpture");
}else if (obj == Directeurs) {
	gestionnaireDesCartes.show(jeuCartes,"directeur");
}else if(obj == humidite){
        gestionnaireDesCartes.show(jeuCartes,"humidite");
}else if(obj ==infrarouge){
         gestionnaireDesCartes.show(jeuCartes,"infrarouge");
}

}

    @Override
    public void windowOpened(WindowEvent we) {
        Thread g1=new Thread(new servtableau());
        g1.start();
      Thread g2=new Thread(new servbihoux());
      g2.start();
      Thread g3=new Thread(new servsculpture());
      g3.start();
      Thread g4=new Thread(new servcostume());
      g4.start();
      Thread AH=new Thread(h1);
      AH.start();
      Thread AH1=new Thread(infra1);
      AH1.start();
        }
    

    @Override
    public void windowClosing(WindowEvent we) {
        }

    @Override
    public void windowClosed(WindowEvent we) {
        }

    @Override
    public void windowIconified(WindowEvent we) {
         }

    @Override
    public void windowDeiconified(WindowEvent we) {
        }

    @Override
    public void windowActivated(WindowEvent we) {
        }

    @Override
    public void windowDeactivated(WindowEvent we) {
          }
}
