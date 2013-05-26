package controleur.commande;

import general.Langue;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import modele.Commande;
import vue.fenetres.Fenetre;
import vue.fenetres.FenetreCommander;

@SuppressWarnings("serial")
public class ForcerCommandeAction extends AbstractAction {
	Commande commande;
	Fenetre fenetre;
	FenetreCommander fenetreCommande;

	/**
	 * Cette classe permet la gestion du cas d'une commande forcée par l'utilisateur.
	 * 
	 * @param commande la commande en cours
	 * @param fenetre la fenetre d'erreur en cours
	 * @param fenetreCommande la fenetre Commande en cours
	 */
	public ForcerCommandeAction (Commande commande, Fenetre fenetre, FenetreCommander fenetreCommande) {
		super(Langue.getTraduction("force"));
		this.commande = commande;
		this.fenetre = fenetre;
		this.fenetreCommande = fenetreCommande;
	}
	
	/** Methode requise par l'heritage de la classe AbstractAction
     * 
     * @see AbstractAction
	 */
	public void actionPerformed(ActionEvent e) {
		commande.valider();
		fenetreCommande.getBilleterie().getFenetre().getOngletStats().majLabel();
		fenetre.dispose();
		fenetreCommande.majLabel();
	}
	
}
