/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package museeiot;

import DB.CRUD_BIJOUX;
import DB.CRUD_COSTUME;
import DB.CRUD_TABLEAU;
import DB.MyRendererAndEditor;
import DB.MyRendererAndEditorcostume;
import DB.capteurtemperature.hmicostume;
import DB.capteurtemperature.infcostume;
import DB.information;
import DB.modif;
import DB.modifcostume;
import DB.receptiontableau;
import DB.servcostume;
import DB.servcostumepro;
import DB.serveurcostume;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
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
public class Costumed extends JFrame implements ActionListener,TableModelListener,WindowListener{
  JButton button;
  JButton button2;
  JButton button3;
  JButton button4;
  JButton button5;
  JPanel p1;
  hmicostume k1=new hmicostume(Color.red);
  infcostume k2=new infcostume(Color.BLUE);
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
    public Costumed(String titre, String Description, double c1,String c2){
     this.titre=titre;
    this.Description=Description;
    this.c1=c1;
    this.c2=c2;
   
   }
   public Costumed(String[][] donne){
     /*  String[] lt=new String[0];
       this.addWindowListener(this);
       button=new JButton("Ajouter Costume");
       button.addActionListener(this);
       setTitle("LES COSTUMES");
       setDefaultCloseOperation(3);
       //pack();
       setSize(700,700);
      setVisible(true);
      setResizable(false);
      setLocationRelativeTo(null);
      JPanel k=new JPanel();
      k.setLayout(new GridLayout());
      jI=donne;
      model = new DefaultTableModel(jI,g);
      table=new JTable(model);
      table.setDefaultRenderer(Object.class, new tables());
      
      stable=new JScrollPane(table);
      
      
      setLayout(new BorderLayout());
      add(button,BorderLayout.SOUTH);
      
      int delay = 1000; //milliseconds
        ActionListener taskPerformer;
    //   Timer t = new Timer(delay, taskPerformer);
        taskPerformer = (ActionEvent evt) -> {
           // model = table.getModel();
           //table.getColumnName(3);
           
           try {
               
           CRUD_COSTUME hh=new CRUD_COSTUME();
           if(hh.getlignes()!=0){
           //table.setValueAt("ff"+b, 1, 3);
           try {
            Socket socket = new Socket("127.0.0.1", 6000);
            ObjectInputStream oin = new ObjectInputStream(socket.getInputStream());
            information product = (information) oin.readObject();
            System.out.println(product);
            String[] ress=product.gettit();
            table.setValueAt(ress[b], b, 3);
        } catch (IOException ex) {
            Logger.getLogger(receptiontableau.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(receptiontableau.class.getName()).log(Level.SEVERE, null, ex);
        }
           System.out.print(table.getValueAt(b,1));
           
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
       CRUD_COSTUME hhA=new CRUD_COSTUME();
      try {
          if(hhA.getlignes()!=0){
               t.start();
          }
              //System.out.println(b);
              add(stable,BorderLayout.CENTER);
          //add(stable);
          // int delay = 1000; //milliseconds
          //   ActionListener taskPerformer;
          //   taskPerformer = (ActionEvent evt) -> {
          
          
          /*tables jj=new tables();
          table.setDefaultRenderer(Object.class, jj);
          DefaultTableModel myTable = new DefaultTableModel ();
          table= new JTable (myTable) ;
          myTable.addRow(donne);
          myTable.addTableModelListener(table);
          this.stable.remove(table);
          this.stable.add(table);
          table=new JTable(jI,g);
          table.getModel().addTableModelListener(new TableModelListener(){
          public void tableChanged(TableModelEvent e) {
          // your code goes here, whatever you want to do when something changes in the table
          //table= new JTable (myTable) ;
          myTable.addRow(jI);
          //myTable.addTableModelListener(table);
          System.out.println("tbdel");
          }
          });*/
          
          /*  try {
          CRUD_TABLEAU nn=new CRUD_TABLEAU();
          String[][] h;
          h = nn.gettableaux();
          this.setJI(h);
          table=new JTable(jI,g);
          DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
          tableModel.fireTableDataChanged();
          } catch (SQLException ex) {
          Logger.getLogger(Tableaud.class.getName()).log(Level.SEVERE, null, ex);
          }
          
          
          };*/
          //Timer t = new Timer(delay, taskPerformer);
          //t.start();
    //  } catch (SQLException ex) {
      //    Logger.getLogger(Tableaud.class.getName()).log(Level.SEVERE, null, ex);
      //}
      //setLocation(new Point(15*frameCountY+100*frameCountX, 15*frameCountY));
       //toFront();
       setResizable(true);
       //setClosable(true);
       //setMaximizable(true);
       //setIconifiable(true);
       setTitle("COSTUMES");
       String[] lt=new String[0];
       this.addWindowListener(this);
       //this.addInternalFrameListener(this);
       button=new JButton("Ajouter Costume");
       button.addActionListener(this);
       setTitle("LES COSTUMES");
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
      table.getColumn("Supprimer").setCellRenderer(new MyRendererAndEditorcostume(table));
    table.getColumn("Supprimer").setCellEditor(new MyRendererAndEditorcostume(table));
    table.getColumn("Modifier").setCellRenderer(new modifcostume(table));
    table.getColumn("Modifier").setCellEditor(new modifcostume(table));
      stable=new JScrollPane(table);
      
      button2=new JButton("supprimer");
      button3=new JButton("Desactiver les notifications");
      button4=new JButton("Activer les notifications");
      button5=new JButton("Desactiver Le capteur infrarouge");
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
      //essai
      Color hj=new Color(239,239,239);
      k1=new hmicostume(hj);
      k2=new infcostume(hj);
      //essai
      //button2.addActionListener(this);
      button2.addActionListener(new suppression(button2,this));
      int delay = 1000; //milliseconds
        ActionListener taskPerformer;
    //   Timer t = new Timer(delay, taskPerformer);
        taskPerformer = (ActionEvent evt) -> {
           
           // model = table.getModel();
           //table.getColumnName(3);
            //Thread g=new Thread(new serveurtemperature());
      //g.start();
       /*    try {
               
           CRUD_TABLEAU hh=new CRUD_TABLEAU();
           if(hh.getlignes()!=0){
           //table.setValueAt("ff"+b, 1, 3);
           try {
            Socket socket = new Socket("127.0.0.1", 3000);
            ObjectInputStream oin = new ObjectInputStream(socket.getInputStream());
            information product = (information) oin.readObject();
            System.out.println(product);
            String[] ress=product.gettit();
            table.setValueAt(ress[b], b, 3);
        } catch (IOException ex) {
            Logger.getLogger(receptiontableau.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(receptiontableau.class.getName()).log(Level.SEVERE, null, ex);
        }
           System.out.print(table.getValueAt(b,1));
           
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
           System.out.println(b);*/
        try {
               
           CRUD_COSTUME hh=new CRUD_COSTUME();
          // this.model=new DefaultTableModel(hh.gettableaux(),g);
          // this.table=new JTable(this.model);
           if(hh.getlignes()!=0){
           //table.setValueAt("ff"+b, 1, 3);
           try {
                //essai
               Thread r=new Thread(k1);
               r.start();
               Thread r1=new Thread(k2);
               r1.start();
               //essai
            Socket socket = new Socket("127.0.0.1", 6000);
            ObjectInputStream oin = new ObjectInputStream(socket.getInputStream());
            information product = (information) oin.readObject();
            System.out.println(product);
            String[] ress=product.gettit();
            //pro
             Socket sockett = new Socket("127.0.0.1", 6004);
            ObjectInputStream oint = new ObjectInputStream(sockett.getInputStream());
            information productt = (information) oint.readObject();
            System.out.println(productt);
            String[] resst=productt.gettit();
            
            //pro
            //ress=this.ee(ress, b);
            //  model.fireTableDataChanged(); 
            int fg=hh.getlastline();
            //int fgg=fg-b-1;
            if(table.getRowCount()>=1 || fg!=0){
           // Object ve=(String)table.getValueAt(b,3);
            //String sdf=(String)ve;
           // if(!sdf.isEmpty()){
           if(b<table.getRowCount()){
               System.out.println("La taille du tableau est  "+table.getRowCount());
              table.setValueAt(ress[b], b, 3);
              table.setValueAt(resst[b], b, 4);
           }
              //b++;
           // }else{
             //   String[] nb={" "," "," "," "," "," "};
              //model.addRow(nb);
           // }
            
            if(b==hh.getlignes()){
             // b--;
            }
            }
            //System.out.println("xxxx   :"+ress[fgg]+"ff:  "+fgg);
            if(b==hh.getlignes()){
              System.out.print("le tableau est empty");
            }
            //model.fireTableStructureChanged();
           System.out.println(b); 
           // ress=this.ee(product.gettit(),table.getRowCount());
            //ress=hh.gettableaux();
           // jI=hh.gettableaux();
           
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
       //t.start();
       CRUD_COSTUME hhA=new CRUD_COSTUME();
       
      try {
          if(hhA.getlignes()!=0 || hhA.getlastline()!=0){
              System.out.println("wxc  :"+hhA.getlignes());
               t.start();
             //System.out.print();
          }
          
              //System.out.println(b);
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
          //add(stable);
          // int delay = 1000; //milliseconds
          //   ActionListener taskPerformer;
          //   taskPerformer = (ActionEvent evt) -> {
          
          
          /*tables jj=new tables();
          table.setDefaultRenderer(Object.class, jj);
          DefaultTableModel myTable = new DefaultTableModel ();
          table= new JTable (myTable) ;
          myTable.addRow(donne);
          myTable.addTableModelListener(table);
          this.stable.remove(table);
          this.stable.add(table);
          table=new JTable(jI,g);
          table.getModel().addTableModelListener(new TableModelListener(){
          public void tableChanged(TableModelEvent e) {
          // your code goes here, whatever you want to do when something changes in the table
          //table= new JTable (myTable) ;
          myTable.addRow(jI);
          //myTable.addTableModelListener(table);
          System.out.println("tbdel");
          }
          });*/
          
          /*  try {
          CRUD_TABLEAU nn=new CRUD_TABLEAU();
          String[][] h;
          h = nn.gettableaux();
          this.setJI(h);
          table=new JTable(jI,g);
          DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
          tableModel.fireTableDataChanged();
          } catch (SQLException ex) {
          Logger.getLogger(Tableaud.class.getName()).log(Level.SEVERE, null, ex);
          }
          
          
          };*/
          //Timer t = new Timer(delay, taskPerformer);
          //t.start();
      } catch (SQLException ex) {
          Logger.getLogger(Tableaud.class.getName()).log(Level.SEVERE, null, ex);
      }
  }  
   public void setJI(String[][] y){
    this.jI=y;
   }
public String getTitrec(){
  return this.titre;
}
public String getDescriptionc(){
  return this.Description;
}
public double getC1c(){
  return this.c1;
}
public String getC2c(){
  return this.c2;
}
    @Override
    public void actionPerformed(ActionEvent ae) {
       /* if(ae.getActionCommand().equals("Ajouter Costume")){
      JFrame k=new JFrame();
      //JDialog k=new JDialog(e,true);
      k.setLayout(new GridLayout(6,1));
      JLabel id=new JLabel("ID");
      JLabel des=new JLabel("Description");
      JLabel titre=new JLabel("Titre");
      JLabel cp1=new JLabel("capteur1");
      JLabel cp2=new JLabel("capteur2");
      JTextField i1=new JTextField(b);
      b++;
      i1.setEditable(false);
      i1.setEnabled(false);
      JTextField i2=new JTextField();
      JTextField i3=new JTextField();
      JTextField i4=new JTextField();
      JTextField i5=new JTextField();
      k.add(id);
      k.add(i1);
      k.add(des);
      k.add(i2);
      k.add(titre);
      k.add(i3);
      k.add(cp1);
      k.add(i4);
      k.add(cp2);
      k.add(i5);
      JButton y=new JButton("inserer");
      k.add(y);
      k.setVisible(true);
      k.pack();
      k.setResizable(false);
      k.setTitle("Ajouter tableau");
      k.setLocationRelativeTo(null);
        }
        if(ae.getActionCommand().equals("inserer")){
         System.out.println("vous appuyez sur le bouton inserer du formualire");
       }*/
       if(ae.getActionCommand().equals("Ajouter Costume")){
       formulaire n=new formulaire("costume",this);
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
       Thread g=new Thread(new servcostume());
      g.start();
      Thread g4=new Thread(new servcostumepro());
      g4.start();
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
