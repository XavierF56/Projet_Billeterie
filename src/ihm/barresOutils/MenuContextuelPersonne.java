package ihm.barresOutils;

import ihm.actions.AjouterAction;
import ihm.actions.CommandeBilletAction;
import ihm.actions.ModifierAction;
import ihm.actions.SupprimerAction;
import ihm.actions.VoirAction;

import javax.swing.JPopupMenu;

import modele.ListeObjet;

public class MenuContextuelPersonne extends JPopupMenu {
	private static final long serialVersionUID = 1L;
	ListeObjet listeObjet;
	
	public MenuContextuelPersonne (ListeObjet listeObjet) {
		this.listeObjet = listeObjet;
		
		this.add(new AjouterAction(listeObjet, "Ajouter une nouvelle personne"));
		this.add(new ModifierAction(listeObjet));
		this.add(new SupprimerAction(listeObjet));
		this.add(new VoirAction(listeObjet));
		this.add(new CommandeBilletAction(listeObjet, listeObjet.getBilleterie()));
	}
	
}
