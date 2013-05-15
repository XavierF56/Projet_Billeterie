package ihm.barresOutils;

import java.awt.FlowLayout;

import ihm.actions.RechercheAction;
import ihm.actions.fenetre.FenetreAjouterAction;
import ihm.actions.fenetre.FenetreModifierAction;
import ihm.actions.fenetre.FenetreSupprimerAction;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import modele.Billeterie;

@SuppressWarnings("serial")
public class BarreOutilsBillets extends JPanel {
	
	private JTextField textRecherche;
	
	public BarreOutilsBillets(Billeterie billeterie) {
		textRecherche = new JTextField();
		textRecherche.setColumns(20);
		textRecherche.addKeyListener(new RechercheAction(billeterie.getListeBillets(), textRecherche));
		
		setLayout(new FlowLayout(FlowLayout.LEFT));
		this.add(textRecherche);
		this.add(new JButton(new RechercheAction(billeterie.getListeBillets(), textRecherche)));
		this.add(new JButton(new FenetreAjouterAction(billeterie.getListeBillets(), "Ajouter un nouveau billet")));
		this.add(new JButton(new FenetreModifierAction(billeterie.getListeBillets())));
		this.add(new JButton(new FenetreSupprimerAction(billeterie.getListeBillets())));
	}
}
