package ihm.barresOutils;

import java.awt.FlowLayout;

import ihm.actions.AjouterAuPanierAction;
import ihm.actions.RechercheAction;
import ihm.actions.TextRecherche;

import javax.swing.JButton;
import javax.swing.JPanel;

import modele.Billeterie;

@SuppressWarnings("serial")
public class BarreOutilsCommande extends JPanel {

	private TextRecherche textRecherche;
	
	public BarreOutilsCommande(Billeterie billeterie) {
		textRecherche = new TextRecherche(billeterie.getListeBillets());
		setLayout(new FlowLayout(FlowLayout.LEFT));
		this.add(textRecherche);
		this.add(new JButton(new RechercheAction(billeterie.getListeBillets(), textRecherche)));
		this.add(new JButton(new AjouterAuPanierAction(billeterie.getListeBillets())));
	}
}