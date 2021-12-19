/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import museeiot.Tableaud;
import museeiot.formulaire;

/**
 *
 * @author zineb
 */
public class CRUD_TABLEAU implements Runnable{
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
        ResultSet rs=stmt.executeQuery("SELECT MAX(id) as ui FROM Tableau");
        while(rs.next()){
            r=rs.getInt("ui");
         // System.out.println(rs.getInt("id"));
    }
        con.close();
    return r;
    
    }
    public String getlastline1() throws SQLException{
    String r="";
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
        ResultSet rs=stmt.executeQuery("SELECT MAX(id) FROM Tableau");
        while(rs.next()){
            r=rs.getString("id");
         // System.out.println(rs.getInt("id"));
    }
        con.close();
    return r;
    
    }
    public int Ajoutertableaux(Tableaud t){
         
        int rs=0;
        try {
            String classname="com.mysql.cj.jdbc.Driver";
            
            Class.forName(classname);
            //Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/museeIoT","root","root1234ROOT");
            
            Statement stmt;
            stmt = con.createStatement();
            String requete="INSERT INTO Tableau(Titre,Description,capteur1,capteur2) VALUES('"+t.getTitre()+"' ,'"+t.getDescription()+"' , '"+t.getC1()+"' , '"+t.getC2()+"')";
             rs=stmt.executeUpdate(requete);
            
            con.close();
            String fich="../../Desktop/Tableau/ctemp/"+t.getTitre()+"t.txt";
            File fichier=new File(fich);
            FileWriter fileWriter = new FileWriter(fichier);
            String c1=String.valueOf(t.getC1());
            fileWriter.write(c1);
             fileWriter.write("\n");
              fileWriter.close();
              //proximite
              String fich1="../../Desktop/Tableau/cpro/"+t.getTitre()+"p.txt";
            File fichier1=new File(fich1);
            FileWriter fileWriter1 = new FileWriter(fichier1);
            String c11=String.valueOf(t.getC1());
            fileWriter1.write("non");
             fileWriter1.write("\n");
              fileWriter1.close();
              //proximite
            if (fichier.createNewFile())
                System.out.println("File created");
            else
                System.out.println("File already exists");
            return rs;
        } catch (ClassNotFoundException ex) {
           // Logger.getLogger(CRUD_TABLEAU.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
           
           // Logger.getLogger(CRUD_TABLEAU.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CRUD_TABLEAU.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        return rs;
    }
    public String gettitreseul(int ff) throws SQLException{
        String t="";
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
        String requete="SELECT Titre FROM Tableau WHERE id='"+ff+"'";
        ResultSet rs=stmt.executeQuery(requete);
        while(rs.next()){
            t=rs.getString("Titre");
          //System.out.println(rs.getString("Titre"));
    }
        con.close();
    return t;
    }
    public void supprimertableaux(int dd) throws SQLException{
        String classname="com.mysql.cj.jdbc.Driver";
         try{
             Class.forName(classname);
             }catch(ClassNotFoundException ex){
           System.out.println("driver failed to load");
    }
        String fich="../../Desktop/Tableau/ctemp/"+this.gettitreseul(dd)+"t.txt";
        File h=new File(fich);
        String fich11="../../Desktop/Tableau/cpro/"+this.gettitreseul(dd)+"p.txt";
        File h12=new File(fich11);
        if(h.delete() && h12.delete()){
        JOptionPane.showMessageDialog(null, "Le fichier est supprime");
        }
         //Class.forName("com.mysql.cj.jdbc.Driver");   
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/museeIoT","root","root1234ROOT");
       
        Statement stmt;
        stmt = con.createStatement();
        String requete="DELETE FROM Tableau WHERE id='"+dd+"'";
        int rs=stmt.executeUpdate(requete);
       
        
        
    con.close();
    }
    public String[] getlistetitre() throws SQLException{
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
        
        ResultSet rs=stmt.executeQuery("SELECT * FROM Tableau");
        int size=this.getlignes();
       // System.out.println(size);
        String[] donnee=new String[size];
        System.out.println(donnee.length);
        int compteur=0;
        
        
        while(rs.next()){
            //donnee[compteur]=rs.getString("Titre").concat("t"+rs.getString("id"));
            donnee[compteur]=rs.getString("Titre").concat("t");
               compteur++;
           // System.out.println(donnee[compteur][2]);
                    
         //System.out.println(donnee[compteur][3]);
          //System.out.println(rs.getString("Titre")+"|"+rs.getString("Description")+"|"+rs.getString("capteur1")+"|"+rs.getString("capteur2"));
          
    }
       con.close();
       
       return donnee;

        
    }
    public String[] getlistetitrep() throws SQLException{
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
        
        ResultSet rs=stmt.executeQuery("SELECT * FROM Tableau");
        int size=this.getlignes();
       // System.out.println(size);
        String[] donnee=new String[size];
        System.out.println(donnee.length);
        int compteur=0;
        
        
        while(rs.next()){
            //donnee[compteur]=rs.getString("Titre").concat("t"+rs.getString("id"));
            donnee[compteur]=rs.getString("Titre").concat("p");
               compteur++;
           // System.out.println(donnee[compteur][2]);
                    
         //System.out.println(donnee[compteur][3]);
          //System.out.println(rs.getString("Titre")+"|"+rs.getString("Description")+"|"+rs.getString("capteur1")+"|"+rs.getString("capteur2"));
          
    }
       con.close();
       
       return donnee;

        
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
             String requete="UPDATE Tableau SET Description ='"+temp+"' WHERE id='"+tt+"'";
             rs=stmt.executeUpdate(requete);
             System.out.println("La resultat de la modification est "+rs);
             con.close();
             
         }catch(SQLException ex){
            Logger.getLogger(CRUD_TABLEAU.class.getName()).log(Level.SEVERE, null, ex);
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
        
        ResultSet rs=stmtA.executeQuery("SELECT COUNT(*) as count FROM Tableau");
        
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
        
        ResultSet rs=stmt.executeQuery("SELECT * FROM Tableau");
        int size=this.getlignes();
       // System.out.println(size);
        String[][] donnee=new String[size][5];
        System.out.println(donnee.length);
        int compteur=0;
        
        
        while(rs.next()){
            donnee[compteur][0]=rs.getString("id");
            donnee[compteur][1]=rs.getString("Titre");
             donnee[compteur][2]=rs.getString("DEscription");
              donnee[compteur][3]=rs.getString("capteur1");
               donnee[compteur][4]=rs.getString("capteur2");
               compteur++;
           // System.out.println(donnee[compteur][2]);
                    
         //System.out.println(donnee[compteur][3]);
          //System.out.println(rs.getString("Titre")+"|"+rs.getString("Description")+"|"+rs.getString("capteur1")+"|"+rs.getString("capteur2"));
          
    }
       con.close();
       
       return donnee;

}

    @Override
    public void run() {
       
        try {
            int port=1000;
            ServerSocket sersoc = new ServerSocket (port) ;
            System.out.println ("serveur active sur port " + port) ;
            while (true)
            {
                Socket soc = sersoc.accept();
               // InputStream flux = soc.getInputStream ();
                //BufferedReader entree = new BufferedReader (new InputStreamReader (flux)) ;
                //String message = entree.readLine() ;
                //System.out.println("message reçu sur le serveur = " + message) ;
                ObjectInputStream oin = new ObjectInputStream(soc.getInputStream());
 information product = (information) oin.readObject();
  
      System.out.println(product);
                
            }
        } catch (IOException ex) {
            Logger.getLogger(CRUD_TABLEAU.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CRUD_TABLEAU.class.getName()).log(Level.SEVERE, null, ex);
        }
}
    public String[][] mofi(String[][] don,int ii){
     //String[][] g=don;
     
    for(int u=0;u<don.length;u++){
        don[u][3]="v"+ii;
    }
     return don;
    
    }
    public static void main(String[] args){
      Thread f=new Thread(new CRUD_TABLEAU());
      f.start();
      
    }
}
