package vue.menuContextuel;


import java.awt.Component;
import java.awt.Point;

import javax.swing.JPopupMenu;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import controleur.commande.FenetreQuantiteAction;

import vue.fenetres.FenetreCommander;

import modele.Commande;
import modele.ListeBillets;

@SuppressWarnings("serial")
public class MenuContextuelCommande extends JPopupMenu {
	JTable tableau;
	
	/**
	 * Cette classe permet la gestion du clic droit dans la fenêtre Commander
	 * 
	 * @param fenetre la fenetre Commander en cours
	 * @param listeBillets la liste des billets
	 * @param tableau une copie du tableau des billets
	 * @param commande la commande en cours
	 * @see FenetreCommande
	 */
	public MenuContextuelCommande (FenetreCommander fenetre, ListeBillets listeBillets, JTable tableau, Commande commande) {
		this.tableau = tableau;
		
		this.add(new FenetreQuantiteAction(fenetre, listeBillets, tableau, commande));
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
