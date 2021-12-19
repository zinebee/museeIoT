/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package museeiot;

import DB.CRUD_BIJOUX;
import DB.CRUD_SCULPTURE;
import DB.CRUD_TABLEAU;
import DB.MyRendererAndEditor;
import DB.MyRendererAndEditorsculpture;
import DB.capteurtemperature.hmisculpture;
import DB.capteurtemperature.infsculpture;
import DB.information;
import DB.modif;
import DB.modifsculpture;
import DB.receptiontableau;
import DB.serveursculpture;
import DB.servsculpture;
import DB.servsculpturepro;
import java.awt.BorderLayout;
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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import static museeiot.Bijouxd.b;
import static museeiot.DynmicTable.columns;
import static museeiot.Tableaud.b;

/**
 *
 * @author zineb
 */
public class Sculptured extends JFrame implements ActionListener,TableModelListener,WindowListener{
  JButton button;
  JButton button2;
  JButton button3;
  JButton button4;
  JButton button5;
  hmisculpture k1=new hmisculpture(Color.red);
  infsculpture k2=new infsculpture(Color.BLUE);
  JPanel p1;
  DefaultTableModel model ;
   static int b=0;
   formulaire n;
   JTable table;
  String[] g={"ID","Titre","Description","capteur1","capteur2","Supprimer","Modifier"};
  String[][] j={{"Nom12","Prenom12","note12","","-2332"},{"Nom2","Prenom2","note2","",""},{"Nom3","Prenom3","note3","",""}};
  String titre;
    String Description;
    double c1;
    String c2;
    String[][] jI;
    JScrollPane stable;
    public Sculptured(String titre, String Description, double c1,String c2){
     this.titre=titre;
    this.Description=Description;
    this.c1=c1;
    this.c2=c2;
   
   }
   public Sculptured(String[][] donne){
      
       setResizable(true);
       setTitle("SCULPTURES");
       String[] lt=new String[0];
       this.addWindowListener(this);
       //this.addInternalFrameListener(this);
       button=new JButton("Ajouter Sculpture");
       button.addActionListener(this);
       setTitle("LES SCULPTURES");
       setDefaultCloseOperation(3);
       //pack();
       setSize(700,600);
       setLocation(0,80);
      setVisible(true);
      setResizable(false);
      //setLocationRelativeTo(null);
      JPanel k=new JPanel();
      k.setLayout(new GridLayout());
      jI=donne;
      setJI(donne);
      model = new DefaultTableModel(jI,g);
      table=new JTable(model);
      table.setDefaultRenderer(Object.class, new tables());
      table.getColumn("Supprimer").setCellRenderer(new MyRendererAndEditorsculpture(table));
    table.getColumn("Supprimer").setCellEditor(new MyRendererAndEditorsculpture(table));
    table.getColumn("Modifier").setCellRenderer(new modifsculpture(table));
    table.getColumn("Modifier").setCellEditor(new modifsculpture(table));
      stable=new JScrollPane(table);
       //essai
      Color hj=new Color(239,239,239);
      k1=new hmisculpture(hj);
      k2=new infsculpture(hj);
      //essai
      button2=new JButton("supprimer");
      button3=new JButton("Desactiver les notifications");
      button4=new JButton("Activer les notifications");
      button5=new JButton("Desactiver le capteur infrarouge");
      button5.addActionListener(this);
      button3.addActionListener(this);
      button4.addActionListener(this);
      setLayout(new BorderLayout());
      p1=new JPanel(new GridLayout(4,1));
      p1.add(button);
      //p1.add(button2);
      p1.add(button3);
      p1.add(button4);
      p1.add(button5);
      add(p1,BorderLayout.WEST);
      
      button2.addActionListener(new suppression(button2,this));
      int delay = 1000; //milliseconds
        ActionListener taskPerformer;
        taskPerformer = (ActionEvent evt) -> {
        try {
               
           CRUD_SCULPTURE hh=new CRUD_SCULPTURE();
           if(hh.getlignes()!=0){
           try {
               //essai
               Thread r=new Thread(k1);
               r.start();
               Thread r1=new Thread(k2);
               r1.start();
               //essai
            Socket socket = new Socket("127.0.0.1", 5000);
            ObjectInputStream oin = new ObjectInputStream(socket.getInputStream());
            information product = (information) oin.readObject();
            System.out.println(product);
            String[] ress=product.gettit();
            //pro
             Socket sockett = new Socket("127.0.0.1", 5004);
            ObjectInputStream oint = new ObjectInputStream(sockett.getInputStream());
            information productt = (information) oint.readObject();
            System.out.println(productt);
            String[] resst=productt.gettit();
            int fg=hh.getlastline();
           
            if(table.getRowCount()>=1 || fg!=0){
           
           if(b<table.getRowCount()){
               System.out.println("La taille du tableau est  "+table.getRowCount());
              table.setValueAt(ress[b], b, 3);
              table.setValueAt(resst[b], b, 4);
           }
           if(b==hh.getlignes()){
            
            }
            }
           
            if(b==hh.getlignes()){
              System.out.print("le tableau est empty");
            }
            
           System.out.println(b); 
           
           
        } catch (IOException ex) {
            Logger.getLogger(receptiontableau.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            //Logger.getLogger(receptiontableau.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("ssssss");
        }
         //  System.out.print(table.getValueAt(b,1));
           
           b++;
           int sir=hh.getlignes();
               if(b>=sir && sir!=0){
                   
                   b=0;
                   //t.stop();
               }
           }
           
           } catch (SQLException ex) {
               Logger.getLogger(Tableaud.class.getName()).log(Level.SEVERE, null, ex);
           }
           System.out.println(b);
            
        };
       Timer  t = new Timer(delay, taskPerformer);
       
       CRUD_SCULPTURE hhA=new CRUD_SCULPTURE();
       
      try {
          if(hhA.getlignes()!=0 || hhA.getlastline()!=0){
              System.out.println("wxc  :"+hhA.getlignes());
               t.start();
             
          }
          
              
              add(stable,BorderLayout.CENTER);
              //essai
               JPanel kP=new JPanel();
              JLabel  a=new JLabel("humidite");
              JLabel b=new JLabel("Infrarouge");
              JPanel aa=new JPanel(new GridLayout(1,2));
              aa.add(a);
              aa.add(b);
              
              kP.setLayout(new BorderLayout());
              kP.add(aa,BorderLayout.NORTH);
              kP.add(k1,BorderLayout.WEST);
              JPanel noir=new JPanel();
              noir.setBackground(Color.BLACK);
              noir.setPreferredSize(new Dimension(1,700));
              kP.add(noir,BorderLayout.CENTER);
              kP.add(k2,BorderLayout.EAST);
              add(kP,BorderLayout.EAST);
              //essai
         
      } catch (SQLException ex) {
          Logger.getLogger(Tableaud.class.getName()).log(Level.SEVERE, null, ex);
      }
  }
   public void setJI(String[][] y){
    this.jI=y;
   }
public String getTitres(){
  return this.titre;
}
public String getDescriptions(){
  return this.Description;
}
public double getC1s(){
  return this.c1;
}
public String getC2s(){
  return this.c2;
}
    @Override
    public void actionPerformed(ActionEvent ae) {
        
        if(ae.getActionCommand().equals("Ajouter Sculpture")){
       formulaire n=new formulaire("sculpture",this);
     }
        if(ae.getSource()==button3){
        this.table.setDefaultRenderer(Object.class, new tablesdes());
     
     }
     if(ae.getSource()==button4){
     this.table.setDefaultRenderer(Object.class, new tables());
     }
    }

    @Override
    public void tableChanged(TableModelEvent tme) {
       
    }

    @Override
    public void windowOpened(WindowEvent we) {
      Thread g=new Thread(new servsculpture());
      g.start();
      Thread g5=new Thread(new servsculpturepro());
      g5.start();
       //serveur
      Thread gg=this.k1.serveurhum();
      gg.start();
      Thread gg1=this.k2.serveurhum();
      gg1.start();
      //serveur
       
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
