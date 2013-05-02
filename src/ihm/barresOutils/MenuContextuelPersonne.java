package ihm.barresOutils;

import ihm.actions.FenetreAjouterAction;
import ihm.actions.CommandeBilletAction;
import ihm.actions.FenetreModifierAction;
import ihm.actions.SupprimerAction;
import ihm.actions.FenetreDetailsAction;

import javax.swing.JPopupMenu;

import modele.ListeObjet;

public class MenuContextuelPersonne extends JPopupMenu {
	private static final long serialVersionUID = 1L;
	ListeObjet listeObjet;
	
	public MenuContextuelPersonne (ListeObjet listeObjet) {
		this.listeObjet = listeObjet;
		
		this.add(new FenetreAjouterAction(listeObjet, "Ajouter une nouvelle personne"));
		this.add(new FenetreModifierAction(listeObjet));
		this.add(new SupprimerAction(listeObjet));
		this.add(new FenetreDetailsAction(listeObjet));
		this.add(new CommandeBilletAction(listeObjet, listeObjet.getBilleterie()));
	}
	
}
