package vue.menuContextuel;

import general.Langue;

import java.awt.Component;
import java.awt.Point;


import javax.swing.JPopupMenu;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import controleur.basique.FenetreAjouterAction;
import controleur.basique.FenetreSupprimerAction;
import controleur.commande.FenetreCommanderAction;
import controleur.details.FenetreDetailsAction;
import controleur.modifier.FenetreModifierAction;

import modele.ListeObjet;

@SuppressWarnings("serial")
public class MenuContextuelPersonne extends JPopupMenu {

	private JTable table;
	
	/**
	 * Cette classe permet la gestion du clic droit dans l'onglet Personnes.
	 * 
	 * @param listeObjet la liste des personnes
	 * @param table une copie de la table des personnes
	 * @see FenetrePrincipale
	 */
	public MenuContextuelPersonne (ListeObjet listeObjet, JTable table) {
		this.table = table;
		
		this.add(new FenetreAjouterAction(listeObjet, Langue.getTraduction("add_new_person")));
		this.add(new FenetreModifierAction(listeObjet));
		this.add(new FenetreSupprimerAction(listeObjet));
		this.add(new FenetreDetailsAction(listeObjet.getBilleterie()));
		this.add(new FenetreCommanderAction(listeObjet, listeObjet.getBilleterie()));
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
