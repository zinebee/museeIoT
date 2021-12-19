/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package museeiot;

import DB.CRUD_TABLEAU;
import DB.receptiontableau;
import DB.serveurtemperature;
import java.awt.Desktop;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import net.contentobjects.jnotify.JNotify;
/**
 *
 * @author zineb
 */
public class notif {
   public static void main(String[] args) throws SQLException{
      //Thread g=new Thread(new serveurtemperature());
      //g.start();
      //Thread h=new Thread(new receptiontableau());
      //h.start();
       /* CRUD_TABLEAU fg=new CRUD_TABLEAU();
       String fich="../../Desktop/Tableau/ctemp/"+fg.gettitreseul(79)+"t.txt";
        File h=new File(fich);
        if(h.delete()){
        JOptionPane.showMessageDialog(null, "Le fichier est supprime");
        }*/
       JFrame hh=new JFrame();
       hh.setVisible(true);
       JButton y=new JButton("ok");
        hh.add(y);
        
   }
}
