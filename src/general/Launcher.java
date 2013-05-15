package general;

import ihm.fenetres.FenetrePrincipale;

import java.awt.EventQueue;

import modele.Billeterie;

/**
 * Urgent :

 * TODO Applet .jar (Xavier)
 * TODO Icon (Bruno)
 * 
 * Note : attention a la gestion des cacateres speciaux
 * 
 * Secondaire :
 * 
 * TODO Continuer la Javadoc
 * TODO Bouton payer tout / donner tout / selection multiple / payer et donner (Bruno)
 * TODO Statistiques d'achat (Xavier)
 * TODO Rendre disponibles d'autres options
 * TODO Anglais
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
