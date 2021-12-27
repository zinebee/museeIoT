/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author zineb
 */
public class receptiontableau implements Runnable{
	//test1

    @Override
    public void run() {
        try {
            Socket socket = new Socket("127.0.0.1", 3000);
            ObjectInputStream oin = new ObjectInputStream(socket.getInputStream());
            information product = (information) oin.readObject();
            System.out.println(product);
        } catch (IOException ex) {
            Logger.getLogger(receptiontableau.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(receptiontableau.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        }
    
}
