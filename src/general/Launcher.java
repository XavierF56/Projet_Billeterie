package general;


import java.awt.EventQueue;

import vue.fenetres.FenetrePrincipale;

import modele.Billeterie;

/**
 * TODO Continuer la Javadoc
 * TODO Booleen true false -> vrai faux
 * TODO Bouton payer tout / donner tout / selection multiple / payer et donner (Bruno)
 * TODO Gestion erreurs - "1 000 blanc" (Xavier)
 * TODO Gestion reset quotas (Xavier)
 * TODO Gestion cases vides billets non sub (Xavier)
 * TODO affichage statistiques (Bruno)
 * TODO nom application (Bruno)
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

					FenetrePrincipale frame = new FenetrePrincipale(new Billeterie(Proprietes.getOption("billeterie")));
					frame.setVisible(true);
				} catch (Exception e) {
					Constantes.afficherException(e);
				}
			}
		});
	}
}
