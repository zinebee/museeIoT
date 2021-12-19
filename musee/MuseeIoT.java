/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package museeiot;
import java.sql.*;
import java.util.*;
import java.lang.*;
import java.net.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author zineb
 */
public class MuseeIoT implements Runnable{
    /**
     * @param args the command line arguments
     */
    public int authetification(String a,String b) throws SQLException{
       // int id=0;
       String classname="com.mysql.cj.jdbc.Driver";
         try{
             Class.forName(classname);
             }catch(ClassNotFoundException ex){
           System.out.println("driver failed to load");
    }

         //Class.forName("com.mysql.cj.jdbc.Driver");   
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/museeIoT","root","root1234ROOT");
       Connection con1=DriverManager.getConnection("jdbc:mysql://localhost:3306/museeIoT","root","root1234ROOT");
        Statement stmt;
        stmt = con.createStatement();
        //String lk="SELECT * FROM utilisateur WHERE login = '"+lkk[0]+"' AND password = '"+lkk[1]+"'";
        String requete="SELECT idd,logind,passwordd,idsalle FROM directeurs WHERE logind = '"+a+"' AND passwordd= '"+b+"'";
        ResultSet rs=stmt.executeQuery(requete);
        Statement stmt1;
        stmt1 = con1.createStatement();
        //String lk="SELECT * FROM utilisateur WHERE login = '"+lkk[0]+"' AND password = '"+lkk[1]+"'";
        String requetee="SELECT id,login,password FROM administrateur WHERE login = '"+a+"' AND password= '"+b+"'";
        ResultSet rs1=stmt1.executeQuery(requetee);
        if(rs1.next()){
              return 5;
            }
        while(rs.next()){
            return rs.getInt("idsalle");
           }
        con.close();
        con1.close();
       return 0;
    
    }
    
    public static void main(String[] args) throws SQLException {
        
            // TODO code application logic here
            /*  Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mediatheque?zeroDateTimeBehavior=CONVERT_TO_NULL [root on Default schema]","root","root1234ROOT");
            Statement stmt;
            stmt = con.createStatement();
            ResultSet rs=stmt.executeQuery("SELECT * FROM client");
            while(rs.next()){
            System.out.println(rs.getString("*"));
            }
           
            con.close();*/
            //login z=new login();
             Acceuil d=new Acceuil();
             MuseeIoT muse=new MuseeIoT();
             Thread m=new Thread(muse);
             m.start();
            
            
          
        
    }

    @Override
    public void run(){
        
        try {
            ServerSocket t;
            
            t = new ServerSocket(1000);
        int comp=0;
            while(true){
                
                Socket client=t.accept();
                
                ObjectInputStream oin = new ObjectInputStream(client.getInputStream());
                ObjectOutputStream oos = new ObjectOutputStream(client.getOutputStream());

                //On lit l'objet que le client envoie
                directeur product = (directeur) oin.readObject();
                String a=product.getLogin();
                String b=product.getPassword();
                int resultat=this.authetification(a,b);
                Integer Res=new Integer(resultat);
                oos.writeObject(Res);
                System.out.println(product);
                comp++;
            
            }
        } catch (IOException ex) {
            Logger.getLogger(MuseeIoT.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MuseeIoT.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(MuseeIoT.class.getName()).log(Level.SEVERE, null, ex);
        }

}
}
