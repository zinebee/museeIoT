/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB.capteurtemperature;

/**
 *
 * @author zineb
 */
import DB.CRUD_COSTUME;
import DB.capteurtemperature.SimpleAudioPlayer;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;
import java.util.EventObject;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.event.CellEditorListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import java.lang.*;
/**
 *
 * @author zineb
 */
public class infbihoux extends JPanel implements Runnable{
   // JPanel u;
    JLabel f;
 public infbihoux(Color gg){
    setPreferredSize(new Dimension(100,600));
    setOpaque(true);
    setBackground(gg);
    setLayout(new BorderLayout());
    this.f=new JLabel("securise");
    Font font = new Font("Courier", Font.BOLD,12);
this.f.setFont(font);
this.f.setHorizontalAlignment(SwingConstants.CENTER);
    this.f.setBackground(Color.GREEN);
    add(f,BorderLayout.CENTER);
    //this.f.setText(y);
    
    
 }
public Thread serveurhum(){
     Thread t=new Thread(new Runnable(){
       public void run(){
           try {
               ServerSocket serverSocketj = new ServerSocket(8002);
               
               while(true){
                   Socket jj=serverSocketj.accept();
                   CRUD_COSTUME tr=new CRUD_COSTUME();
                   //String[] gk=tr.getlistetitre();
                   //int larg=gk.length;
                 //  String[] resultat=new String[larg];
                   ObjectOutputStream oos = new ObjectOutputStream(jj.getOutputStream());
                  // int i=0;
                   
                       //for(int i=0;i<gk.length;i++){
                       String fich="../../Desktop/Bijoux/infrarouge.txt";
                       File kk=new File(fich);
                       if(kk.exists()==false){
                           //continue;
                           break;
                           //g=false;
                       }
                      // System.out.println(gk[i]);
                       
                       FileReader jf=new FileReader(fich);
                       
                       BufferedReader inA = new BufferedReader(jf);
                       String line;
                       String linee="";
                       while ((line = inA.readLine()) != null)
                       { linee=new String(line);
                       // Afficher le contenu du fichier
                       System.out.println (line);
                       }
                       //resultat[i]=linee;
                       //i++;
                  
                  // information g=new information(line);
                   oos.writeObject(linee);
                   // Socket j=serverSocket.accept();
               }
           } catch (IOException ex) {
               Logger.getLogger(infcostume.class.getName()).log(Level.SEVERE, null, ex);
           }
       
       }
     
     });
return t;
}
    @Override
    public void run() {
        try {
            Socket soc=new Socket("127.0.0.1",8002);
            ObjectInputStream oin1 = new ObjectInputStream(soc.getInputStream());
            String tt=(String)oin1.readObject();
            System.out.println(tt);
//            double valeur=Double.parseDouble(tt);
            this.f.setText(tt+" securise");
            this.f.setHorizontalAlignment(SwingConstants.CENTER);
            Font font = new Font("Courier", Font.BOLD,12);
this.f.setFont(font);
  Thread compteurtime=null;
 SimpleAudioPlayer audioPlayer=new SimpleAudioPlayer();
			compteurtime=new Thread(new Runnable(){
                           private final AtomicBoolean running = new AtomicBoolean(true);
                           public SimpleAudioPlayer audioPlayer;
                           public void stop() {
        running.set(false);
    }
                           public void stop2(){
                               try {
                                   audioPlayer.stop();
                               } catch (UnsupportedAudioFileException ex) {
                                  // Logger.getLogger(inftableau.class.getName()).log(Level.SEVERE, null, ex);
                               } catch (IOException ex) {
                                 //  Logger.getLogger(inftableau.class.getName()).log(Level.SEVERE, null, ex);
                               } catch (LineUnavailableException ex) {
                                 //  Logger.getLogger(inftableau.class.getName()).log(Level.SEVERE, null, ex);
                               }
                           }
    public void run(){
       long startTime=System.currentTimeMillis();
       int timeOut=1000;
       while(true && running.get()){
           try {
               long elapsed=System.currentTimeMillis()-startTime;
               audioPlayer =new SimpleAudioPlayer();
               //
               
               
               if(elapsed<timeOut){
                   audioPlayer.play();
               }else{
                  audioPlayer.stop();
                   this.stop();
               }
           } catch (LineUnavailableException ex) {
              // Logger.getLogger(inftableau.class.getName()).log(Level.SEVERE, null, ex);
           } catch (IOException ex) {
              // Logger.getLogger(inftableau.class.getName()).log(Level.SEVERE, null, ex);
           } catch (UnsupportedAudioFileException ex) {
              // Logger.getLogger(inftableau.class.getName()).log(Level.SEVERE, null, ex);
           }
       }
    }
  
  });
  
		
            if(tt.equals("non")){
               this.setBackground(Color.RED);
               //essai
              compteurtime.start();
               //essai
            }else{
                //if(compteurtime !=null){
                this.setBackground(Color.GREEN);
               compteurtime.stop();
               compteurtime.join();
               compteurtime.interrupt();
               audioPlayer.stop();
               
               //audioPlayer.clip.close();
               //compteurtime.stop2();
               //compteurtime.audioPlayer.stop();
               // }
              
              
            }
           
        } catch (IOException ex) {
           // Logger.getLogger(hmitableau.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
          //  Logger.getLogger(hmitableau.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
          //  Logger.getLogger(inftableau.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedAudioFileException ex) {
          //  Logger.getLogger(inftableau.class.getName()).log(Level.SEVERE, null, ex);
        } catch (LineUnavailableException ex) {
          //  Logger.getLogger(inftableau.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
