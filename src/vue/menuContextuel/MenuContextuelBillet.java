package vue.menuContextuel;

import general.Langue;

import java.awt.Component;
import java.awt.Point;


import javax.swing.JPopupMenu;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import controleur.basique.FenetreAjouterAction;
import controleur.basique.FenetreModifierAction;
import controleur.basique.FenetreSupprimerAction;

import modele.ListeObjet;

@SuppressWarnings("serial")
public class MenuContextuelBillet extends JPopupMenu {
	
	private JTable table;
	
	public MenuContextuelBillet (ListeObjet listeObjet, JTable table) {
		this.table = table;
		this.add(new FenetreAjouterAction(listeObjet, Langue.getTraduction("add_new_person")));
		this.add(new FenetreModifierAction(listeObjet));
		this.add(new FenetreSupprimerAction(listeObjet));
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