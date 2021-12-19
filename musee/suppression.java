/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package museeiot;

import DB.CRUD_TABLEAU;
import DB.DeleteRow;
import DB.Main;
//import DB.MyRendererAndEditor;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author zineb
 */
public class suppression extends JFrame implements ActionListener{
  JButton t;
  Tableaud tt;
  Bijouxd b;
  Costumed c;
  Sculptured s;
  JTable hj;
  JButton t1;
  public suppression(JButton t,Tableaud tt){
    this.t=t;
    this.tt=tt;
    //setVisible(true);
     //hj=new JTable(this.tt.model);
    //setLayout(new BorderLayout());
    //add(hj,BorderLayout.NORTH);
    //t1=new JButton("Supprimer une ligne");
    //add(t1,BorderLayout.SOUTH);
    //setSize(300,200);
    //setLocationRelativeTo(null);
    
  }
  public suppression(JButton t,Bijouxd b){
    this.t=t;
    this.b=b;
  }
  public suppression(JButton t,Costumed c){
    this.t=t;
    this.c=c;
  }
public suppression(JButton t,Sculptured s){
    this.t=t;
    this.s=s;
  }
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getActionCommand().equals("supprimer")){
        int row=this.tt.table.getSelectedRow();
        if(row ==-1){
        JOptionPane.showMessageDialog(this.tt, "Veuillez Selectionner la igne que vous voulez supprimer", "REMARQUE",JOptionPane.INFORMATION_MESSAGE);
        }else{
           if(this.tt.table.getSelectedRow() != -1) 
            {  try {
                //new Main();
                
              DefaultTableModel model = (DefaultTableModel) this.tt.table.getModel();
              Object[][] data =null;
              //  model.addRow(data);
              String dd=(String)this.tt.table.getValueAt(row, 0);
              int nbre=Integer.parseInt(dd);
              CRUD_TABLEAU hh=new CRUD_TABLEAU();
              hh.supprimertableaux(nbre);
              //System.out.println(nbre);
              //System.out.println(hh.gettitreseul(nbre));
              model.removeRow(row);
         
                //new DeleteRow();
                /* try {
                row=this.tt.table.getSelectedRow();
                String dd=(String)this.tt.table.getValueAt(row, 0);
                int nbre=Integer.parseInt(dd);
                int nbree=(int)nbre;
                System.out.println("voila fadiallllaaa"+nbre);
                CRUD_TABLEAU j=new CRUD_TABLEAU();
                String[] g={"ID","Titre","Description","capteur1","capteur2"};
                //supprimer la ligne sélectionnée du modèle de table
                
                j.supprimertableaux(nbree);
                this.tt.model.removeRow(this.tt.table.getSelectedRow());
                //this.tt.table.removeAll();
                //this.tt.model=new DefaultTableModel(j.gettableaux(),g);
                //this.tt.table=new JTable(this.tt.model);
                JOptionPane.showMessageDialog(null, "Le suppresseion est effectue successivement");
                } catch (SQLException ex) {
                Logger.getLogger(suppression.class.getName()).log(Level.SEVERE, null, ex);
                }*/
               } catch (SQLException ex) {
                   Logger.getLogger(suppression.class.getName()).log(Level.SEVERE, null, ex);
               }
                           }
        }
        }
     }
}