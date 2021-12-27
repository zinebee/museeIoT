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
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.EventObject;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.CellEditorListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author zineb
 */
public class modifdirecteur implements TableCellRenderer, TableCellEditor {
	//test3
   JButton btn;
   JButton btn2;
   int row;
  public modifdirecteur(JTable table) {
    btn = new JButton("Modifier");
    btn.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
          //DefaultTableModel model = (DefaultTableModel) table.getModel();
          //Object[][] data =null;
          //System.out.println("vous avez clique sur  "+table.getValueAt(row, 0));
          //int gg=table.getSelectedRow();
          //System.out.println(gg);
          JFrame f1=new JFrame();
          f1.setVisible(true);
          JLabel ii1=new JLabel("Description");
          JTextField i1=new JTextField();
         // JLabel ii2=new JLabel("Titre");
          //JTextField i2=new JTextField();
          f1.setLayout(new GridLayout(3,2));
          JButton submit=new JButton("Modifier");
          f1.add(ii1);
          f1.add(i1);
         // f1.add(ii2);
          //f1.add(i2);
          f1.add(submit);
          f1.pack();
          f1.setTitle("Modification");
          f1.setLocationRelativeTo(null);
          submit.addActionListener(new ddfdirecteur(i1,submit,table));
          //  model.addRow(data);
          //String dd=(String)table.getValueAt(row, 0);
//              int ddD=(int)table.getValueAt(row, 0);
//int nbre=Integer.parseInt(dd);
//CRUD_TABLEAU hh=new CRUD_TABLEAU();

// hh.supprimertableaux(nbre);
//System.out.println(nbre);
//System.out.println(hh.gettitreseul(nbre));
//model.removeRow(row);
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

class ddfdirecteur implements ActionListener{
JTextField i1;
JTextField i2;
JButton submit;
JTable table;
public ddfdirecteur(JTextField i1,JButton submit,JTable table){
 this.i1=i1;
//this.i2=i2;
this.table=table;
this.submit=submit;

}
    @Override
    public void actionPerformed(ActionEvent ae) {
      if(ae.getSource()==this.submit){
          int gg=table.getSelectedRow();
           CRUD_DIRECTEUR hj=new CRUD_DIRECTEUR();
           Object o=this.table.getValueAt(gg, 0);
           String ftf=(String)o;
           int fh=Integer.parseInt(ftf);
           String nbv=this.i1.getText();
          int  u=hj.modifiertableaux(nbv,fh);
          System.out.println("Le u= "+u);
          if(u==1){
           table.setValueAt(this.i1.getText(),gg,1);
          }
          //this.setVisible(false);
          String gf=this.i1.getText()+"vous avez clique sur  "+table.getValueAt(gg, 0);
          //JOptionPane.showMessageDialog(null, gf, "ERREUR",JOptionPane.ERROR_MESSAGE);
                
        
      }    
    
    }



}
