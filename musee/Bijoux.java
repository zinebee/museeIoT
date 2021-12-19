/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package museeiot;

import DB.CRUD_BIJOUX;
import DB.CRUD_TABLEAU;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JWindow;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author zineb
 */
public class Bijoux extends JPanel{
    JButton button;
    String titre;
    String Description;
    String c1;
    static int bi=0;
    String c2;
    JTable tableb;
  String[] g={"ID","Titre","Description","capteur1","capteur2"};
  String[][] j={{"Nom14","Prenom14","note14","","-2334"},{"Nom2","Prenom2","note2","",""},{"Nom3","Prenom3","note3","",""}};
  DefaultTableModel modelb;
   public Bijoux() throws SQLException{
       button=new JButton("Ajouter Bijoux");
      // setTitle("LES BIJOUX");
       //setDefaultCloseOperation(2);
       //pack();
       setSize(600,300);
      setVisible(true);
      //setResizable(false);
      //setLocationRelativeTo(null);
      CRUD_BIJOUX gt=new CRUD_BIJOUX();
      String[][] h=gt.gettableaux();
      JPanel k=new JPanel();
      k.setLayout(new GridLayout());
     modelb = new DefaultTableModel(gt.gettableaux(),g);
      tableb=new JTable(modelb);
      tableb.setDefaultRenderer(Object.class, new tables());
      JScrollPane stable=new JScrollPane(tableb);
      setLayout(new BorderLayout());
      add(new JLabel("Bijoux"),BorderLayout.NORTH);
      //add(button,BorderLayout.SOUTH);
      add(stable,BorderLayout.CENTER);
      //add(stable);
      
  } 
   public Bijoux(String titre, String Description, String c1,String c2){
     this.titre=titre;
    this.Description=Description;
    this.c1=c1;
    this.c2=c2;
   
   }
}
