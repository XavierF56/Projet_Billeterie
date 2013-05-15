package general;

import ihm.fenetres.FenetrePrincipale;

import java.awt.EventQueue;

import modele.Billeterie;

/**
 * Urgent :

 * TODO Onglet Ajout
 * TODO Applet .jar
 * TODO Icon
 * 
 * Note : attention a la gestion des cacateres speciaux
 * 
 * Secondaire :
 * 
 * TODO Continuer la Javadoc
 * TODO Bouton payer tout / donner tout / selection multiple / payer et donner
 * TODO : statistiques d'achat
 * TODO : rendre disponibles d'autres options
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
