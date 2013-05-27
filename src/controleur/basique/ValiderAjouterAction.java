package controleur.basique;

import general.Langue;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Map;

import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import vue.fenetres.FenetreAjouter;

import modele.ListeObjet;

@SuppressWarnings("serial")
public class ValiderAjouterAction extends AbstractAction implements KeyListener {

	private FenetreAjouter fenetre;
	private ListeObjet listeObjet;
	private boolean sub;
	
	/**
	 * Cette action permet la gestion de la validation de l'ajout dun objet (Billet ou Personne) par l'utilisteur.
	 * 
	 * @param fenetre la fenetre en cours
	 * @param listeObjet la liste des Billets
	 * @param sub
	 * @see FenetreAjouter
	 * @see ListeObjet
	 */
    public ValiderAjouterAction(FenetreAjouter fenetre, ListeObjet listeObjet, boolean sub) {
        super(Langue.getTraduction("validate"));
        this.fenetre = fenetre;
        this.listeObjet = listeObjet;
    }
    
    /**
     * Cette fonction valide l'action
     */
    public void valider() {
    	try {
			Map<String, Object>  map = fenetre.getChamps().getDonnees();
			listeObjet.ajouter(map, sub);
        	fenetre.dispose();
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(new JFrame(), Langue.getTraduction("error_adding"),
					Langue.getTraduction("error"), JOptionPane.ERROR_MESSAGE);
		}
    }
    
    /** Methode requise par l'heritage de la classe AbstractAction
     * 
     * @see AbstractAction
	 */
    public void actionPerformed(ActionEvent e) {
		valider();
    }
    public void keyTyped(KeyEvent e) {
    }
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
	    	valider();
        }
    }
    public void keyReleased(KeyEvent e) {
    }
}