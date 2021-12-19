/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package museeiot;

import DB.CRUD_BIJOUX;
import DB.CRUD_TABLEAU;
import DB.MyRendererAndEditor;
import DB.MyRendererAndEditorbijoux;
import DB.capteurtemperature.hmiBijoux;
import DB.capteurtemperature.infbihoux;
import DB.hmitableau;
import DB.information;
import DB.inftableau;
import DB.modif;
import DB.modifbijoux;
import DB.receptiontableau;
import DB.servbihoux;
import DB.servbijoupro;
import DB.serveurbijoux;
import DB.serveurtemperature;
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
import static museeiot.DynmicTable.columns;
import static museeiot.Tableaud.b;

/**
 *
 * @author zineb
 */
public class Bijouxd extends JFrame implements ActionListener,TableModelListener,WindowListener{
  JButton button;
  JButton button2;
  JButton button3;
  JButton button4;
  JButton button5;
  JPanel p1;
  hmiBijoux k1=new hmiBijoux(Color.red);
  infbihoux k2=new infbihoux(Color.BLUE);
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
    public Bijouxd(String titre, String Description, double c1,String c2){
     this.titre=titre;
    this.Description=Description;
    this.c1=c1;
    this.c2=c2;
   
   }
   public Bijouxd(String[][] donne){
    /*   String[] lt=new String[0];
       this.addWindowListener(this);
       button=new JButton("Ajouter Bijoux");
       button.addActionListener(this);
       setTitle("LES BIJOUX");
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
               
           CRUD_BIJOUX hh=new CRUD_BIJOUX();
           if(hh.getlignes()!=0){
           //table.setValueAt("ff"+b, 1, 3);
           try {
            Socket socket = new Socket("127.0.0.1", 4000);
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
       CRUD_TABLEAU hhA=new CRUD_TABLEAU();
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
          
     // } catch (SQLException ex) {
       //   Logger.getLogger(Tableaud.class.getName()).log(Level.SEVERE, null, ex);
      //}
      //setLocation(new Point(15*frameCountY+100*frameCountX, 15*frameCountY));
       //toFront();
       setResizable(true);
       //setClosable(true);
       //setMaximizable(true);
       //setIconifiable(true);
       setTitle("BIJOUX");
       String[] lt=new String[0];
       this.addWindowListener(this);
       //this.addInternalFrameListener(this);
       button=new JButton("Ajouter Bijoux");
       button.addActionListener(this);
       setTitle("LES BIJJOUX");
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
      table.getColumn("Supprimer").setCellRenderer(new MyRendererAndEditorbijoux(table));
    table.getColumn("Supprimer").setCellEditor(new MyRendererAndEditorbijoux(table));
    table.getColumn("Modifier").setCellRenderer(new modifbijoux(table));
    table.getColumn("Modifier").setCellEditor(new modifbijoux(table));
      stable=new JScrollPane(table);
      
      button2=new JButton("supprimer");
      button3=new JButton("Desactiver les notifications");
      button4=new JButton("Activer les notifications");
      button5=new JButton("Desactiver le capteur infrarouges");
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
      //button2.addActionListener(this);
      //essai
      Color hj=new Color(239,239,239);
      k1=new hmiBijoux(hj);
      k2=new infbihoux(hj);
      //essai
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
               
           CRUD_BIJOUX hh=new CRUD_BIJOUX();
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
            Socket socket = new Socket("127.0.0.1", 4000);
            ObjectInputStream oin = new ObjectInputStream(socket.getInputStream());
            information product = (information) oin.readObject();
            System.out.println(product);
            String[] ress=product.gettit();
            //pro
             Socket sockett = new Socket("127.0.0.1", 4004);
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
       CRUD_BIJOUX hhA=new CRUD_BIJOUX();
       
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
public String getTitreb(){
  return this.titre;
}
public String getDescriptionb(){
  return this.Description;
}
public double getC1b(){
  return this.c1;
}
public String getC2b(){
  return this.c2;
}
    @Override
    public void actionPerformed(ActionEvent ae) {
      /*  if(ae.getActionCommand().equals("Ajouter Bijoux")){
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
      if(ae.getActionCommand().equals("Ajouter Bijoux")){
       formulaire n=new formulaire("bijoux",this);
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
       Thread g=new Thread(new servbihoux());
      g.start();
      Thread g3=new Thread(new servbijoupro());
      g3.start();
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
