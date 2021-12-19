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
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
class IHMSon extends JPanel implements ActionListener {
	private JButton jouer = new JButton("jouer");
	private java.applet.AudioClip son;

	IHMSon() {
		// Premiere possibilite
		java.net.URL url =JouerSon.class.getResource("../../Downloads/manal.mp3");

		/* Seconde possibilite
			java.net.URL url = null; 
			try {	
			url = new java.net.URL("https://www.youtube.com/watch?v=V8USmc89qNs");
			} 
			catch (java.net.MalformedURLException exc) {
			exc.printStackTrace();
		}  */

		son = java.applet.Applet.newAudioClip(url);

		add(jouer);
		jouer.addActionListener(this);
	} 

	public void actionPerformed(java.awt.event.ActionEvent e) {
		son.play();
	}
}

class JouerSon {
	public static void main(String[] argv) {
		JFrame fenetre = new JFrame();
		fenetre.setContentPane(new IHMSon());
		fenetre.pack();
		fenetre.setLocation(100, 100);
		fenetre.setVisible(true);
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}