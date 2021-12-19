/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import museeiot.directeur;

/**
 *
 * @author zineb
 */
public class CRUD_DIRECTEUR {
    public int getlastline() throws SQLException{
    int r=0;
    String classname="com.mysql.cj.jdbc.Driver";
         try{
             Class.forName(classname);
             }catch(ClassNotFoundException ex){
           System.out.println("driver failed to load");
    }

         //Class.forName("com.mysql.cj.jdbc.Driver");   
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/museeIoT","root","root1234ROOT");
       
        Statement stmt;
        stmt = con.createStatement();
        ResultSet rs=stmt.executeQuery("SELECT MAX(idd) as ui FROM directeurs");
        while(rs.next()){
            r=rs.getInt("ui");
         // System.out.println(rs.getInt("id"));
    }
        con.close();
    return r;
    
    }
    public int Ajouterdirecteur(directeur t){
         
    int rs=0;
        try {
            String classname="com.mysql.cj.jdbc.Driver";
            
            Class.forName(classname);
            //Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/museeIoT","root","root1234ROOT");
            
            Statement stmt;
            stmt = con.createStatement();
            String requete="INSERT INTO directeurs(logind,Passwordd) VALUES('"+t.getLogin()+"' ,'"+t.getPassword()+"')";
             rs=stmt.executeUpdate(requete);
            
            con.close();
            
            return rs;
        } catch (ClassNotFoundException ex) {
           // Logger.getLogger(CRUD_TABLEAU.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
           
            Logger.getLogger(CRUD_DIRECTEUR.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        return rs;
    }
    public int getlignes() throws SQLException{
        
    String classname="com.mysql.cj.jdbc.Driver";
         try{
             Class.forName(classname);
             }catch(ClassNotFoundException ex){
           System.out.println("driver failed to load");
    }

         //Class.forName("com.mysql.cj.jdbc.Driver");   
        Connection conA=DriverManager.getConnection("jdbc:mysql://localhost:3306/museeIoT","root","root1234ROOT");
       
        Statement stmtA;
        stmtA = conA.createStatement();
        
        ResultSet rs=stmtA.executeQuery("SELECT COUNT(*) as count FROM directeurs");
        
        int i=0;
        while(rs.next()){
          i=rs.getInt("count");
        }
        conA.close();
        return i;
    }
  public String[][] gettableaux() throws SQLException{
       String classname="com.mysql.cj.jdbc.Driver";
         try{
             Class.forName(classname);
             }catch(ClassNotFoundException ex){
           System.out.println("driver failed to load");
    }

         //Class.forName("com.mysql.cj.jdbc.Driver");   
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/museeIoT","root","root1234ROOT");
       
        Statement stmt;
        stmt = con.createStatement();
        
        ResultSet rs=stmt.executeQuery("SELECT * FROM directeurs");
        int size=this.getlignes();
       // System.out.println(size);
        String[][] donnee=new String[size][3];
        System.out.println(donnee.length);
        int compteur=0;
        
        
        while(rs.next()){
            donnee[compteur][0]=rs.getString("idd");
            donnee[compteur][1]=rs.getString("logind");
             donnee[compteur][2]=rs.getString("Passwordd");
              
               compteur++;
           // System.out.println(donnee[compteur][2]);
                    
         //System.out.println(donnee[compteur][3]);
          //System.out.println(rs.getString("Titre")+"|"+rs.getString("Description")+"|"+rs.getString("capteur1")+"|"+rs.getString("capteur2"));
          
    }
       con.close();
       
       return donnee;

} 
  public void supprimertableaux(int dd) throws SQLException{
        String classname="com.mysql.cj.jdbc.Driver";
         try{
             Class.forName(classname);
             }catch(ClassNotFoundException ex){
           System.out.println("driver failed to load");
    }
         
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/museeIoT","root","root1234ROOT");
       
        Statement stmt;
        stmt = con.createStatement();
        String requete="DELETE FROM directeurs WHERE idd='"+dd+"'";
        int rs=stmt.executeUpdate(requete);
       
        
        
    con.close();
    }
  public int modifiertableaux(String temp,int tt){
        int rs=0;
         try{
             String classname="com.mysql.cj.jdbc.Driver";
             try{
                 Class.forName(classname);
             }catch(ClassNotFoundException ex){
                 System.out.println("driver failed to load");
             }
             
             //Class.forName("com.mysql.cj.jdbc.Driver");
             Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/museeIoT","root","root1234ROOT");
             
             Statement stmt;
             stmt = con.createStatement();
             String requete="UPDATE directeurs SET  logind='"+temp+"' WHERE idd='"+tt+"'";
             rs=stmt.executeUpdate(requete);
             System.out.println("La resultat de la modification est "+rs);
             con.close();
             
         }catch(SQLException ex){
            Logger.getLogger(CRUD_TABLEAU.class.getName()).log(Level.SEVERE, null, ex);
    }
    return rs;
    }
}
