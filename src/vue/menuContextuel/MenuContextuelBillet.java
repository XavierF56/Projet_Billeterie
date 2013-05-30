package vue.menuContextuel;

import general.Langue;

import java.awt.Component;
import java.awt.Point;

import javax.swing.JPopupMenu;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import modele.ListeObjet;
import vue.fenetres.FenetrePrincipale;
import controleur.basique.FenetreAjouterAction;
import controleur.basique.FenetreRAZQuotaAction;
import controleur.basique.FenetreSupprimerAction;
import controleur.modifier.FenetreModifierAction;

@SuppressWarnings("serial")
public class MenuContextuelBillet extends JPopupMenu {
	
	private JTable table;
	
	/**
	 * Cette classe permet la gestion du clic droit dans l'onglet Billets.
	 * 
	 * @param listeObjet la liste des billets
	 * @param table une copie de la table des billets
	 * @see FenetrePrincipale
	 */
	public MenuContextuelBillet (ListeObjet listeObjet, JTable table) {
		this.table = table;
		this.add(new FenetreAjouterAction(listeObjet, Langue.getTraduction("add_new_person")));
		this.add(new FenetreModifierAction(listeObjet));
		this.add(new FenetreSupprimerAction(listeObjet));
		this.add(new FenetreRAZQuotaAction(listeObjet));
	}
	
	/**
	 * Permet l'affichage du menu contextuel
	 */
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