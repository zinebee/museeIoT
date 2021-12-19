/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package museeiot;

import DB.CRUD_TABLEAU;
import DB.Main;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JToolBar;

/**
 *
 * @author zineb
 */
public class menutableau extends JFrame implements ActionListener{
JButton Ajouter = new JButton("Ajouter Tableau");
 JButton Supprimer = new JButton("Supprimer");
 JButton Modifier = new JButton("Modifier");
 JDesktopPane kk;
 public menutableau() throws SQLException{
     kk=new JDesktopPane();
     setLocationRelativeTo(null);
     JInternalFrame gh=new JInternalFrame("menu",false,false,false,false);
     gh.setVisible(true);
     gh.setSize(700,80);
     gh.setLocation(0,0);
     setVisible(true);
     JToolBar df=new JToolBar();
     df.add(Ajouter);
     df.add(Supprimer);
     df.add(Modifier);
     JPanel jj=new JPanel();
     jj.setSize(900, 100);
     jj.setLayout(new GridLayout(1,3));
     jj.add(Ajouter);
     jj.add(Supprimer);
     jj.add(Modifier);
     gh.add(jj);
     kk.setLocation(0, 0);
     kk.setSize(700,700);
     //kk.setLayout(new BorderLayout());
     kk.add(gh);
     add(kk);
     Ajouter.addActionListener(this);
     Supprimer.addActionListener(this);
     Modifier.addActionListener(this);
     
     //CRUD_TABLEAU j=new CRUD_TABLEAU();
     //Tableaud ff=new Tableaud(j.gettableaux());
     //kk.add(ff);
     setLocationRelativeTo(null);
     setSize(700,700);
 }
 public static void main(String[] args) throws SQLException{
    
  menutableau u=new menutableau();
  u.setDefaultCloseOperation(3);
  u.setLocationRelativeTo(null);
 }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Tableaud ff=null;
        Main g=null;
       if(ae.getActionCommand().equals("Ajouter Tableau") && ae.getSource()==Ajouter){
           try {
               
               CRUD_TABLEAU j=new CRUD_TABLEAU();
                new Tableaud(j.gettableaux());
                //ff.toFront();
               kk.add(ff);
           } catch (SQLException ex) {
               Logger.getLogger(menutableau.class.getName()).log(Level.SEVERE, null, ex);
           }
       }
        if(ae.getActionCommand().equals("Supprimer") && ae.getSource()==Supprimer){
            try {
                if(ff !=null){
                    ff.setVisible(false);
                    ff=null;
                    kk.remove(ff);
                    ff.hide();
                    
                }
                g=new Main();
                g.toFront();
               // g.setVisible(true);
                kk.add(g);
            } catch (SQLException ex) {
                Logger.getLogger(menutableau.class.getName()).log(Level.SEVERE, null, ex);
            }
       }
        if(ae.getActionCommand().equals("Modifier")){
          System.out.println("vous avez clique qur le bouton modifier");
        }
    }
}
