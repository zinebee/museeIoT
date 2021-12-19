/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package museeiot;

import DB.CRUD_DIRECTEUR;
import DB.MyRendererAndEditor;
import DB.MyRendererAndEditordirecteur;
import DB.modif;
import DB.modifdirecteur;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author zineb
 */
public class directors extends JPanel implements ActionListener{
   
   JTable tabled;
   JButton bouton1;
   JButton bouton2;
   JLabel r1;
   JTextField r11;
   JLabel r2;
   JTextField r22;
   String[] colonne={"ID_directeur","Login","Mot de Passe","Supprimer","Modifier"};
   DefaultTableModel modeld;
    public directors() throws SQLException{
      //setTitle("Les Directeurs");
     /* CRUD_DIRECTEUR n=new CRUD_DIRECTEUR();
      String[][] h=n.gettableaux();
       modeld = new DefaultTableModel(n.gettableaux(),colonne);
      tabled=new JTable(modeld);
      tabled.setDefaultRenderer(Object.class, new tablehuminf());
      tabled.getColumn("Supprimer").setCellRenderer(new MyRendererAndEditordirecteur(tabled));
    tabled.getColumn("Supprimer").setCellEditor(new MyRendererAndEditordirecteur(tabled));
    tabled.getColumn("Modifier").setCellRenderer(new modifdirecteur(tabled));
    tabled.getColumn("Modifier").setCellEditor(new modifdirecteur(tabled));
      JPanel pr=new JPanel();
      pr.setLayout(new GridLayout(1,1));
      setLayout(new BorderLayout());
      JPanel p1=new JPanel();
      JPanel p2=new  JPanel();
      JPanel p3=new JPanel();
      JPanel p4=new JPanel();
       bouton1=new JButton("Ajouter directeur");
       bouton1.addActionListener(this);
      p1.setBackground(Color.yellow);
      p2.setBackground(Color.red);
      p3.setBackground(Color.GREEN);
      p4.setBackground(Color.blue);
      //pr.add(p1);
      //pr.add(p2);
      //pr.add(p3);
      //pr.add(p4);
      pr.add(tabled);
      add(pr,BorderLayout.CENTER);
      add(bouton1,BorderLayout.SOUTH);
      setVisible(true);
      r1=new JLabel("Login");
          r11=new JTextField();
          r2=new JLabel("Nouveau mot de passe");
          r22=new JTextField();
           //bouton2.addActionListener(new ecouteurA(bouton2,r11.getText(),r22.getText(),modeld,tabled));*/
     
       
     
      CRUD_DIRECTEUR gt=new CRUD_DIRECTEUR();
      String[][] h=gt.gettableaux();
       modeld = new DefaultTableModel(gt.gettableaux(),colonne);
      tabled=new JTable(modeld);
      tabled.setDefaultRenderer(Object.class, new tablehuminf());
       tabled.getColumn("Supprimer").setCellRenderer(new MyRendererAndEditordirecteur(tabled));
    tabled.getColumn("Supprimer").setCellEditor(new MyRendererAndEditordirecteur(tabled));
    tabled.getColumn("Modifier").setCellRenderer(new modifdirecteur(tabled));
    tabled.getColumn("Modifier").setCellEditor(new modifdirecteur(tabled));
      JScrollPane stable=new JScrollPane(tabled);
      setLayout(new BorderLayout());
      bouton1=new JButton("Ajouter directeur");
       bouton1.addActionListener(this);
      //add(button,BorderLayout.SOUTH);
      //add(new JLabel("Directeur"),BorderLayout.NORTH);
      add(stable,BorderLayout.CENTER);
      add(bouton1,BorderLayout.SOUTH);
       r1=new JLabel("Login");
          r11=new JTextField();
          r2=new JLabel("Nouveau mot de passe");
          r22=new JTextField();
          bouton2=new JButton("Ajouter");
          bouton2.addActionListener(this);
      //add(stable);
          
    }

    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==bouton1){
          JFrame ins=new JFrame();
          ins.setVisible(true);
          
          ins.setLayout(new GridLayout(3,2));
          ins.add(r1);
          ins.add(r11);
          ins.add(r2);
          ins.add(r22);
          bouton2=new JButton("Ajouter");
          System.out.println(r11.getText());
          bouton2.addActionListener(new ecouteurA(bouton2,r11,r22,modeld,tabled));
          ins.add(bouton2);
          ins.pack();
          
          
        }
        if(ae.getSource()==bouton2){
        System.out.println("Vous ajoute le diecteur");
        directeur hh=new directeur(r11.getText(),r22.getText());
        CRUD_DIRECTEUR nn=new CRUD_DIRECTEUR();
        int rr=nn.Ajouterdirecteur(hh);
        int reponse=JOptionPane.showConfirmDialog(null, "Succe", "Inserted Succefully",JOptionPane.YES_OPTION);
                  if(reponse == JOptionPane.YES_OPTION){
            try {
                int idaffich=nn.getlastline();
                String xcv=String.valueOf(idaffich);
                // this.setVisible(false);
                this.modeld.addRow(
                        new Object[]{
                            xcv,
                            r11.getText(),
                            r22.getText(),
                            
                            
                        }
                );
               // this.tabled.setDefaultRenderer(Object.class, new tablehuminf());
            } catch (SQLException ex) {
                Logger.getLogger(ecouteurA.class.getName()).log(Level.SEVERE, null, ex);
            }
       }
        
        }
        }


}
class ecouteurA implements ActionListener{
    JButton bouton2;
    String login;
    String password;
    DefaultTableModel modeld;
    JTable tabled;
public ecouteurA(JButton bouton2,JTextField login,JTextField password,DefaultTableModel modeld,JTable tabled){
this.bouton2=bouton2;
this.login=login.getText();
this.password=password.getText();
this.modeld=modeld;
this.tabled=tabled;
}

    @Override
    public void actionPerformed(ActionEvent ae){
       if(ae.getSource()==bouton2){
        System.out.println("Vous ajoute le diecteur");
        directeur hh=new directeur(this.login,this.password);
        CRUD_DIRECTEUR nn=new CRUD_DIRECTEUR();
        int rr=nn.Ajouterdirecteur(hh);
        int reponse=JOptionPane.showConfirmDialog(null, "Succe", "Inserted Succefully",JOptionPane.YES_OPTION);
                  if(reponse == JOptionPane.YES_OPTION){
            try {
                int idaffich=nn.getlastline();
                String xcv=String.valueOf(idaffich);
                // this.setVisible(false);
                this.modeld.addRow(
                        new Object[]{
                            xcv,
                            this.login,
                            this.password,
                            
                            
                        }
                );
               // this.tabled.setDefaultRenderer(Object.class, new tablehuminf());
            } catch (SQLException ex) {
                Logger.getLogger(ecouteurA.class.getName()).log(Level.SEVERE, null, ex);
            }
       }
    }
    }
}
