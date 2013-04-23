package ihm.fenetres;

import ihm.actions.RechercheAction;
import ihm.actions.TextRecherche;

import javax.swing.JButton;

import modele.Billeterie;
import modele.Personne;

@SuppressWarnings("serial")
public class FenetreCommande extends Fenetre {
	Personne personne;
	private TextRecherche textRecherche;
	
	public FenetreCommande(Billeterie billeterie) {
		this.setTitle("Commande de billet");

		textRecherche = new TextRecherche(billeterie.getListeBillets());
		this.add(textRecherche);
		this.add(new JButton(new RechercheAction(billeterie.getListeBillets(), textRecherche)));
		
		this.afficher();
	}
}
