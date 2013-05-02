package ihm.barresOutils;

import java.awt.FlowLayout;

import ihm.actions.FenetreAjouterAction;
import ihm.actions.FenetreModifierAction;
import ihm.actions.FenetreSuppressionAction;
import ihm.actions.RechercheAction;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import modele.Billeterie;

public class BarreOutilsBillets extends JPanel {
	
	private static final long serialVersionUID = 1L;
	Billeterie billeterie;
	private JTextField textRecherche;
	
	public BarreOutilsBillets(Billeterie billeterie) {
		this.billeterie = billeterie;
		textRecherche = new JTextField();
		textRecherche.setColumns(20);
		textRecherche.addKeyListener(new RechercheAction(billeterie.getListeBillets(), textRecherche));
		
		setLayout(new FlowLayout(FlowLayout.LEFT));
		this.add(textRecherche);
		this.add(new JButton(new RechercheAction(billeterie.getListeBillets(), textRecherche)));
		this.add(new JButton(new FenetreAjouterAction(billeterie.getListeBillets(), "Ajouter un nouveau billet")));
		this.add(new JButton(new FenetreModifierAction(billeterie.getListeBillets())));
		this.add(new JButton(new FenetreSuppressionAction(billeterie.getListeBillets())));
		this.add(new JButton("Modifier Qt"));
	}

}
