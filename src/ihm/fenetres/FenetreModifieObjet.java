package ihm.fenetres;


import java.awt.BorderLayout;

import ihm.actions.ValiderModificationAction;
import ihm.barresOutils.Champs;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

import modele.ListeObjet;
import modele.Objet;

@SuppressWarnings("serial")
public class FenetreModifieObjet extends Fenetre {
	private Objet objetTraite;
	private Champs champs;
	private ListeObjet objets;
	
	public FenetreModifieObjet(Objet objetTraite, ListeObjet listeObjet) {
		this.objetTraite = objetTraite;
		this.objets = listeObjet;
		
		//Fenetre
		this.setTitle("Modification de " + objetTraite);
		JPanel fenetre = new JPanel(new BorderLayout());
		fenetre.setBorder(BorderFactory.createEmptyBorder(10, 10, 5, 10));
		this.add(fenetre);
		
		//Champs
		champs = new Champs(objets.getAttributs());
		champs.setValeurs(objetTraite.getHashMap());
		fenetre.add(champs, "Center");
		champs.ajouterListener(new ValiderModificationAction(this));
		
		//Bouton Valider
		JButton button = new JButton(new ValiderModificationAction(this));
		JPanel panelSouth = new JPanel();
		panelSouth.add(button);
		fenetre.add(panelSouth, "South");
		
		this.afficher();
	}
	
	public Champs getChamps() {
		return champs;
	}
	
	public Objet getObjetTraite() {
		return objetTraite;
	}
	
	public ListeObjet getObjets() {
		return objets;
	}
}