package ihm.barresOutils;

import ihm.actions.AjouterAuPanierAction;
import ihm.actions.RechercheAction;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

import modele.Billeterie;
import modele.Commande;

@SuppressWarnings("serial")
public class BarreOutilsCommande extends JPanel {
	
	public BarreOutilsCommande(Billeterie billeterie, JTable tableau, Commande commande) {
		JTextField textRecherche = new JTextField();
		textRecherche.setColumns(20);
		textRecherche.addKeyListener(new RechercheAction(billeterie.getListeBillets(), textRecherche));
		
		setLayout(new FlowLayout(FlowLayout.LEFT));
		this.add(textRecherche);
		this.add(new JButton(new RechercheAction(billeterie.getListeBillets(), textRecherche)));
		this.add(new JButton(new AjouterAuPanierAction(billeterie.getListeBillets(), tableau, commande)));
	}
}