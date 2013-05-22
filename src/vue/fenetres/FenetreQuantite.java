package vue.fenetres;


import general.Langue;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import controleur.commande.ValiderQuantiteAction;

import vue.outils.PanelChoixQuantite;

import modele.Billet;
import modele.Commande;
import modele.ListeBillets;

@SuppressWarnings("serial")
public class FenetreQuantite extends Fenetre {
	
	private JPanel contentPane;
	private PanelChoixQuantite panelChoixQuantite;
	
	public FenetreQuantite(FenetreCommander fenetreCommander, Billet billet, ListeBillets listeBillets, Commande commande) {
		this.setTitle(Langue.getTraduction("choice_title"));
		
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		panelChoixQuantite = new PanelChoixQuantite(new ValiderQuantiteAction(fenetreCommander, this, commande, billet));
		
		contentPane.add(panelChoixQuantite, "Center");
		contentPane.add(new JButton(new ValiderQuantiteAction(fenetreCommander, this, commande, billet)), "South");
		
		this.afficherDialog();
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