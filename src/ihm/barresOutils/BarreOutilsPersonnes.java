package ihm.barresOutils;

import java.awt.FlowLayout;

import ihm.actions.FenetreAjouterAction;
import ihm.actions.FenetreCommanderAction;
import ihm.actions.FenetreModifierAction;
import ihm.actions.FenetreSupprimerAction;
import ihm.actions.RechercheAction;
import ihm.actions.FenetreDetailsAction;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import modele.Billeterie;

@SuppressWarnings("serial")
public class BarreOutilsPersonnes extends JPanel {
	JTextField textRecherche;

	public BarreOutilsPersonnes(Billeterie billeterie) {
		setLayout(new FlowLayout(FlowLayout.LEFT));
		
		textRecherche = new JTextField();
		textRecherche.setColumns(20);
		textRecherche.addKeyListener(new RechercheAction(billeterie.getListePersonnes(), textRecherche));
		
		this.add(textRecherche);
		this.add(new JButton(new RechercheAction(billeterie.getListePersonnes(), textRecherche)));
		this.add(new JButton(new FenetreCommanderAction(billeterie.getListePersonnes(), billeterie)));
		this.add(new JButton(new FenetreAjouterAction(billeterie.getListePersonnes(), "Ajouter une nouvelle personne")));
		this.add(new JButton(new FenetreModifierAction(billeterie.getListePersonnes())));
		this.add(new JButton(new FenetreSupprimerAction(billeterie.getListePersonnes())));
		this.add(new JButton(new FenetreDetailsAction(billeterie.getListePersonnes())));
	}
}
