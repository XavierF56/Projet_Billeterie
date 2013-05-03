package ihm.actions;

import ihm.fenetres.FenetreNouvelleObjet;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Map;

import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import modele.ListeObjet;

public class ValiderAjoutAction extends AbstractAction implements KeyListener {
	private static final long serialVersionUID = 1L;
	private FenetreNouvelleObjet fenetre;
	private ListeObjet listeObjet;
	
	/**
	 * Constructeur
	 * @param fenetre
	 * @param listeObjet
	 */
    public ValiderAjoutAction(FenetreNouvelleObjet fenetre, ListeObjet listeObjet) {
        super("Valider");
        this.fenetre = fenetre;
        this.listeObjet = listeObjet;
    }
    
    /**
     * Cette fonction valider l'action
     */
    public void valider() {
    	try {
			Map<String, Object>  map = fenetre.getChamps().getDonnees();
			listeObjet.ajouter(map);
        	fenetre.dispose();
		} catch (Exception e1) {
			System.out.println(e1);
			String message = "\"Erreur lors de l'ajout\"\n"
		            + "Tous les champs n'ont pas ete renseignes\n";
			JOptionPane.showMessageDialog(new JFrame(), message, "Dialog", JOptionPane.ERROR_MESSAGE);
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