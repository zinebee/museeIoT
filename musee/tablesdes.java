/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package museeiot;

/**
 *
 * @author zineb
 */
import DB.capteurtemperature.SimpleAudioPlayer;
import java.awt.Color;
import java.awt.Component;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import static javax.swing.SwingConstants.CENTER;
import static javax.swing.SwingConstants.RIGHT;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author zineb
 */
public class tablesdes extends DefaultTableCellRenderer {
 
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        /**
         * Fixer la couleur de fond de la première colonne en jaune
         */
        
        if (column == 3) {
            Color clr = new Color(239, 239, 239);
            component.setBackground(clr);
           Object o = table.getValueAt(row, 3);
           
            String ff=(String)o;
            if(ff!=null){
            if(!ff.isEmpty()){
            double convertir=Double.parseDouble(ff);
            if(convertir>20.0){
            Color clrA = new Color(239, 239, 239);
                component.setBackground(clrA);
                //SimpleAudioPlayer hh=new SimpleAudioPlayer();
            }
            } 
            }
        } else {
            if(column==4){
                
        Color clrX = new Color(239, 239, 239);
            component.setBackground(clrX);
        }
            Color clr = new Color(239, 239, 239);
            component.setBackground(clr);
        }
        /**
         * Colorier les cellules en orange si le montant est négatif
         */
        Object o = table.getValueAt(row, 4);
        System.out.println(o);
       // Object o = table.getColumn(3);
        if (o != null && component instanceof JLabel) {
            JLabel label = (JLabel) component;
            
            if (label.getText().equals("oui")){
              //  Color clr = new Color(253, 63, 1);
               // component.setBackground(clr);
               Color clrA = new Color(239, 239, 239);
                component.setBackground(clrA);
                
            }else{
                if(column==4){
              Color clr = new Color(239, 239, 239);
            component.setBackground(clr);
                }
            }
            //double convertir=Double.parseDouble(label.getText());
            //System.out.println("fadila "+convertir);
       /* Object o = table.getValueAt(row, 3);
        String te=(String) o;
        //System.out.println("Voici o :"+te);
        
        if (o != null && component instanceof JLabel) {
            JLabel label = (JLabel) component;
            String mons=label.getText();
            boolean dd=!(mons.isEmpty() && te.isEmpty());
            //System.out.println("Le voici : "+mons);
            //double str1 = Double.valueOf(mons); 
            if(dd){
            double convertir=Double.parseDouble(te);
            if (convertir > 20.0){
                Color clr = new Color(253, 63, 1);
                component.setBackground(clr);
            }
            }*/
            /**
             * Center le texte pour la colonne 0 et aligner le texte à droite pour les autres colonnes
             */
            if (column == 0) {
                label.setHorizontalAlignment(CENTER);
            } else {
                label.setHorizontalAlignment(RIGHT);
            }
        }
        return component;
    }
}
 