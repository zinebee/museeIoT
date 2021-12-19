/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
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
import museeiot.Sculptured;
import museeiot.Tableaud;

/**
 *
 * @author zineb
 */
public class CRUD_SCULPTURE implements Runnable{
   /* public int Ajoutersculpture(Sculptured s) throws SQLException{
        int rs=0;
        try {
            String classname="com.mysql.cj.jdbc.Driver";
            
            Class.forName(classname);
            
            
            //Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/museeIoT","root","root1234ROOT");
            
            Statement stmt;
            stmt = con.createStatement();
            String requete="INSERT INTO Sculpture(Titres,Descriptions,capteur1s,capteur2s) VALUES('"+s.getTitres()+"' ,'"+s.getDescriptions()+"' , '"+s.getC1s()+"' , '"+s.getC2s()+"')";
             rs=stmt.executeUpdate(requete);
            
            con.close();
            String fich="../../Desktop/Sculpture/ctemp/"+s.getTitres()+"t"+this.getlignes()+".txt";
            File fichier=new File(fich);
            FileWriter fileWriter = new FileWriter(fichier);
            String c1=String.valueOf(s.getC1s());
            fileWriter.write(c1);
             fileWriter.write("\n");
              fileWriter.close();
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
    public void supprimersculpture(){
    
    }
    public void modifiersculpture(){
    
    }
    public void getsculpture(){
    
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
        
        ResultSet rs=stmtA.executeQuery("SELECT COUNT(*) as count FROM Sculpture");
        
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
        
        ResultSet rs=stmt.executeQuery("SELECT * FROM Sculpture");
        int size=this.getlignes();
       // System.out.println(size);
        String[][] donnee=new String[size][5];
        System.out.println(donnee.length);
        int compteur=0;
        
        
        while(rs.next()){
            donnee[compteur][0]=rs.getString("ids");
            donnee[compteur][1]=rs.getString("Titres");
             donnee[compteur][2]=rs.getString("DEscriptions");
              donnee[compteur][3]=rs.getString("capteur1s");
               donnee[compteur][4]=rs.getString("capteur2s");
               compteur++;
           // System.out.println(donnee[compteur][2]);
                    
         //System.out.println(donnee[compteur][3]);
          //System.out.println(rs.getString("Titre")+"|"+rs.getString("Description")+"|"+rs.getString("capteur1")+"|"+rs.getString("capteur2"));
          
    }
       con.close();
       
       return donnee;


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
        
        ResultSet rs=stmt.executeQuery("SELECT * FROM Sculpture");
        int size=this.getlignes();
       // System.out.println(size);
        String[] donnee=new String[size];
        System.out.println(donnee.length);
        int compteur=0;
        
        
        while(rs.next()){
            donnee[compteur]=rs.getString("Titres").concat("t"+rs.getString("ids"));
            
               compteur++;
           // System.out.println(donnee[compteur][2]);
                    
         //System.out.println(donnee[compteur][3]);
          //System.out.println(rs.getString("Titre")+"|"+rs.getString("Description")+"|"+rs.getString("capteur1")+"|"+rs.getString("capteur2"));
          
    }
       con.close();
       
       return donnee;

        
    }  */
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
        ResultSet rs=stmt.executeQuery("SELECT MAX(ids) as ui FROM Sculpture");
        while(rs.next()){
            r=rs.getInt("ui");
         // System.out.println(rs.getInt("id"));
    }
        con.close();
    return r;
    
    }public String getlastline1() throws SQLException{
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
        ResultSet rs=stmt.executeQuery("SELECT MAX(ids) FROM Sculpture");
        while(rs.next()){
            r=rs.getString("id");
         // System.out.println(rs.getInt("id"));
    }
        con.close();
    return r;
    
    }
    public int AjouterSculpture(Sculptured s){
         
        int rs=0;
        try {
            String classname="com.mysql.cj.jdbc.Driver";
            
            Class.forName(classname);
            //Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/museeIoT","root","root1234ROOT");
            
            Statement stmt;
            stmt = con.createStatement();
            String requete="INSERT INTO Sculpture(Titres,Descriptions,capteur1s,capteur2s) VALUES('"+s.getTitres()+"' ,'"+s.getDescriptions()+"' , '"+s.getC1s()+"' , '"+s.getC2s()+"')";
             rs=stmt.executeUpdate(requete);
            
            con.close();
            String fich="../../Desktop/Sculpture/ctemp/"+s.getTitres()+"t.txt";
            File fichier=new File(fich);
            FileWriter fileWriter = new FileWriter(fichier);
            String c1=String.valueOf(s.getC1s());
            fileWriter.write(c1);
             fileWriter.write("\n");
              fileWriter.close();
              //proximite
              String fich1="../../Desktop/Sculpture/cpro/"+s.getTitres()+"p.txt";
            File fichier1=new File(fich1);
            FileWriter fileWriter1 = new FileWriter(fichier1);
            String c11=String.valueOf(s.getC1s());
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
        String requete="SELECT Titres FROM Sculpture WHERE ids='"+ff+"'";
        ResultSet rs=stmt.executeQuery(requete);
        while(rs.next()){
            t=rs.getString("Titres");
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
        String fich="../../Desktop/Sculpture/ctemp/"+this.gettitreseul(dd)+"t.txt";
        File h=new File(fich);
        String fich11="../../Desktop/Sculpture/cpro/"+this.gettitreseul(dd)+"p.txt";
        File h12=new File(fich11);
        if(h.delete() && h12.delete()){
        JOptionPane.showMessageDialog(null, "Le fichier est supprime");
        }
         //Class.forName("com.mysql.cj.jdbc.Driver");   
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/museeIoT","root","root1234ROOT");
       
        Statement stmt;
        stmt = con.createStatement();
        String requete="DELETE FROM Sculpture WHERE ids='"+dd+"'";
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
        
        ResultSet rs=stmt.executeQuery("SELECT * FROM Sculpture");
        int size=this.getlignes();
       // System.out.println(size);
        String[] donnee=new String[size];
        System.out.println(donnee.length);
        int compteur=0;
        
        
        while(rs.next()){
            //donnee[compteur]=rs.getString("Titre").concat("t"+rs.getString("id"));
            donnee[compteur]=rs.getString("Titres").concat("t");
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
        
        ResultSet rs=stmt.executeQuery("SELECT * FROM Sculpture");
        int size=this.getlignes();
       // System.out.println(size);
        String[] donnee=new String[size];
        System.out.println(donnee.length);
        int compteur=0;
        
        
        while(rs.next()){
            //donnee[compteur]=rs.getString("Titre").concat("t"+rs.getString("id"));
            donnee[compteur]=rs.getString("Titres").concat("p");
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
             String requete="UPDATE Sculpture SET Descriptions ='"+temp+"' WHERE ids='"+tt+"'";
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
        
        ResultSet rs=stmtA.executeQuery("SELECT COUNT(*) as count FROM Sculpture");
        
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
        
        ResultSet rs=stmt.executeQuery("SELECT * FROM Sculpture");
        int size=this.getlignes();
       // System.out.println(size);
        String[][] donnee=new String[size][5];
        System.out.println(donnee.length);
        int compteur=0;
        
        
        while(rs.next()){
            donnee[compteur][0]=rs.getString("ids");
            donnee[compteur][1]=rs.getString("Titres");
             donnee[compteur][2]=rs.getString("DEscriptions");
              donnee[compteur][3]=rs.getString("capteur1s");
               donnee[compteur][4]=rs.getString("capteur2s");
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
