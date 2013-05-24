package vue.barreOutils;

import general.Langue;

import java.awt.FlowLayout;


import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controleur.basique.FenetreAjouterAction;
import controleur.basique.FenetreRAZQuotaAction;
import controleur.basique.FenetreSupprimerAction;
import controleur.basique.RechercheAction;
import controleur.modifier.FenetreModifierAction;

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
		this.add(new JButton(new FenetreAjouterAction(billeterie.getListeBillets(), 
				Langue.getTraduction("add_new_ticket"))));
		this.add(new JButton(new FenetreModifierAction(billeterie.getListeBillets())));
		this.add(new JButton(new FenetreSupprimerAction(billeterie.getListeBillets())));
		this.add(new JButton(new FenetreRAZQuotaAction(billeterie.getListeBillets())));
	}
}
