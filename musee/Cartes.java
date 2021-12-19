/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package museeiot;

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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

/**
 *
 * @author zineb
 */
public class Cartes extends JFrame implements ActionListener {
 JButton bijoux = new JButton("Bijoux");
 JButton costume = new JButton("Costume");
 JButton sculpture = new JButton("Sculpture");
 JButton tableau = new JButton("Tableau");
 JButton Directeurs=new JButton("Directeurs");
 CardLayout gestionnaireDesCartes = new CardLayout();
 JPanel jeuCartes = new JPanel();

 public Cartes() {
     try {
         JPanel p = new JPanel();
         //JTextArea zone = new JTextArea("Vous pouvez ecrie ici.");
         //JLabel message = new JLabel("Bonjour", SwingConstants.CENTER);
         VoirCercle voirCercle = new VoirCercle();
         Tableau j1=new Tableau();
         Bijoux j2=new Bijoux();
         Sculpture j3=new Sculpture();
         Costume j4=new Costume();
         directors d1=new directors();
         jeuCartes.setLayout(gestionnaireDesCartes);
         jeuCartes.setPreferredSize(new Dimension(800, 900));
         //jeuCartes.add(zone, "zone");
         jeuCartes.add(j1,"Tableauv");
         jeuCartes.add(j2, "Bijoux");
         jeuCartes.add(j3, "Sculpture");
         jeuCartes.add(j4, "Costume");
         jeuCartes.add(d1, "directeur");
         //jeuCartes.add(voirCercle, "voir un cercle");
         //message.setOpaque(true);
         //jeuCartes.add(message, "message");
         add(jeuCartes, BorderLayout.CENTER);
         tableau.addActionListener(this);
         bijoux.addActionListener(this);
         costume.addActionListener(this);
         sculpture.addActionListener(this);
         Directeurs.addActionListener(this);
         p.setLayout(new GridLayout(3,2));
         p.add(bijoux);
         p.add(costume);
         p.add(sculpture);
         p.add(tableau);
         p.add(Directeurs);
         add(p,BorderLayout.WEST);
//setLocationRelativeTo(null);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setSize(300, 250);
setVisible(true);
pack();
     } catch (SQLException ex) {
         Logger.getLogger(Cartes.class.getName()).log(Level.SEVERE, null, ex);
     }
 } 
 
 public void actionPerformed(ActionEvent e) {
 Object obj = e.getSource();

 if (obj == tableau) {
	gestionnaireDesCartes.show(jeuCartes,"Tableauv");
}
else if (obj == bijoux) {
	gestionnaireDesCartes.show(jeuCartes,"Bijoux");
}else if (obj == costume) {
	gestionnaireDesCartes.show(jeuCartes,"Costume");
}else if (obj == sculpture) {
	gestionnaireDesCartes.show(jeuCartes,"Sculpture");
}else if (obj == Directeurs) {
	gestionnaireDesCartes.show(jeuCartes,"directeur");
}

}
}