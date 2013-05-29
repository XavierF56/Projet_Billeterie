package vue.fenetres;


import general.Langue;
import general.Constantes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	
	/**
	 * Classe permettant de générer la fenêtre qui permet à l'utilisateur d'ajouter un achat à la commande et de choisirs la quantité de billets à réserver
	 * Cette classe est appelée après avoir sélectionné un billet dans la fenêtre Commander
	 * 
	 * @param fenetreCommander la fenetre commander en cours
	 * @param billet le billet selectionne
	 * @param listeBillets la liste des billets
	 * @param commande la commande en cours
	 * @see FenetreCommander
	 * @see Billet
	 * @see ListeBillets
	 * @see Commande
	 */
	public FenetreCommandeAjouter(FenetreCommander fenetre, Billet billet, ListeBillets listeBillets, Commande commande) {
		
		/* Fenetre */
		this.setTitle(Langue.getTraduction("choice_title")+ " : " + billet);
		this.sub = billet.getSub();
		
		contentPane = new JPanel();
		contentPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 5, 10));
		setContentPane(contentPane);
		
		/* Champs */
		List<Attribut> map = new ArrayList<Attribut>();
		Map<String, Object> valeurs =  new HashMap<String, Object>();
		map.add(new Attribut("quantite", Langue.getTraduction("qt"), Constantes.INTEGER));
		
		if (sub) {
			map.add(new Attribut("subventionne", Langue.getTraduction("subsidizes_ticket"), Constantes.BOOLEAN));
			valeurs.put("subventionne", true);
		}
		map.add(new Attribut("paye", Langue.getTraduction("paid_person"), Constantes.BOOLEAN));
		valeurs.put("paye", true);
		map.add(new Attribut("donne", Langue.getTraduction("given_person"), Constantes.BOOLEAN));
		valeurs.put("donne", true);
		Champs champs = new Champs(map);
		champs.setValeurs(valeurs);
		
		contentPane.add(champs, "North");
		contentPane.add(new JButton(new ValiderQuantiteAction(fenetre, this, commande, billet, champs)), "South");
		
		/* Affichage de la fenetre */
		this.afficherDialog();
	}
}