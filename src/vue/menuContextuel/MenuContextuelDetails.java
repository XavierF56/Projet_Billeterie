package vue.menuContextuel;


import java.awt.Component;
import java.awt.Point;

import javax.swing.JPopupMenu;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import controleur.details.ValiderDonBilletAction;
import controleur.details.ValiderPaiementAction;

import modele.ListeAchats;

@SuppressWarnings("serial")
public class MenuContextuelDetails extends JPopupMenu {
	
	JTable tableau;
	
	/**
	 * Cette classe permet la gestion du clic droit dans la fenêtre Détails
	 * 
	 * @param listeAchats la liste des achats de la personne sélectionnée
	 * @param tableau
	 * @see FenetreDetails
	 */
	public MenuContextuelDetails (ListeAchats listeAchats, JTable tableau) {
		this.tableau = tableau;
		
		this.add(new ValiderDonBilletAction(listeAchats, tableau));
		this.add(new ValiderPaiementAction(listeAchats, tableau));
	}
	
	/**
	 * Permet l'affichage du menu contextuel
	 */
	public void show(Component invoker, int x, int y) {
		Point p = tableau.getMousePosition();

        if(p != null) {
        	int rowNumber = tableau.rowAtPoint(p);
        	ListSelectionModel model = tableau.getSelectionModel();
        	model.setSelectionInterval(rowNumber, rowNumber);
       	}

		super.show(invoker, x, y);
    }     
}
