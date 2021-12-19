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
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import static museeiot.direclogin.yy;
/**
 *
 * @author zineb
 */
public class login extends JFrame implements ActionListener,Runnable{
    public static int yy=0;
    public static int ty=0;
    private JTextField tLogin;
     private JPasswordField tPassword;
     private JButton envoi;
    public login(){
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
      envoi.addActionListener(this);
      add(panneau);
      setDefaultCloseOperation(3);
      pack();
      setVisible(true);
      setResizable(false);
      setLocationRelativeTo(null);
    
    }
    public JButton getenvoi(){
       return this.envoi;
    }
    public String getlogin(){
        String loginn=tLogin.getText();
    return loginn;
    }
    public String getppassword(){
      char[] rabpassword=tPassword.getPassword();
      String passwordd=new String(rabpassword);
       return passwordd;
    }
    public boolean authetification(){
       String a=this.getlogin();
       String b=this.getppassword();
       if(a.equals("vo") && b.equals("vo")){
         return true;
       }else{
         return false;
       }
    
    }

    @Override
    public void actionPerformed(ActionEvent e) {
          Thread y=new Thread(this);
        y.start();
    }

    @Override
    public void run(){
        //int yy=0;
        try {
            //int u;
           // String lp=this.getlogin()+"-"+this.getppassword();
            Socket r=new Socket("127.0.0.1",1000);
            ObjectInputStream oin ;
            ObjectOutputStream oos;
        while(true && yy<3){
            
            oos = new ObjectOutputStream(r.getOutputStream());
            oin = new ObjectInputStream(r.getInputStream());
            
            directeur direct = new directeur(this.getlogin(),this.getppassword());
            
            //On envoie l'objet
            oos.writeObject(direct);
            int res1=lire(oin);
            System.out.println(res1);
            //if(res1!=0){
             if(this.getlogin().equals("mouna") && this.getppassword().equals("zineb")){   
               Cartesadmin k=new Cartesadmin();
               k.setVisible(true);
              yy=4;
              
              //r.close();
              System.out.println("mzn"+res1);
              break;
            }else{
                yy++;
              
                this.setVisible(false);
              login me=new login();
              
             
            }
            
            //On ferme la socket (client)
            System.out.println(yy);
        }
        if(yy==2){
            //this.setVisible(false);
         // System.out.println("les donnees sont incorrecte");
          //r.close();
        }
        } catch (IOException ex) {
         
        } catch (SQLException ex) {
            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    public synchronized int lire(ObjectInputStream oin){
        int comp=0;
        try {
            
            Integer entier=(Integer)oin.readObject();
            int f=entier.intValue();
            System.out.println(f);
            comp=f;
        } catch (IOException ex) {
            Logger.getLogger(direclogin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(direclogin.class.getName()).log(Level.SEVERE, null, ex);
        }
        return comp;
    }
}
