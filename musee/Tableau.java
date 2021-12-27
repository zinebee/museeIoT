/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package museeiot;
import DB.CRUD_TABLEAU;
import DB.information;
import DB.receptiontableau;
import DB.servtableau;
import java.net.*;
import java.lang.*;
import java.util.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.Timer;
import java.awt.event.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import static museeiot.Tableaud.b;
/**
 *
 * @author zineb
 */
public class Tableau extends JPanel implements ActionListener,WindowListener{
  JButton button;
   static int bb=0;
  String[] g={"ID","Titre","Description","capteur1","capteur2"};
  String[][] j={{"Nom12","Prenom12","note12","","-2332"},{"Nom2","Prenom2","note2","",""},{"Nom3","Prenom3","note3","",""}};
  DefaultTableModel modell;
  JTable tablee;
   public Tableau() throws SQLException{
       button=new JButton("Ajouter Tableau");
       button.addActionListener(this);
      // setTitle("LES BIJOUX");
       //setDefaultCloseOperation(2);
       //pack();
       setSize(600,300);
      setVisible(true);
      //setResizable(false);
      //setLocationRelativeTo(null);
      JPanel k=new JPanel();
      k.setLayout(new GridLayout());
      CRUD_TABLEAU gt=new CRUD_TABLEAU();
     modell = new DefaultTableModel(gt.gettableaux(),g);
      tablee=new JTable(modell);
      tablee.setDefaultRenderer(Object.class, new tables());
      JScrollPane stable=new JScrollPane(tablee);
      setLayout(new BorderLayout());
     // add(button,BorderLayout.SOUTH);
     add(new JLabel("Tableau"),BorderLayout.NORTH);
      add(stable,BorderLayout.CENTER);
      //add(stable);
      
  }  

    @Override
    public void actionPerformed(ActionEvent ae) {
      //code
      //code
      /* JFrame k=new JFrame();
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
      k.setLocationRelativeTo(null);*/
      
    }

    @Override
    public void windowOpened(WindowEvent we) {
      // Thread g1=new Thread(new servtableau());
       // g1.start(); 
       System.out.println("holeeeee"); 
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
