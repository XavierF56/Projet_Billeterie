package vue.fenetres;


import general.Langue;
import general.Constantes;

import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

import modele.Attribut;
import modele.Billet;
import modele.Commande;
import modele.ListeBillets;
import vue.outils.Champs;
import controleur.commande.ValiderQuantiteAction;

@SuppressWarnings("serial")
public class FenetreCommandeAjouter extends Fenetre {
	
	private JPanel contentPane;
	private boolean sub;
	
	public FenetreCommandeAjouter(FenetreCommander fenetreCommander, Billet billet, ListeBillets listeBillets, Commande commande) {
		this.setTitle(Langue.getTraduction("choice_title"));
		this.sub = billet.getSub();
		
		contentPane = new JPanel();
		contentPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 5, 10));
		setContentPane(contentPane);
		
		List<Attribut> map = new ArrayList<Attribut>();
		map.add(new Attribut("quantite", Langue.getTraduction("qt"), Constantes.INTEGER));
		if (sub) {
			map.add(new Attribut("subventionne", Langue.getTraduction("subsidizes_ticket"), Constantes.BOOLEAN));
		}
		map.add(new Attribut("paye", Langue.getTraduction("paid_person"), Constantes.BOOLEAN));
		map.add(new Attribut("donne", Langue.getTraduction("given_person"), Constantes.BOOLEAN));
		Champs champs = new Champs(map);
		
		contentPane.add(champs, "North");
		contentPane.add(new JButton(new ValiderQuantiteAction(fenetreCommander, this, commande, billet, champs)), "South");
		
		this.afficherDialog();
	}
}