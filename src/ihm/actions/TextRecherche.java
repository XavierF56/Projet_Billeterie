package ihm.actions;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JTextField;

import modele.ListeObjet;

public class TextRecherche extends JTextField  implements KeyListener {
	private static final long serialVersionUID = 1L;
	private ListeObjet listeObjet;
	public TextRecherche(ListeObjet listeObjet) {
    	super();
    	this.setColumns(20);
    	this.listeObjet = listeObjet;
        addKeyListener(this);
    }
    public void keyTyped(KeyEvent e) {
    }
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
        	listeObjet.recherche(this.getText());
        }
    }
    public void keyReleased(KeyEvent e) {
    }
}
