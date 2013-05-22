package general;


import java.awt.EventQueue;

import vue.fenetres.FenetrePrincipale;

import modele.Billeterie;

/**
 * Urgent :

 * TODO Applet .jar
 * 
 * Note : attention a la gestion des cacateres speciaux
 * 
 * Secondaire :
 * 
 * TODO Continuer la Javadoc
 * TODO Booleen true false -> vrai faux
 * TODO Bouton payer tout / donner tout / selection multiple / payer et donner (Bruno)
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
					Proprietes.proprietesInit();
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
