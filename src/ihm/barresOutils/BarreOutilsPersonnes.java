package ihm.barresOutils;

import java.awt.FlowLayout;

import ihm.actions.FenetreAjouterAction;
import ihm.actions.CommandeBilletAction;
import ihm.actions.FenetreModifierAction;
import ihm.actions.RechercheAction;
import ihm.actions.SupprimerAction;
import ihm.actions.TextRecherche;
import ihm.actions.FenetreDetailsAction;

import javax.swing.JButton;
import javax.swing.JPanel;

import modele.Billeterie;

@SuppressWarnings("serial")
public class BarreOutilsPersonnes extends JPanel {


	public BarreOutilsPersonnes(Billeterie billeterie) {
		setLayout(new FlowLayout(FlowLayout.LEFT));
		
		TextRecherche textRecherche = new TextRecherche(billeterie.getListePersonnes());
		this.add(textRecherche);
		this.add(new JButton(new RechercheAction(billeterie.getListePersonnes(), textRecherche)));
		this.add(new JButton(new CommandeBilletAction(billeterie.getListePersonnes(), billeterie)));
		this.add(new JButton(new FenetreAjouterAction(billeterie.getListePersonnes(), "Ajouter une nouvelle personne")));
		this.add(new JButton(new FenetreModifierAction(billeterie.getListePersonnes())));
		this.add(new JButton(new SupprimerAction(billeterie.getListePersonnes())));
		this.add(new JButton(new FenetreDetailsAction(billeterie.getListePersonnes())));
	}
}
