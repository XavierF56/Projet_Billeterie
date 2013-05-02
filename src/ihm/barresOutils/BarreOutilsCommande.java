package ihm.barresOutils;

import java.awt.FlowLayout;

import ihm.actions.AjouterAuPanierAction;
import ihm.actions.RechercheAction;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import modele.Billeterie;

@SuppressWarnings("serial")
public class BarreOutilsCommande extends JPanel {

	private JTextField textRecherche;
	
	public BarreOutilsCommande(Billeterie billeterie) {
		textRecherche = new JTextField();
		textRecherche.setColumns(20);
		textRecherche.addKeyListener(new RechercheAction(billeterie.getListeBillets(), textRecherche));
		
		setLayout(new FlowLayout(FlowLayout.LEFT));
		this.add(textRecherche);
		this.add(new JButton(new RechercheAction(billeterie.getListeBillets(), textRecherche)));
		this.add(new JButton(new AjouterAuPanierAction(billeterie.getListeBillets())));
	}
}