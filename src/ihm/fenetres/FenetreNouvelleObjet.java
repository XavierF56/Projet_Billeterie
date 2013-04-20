package ihm.fenetres;

import ihm.actions.ValiderAction3;
import ihm.barresOutils.Champs;

import javax.swing.JButton;

import modele.ListeObjet;

@SuppressWarnings("serial")
public class FenetreNouvelleObjet extends Fenetre {
	private Champs champs;
	
	public FenetreNouvelleObjet(ListeObjet listeObjet, String titre) {
		champs = new Champs(listeObjet.getAttributs());
		//setBounds(100, 100, 450, 300);
		this.add(champs, "Center");
		this.add(new JButton(new ValiderAction3(this, listeObjet)), "South");
		this.setTitle(titre);
		
		this.afficher();
	}
	
	public Champs getChamps() {
		return champs;
	}
	
	
}