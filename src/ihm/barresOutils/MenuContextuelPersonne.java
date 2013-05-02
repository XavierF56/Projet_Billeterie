package ihm.barresOutils;

import java.awt.Point;

import ihm.actions.FenetreAjouterAction;
import ihm.actions.CommandeBilletAction;
import ihm.actions.FenetreModifierAction;
import ihm.actions.SupprimerAction;
import ihm.actions.FenetreDetailsAction;

import javax.swing.JPopupMenu;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import modele.ListeObjet;

public class MenuContextuelPersonne extends JPopupMenu {
	private static final long serialVersionUID = 1L;
	ListeObjet listeObjet;
	
	public MenuContextuelPersonne (ListeObjet listeObjet, Point p, JTable table) {
		this.listeObjet = listeObjet;
		
		//Clique droit
		System.out.println(p);
		if(p != null) {
			int rowNumber = table.rowAtPoint(p);
			ListSelectionModel model = table.getSelectionModel();
			model.setSelectionInterval(rowNumber, rowNumber);
		}
		
		this.add(new FenetreAjouterAction(listeObjet, "Ajouter une nouvelle personne"));
		this.add(new FenetreModifierAction(listeObjet));
		this.add(new SupprimerAction(listeObjet));
		this.add(new FenetreDetailsAction(listeObjet));
		this.add(new CommandeBilletAction(listeObjet, listeObjet.getBilleterie()));
	}
}
