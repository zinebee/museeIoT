/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package museeiot;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author zineb
 */
public class connexion extends JFrame {
    private JTextField tLogin;
     private JPasswordField tPassword;
     private JButton envoi;
    public connexion(){
    setTitle("Coordonnee");
      JPanel panneau=new JPanel();
      panneau.setLayout(new BoxLayout(panneau,BoxLayout.Y_AXIS));
      JLabel eLogin=new JLabel("Login");
      panneau.add(eLogin);
      tLogin=new JTextField(30);
      panneau.add(tLogin);
      JLabel epassword=new JLabel("Password");
      panneau.add(epassword);
      tPassword=new JPasswordField(30);
      tPassword.setEchoChar('#');
      panneau.add(tPassword);
      envoi=new JButton("Submit");
      panneau.add(envoi);
      //envoi.addActionListener(this);
      add(panneau);
      setDefaultCloseOperation(3);
      pack();
      setVisible(true);
      setResizable(false);
      setLocationRelativeTo(null);
    }
}
