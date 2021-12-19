/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB.capteurtemperature;
 import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import museeiot.tablehuminf;
import museeiot.tables;
/**
 *
 * @author zineb
 */

   

public class cadresIoT extends JPanel{

 public cadresIoT(){
  
    JFrame f = new JFrame("BorderFactoryExemple");
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.setVisible(true);
    f.setLocationRelativeTo(null);
    JPanel panel = new JPanel();
    
   JLabel label = new JLabel("       ");
    label.setPreferredSize(new Dimension(400, 400));
    panel.add(label);
    panel.setPreferredSize(new Dimension(200,125));
    //créer une bordure de trait noir et largeur minimale 1
    Border lineborder = BorderFactory.createLineBorder(Color.black, 2); 
    //associer à JLabel
    label.setBorder(lineborder);
    label.setOpaque(true);
label.setBackground(Color.BLUE);
  //  f.getContentPane().setLayout(new BorderLayout());
   // f.add(new JLabel("Bonjour"), BorderLayout.NORTH);
    //adjuster au centre
   // f.add(panel, BorderLayout.CENTER);
    JLabel jkl=new JLabel("holaa");
   // f.add(jkl,BorderLayout.EAST);
    f.setSize(500,600);
    String[][] nn={{"0","1"},{"1","1"}};
    String[] g={"Humidite","Infragouge"," "};
    DefaultTableModel model = new DefaultTableModel(nn,g);
      JTable table=new JTable(model);
      table.setDefaultRenderer(Object.class, new tablehuminf());
    f.add(table,BorderLayout.WEST);
 }
 public static void main(String[] args) {
  new cadresIoT();
 }
}

