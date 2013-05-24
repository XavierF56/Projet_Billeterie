package vue.barreOutils;


import general.Langue;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controleur.basique.FenetreAjouterAction;
import controleur.basique.FenetreModifierAction;
import controleur.basique.FenetreSupprimerAction;
import controleur.basique.RechercheAction;
import controleur.commande.FenetreCommanderAction;
import controleur.details.FenetreDetailsAction;

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
		this.add(new JButton(new FenetreDetailsAction(billeterie)));
		this.add(new JButton(new FenetreAjouterAction(listePersonnes, 
				Langue.getTraduction("add_new_person"), true)));
		this.add(new JButton(new FenetreModifierAction(listePersonnes)));
		this.add(new JButton(new FenetreSupprimerAction(listePersonnes)));
	}
}
