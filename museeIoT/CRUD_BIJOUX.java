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
import museeiot.Bijoux;
import museeiot.Bijouxd;
import museeiot.Tableaud;

/**
 *
 * @author zineb
 */
public class CRUD_BIJOUX implements Runnable{
   /* public int Ajouterbijoux(Bijouxd b) throws SQLException{
        int rs=0;
        try {
            String classname="com.mysql.cj.jdbc.Driver";
            
            Class.forName(classname);
            
            
            //Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/museeIoT","root","root1234ROOT");
            
            Statement stmt;
            stmt = con.createStatement();
            String requete="INSERT INTO Bijoux(Titreb,Descriptionb,capteur1b,capteur2b) VALUES('"+b.getTitreb()+"' ,'"+b.getDescriptionb()+"' , '"+b.getC1b()+"' , '"+b.getC2b()+"')";
             rs=stmt.executeUpdate(requete);
            
            con.close();
            String fich="../../Desktop/Bijoux/ctemp/"+b.getTitreb()+"t"+this.getlignes()+".txt";
            File fichier=new File(fich);
            FileWriter fileWriter = new FileWriter(fichier);
            String c1=String.valueOf(b.getC1b());
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
    public void supprimerbijoux(){
    
    }
    public void modiiferbijoux(){
    
    }
    public void getbijoux(){
    
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
        
        ResultSet rs=stmtA.executeQuery("SELECT COUNT(*) as count FROM Bijoux");
        
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
        
        ResultSet rs=stmt.executeQuery("SELECT * FROM Bijoux");
        int size=this.getlignes();
       // System.out.println(size);
        String[][] donnee=new String[size][5];
        System.out.println(donnee.length);
        int compteur=0;
        
        
        while(rs.next()){
            donnee[compteur][0]=rs.getString("idb");
            donnee[compteur][1]=rs.getString("Titreb");
             donnee[compteur][2]=rs.getString("DEscriptionb");
              donnee[compteur][3]=rs.getString("capteur1b");
               donnee[compteur][4]=rs.getString("capteur2b");
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
        
        ResultSet rs=stmt.executeQuery("SELECT * FROM Bijoux");
        int size=this.getlignes();
       // System.out.println(size);
        String[] donnee=new String[size];
        System.out.println(donnee.length);
        int compteur=0;
        
        
        while(rs.next()){
            donnee[compteur]=rs.getString("Titreb").concat("t"+rs.getString("idb"));
            
               compteur++;
           // System.out.println(donnee[compteur][2]);
                    
         //System.out.println(donnee[compteur][3]);
          //System.out.println(rs.getString("Titre")+"|"+rs.getString("Description")+"|"+rs.getString("capteur1")+"|"+rs.getString("capteur2"));
          
    }
       con.close();
       
       return donnee;

        
    }   
 public int modifiertableaux(double temp){
        int rs=0;
         try{
             String classname="com.mysql.cj.jdbc.Driver";
             try{
                 Class.forName(classname);
             }catch(ClassNotFoundException ex){
                 System.out.println("driver failed to load");
             }
             
             //Class.forName("com.mysql.cj.jdbc.Driver");
             Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mediatheque","root","root1234ROOT");
             
             Statement stmt;
             stmt = con.createStatement();
             String requete="UPDATE Tableau SET nom_colonne_1 = '"+temp+"' WHERE id=1";
             rs=stmt.executeUpdate(requete);
             
             con.close();
             
         }catch(SQLException ex){
           // Logger.getLogger(CRUD_TABLEAU.class.getName()).log(Level.SEVERE, null, ex);
    }
    return rs;
    }*/
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
        ResultSet rs=stmt.executeQuery("SELECT MAX(idb) as ui FROM Bijoux");
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
        ResultSet rs=stmt.executeQuery("SELECT MAX(idb) FROM Bijoux");
        while(rs.next()){
            r=rs.getString("id");
         // System.out.println(rs.getInt("id"));
    }
        con.close();
    return r;
    
    }
    public int AjouterBijoux(Bijouxd b){
         
        int rs=0;
        try {
            String classname="com.mysql.cj.jdbc.Driver";
            
            Class.forName(classname);
            //Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/museeIoT","root","root1234ROOT");
            
            Statement stmt;
            stmt = con.createStatement();
            String requete="INSERT INTO Bijoux(Titreb,Descriptionb,capteur1b,capteur2b) VALUES('"+b.getTitreb()+"' ,'"+b.getDescriptionb()+"' , '"+b.getC1b()+"' , '"+b.getC2b()+"')";
             rs=stmt.executeUpdate(requete);
            
            con.close();
            String fich="../../Desktop/Bijoux/ctemp/"+b.getTitreb()+"t.txt";
            File fichier=new File(fich);
            FileWriter fileWriter = new FileWriter(fichier);
            String c1=String.valueOf(b.getC1b());
            fileWriter.write(c1);
             fileWriter.write("\n");
              fileWriter.close();
              //proximite
              String fich1="../../Desktop/Bijoux/cpro/"+b.getTitreb()+"p.txt";
            File fichier1=new File(fich1);
            FileWriter fileWriter1 = new FileWriter(fichier1);
            String c11=String.valueOf(b.getC1b());
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
        String requete="SELECT Titreb FROM Bijoux WHERE idb='"+ff+"'";
        ResultSet rs=stmt.executeQuery(requete);
        while(rs.next()){
            t=rs.getString("Titreb");
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
        String fich="../../Desktop/Bijoux/ctemp/"+this.gettitreseul(dd)+"t.txt";
        File h=new File(fich);
        String fich11="../../Desktop/Bijoux/cpro/"+this.gettitreseul(dd)+"p.txt";
        File h12=new File(fich11);
        if(h.delete() && h12.delete()){
        JOptionPane.showMessageDialog(null, "Le fichier est supprime");
        }
         //Class.forName("com.mysql.cj.jdbc.Driver");   
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/museeIoT","root","root1234ROOT");
       
        Statement stmt;
        stmt = con.createStatement();
        String requete="DELETE FROM Bijoux WHERE idb='"+dd+"'";
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
        
        ResultSet rs=stmt.executeQuery("SELECT * FROM Bijoux");
        int size=this.getlignes();
       // System.out.println(size);
        String[] donnee=new String[size];
        System.out.println(donnee.length);
        int compteur=0;
        
        
        while(rs.next()){
            //donnee[compteur]=rs.getString("Titre").concat("t"+rs.getString("id"));
            donnee[compteur]=rs.getString("Titreb").concat("t");
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
        
        ResultSet rs=stmt.executeQuery("SELECT * FROM Bijoux");
        int size=this.getlignes();
       // System.out.println(size);
        String[] donnee=new String[size];
        System.out.println(donnee.length);
        int compteur=0;
        
        
        while(rs.next()){
            //donnee[compteur]=rs.getString("Titre").concat("t"+rs.getString("id"));
            donnee[compteur]=rs.getString("Titreb").concat("p");
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
             String requete="UPDATE Bijoux SET Descriptionb ='"+temp+"' WHERE idb='"+tt+"'";
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
        
        ResultSet rs=stmtA.executeQuery("SELECT COUNT(*) as count FROM Bijoux");
        
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
        
        ResultSet rs=stmt.executeQuery("SELECT * FROM Bijoux");
        int size=this.getlignes();
       // System.out.println(size);
        String[][] donnee=new String[size][5];
        System.out.println(donnee.length);
        int compteur=0;
        
        
        while(rs.next()){
            donnee[compteur][0]=rs.getString("idb");
            donnee[compteur][1]=rs.getString("Titreb");
             donnee[compteur][2]=rs.getString("DEscriptionb");
              donnee[compteur][3]=rs.getString("capteur1b");
               donnee[compteur][4]=rs.getString("capteur2b");
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
