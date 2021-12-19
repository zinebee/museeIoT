/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package museeiot;
import DB.CRUD_SCULPTURE;
import java.net.*;
import java.lang.*;
import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author zineb
 */
public class Sculpture extends JPanel{
    JButton button;
    static int bs=0;
  String[] g={"ID","Titre","Description","c1temp","c2hy"};
  String[][] j={{"Nom11","Prenom11","note11","","-2331"},{"Nom2","Prenom2","note2","",""},{"Nom3","Prenom3","note3","",""}};
   JTable tables;
   DefaultTableModel models;
   public Sculpture() throws SQLException{
       button=new JButton("Ajouter Sculpture");
      // setTitle("LES BIJOUX");
       //setDefaultCloseOperation(2);
       //pack();
       setSize(600,300);
      setVisible(true);
      //setResizable(false);
      //setLocationRelativeTo(null);
      JPanel k=new JPanel();
      k.setLayout(new GridLayout());
      CRUD_SCULPTURE gt=new CRUD_SCULPTURE();
      String[][] h=gt.gettableaux();
       models = new DefaultTableModel(gt.gettableaux(),g);
      tables=new JTable(models);
      tables.setDefaultRenderer(Object.class, new tables());
      JScrollPane stable=new JScrollPane(tables);
      setLayout(new BorderLayout());
      //add(button,BorderLayout.SOUTH);
      add(new JLabel("Sculpture"),BorderLayout.NORTH);
      add(stable,BorderLayout.CENTER);
      //add(stable);
      
  }  
}
