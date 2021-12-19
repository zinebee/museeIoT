/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

/**
 *
 * @author zineb
 */
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.table.*;
public class DeleteRow extends JFrame implements ActionListener{
    JTable table;
    JButton btn;
   DefaultTableModel tablemodel;
    String[] columns;
   Object[][] rows;
   
   public DeleteRow() throws SQLException 
   {
      setTitle("Supprimer une ligne selectionnee");
      columns = new String[]{"ID","Titre","Description","capteur1","capteur2"};
      
      CRUD_TABLEAU j=new CRUD_TABLEAU();
      rows = new Object[][] {
            {"0001", "Alex"}, 
            {"0002", "Bob"}, 
            {"0003", "Thomas"}, 
            {"0004", "Yohan"},
            {"0005", "Juliette"},
            {"0006", "Emily"}
      };
      Object[][] rowss=j.gettableaux();
      tablemodel = new DefaultTableModel(rowss, columns);
      table = new JTable(tablemodel);
      table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
      btn = new JButton("Supprimer");
    
      btn.addActionListener(this);
      add(new JScrollPane(table), BorderLayout.CENTER);
      add(btn, BorderLayout.SOUTH);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setSize(500, 700);
      setLocationRelativeTo(null);
      setVisible(true);
   }
   

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(table.getSelectedRow() != -1) 
            { 
            try {
                // supprimer la ligne sélectionnée du modèle de table
                tablemodel.removeRow(table.getSelectedRow());
                CRUD_TABLEAU j=new CRUD_TABLEAU();
                String[] g={"ID","Titre","Description","capteur1","capteur2"};
                int row=this.table.getSelectedRow();
                String dd=(String)this.table.getValueAt(row, 0);
                int nbre=Integer.parseInt(dd);
                j.supprimertableaux(nbre);
                JOptionPane.showMessageDialog(null, "Deleted successfully");
            } catch (SQLException ex) {
                Logger.getLogger(DeleteRow.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
         }
        }

