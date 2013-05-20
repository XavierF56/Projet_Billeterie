package general;

import ihm.fenetres.FenetrePrincipale;

import java.awt.EventQueue;

import modele.Billeterie;

/**
 * Urgent :

 * TODO Applet .jar (Xavier)
 * 
 * Note : attention a la gestion des cacateres speciaux
 * 
 * BUG
 * Disparition de l'icone dans bin/ihm/fenetre -> plus d'icone pour l'appli
 * 
 * Secondaire :
 * 
 * TODO Continuer la Javadoc
 * TODO Booleen true false -> vrai faux
 * TODO Bouton payer tout / donner tout / selection multiple / payer et donner (Bruno)
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
					/* Langue */
					Langue.langueInit();
				
					FenetrePrincipale frame = new FenetrePrincipale(new Billeterie("database.sqlite"));
					frame.setVisible(true);
				} catch (Exception e) {
					Constantes.afficherException(e);
				}
			}
		});
	}
}
