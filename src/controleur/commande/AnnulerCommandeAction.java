package controleur.commande;

import general.Langue;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import vue.fenetres.Fenetre;

import modele.Commande;

@SuppressWarnings("serial")
public class AnnulerCommandeAction extends AbstractAction {
	
	private Commande commande;
	private Fenetre fenetre;
	
	/**
	 * Cette classe permet la gestion de l'annulation d'un achat
	 * 
	 * @param commande la commande en cours
	 * @param fenetre la fenêtre en cours
	 */
	public AnnulerCommandeAction (Commande commande, Fenetre fenetre) {
		super(Langue.getTraduction("cancel"));
		this.commande = commande;
		this.fenetre = fenetre;
	}

	/** Methode requise par l'heritage de la classe AbstractAction
     * 
     * @see AbstractAction
	 */
	public void actionPerformed(ActionEvent e) {
		commande.annuler();
		fenetre.dispose();
	}
}
