package ihm.fenetres;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public abstract class Fenetre extends JFrame{
	
	public Fenetre() {
		// Icone de l'application : ce dernier se trouve dans le dossier ou se trouve fenetre.class
		setIconImage(new ImageIcon(this.getClass().getResource("ticket-icon.png")).getImage());
	}
	protected void afficher() {
		pack();
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((screen.width - this.getSize().width)/2,(screen.height - this.getSize().height)/2);
		setVisible(true);
	}
}
