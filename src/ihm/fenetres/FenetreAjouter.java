package ihm.fenetres;

import java.awt.BorderLayout;

import ihm.actions.valider.ValiderAjouterAction;
import ihm.barresOutils.Champs;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

import modele.ListeObjet;

@SuppressWarnings("serial")
public class FenetreAjouter extends Fenetre {
	
	private Champs champs;
	
	/** Fenetre permettant l'ajout d'un billet ou d'une personne
	 * 
	 * @param listeObjet la liste des billets ou des personnes
	 * @param titre le titre de la fenetre
	 * @see Fenetre
	 */
	public FenetreAjouter(ListeObjet listeObjet, String titre) {
		
		//Fenetre
		this.setTitle(titre);
		JPanel contentPane = new JPanel(new BorderLayout());
		contentPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 5, 10));
		this.add(contentPane);
		
		//Champs
		champs = new Champs(listeObjet.getAttributs());
		contentPane.add(champs, "Center");
		champs.ajouterListener(new ValiderAjouterAction(this, listeObjet));
		
		//Bouton Valider
		JButton button = new JButton(new ValiderAjouterAction(this, listeObjet));
		JPanel panelSouth = new JPanel();
		panelSouth.add(button);
		contentPane.add(panelSouth, "South");
		
		this.afficherDialog();
	}
	
	public Champs getChamps() {
		return champs;
	}
}