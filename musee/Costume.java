/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package museeiot;

import DB.CRUD_COSTUME;
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
public class Costume extends JPanel{
    JButton button;
  String[] g={"Titre","Description","c1temp","c2hy"};
  String[][] j={{"Nom13","Prenom13","note13","","-2333"},{"Nom2","Prenom2","note2","",""},{"Nom3","Prenom3","note3","",""}};
  JTable tablec;
   DefaultTableModel modelc;
   static int bc=0;
   public Costume() throws SQLException{
      button=new JButton("Ajouter Costume");
      // setTitle("LES BIJOUX");
       //setDefaultCloseOperation(2);
       //pack();
       setSize(600,300);
      setVisible(true);
      //setResizable(false);
      //setLocationRelativeTo(null);
      JPanel k=new JPanel();
      k.setLayout(new GridLayout());
      CRUD_COSTUME n=new CRUD_COSTUME();
      String[][] h=n.gettableaux();
       modelc = new DefaultTableModel(n.gettableaux(),g);
      tablec=new JTable(modelc);
      tablec.setDefaultRenderer(Object.class, new tables());
      JScrollPane stable=new JScrollPane(tablec);
      setLayout(new BorderLayout());
      //add(button,BorderLayout.SOUTH);
      add(new JLabel("Costume"),BorderLayout.NORTH);
      add(stable,BorderLayout.CENTER);
      //add(stable);
      
  }  
}
