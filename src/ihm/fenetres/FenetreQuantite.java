package ihm.fenetres;

import ihm.actions.ValiderQuantiteAction;

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
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		

		
		contentPane.add(new JButton(new ValiderQuantiteAction(this)), "South");
		
		
		this.afficher();
	}
}