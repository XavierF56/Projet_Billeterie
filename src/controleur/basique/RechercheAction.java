package controleur.basique;

import general.Langue;

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

	/**
	 * Cette classe permet la gestion du bouton de recherche.
	 * 
	 * @param listeObjet la liste des objets traités
	 * @param textRecherche le champ de recherche
	 * @see ListeObjet
	 * @see JTextField
	 */
	public RechercheAction(ListeObjet listeObjet, JTextField textRecherche) {
        super(Langue.getTraduction("search"));
        this.textRecherche = textRecherche;
    	this.listeObjet = listeObjet;
    }
	
	/** Methode requise par l'heritage de la classe AbstractAction
     * 
     * @see AbstractAction
	 */
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
