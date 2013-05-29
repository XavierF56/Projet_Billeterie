package vue.barreOutils;


import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

import controleur.basique.RechercheAction;
import controleur.commande.FenetreQuantiteAction;

import vue.fenetres.FenetreCommander;

import modele.Billetterie;
import modele.Commande;

@SuppressWarnings("serial")
public class BarreOutilsCommande extends JPanel {
	
	/**
	 * Cette classe permet l'affichage du champ de recherches et des boutons de la barre d'outils de la fenetre Commander
	 * 
	 * @param fenetre la fenetre Commander ouverte
	 * @param billeterie la billeterie en cours
	 * @param tableau une copie du tableau des billets
	 * @param commande la commande en cours
	 * @see FenetreCommander
	 * @see Billetterie
	 * @see Commande
	 */
	public BarreOutilsCommande(FenetreCommander fenetre, Billetterie billeterie, JTable tableau, Commande commande) {
		JTextField textRecherche = new JTextField();
		textRecherche.setColumns(20);
		textRecherche.addKeyListener(new RechercheAction(billeterie.getListeBillets(), textRecherche));
		
		setLayout(new FlowLayout(FlowLayout.LEFT));
		this.add(textRecherche);
		this.add(new JButton(new RechercheAction(billeterie.getListeBillets(), textRecherche)));
		this.add(new JButton(new FenetreQuantiteAction(fenetre, billeterie.getListeBillets(), tableau, commande)));
	}
}