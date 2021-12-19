/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB.capteurtemperature;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.media.j3d.*;
/**
 *
 * @author zineb
 */

// Classe de label clignotant en utilisant 
// alternativement la couleur par défaut du label 
// et une autre couleur passée au constructeur 
public class Mainn extends JLabel
{  
  Color defaultColor;   // Couleur par défaut du label
  Color blinkingColor;  // Couleur de clignotement
  Timer timer;          // Timer déclenchant des tics
 
  // Constructeur 
  public Mainn(String text, Color  blinkingColor) 
  {	
    super (text);    
    this.blinkingColor = blinkingColor;
    this.defaultColor  = getForeground ();
 
    // Création et lancement du timer
    timer = createTimer ();
    timer.start ();
  }
  
  // Méthode renvoyant un timer prêt à démarrer
  private Timer createTimer ()
  {
    // Création d'une instance de listener 
    // associée au timer
    ActionListener action = new ActionListener ()
      {
        // Méthode appelée à chaque tic du timer
        public void actionPerformed (ActionEvent event)
        {
          // Inversion de la couleur
          if (getForeground ().equals (defaultColor))            
            setForeground (blinkingColor);
          else
            setForeground (defaultColor);
        }
      };
      
    // Création d'un timer qui génère un tic
    // chaque 500 millième de seconde
    return new Timer (500, action);
  }  
  
  // Méthode main () d'exemple de mise en oeuvre.
  // Utilisation : java BlinkingLabel
  public static void main (String [] args)
  {
    // Création de deux labels
    JLabel label1 = new Mainn ("Label 1", Color.blue);
    JLabel label2 = new Mainn ("Label 2", Color.red.darker ());
    
    // Ajout des labels à une fenêtre d'exemple
    JFrame frame = new JFrame ("Exemple");
    frame.getContentPane ().setLayout (new GridLayout (2, 1, 5, 5));
    frame.getContentPane ().add (label1);
    frame.getContentPane ().add (label2);
    frame.pack ();
    frame.show ();
    frame.setVisible(true);
  }
}