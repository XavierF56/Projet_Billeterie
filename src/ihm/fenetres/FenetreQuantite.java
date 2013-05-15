package ihm.fenetres;

import ihm.actions.valider.ValiderQuantiteAction;
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
	private PanelChoixQuantite panelChoixQuantite;
	
	public FenetreQuantite(FenetreCommander fenetreCommander, Billet billet, ListeBillets listeBillets, Commande commande) {
		this.setTitle("Choix de la quantite de billets");
		
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		panelChoixQuantite = new PanelChoixQuantite(new ValiderQuantiteAction(fenetreCommander, this, commande, billet));
		
		contentPane.add(panelChoixQuantite, "Center");
		contentPane.add(new JButton(new ValiderQuantiteAction(fenetreCommander, this, commande, billet)), "South");
		
		this.afficher();
	}

	public boolean getSubventionne() {
		return panelChoixQuantite.getSubventionne();
	}
	
	public int getQuantite() {
		return panelChoixQuantite.getQuantite();
	}

	public boolean getPaye() {
		return panelChoixQuantite.getPaye();
	}

	public boolean getDonne() {
		return panelChoixQuantite.getDonne();
	}
}