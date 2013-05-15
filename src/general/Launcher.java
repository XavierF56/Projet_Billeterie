package general;

import ihm.fenetres.FenetrePrincipale;

import java.awt.EventQueue;

import modele.Billeterie;

/**
 * Urgent :
 * 
 * TODO BUG
 * Lors de l'ajout d'une colonne depuis SQLITEManager, si aucune valeur par defaut affectee 
 * -> la recuperation du type pose probleme...
 * 
 * TODO Bouton payer tout / donner tout / selection multiple / payer et donner
 * 
 * Note : attention a la gestion des cacateres speciaux
 * 
 * Secondaire :
 * TODO Continuer la Javadoc
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
