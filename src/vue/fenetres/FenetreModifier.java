package vue.fenetres;


import java.awt.BorderLayout;

import general.Langue;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

import controleur.modifier.ValiderModifierAction;

import vue.outils.Champs;

import modele.ListeObjet;
import modele.Objet;

@SuppressWarnings("serial")
public class FenetreModifier extends Fenetre {
	
	private Objet objetTraite;
	private Champs champs;
	private ListeObjet objets;
	
	/**
	 * Cette classe permet la gestion de l'affichage de la fenêtre Modifier.
	 * Cette fenêtre permet à l'utilisateur de modifier les attributs d'un objet (Billet ou Personne).
	 * 
	 * @param objetTraite l'objet sélectionné
	 * @param listeObjet la liste des différents objets (Billets ou Personnes)
	 */
	public FenetreModifier(Objet objetTraite, ListeObjet listeObjet) {
		this.objetTraite = objetTraite;
		this.objets = listeObjet;
		
		/* Fenêtre */
		this.setTitle(Langue.getTraduction("modification") + objetTraite);
		JPanel fenetre = new JPanel(new BorderLayout());
		fenetre.setBorder(BorderFactory.createEmptyBorder(10, 10, 5, 10));
		this.add(fenetre);
		
		/* Champs */
		boolean sub = objetTraite.getSub();
		if (sub) {
			champs = new Champs(listeObjet.getAttributs());
		} else  {
			champs = new Champs(listeObjet.getAttributsRed());
		}
		champs.setValeurs(objetTraite.getHashMap());
		fenetre.add(champs, "Center");
		champs.ajouterListener(new ValiderModifierAction(this));
		
		/* Bouton Valider */
		JButton button = new JButton(new ValiderModifierAction(this));
		JPanel panelSouth = new JPanel();
		panelSouth.add(button);
		fenetre.add(panelSouth, "South");
		
		/* Affichage de la fenetre */
		this.afficherDialog();
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