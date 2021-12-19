/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package museeiot;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author zineb
 */
class Image extends JPanel {
 
private String adImg;
 public Image(){
 }
public Image(String adImg){
this.adImg=adImg;
}
 
    public void paintComponent(Graphics g){
        try {
       StringBuffer imgg = new StringBuffer(this.adImg);
            String immg = new String(imgg);
            BufferedImage img = ImageIO.read(new File(immg));
            g.drawImage(img,0,0, this);
           } catch (IOException e) {
           e.printStackTrace();
        }
    }
    public static void main(String[] args){
    
     JFrame k=new JFrame();
     
    k.setVisible(true);
    k.setTitle("essai");
    Image j=new Image("d");
    k.add(j);
    }
}

    

