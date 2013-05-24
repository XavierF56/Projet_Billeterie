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
public class FenetreCommandeAjouter extends Fenetre {
	
	private JPanel contentPane;
	private PanelChoixQuantite panelChoixQuantite;
	private boolean sub;
	
	public FenetreCommandeAjouter(FenetreCommander fenetreCommander, Billet billet, ListeBillets listeBillets, Commande commande) {
		this.setTitle(Langue.getTraduction("choice_title"));
		this.sub = billet.getSub();
		
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		panelChoixQuantite = new PanelChoixQuantite(sub, new ValiderQuantiteAction(fenetreCommander, this, commande, billet));
		
		contentPane.add(panelChoixQuantite, "Center");
		contentPane.add(new JButton(new ValiderQuantiteAction(fenetreCommander, this, commande, billet)), "South");
		
		this.afficherDialog();
	}

	public boolean getSubventionne() {
		if(sub)
			return panelChoixQuantite.getSubventionne();
		else
			return false;
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