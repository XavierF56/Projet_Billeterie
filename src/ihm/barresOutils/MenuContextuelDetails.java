package ihm.barresOutils;

import ihm.actions.valider.ValiderDonBilletAction;
import ihm.actions.valider.ValiderPaiementAction;

import java.awt.Component;
import java.awt.Point;

import javax.swing.JPopupMenu;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import modele.ListeAchats;

@SuppressWarnings("serial")
public class MenuContextuelDetails extends JPopupMenu {
	JTable tableau;
	
	public MenuContextuelDetails (ListeAchats listeAchats, JTable tableau) {
		this.tableau = tableau;
		
		this.add(new ValiderDonBilletAction(listeAchats, tableau));
		this.add(new ValiderPaiementAction(listeAchats, tableau));
	}
	
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
