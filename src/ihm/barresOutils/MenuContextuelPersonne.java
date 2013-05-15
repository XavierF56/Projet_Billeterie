package ihm.barresOutils;

import java.awt.Component;
import java.awt.Point;

import ihm.actions.fenetre.FenetreAjouterAction;
import ihm.actions.fenetre.FenetreCommanderAction;
import ihm.actions.fenetre.FenetreDetailsAction;
import ihm.actions.fenetre.FenetreModifierAction;
import ihm.actions.fenetre.FenetreSupprimerAction;

import javax.swing.JPopupMenu;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import modele.ListeObjet;

@SuppressWarnings("serial")
public class MenuContextuelPersonne extends JPopupMenu {

	private JTable table;
	
	public MenuContextuelPersonne (ListeObjet listeObjet, JTable table) {
		this.table = table;
		
		this.add(new FenetreAjouterAction(listeObjet, "Ajouter une nouvelle personne"));
		this.add(new FenetreModifierAction(listeObjet));
		this.add(new FenetreSupprimerAction(listeObjet));
		this.add(new FenetreDetailsAction(listeObjet.getBilleterie()));
		this.add(new FenetreCommanderAction(listeObjet, listeObjet.getBilleterie()));
	}
	
	public void show(Component invoker, int x, int y) {
		Point p = table.getMousePosition();

        if(p != null) {
        	int rowNumber = table.rowAtPoint(p);
        	ListSelectionModel model = table.getSelectionModel();
        	model.setSelectionInterval(rowNumber, rowNumber);
       	}

		super.show(invoker, x, y);
    }     
}
