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
import DB.CRUD_BIJOUX;
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
import java.util.logging.Level;
import java.util.logging.Logger;
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

/**
 *
 * @author zineb
 */
public class hmiBijoux extends JPanel implements Runnable{
   // JPanel u;
    JLabel f;
 public hmiBijoux(Color gg){
    setPreferredSize(new Dimension(100,600));
    setOpaque(true);
    setBackground(gg);
    setLayout(new BorderLayout());
    this.f=new JLabel("0.0");
    this.f.setHorizontalAlignment(SwingConstants.CENTER);
    Font font = new Font("Courier", Font.BOLD,12);
   this.f.setFont(font);
    this.f.setBackground(Color.GREEN);
    add(f,BorderLayout.CENTER);
    //this.f.setText(y);
    
    
 }
public Thread serveurhum(){
     Thread t=new Thread(new Runnable(){
       public void run(){
           try {
               ServerSocket serverSocketj = new ServerSocket(3001);
               
               while(true){
                   Socket jj=serverSocketj.accept();
                   CRUD_BIJOUX tr=new CRUD_BIJOUX();
                   //String[] gk=tr.getlistetitre();
                   //int larg=gk.length;
                 //  String[] resultat=new String[larg];
                   ObjectOutputStream oos = new ObjectOutputStream(jj.getOutputStream());
                  // int i=0;
                   
                       //for(int i=0;i<gk.length;i++){
                       String fich="../../Desktop/Bijoux/aa.txt";
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
               Logger.getLogger(hmiBijoux.class.getName()).log(Level.SEVERE, null, ex);
           }
       
       }
     
     });
return t;
}
    @Override
    public void run() {
        try {
            Socket soc=new Socket("127.0.0.1",3001);
            ObjectInputStream oin1 = new ObjectInputStream(soc.getInputStream());
            String tt=(String)oin1.readObject();
            System.out.println(tt);
            double valeur=Double.parseDouble(tt);
            this.f.setText(tt);
            this.f.setHorizontalAlignment(SwingConstants.CENTER);
            Font font = new Font("Courier", Font.BOLD,12);
this.f.setFont(font);
            if(valeur<23.3){
               this.setBackground(Color.GREEN);
            }else{
              this.setBackground(Color.RED);
            }
        } catch (IOException ex) {
            Logger.getLogger(hmiBijoux.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(hmiBijoux.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
