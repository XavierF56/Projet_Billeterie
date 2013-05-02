package ihm.fenetres;

import java.awt.BorderLayout;

import ihm.actions.ValiderAjoutAction;
import ihm.barresOutils.Champs;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

import modele.ListeObjet;

@SuppressWarnings("serial")
public class FenetreNouvelleObjet extends Fenetre {
	private Champs champs;
	
	public FenetreNouvelleObjet(ListeObjet listeObjet, String titre) {
		//Fenetre
		this.setTitle(titre);
		JPanel contentPane = new JPanel(new BorderLayout());
		contentPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 5, 10));
		this.add(contentPane);
		
		//Champs
		champs = new Champs(listeObjet.getAttributs());
		contentPane.add(champs, "Center");
		champs.ajouterListener(new ValiderAjoutAction(this, listeObjet));
		
		//Bouton Valider
		JButton button = new JButton(new ValiderAjoutAction(this, listeObjet));
		JPanel panelSouth = new JPanel();
		panelSouth.add(button);
		contentPane.add(panelSouth, "South");
		
		this.afficher();
	}
	
	public Champs getChamps() {
		return champs;
	}
	
	
}