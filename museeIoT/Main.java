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
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.event.CellEditorListener;
import java.awt.Component;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.EventObject;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
public class Main extends JFrame {
    JTable table;
    public Main() throws SQLException{
    //Header de JTable 
    /*String[] columns = new String[] {"Id","Nom","Adresse","Taux horaire"," "};
    //données pour JTable dans un tableau 2D
   
    CRUD_TABLEAU k=new CRUD_TABLEAU();
    String[][] gg=k.gettableaux();
    Object[][] data = new Object[][] {
        {1, "Thomas", "Paris", 20.0, " " },
        {2, "Jean", "Marseille", 50.0, " " },
        {3, "Yohan", "Lyon", 30.0, " " },
        {4, "Emily", "Toulouse", 60.0, " " },
        {5, "Alex", "Nice", 10.0, " " },
    };
    //définir le modéle de JTable
    DefaultTableModel model = new DefaultTableModel(gg, columns);
    //crée un JTable avec des données
    JTable table = new JTable(model);
    //définir notre Renderer sur la colonne " "
    
    table.getColumn(" ").setCellRenderer(new MyRendererAndEditor(table));
    table.getColumn(" ").setCellEditor(new MyRendererAndEditor(table));
    JInternalFrame f = new JInternalFrame("xx",true,true,true,true);
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.getContentPane().add(new JScrollPane(table));
    f.setSize(500, 180);
    f.setVisible(true);
     //setResizable(true);
       //setClosable(true);
       //setMaximizable(true);
       //setIconifiable(true);
       //setTitle("SUPPRIMER");*/
    //Header de JTable 
    String[] columns = new String[] {"Id","Nom","Adresse","Taux horaire"," "};
    //données pour JTable dans un tableau 2D
   
    CRUD_TABLEAU k=new CRUD_TABLEAU();
    Object[][] gg=k.gettableaux();
    Object[][] data = new Object[][] {
        {1, "Thomas", "Paris", 20.0, " " },
        {2, "Jean", "Marseille", 50.0, " " },
        {3, "Yohan", "Lyon", 30.0, " " },
        {4, "Emily", "Toulouse", 60.0, " " },
        {5, "Alex", "Nice", 10.0, " " },
    };
    //définir le modéle de JTable
    DefaultTableModel model = new DefaultTableModel(gg, columns);
    //crée un JTable avec des données
    String[] hh=null;
    //model.addRow(hh);
    table = new JTable(model);
    //définir notre Renderer sur la colonne " "
    
    table.getColumn(" ").setCellRenderer(new MyRendererAndEditorr(table));
    table.getColumn(" ").setCellEditor(new MyRendererAndEditorr(table));
    JFrame f = new JFrame();
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.getContentPane().add(new JScrollPane(table));
    f.setSize(500, 180);
    f.setVisible(true);
    }
  public static void main(String[] args) throws SQLException 
  {  
    new Main();
  }

   
    
}
class MyRendererAndEditorr implements TableCellRenderer, TableCellEditor 
{
  private JButton btn;
  private int row;
  MyRendererAndEditorr(JTable table) {
    btn = new JButton("Supprimer");
    btn.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
          try {
              DefaultTableModel model = (DefaultTableModel) table.getModel();
              Object[][] data =null;
              //  model.addRow(data);
              String dd=(String)table.getValueAt(row, 0);
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