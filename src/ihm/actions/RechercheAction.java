package ihm.actions;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.AbstractAction;
import javax.swing.JTextField;

import modele.ListeObjet;

@SuppressWarnings("serial")
public class RechercheAction extends AbstractAction implements KeyListener {
	
	private ListeObjet listeObjet;
	private JTextField textRecherche;

	public RechercheAction(ListeObjet listeObjet, JTextField textRecherche) {
        super("Rechercher");
        this.textRecherche = textRecherche;
    	this.listeObjet = listeObjet;
    }

    public void actionPerformed(ActionEvent e) {
        listeObjet.recherche(textRecherche.getText());
    }
    
    public void keyTyped(KeyEvent e) {
    }
    
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
        	listeObjet.recherche(textRecherche.getText());
        }
    }
    
    public void keyReleased(KeyEvent e) {
    }
}
