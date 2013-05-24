package vue.fenetres;

import java.awt.BorderLayout;


import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

import controleur.basique.ValiderAjouterAction;

import vue.outils.Champs;

import modele.ListeObjet;

@SuppressWarnings("serial")
public class FenetreAjouter extends Fenetre {
	
	private Champs champs;
	private boolean sub;
	
	/** Fenetre permettant l'ajout d'un billet ou d'une personne
	 * 
	 * @param listeObjet la liste des billets ou des personnes
	 * @param titre le titre de la fenetre
	 * @see Fenetre
	 */
	public FenetreAjouter(ListeObjet listeObjet, String titre, boolean sub) {
		this.sub = sub;
		
		//Fenetre
		this.setTitle(titre);
		JPanel contentPane = new JPanel(new BorderLayout());
		contentPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 5, 10));
		this.add(contentPane);
		
		//Champs
		if (sub) {
			champs = new Champs(listeObjet.getAttributs());
		} else  {
			champs = new Champs(listeObjet.getAttributsRed());
		}
		contentPane.add(champs, "Center");
		champs.ajouterListener(new ValiderAjouterAction(this, listeObjet, sub));
		
		//Bouton Valider
		JButton button = new JButton(new ValiderAjouterAction(this, listeObjet, sub));
		JPanel panelSouth = new JPanel();
		panelSouth.add(button);
		contentPane.add(panelSouth, "South");
		
		this.afficherDialog();
	}
	
	public Champs getChamps() {
		return champs;
	}
}