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
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowSorter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import static museeiot.Tableaud.b;

/**
 *
 * @author zineb
 */
public class formulaire extends  JFrame implements ActionListener{
     JTextField i2;
      JTextField i3;
      JTextField i4;
      JTextField i5;
      JTextField i1;
      JButton y;
      static int b=1;
      String h;
      String oui;
      Tableaud hk;
      Costumed hkc;
      Sculptured hks;
      Bijouxd hkb;
      public formulaire(String r,Tableaud hk){
          this.hk=hk;
          h=r;
          this.oui="non";
          i2=new JTextField();
   i3=new JTextField();
     i4=new JTextField();
      i5=new JTextField();
       i1=new JTextField();
      setLayout(new GridLayout(6,1));
      JLabel id=new JLabel("ID");
      JLabel des=new JLabel("Description");
      JLabel titre=new JLabel("Titre");
      JLabel cp1=new JLabel("capteur1");
      JLabel cp2=new JLabel("capteur2");
      //b++;
      i1.setEditable(false);
      i1.setEnabled(false);
     
      //add(id);
      //add(i1);
      add(des);
      add(i2);
      add(titre);
      add(i3);
      add(cp1);
      add(i4);
      add(cp2);
      add(i5);
      String gh="inserer "+h;
      y=new JButton(gh);
      y.addActionListener(this);
      pack();
      add(y);
      setVisible(true);
      setResizable(false);
      setTitle("Ajouter tableau");
      setLocationRelativeTo(null);
  }
      public formulaire(String r,Costumed hk){
          this.hkc=hk;
          h=r;
          this.oui="non";
          i2=new JTextField();
   i3=new JTextField();
     i4=new JTextField();
      i5=new JTextField();
       i1=new JTextField();
      setLayout(new GridLayout(6,1));
      JLabel id=new JLabel("ID");
      JLabel des=new JLabel("Description");
      JLabel titre=new JLabel("Titre");
      JLabel cp1=new JLabel("capteur1");
      JLabel cp2=new JLabel("capteur2");
      //b++;
      i1.setEditable(false);
      i1.setEnabled(false);
     
      //add(id);
      //add(i1);
      add(des);
      add(i2);
      add(titre);
      add(i3);
      add(cp1);
      add(i4);
      add(cp2);
      add(i5);
      String gh="inserer "+h;
      y=new JButton(gh);
      y.addActionListener(this);
      pack();
      add(y);
      setVisible(true);
      setResizable(false);
      setTitle("Ajouter tableau");
      setLocationRelativeTo(null);
  }
      public formulaire(String r,Sculptured hk){
          this.hks=hk;
          h=r;
          this.oui="non";
          i2=new JTextField();
   i3=new JTextField();
     i4=new JTextField();
      i5=new JTextField();
       i1=new JTextField();
      setLayout(new GridLayout(6,1));
      JLabel id=new JLabel("ID");
      JLabel des=new JLabel("Description");
      JLabel titre=new JLabel("Titre");
      JLabel cp1=new JLabel("capteur1");
      JLabel cp2=new JLabel("capteur2");
      //b++;
      i1.setEditable(false);
      i1.setEnabled(false);
     
      //add(id);
      //add(i1);
      add(des);
      add(i2);
      add(titre);
      add(i3);
      add(cp1);
      add(i4);
      add(cp2);
      add(i5);
      String gh="inserer "+h;
      y=new JButton(gh);
      y.addActionListener(this);
      pack();
      add(y);
      setVisible(true);
      setResizable(false);
      setTitle("Ajouter tableau");
      setLocationRelativeTo(null);
  }
      public formulaire(String r,Bijouxd hk){
          this.hkb=hk;
          h=r;
          this.oui="non";
          i2=new JTextField();
   i3=new JTextField();
     i4=new JTextField();
      i5=new JTextField();
       i1=new JTextField();
      setLayout(new GridLayout(6,1));
      JLabel id=new JLabel("ID");
      JLabel des=new JLabel("Description");
      JLabel titre=new JLabel("Titre");
      JLabel cp1=new JLabel("capteur1");
      JLabel cp2=new JLabel("capteur2");
      //b++;
      i1.setEditable(false);
      i1.setEnabled(false);
     
      //add(id);
      //add(i1);
      add(des);
      add(i2);
      add(titre);
      add(i3);
      add(cp1);
      add(i4);
      add(cp2);
      add(i5);
      String gh="inserer "+h;
      y=new JButton(gh);
      y.addActionListener(this);
      pack();
      add(y);
      setVisible(true);
      setResizable(false);
      setTitle("Ajouter tableau");
      setLocationRelativeTo(null);
  }
      public String getoui(){
        return this.oui;
      }
    @Override
    public void actionPerformed(ActionEvent ae) {
        int dfg=9;
       
        if(ae.getActionCommand().equals("inserer tableau")){
            try {
               double ii4=Double.parseDouble(i4.getText());
                Tableaud t=new Tableaud(i3.getText(),i2.getText(),ii4,i5.getText());
                CRUD_TABLEAU crudt=new CRUD_TABLEAU();
               // int idaffich=crudt.getlastline()+crudt.getlignes()+1;
              // int idaffich=crudt.getlastline();
                //String xcv=String.valueOf(idaffich);
                int tt;
                tt=crudt.Ajoutertableaux(t);
                if(tt==1){
                    Object[][] n=crudt.gettableaux();
                  int reponse=JOptionPane.showConfirmDialog(this, "Succe", "Inserted Succefully",JOptionPane.YES_OPTION);
                  if(reponse == JOptionPane.YES_OPTION){
                      int idaffich=crudt.getlastline();
                String xcv=String.valueOf(idaffich);
                      this.setVisible(false);
                    this.hk.model.addRow(
                   new Object[]{
                         xcv,
                         i3.getText(), 
                         i2.getText(),
                         i4.getText(),
                         i5.getText(),
                         
                   }
              );
              this.hk.table.setDefaultRenderer(Object.class, new tables());
                  // RowSorter<TableModel> sorter = new TableRowSorter<TableModel>(this.hk.model);
 
			     // this.hk.table.setRowSorter(sorter);
                  }

                  
                }else{
                 this.setVisible(false);
                  JOptionPane.showMessageDialog(this, "L'element ajoute existe deja", "ERREUR",JOptionPane.ERROR_MESSAGE);
                
                }
            }catch (SQLException ex) {
                
               this.setVisible(false);
                  JOptionPane.showMessageDialog(this, "L'element ajoute existe deja", "ERREUR",JOptionPane.ERROR_MESSAGE);
                
            }
            // Logger.getLogger(formulaire.class.getName()).log(Level.SEVERE, null, ex);
            
         
       }
        if(ae.getActionCommand().equals("inserer bijoux")){
        /* try {
               double ii4=Double.parseDouble(i4.getText());
                Bijouxd t=new Bijouxd(i3.getText(),i2.getText(),ii4,i5.getText());
                CRUD_BIJOUX crudt=new CRUD_BIJOUX();
                int tt;
                tt=crudt.AjouterBijoux(t);
                if(tt==1){
                    String[][] n=crudt.gettableaux();
                  int reponse=JOptionPane.showConfirmDialog(this, "Succe", "Inserted Succefully",JOptionPane.YES_OPTION);
                  if(reponse == JOptionPane.YES_OPTION){
                      this.setVisible(false);
                    this.hkb.model.addRow(
                   new Object[]{
                       crudt.getlignes(),
                         i3.getText(), 
                         i2.getText(),
                         i4.getText(),
                         i5.getText()
                   }
              );
              this.hkb.table.setDefaultRenderer(Object.class, new tables());
                   
                  }

                  
                }
            } catch (SQLException ex) {
                
               this.setVisible(false);
                  JOptionPane.showMessageDialog(this, "L'element ajoute existe deja", "ERREUR",JOptionPane.ERROR_MESSAGE);
                
            }*/
        
          try {
               double ii4=Double.parseDouble(i4.getText());
                Bijouxd t=new Bijouxd(i3.getText(),i2.getText(),ii4,i5.getText());
                CRUD_BIJOUX crudt=new CRUD_BIJOUX();
               // int idaffich=crudt.getlastline()+crudt.getlignes()+1;
              // int idaffich=crudt.getlastline();
                //String xcv=String.valueOf(idaffich);
                int tt;
                tt=crudt.AjouterBijoux(t);
                if(tt==1){
                    Object[][] n=crudt.gettableaux();
                  int reponse=JOptionPane.showConfirmDialog(this, "Succe", "Inserted Succefully",JOptionPane.YES_OPTION);
                  if(reponse == JOptionPane.YES_OPTION){
                      int idaffich=crudt.getlastline();
                String xcv=String.valueOf(idaffich);
                      this.setVisible(false);
                    this.hkb.model.addRow(
                   new Object[]{
                         xcv,
                         i3.getText(), 
                         i2.getText(),
                         i4.getText(),
                         i5.getText(),
                         
                   }
              );
              this.hkb.table.setDefaultRenderer(Object.class, new tables());
                  // RowSorter<TableModel> sorter = new TableRowSorter<TableModel>(this.hk.model);
 
			     // this.hk.table.setRowSorter(sorter);
                  }

                  
                }else{
                 this.setVisible(false);
                  JOptionPane.showMessageDialog(this, "L'element ajoute existe deja", "ERREUR",JOptionPane.ERROR_MESSAGE);
                
                }
            }catch (SQLException ex) {
                
               this.setVisible(false);
                  JOptionPane.showMessageDialog(this, "L'element ajoute existe deja", "ERREUR",JOptionPane.ERROR_MESSAGE);
                
            }
            // Logger.getLogger(formulaire.class.getName()).log(Level.SEVERE, null, ex);
            
         
       }
       if(ae.getActionCommand().equals("inserer sculpture")){
         
         
       /*   try {
               double ii4=Double.parseDouble(i4.getText());
                Sculptured t=new Sculptured(i3.getText(),i2.getText(),ii4,i5.getText());
                CRUD_SCULPTURE crudt=new CRUD_SCULPTURE();
                int tt;
                tt=crudt.AjouterSculpture(t);
                if(tt==1){
                    String[][] n=crudt.gettableaux();
                  int reponse=JOptionPane.showConfirmDialog(this, "Succe", "Inserted Succefully",JOptionPane.YES_OPTION);
                  if(reponse == JOptionPane.YES_OPTION){
                      this.setVisible(false);
                    this.hks.model.addRow(
                   new Object[]{
                        crudt.getlignes(),
                         i3.getText(), 
                         i2.getText(),
                         i4.getText(),
                         i5.getText()
                   }
              );
              this.hks.table.setDefaultRenderer(Object.class, new tables());
                    
                  }

                  
                }
            } catch (SQLException ex) {
                
               this.setVisible(false);
                  JOptionPane.showMessageDialog(this, "L'element ajoute existe deja", "ERREUR",JOptionPane.ERROR_MESSAGE);
                
            }*/
       try {
               double ii4=Double.parseDouble(i4.getText());
                Sculptured t=new Sculptured(i3.getText(),i2.getText(),ii4,i5.getText());
                CRUD_SCULPTURE crudt=new CRUD_SCULPTURE();
               // int idaffich=crudt.getlastline()+crudt.getlignes()+1;
              // int idaffich=crudt.getlastline();
                //String xcv=String.valueOf(idaffich);
                int tt;
                tt=crudt.AjouterSculpture(t);
                if(tt==1){
                    Object[][] n=crudt.gettableaux();
                  int reponse=JOptionPane.showConfirmDialog(this, "Succe", "Inserted Succefully",JOptionPane.YES_OPTION);
                  if(reponse == JOptionPane.YES_OPTION){
                      int idaffich=crudt.getlastline();
                String xcv=String.valueOf(idaffich);
                      this.setVisible(false);
                    this.hks.model.addRow(
                   new Object[]{
                         xcv,
                         i3.getText(), 
                         i2.getText(),
                         i4.getText(),
                         i5.getText(),
                         
                   }
              );
              this.hks.table.setDefaultRenderer(Object.class, new tables());
                  // RowSorter<TableModel> sorter = new TableRowSorter<TableModel>(this.hk.model);
 
			     // this.hk.table.setRowSorter(sorter);
                  }

                  
                }else{
                 this.setVisible(false);
                  JOptionPane.showMessageDialog(this, "L'element ajoute existe deja", "ERREUR",JOptionPane.ERROR_MESSAGE);
                
                }
            }catch (SQLException ex) {
                
               this.setVisible(false);
                  JOptionPane.showMessageDialog(this, "L'element ajoute existe deja", "ERREUR",JOptionPane.ERROR_MESSAGE);
                
            }
            // Logger.getLogger(formulaire.class.getName()).log(Level.SEVERE, null, ex);
            
         
       }
       if(ae.getActionCommand().equals("inserer costume")){
         
       /*  try {
               double ii4=Double.parseDouble(i4.getText());
                Costumed t=new Costumed(i3.getText(),i2.getText(),ii4,i5.getText());
                CRUD_COSTUME crudt=new CRUD_COSTUME();
                int tt;
                tt=crudt.Ajoutercostume(t);
                if(tt==1){
                    String[][] n=crudt.gettableaux();
                  int reponse=JOptionPane.showConfirmDialog(this, "Succe", "Inserted Succefully",JOptionPane.YES_OPTION);
                  if(reponse == JOptionPane.YES_OPTION){
                      this.setVisible(false);
                    this.hkc.model.addRow(
                   new Object[]{
                       crudt.getlignes(),
                         i3.getText(), 
                         i2.getText(),
                         i4.getText(),
                         i5.getText()
                   }
              );
              this.hkc.table.setDefaultRenderer(Object.class, new tables());
                    
                  }

                  
                }
            } catch (SQLException ex) {
                
               this.setVisible(false);
                  JOptionPane.showMessageDialog(this, "L'element ajoute existe deja", "ERREUR",JOptionPane.ERROR_MESSAGE);
                
            }*/
           try {
               double ii4=Double.parseDouble(i4.getText());
                Costumed t=new Costumed(i3.getText(),i2.getText(),ii4,i5.getText());
                CRUD_COSTUME crudt=new CRUD_COSTUME();
               // int idaffich=crudt.getlastline()+crudt.getlignes()+1;
              // int idaffich=crudt.getlastline();
                //String xcv=String.valueOf(idaffich);
                int tt;
                tt=crudt.AjouterCostume(t);
                if(tt==1){
                    Object[][] n=crudt.gettableaux();
                  int reponse=JOptionPane.showConfirmDialog(this, "Succe", "Inserted Succefully",JOptionPane.YES_OPTION);
                  if(reponse == JOptionPane.YES_OPTION){
                      int idaffich=crudt.getlastline();
                String xcv=String.valueOf(idaffich);
                      this.setVisible(false);
                    this.hkc.model.addRow(
                   new Object[]{
                         xcv,
                         i3.getText(), 
                         i2.getText(),
                         i4.getText(),
                         i5.getText(),
                         
                   }
              );
              this.hkc.table.setDefaultRenderer(Object.class, new tables());
                  // RowSorter<TableModel> sorter = new TableRowSorter<TableModel>(this.hk.model);
 
			     // this.hk.table.setRowSorter(sorter);
                  }

                  
                }else{
                 this.setVisible(false);
                  JOptionPane.showMessageDialog(this, "L'element ajoute existe deja", "ERREUR",JOptionPane.ERROR_MESSAGE);
                
                }
            }catch (SQLException ex) {
                
               this.setVisible(false);
                  JOptionPane.showMessageDialog(this, "L'element ajoute existe deja", "ERREUR",JOptionPane.ERROR_MESSAGE);
                
            }
            // Logger.getLogger(formulaire.class.getName()).log(Level.SEVERE, null, ex);
            
       
       }
        }
    
}
