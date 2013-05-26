package controleur.commande;

import general.Langue;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import modele.Commande;
import vue.fenetres.Fenetre;
import vue.fenetres.FenetreCommander;

@SuppressWarnings("serial")
public class CompleterCommandeAction extends AbstractAction {
	
	private Commande commande;
	private Fenetre fenetre;
	private FenetreCommander fenetreCommande;

	/**
	 * 
	 * @param commande
	 * @param fenetre
	 * @param fenetreCommande
	 */
	public CompleterCommandeAction (Commande commande, Fenetre fenetre, FenetreCommander fenetreCommande) {
		super(Langue.getTraduction("complete"));
		this.commande = commande;
		this.fenetre = fenetre;
		this.fenetreCommande = fenetreCommande;
	}
	
	/** Methode requise par l'heritage de la classe AbstractAction
     * 
     * @see AbstractAction
	 */
	public void actionPerformed(ActionEvent e) {
		commande.completer();
		fenetreCommande.getBilleterie().getFenetre().getOngletStats().majLabel();
		fenetre.dispose();
		fenetreCommande.majLabel();
	}
	
}
