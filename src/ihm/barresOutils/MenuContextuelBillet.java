package ihm.barresOutils;

import ihm.actions.FenetreAjouterAction;
import ihm.actions.FenetreModifierAction;
import ihm.actions.SupprimerAction;

import javax.swing.JPopupMenu;

import modele.ListeObjet;

public class MenuContextuelBillet extends JPopupMenu {
	private static final long serialVersionUID = 1L;
	ListeObjet listeObjet;
	
	public MenuContextuelBillet (ListeObjet listeObjet) {
		this.listeObjet = listeObjet;
		this.add(new FenetreAjouterAction(listeObjet, "Ajouter une nouvelle personne"));
		this.add(new FenetreModifierAction(listeObjet));
		this.add(new SupprimerAction(listeObjet));
	}
	
}