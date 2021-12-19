/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package museeiot;
import java.net.*;
import java.lang.*;
import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author zineb
 */
public class basemusee extends JFrame implements ActionListener{
    private JButton tableau;
    private JButton  bijoux;
    private JButton costume;
    private JButton sculpture;
    private JPanel p1;
    private JPanel p2;
    public basemusee(){
        
        tableau=new JButton("TABLEAUX");
        bijoux=new JButton("BIJOUX");
        costume=new JButton("COSTUME");
        sculpture=new JButton("SCULPTURE");
        tableau.addActionListener(this);
        bijoux.addActionListener(this);
        costume.addActionListener(this);
        sculpture.addActionListener(this);
        setTitle("Base de donnee");
       p1=new JPanel();
       p1.setLayout(new GridLayout(3,2));
       p1.add(bijoux);
       p1.add(costume);
       p1.add(sculpture);
       p1.add(tableau);
       add(p1,BorderLayout.WEST);
       setDefaultCloseOperation(3);
       setSize(600,500);
      //pack();
      setVisible(true);
      //setResizable(false);
      setLocationRelativeTo(null);
    
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            Tableau j1=new Tableau();
            Bijoux j2=new Bijoux();
            Sculpture j3=new Sculpture();
            Costume j4=new Costume();
            JPanel p2=new JPanel();
            CardLayout t=new CardLayout(300,300);
            p2.setLayout(t);
            p2.add(j1,"Tableauv");
            p2.add(j2,"Bijouxv");
            p2.add(j3,"Sculpturev");
            p2.add(j4,"Costumev");
            add(p2,BorderLayout.CENTER);
            if(e.getSource()==tableau){
                t.show(p2, "Tableau");
            }
            if(e.getSource()==bijoux){
                //((CardLayout)getLayout()).show(this, "Bijoux");
                t.show(p2, "Bijoux");
            }
            if(e.getSource()==costume){
                //((CardLayout)getLayout()).show(this, "Costume");
                t.show(p2, "Costume");
            }
            if(e.getSource()==sculpture){
                //((CardLayout)getLayout()).show(this, "Sculpture");
                t.show(p2, "Sculpture");
            }
        } catch (SQLException ex) {
            Logger.getLogger(basemusee.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
