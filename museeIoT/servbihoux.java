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
public class servbihoux implements Runnable{
	//comment servbihoux
    String[] listetitre;
    public servbihoux(){
        try {
            CRUD_BIJOUX tr=new CRUD_BIJOUX();
            this.listetitre=tr.getlistetitre();
        } catch (SQLException ex) {
            Logger.getLogger(serveurtemperature.class.getName()).log(Level.SEVERE, null, ex);
        }
  }
public servbihoux(String[] a){
    // CRUD_TABLEAU tr=new CRUD_TABLEAU();
    this.listetitre=a;
  }
    @Override
    public void run(){
        try {
            /* OutputStream flux = null ;
            try {double[] b={1.0,2.0,3.0};
            information info=new information(b);
            String hote = "127.0.0.1" ;
            int port = 1000 ;
            Socket soc = new Socket (hote, port) ;
            ObjectOutputStream oos = new ObjectOutputStream(soc.getOutputStream());
            
            BufferedReader inA = new BufferedReader(new FileReader("../../Desktop/aaE.txt"));
            String line;
            String linee="";
            while ((line = inA.readLine()) != null)
            { linee=line;
            // Afficher le contenu du fichier
            System.out.println (line);
            }
            inA.close();
            oos.writeObject(info);
            
            
            } catch (IOException ex) {
            Logger.getLogger(serveurtemperature.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
            // flux.close();

            }
            
            
            }
            // public static void main(String[] args){
            
            // Thread g=new Thread(new serveurtemperature());
            //g.start();
            // */
            ServerSocket serverSocket = new ServerSocket(4000);
           /* while(true){
             Socket j=serverSocket.accept();
             CRUD_BIJOUX tr=new CRUD_BIJOUX();
            String[] gk=tr.getlistetitre();
             int larg=gk.length;
             String[] resultat=new String[larg];
             ObjectOutputStream oos = new ObjectOutputStream(j.getOutputStream());
             for(int i=0;i<gk.length;i++){
                 System.out.println(gk[i]);
                 String fich="../../Desktop/Bijoux/ctemp/"+gk[i]+".txt";
             BufferedReader inA = new BufferedReader(new FileReader(fich));
            String line;
            String linee="";
            while ((line = inA.readLine()) != null)
            { linee=line;
            // Afficher le contenu du fichier
            System.out.println (line);
            }
             resultat[i]=linee;
             } 
             information g=new information(resultat);
             oos.writeObject(g);
            }*/
           while(true){
             Socket j=serverSocket.accept();
             CRUD_BIJOUX tr=new CRUD_BIJOUX();
            String[] gk=tr.getlistetitre();
             int larg=gk.length;
             String[] resultat=new String[larg];
             ObjectOutputStream oos = new ObjectOutputStream(j.getOutputStream());
             int i=0;
             while(i<gk.length){
             //for(int i=0;i<gk.length;i++){
             String fich="../../Desktop/Bijoux/ctemp/"+gk[i]+".txt";
             File kk=new File(fich);
                 if(kk.exists()==false){
                   //continue;
                   break;
                   //g=false;
                 }
                 System.out.println(gk[i]);
                
                 FileReader jf=new FileReader(fich);
                
             BufferedReader inA = new BufferedReader(jf);
            String line;
            String linee="";
            while ((line = inA.readLine()) != null)
            { linee=line;
            // Afficher le contenu du fichier
            System.out.println (line);
            }
             resultat[i]=linee;
             i++;
             } 
             information g=new information(resultat);
             oos.writeObject(g);
            // Socket j=serverSocket.accept();
            }
        } catch (IOException ex) {
            Logger.getLogger(serveurtemperature.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(servtableau.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    }
    
}
