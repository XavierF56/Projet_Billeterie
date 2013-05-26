package vue.fenetres;

import general.Constantes;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public abstract class Fenetre extends JFrame{
	
	/**
	 * Cette classe dérive de JFrame et permet d'implementer de nouvelles fonctions
	 * sans pour autant toucher aux classes fournies par java-7-oracle.
	 */
	public Fenetre() {
		/* Icone de l'application
		 * Que l'on retrouve dans le dossier ou se trouve fenetre.class */
		try {
			setIconImage(new ImageIcon(this.getClass().getResource("ticket-icon.png")).getImage());
		} catch (Exception e) {
			Constantes.afficherAvetissementException(e, "An error occurred while loading the application icon");
		}
	}
	
	/**
	 * Affichage d'une fenetre de type Dialog
	 */
	protected void afficherDialog() {
		pack();
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((screen.width - this.getSize().width)/2,(screen.height - this.getSize().height)/2);
		setVisible(true);
	}
	
	/**
	 * Affichage d'une fenetre
	 */
	protected void afficherFenetre() {
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((screen.width - this.getSize().width)/2,(screen.height - this.getSize().height)/2);
		setVisible(true);
	}
}
