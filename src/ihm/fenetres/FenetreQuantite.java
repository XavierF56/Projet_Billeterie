package ihm.fenetres;

import ihm.actions.ValiderQuantiteAction;
import ihm.barresOutils.PanelChoixQuantite;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import modele.Billet;
import modele.Commande;
import modele.ListeBillets;

@SuppressWarnings("serial")
public class FenetreQuantite extends Fenetre {
	private JPanel contentPane;
	
	public FenetreQuantite(Billet billet, ListeBillets listeBillets, Commande commande) {
		this.setTitle("Choix de la quantite de billets");
		
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		contentPane.add(new PanelChoixQuantite(), "Center");
		contentPane.add(new JButton(new ValiderQuantiteAction(this)), "South");
		
		this.afficher();
	}
}