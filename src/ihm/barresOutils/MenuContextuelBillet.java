package ihm.barresOutils;

import ihm.actions.AjouterAction;
import ihm.actions.ModifierAction;
import ihm.actions.SupprimerAction;

import javax.swing.JPopupMenu;

import modele.ListeObjet;

public class MenuContextuelBillet extends JPopupMenu {
	private static final long serialVersionUID = 1L;
	ListeObjet listeObjet;
	
	public MenuContextuelBillet (ListeObjet listeObjet) {
		this.listeObjet = listeObjet;
		this.add(new AjouterAction(listeObjet, "Ajouter une nouvelle personne"));
		this.add(new ModifierAction(listeObjet));
		this.add(new SupprimerAction(listeObjet));
	}
	
}