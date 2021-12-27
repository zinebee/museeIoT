/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author zineb
 */
public class servtableau implements Runnable{
    String[] listetitre;
    public servtableau(){
        try {
            CRUD_TABLEAU tr=new CRUD_TABLEAU();
            this.listetitre=tr.getlistetitre();
        } catch (SQLException ex) {
            Logger.getLogger(serveurtemperature.class.getName()).log(Level.SEVERE, null, ex);
        }
  }
public servtableau(String[] a){
    
    this.listetitre=a;
  }
    @Override
    public void run(){
        try {
           
            ServerSocket serverSocket = new ServerSocket(3000);
            
            while(true){
             Socket j=serverSocket.accept();
             CRUD_TABLEAU tr=new CRUD_TABLEAU();
            String[] gk=tr.getlistetitre();
             int larg=gk.length;
             String[] resultat=new String[larg];
             ObjectOutputStream oos = new ObjectOutputStream(j.getOutputStream());
             int i=0;
             while(i<gk.length){
            
             String fich="../../Desktop/Tableau/ctemp/"+gk[i]+".txt";
             File kk=new File(fich);
                 if(kk.exists()==false){
                  
                   break;
                  
                 }
                 System.out.println(gk[i]);
                
                 FileReader jf=new FileReader(fich);
                
             BufferedReader inA = new BufferedReader(jf);
            String line;
            String linee="";
            while ((line = inA.readLine()) != null)
            { linee=line;
           
            System.out.println (line);
            }
             resultat[i]=linee;
             i++;
             } 
             information g=new information(resultat);
             oos.writeObject(g);
           
            }
        } catch (IOException ex) {
            Logger.getLogger(serveurtemperature.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(servtableau.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    }
    
}
