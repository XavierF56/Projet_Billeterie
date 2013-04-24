package ihm.barresOutils;

import ihm.actions.AjouterAuPanierAction;
import ihm.actions.RechercheAction;
import ihm.actions.TextRecherche;

import javax.swing.JButton;
import javax.swing.JPanel;

import modele.Billeterie;

public class BarreOutilsCommande extends JPanel {
	
	private static final long serialVersionUID = 1L;
	Billeterie billeterie;
	private TextRecherche textRecherche;
	
	public BarreOutilsCommande(Billeterie billeterie) {
		this.billeterie = billeterie;
		textRecherche = new TextRecherche(billeterie.getListeBillets());

		this.add(textRecherche);
		this.add(new JButton(new RechercheAction(billeterie.getListeBillets(), textRecherche)));
		this.add(new JButton(new AjouterAuPanierAction()));
	}
}