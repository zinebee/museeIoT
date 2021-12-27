/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package museeiot;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
/**
 *
 * @author zineb
 */
public class VoirCercle extends JPanel implements ActionListener { 
 JButton bouton1 = new JButton("trace");
 JButton bouton2 = new JButton("efface");
 boolean disque = false;

 VoirCercle() {
 bouton1.setActionCommand("tracer");
 bouton2.setActionCommand("effacer");
 add(bouton1);
 add(bouton2);
 bouton1.addActionListener(this);
 bouton2.addActionListener(this);
 setBackground(Color.CYAN);
 }
 
 public void paintComponent(Graphics g) {
 super.paintComponent(g);
 if (disque) g.setColor(Color.RED);
 else g.setColor(Color.CYAN);
 g.fillOval(100, 50, 100, 100);
 }

 public void actionPerformed(ActionEvent e) {
 String commande = e.getActionCommand();

 if (commande.equals("tracer")) disque = true;
 else if (commande.equals("effacer")) disque = false;
 repaint();
 }
}


class EssaiCartes {
 /*public static void main(String[] arg) {
 new Cartes();
 }*/
    
}
