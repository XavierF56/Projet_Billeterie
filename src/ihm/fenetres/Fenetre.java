package ihm.fenetres;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public abstract class Fenetre extends JFrame{
	
	public Fenetre() {
		// Icone de l'application : ce dernier se trouve dans le dossier ou se trouve fenetre.class
		try {
		setIconImage(new ImageIcon(this.getClass().getResource("ticket-icon.png")).getImage());
		} catch (Exception e) {
			// cas ou l'icone n'est pas dans le bon dossier
		}
	}
	protected void afficher() {
		pack();
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((screen.width - this.getSize().width)/2,(screen.height - this.getSize().height)/2);
		setVisible(true);
	}
}
