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
	 * Constructeur
	 * @param fenetre
	 * @param listeObjet
	 */
    public ValiderAjouterAction(FenetreAjouter fenetre, ListeObjet listeObjet, boolean sub) {
        super(Langue.getTraduction("validate"));
        this.fenetre = fenetre;
        this.listeObjet = listeObjet;
        this.sub = sub;
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
			System.out.println(e1);
			JOptionPane.showMessageDialog(new JFrame(), Langue.getTraduction("error_adding"),
					Langue.getTraduction("error"), JOptionPane.ERROR_MESSAGE);
		}
    }
    
    /** Listeners **/
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