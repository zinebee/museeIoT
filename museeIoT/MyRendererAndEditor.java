/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.SQLException;
import java.util.EventObject;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.CellEditorListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author zineb
 */
public class MyRendererAndEditor implements TableCellRenderer, TableCellEditor {
   JButton btn;
   JButton btn2;
   int row;
  public MyRendererAndEditor(JTable table) {
    btn = new JButton("Supprimer");
    btn.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
          try {
              DefaultTableModel model = (DefaultTableModel) table.getModel();
              Object[][] data =null;
              //  model.addRow(data);
             String dd=(String)table.getValueAt(row, 0);
//              int ddD=(int)table.getValueAt(row, 0);
              int nbre=Integer.parseInt(dd);
              CRUD_TABLEAU hh=new CRUD_TABLEAU();
              
              hh.supprimertableaux(nbre);
              
              //System.out.println(nbre);
              //System.out.println(hh.gettitreseul(nbre));
              model.removeRow(row);
          } catch (SQLException ex) {
              Logger.getLogger(MyRendererAndEditor.class.getName()).log(Level.SEVERE, null, ex);
          }
      }
    });
  }
  @Override
  public Component getTableCellRendererComponent(JTable table, Object 
  value, boolean isSelected, boolean hasFocus, int row, int column) 
  { 
    return btn;
  }
  @Override
  public Component getTableCellEditorComponent(JTable table, Object 
  value, boolean isSelected, int row, int column) 
  {
    this.row = row;
    return btn;
  }
  @Override
  public Object getCellEditorValue() { return true; }
  @Override
  public boolean isCellEditable(EventObject anEvent) { return true; }
  @Override
  public boolean shouldSelectCell(EventObject anEvent) { return true; }
  @Override
  public boolean stopCellEditing() { return true; }
  @Override
  public void cancelCellEditing() {}
  @Override
  public void addCellEditorListener(CellEditorListener l) {}
  @Override
  public void removeCellEditorListener(CellEditorListener l) {}
}

