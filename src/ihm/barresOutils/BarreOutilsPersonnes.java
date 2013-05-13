package ihm.barresOutils;

import ihm.actions.FenetreAjouterAction;
import ihm.actions.FenetreCommanderAction;
import ihm.actions.FenetreDetailsAction;
import ihm.actions.FenetreModifierAction;
import ihm.actions.FenetreSupprimerAction;
import ihm.actions.RechercheAction;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import modele.Billeterie;
import modele.ListePersonnes;

@SuppressWarnings("serial")
public class BarreOutilsPersonnes extends JPanel {
	
	private JTextField textRecherche;

	public BarreOutilsPersonnes(Billeterie billeterie) {
		setLayout(new FlowLayout(FlowLayout.LEFT));
		
		textRecherche = new JTextField();
		textRecherche.setColumns(20);
		textRecherche.addKeyListener(new RechercheAction(billeterie.getListePersonnes(), textRecherche));
		ListePersonnes listePersonnes = billeterie.getListePersonnes();
		
		this.add(textRecherche);
		this.add(new JButton(new RechercheAction(listePersonnes, textRecherche)));
		this.add(new JButton(new FenetreCommanderAction(listePersonnes, billeterie)));
		this.add(new JButton(new FenetreAjouterAction(listePersonnes, "Ajouter une nouvelle personne")));
		this.add(new JButton(new FenetreModifierAction(listePersonnes)));
		this.add(new JButton(new FenetreSupprimerAction(listePersonnes)));
		this.add(new JButton(new FenetreDetailsAction(listePersonnes)));
	}
}
