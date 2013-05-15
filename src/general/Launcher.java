package general;

import ihm.fenetres.FenetrePrincipale;

import java.awt.EventQueue;

import modele.Billeterie;

/**
 * Urgent :
 * 
 * TODO Rendre possible le fait de payer dans un second temps (pour le moment un client qui n'a pas paye
 * lors de la commande ne peut plus le faire apres, sauf erreur de ma part)
 * 
 * Note : attention a la gestion des cacateres speciaux
 * 
 * Secondaire :
 * TODO Continuer la Javadoc
 * TODO Gestion du cas normalement non autorise de depassement des quotas
 * 
 * Bonus :
 * TODO : rendre disponibles d'autres options
 * TODO : systeme de panier avec une validation a la fin
 */
public class Launcher {
	/**
	 * Lance l'application
	 * @param args arguments de la main 
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FenetrePrincipale frame = new FenetrePrincipale(new Billeterie("database.sqlite"));
					frame.setVisible(true);
				} catch (Exception e) {
					Constantes.afficherException(e);
				}
			}
		});
	}
}
