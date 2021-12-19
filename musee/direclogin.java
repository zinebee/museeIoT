/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package museeiot;

import DB.CRUD_BIJOUX;
import DB.CRUD_COSTUME;
import DB.CRUD_SCULPTURE;
import DB.CRUD_TABLEAU;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class direclogin extends JFrame implements ActionListener,Runnable{
    public static int yy=0;
    public static int ty=0;
    private JTextField tLogin;
     private JPasswordField tPassword;
     private JButton envoi;
    public direclogin(){
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
    

    @Override
    public void actionPerformed(ActionEvent e) {
        int u=1;
        Thread y=new Thread(this);
        y.start();
        
    }

    @Override
    public void run() {
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
            if(res1!=0){
                
                if(res1==1){
            //System.out.print("l3eeeeeez");
            this.setVisible(false);
            //Cartes r=new Cartes();
            CRUD_BIJOUX nn=new CRUD_BIJOUX();
            Bijouxd f=new Bijouxd(nn.gettableaux());
            f.setVisible(true);
        }
        if(res1==2){
            this.setVisible(false);
            //Cartes r=new Cartes();
            CRUD_COSTUME nn=new CRUD_COSTUME();
            Costumed f=new Costumed(nn.gettableaux());
             f.setVisible(true);
        }
        if(res1==3){
            this.setVisible(false);
            //Cartes r=new Cartes();
             CRUD_SCULPTURE hh=new CRUD_SCULPTURE();
            Sculptured f=new Sculptured(hh.gettableaux());
             f.setVisible(true);
        }
        if(res1==4){
            this.setVisible(false);
            //Cartes r=new Cartes();
            CRUD_TABLEAU hh=new CRUD_TABLEAU();
            Tableaud f=new Tableaud(hh.gettableaux());
             f.setVisible(true);
        }
              yy=4;
              
              //r.close();
              System.out.println("mzn"+res1);
              break;
            }else{
                yy++;
              
                this.setVisible(false);
              direclogin me=new direclogin();
              
             
            }
            
            //On ferme la socket (client)
            System.out.println("dd"+yy);
        }
        if(yy==2){
            //this.setVisible(false);
         // System.out.println("les donnees sont incorrecte");
          //r.close();
        }
        } catch (IOException ex) {
         
        } catch (SQLException ex) {
            Logger.getLogger(direclogin.class.getName()).log(Level.SEVERE, null, ex);
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
