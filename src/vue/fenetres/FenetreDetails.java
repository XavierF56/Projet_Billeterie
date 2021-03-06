package vue.fenetres;


import general.Langue;

import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableRowSorter;

import vue.barreOutils.BarreOutilsDetails;
import vue.menuContextuel.MenuContextuelDetails;

import modele.ListeAchats;
import modele.Personne;

@SuppressWarnings("serial")
public class FenetreDetails extends Fenetre {
	
	private JPanel contentPane;
	private JTable tableau;
	private Personne personne;
	
	/**
	 * Classe permettant la gestion de l'affichage de la fenêtre Détails.
	 * Cette fenêtre permet à l'utilisteur de consulter l'historique des achats d'une personne ;
	 * elle donne aussi la possibilité de payer ou de donner des billets après une commande.
	 * 
	 * @param pers la personne selectionnée
	 */
	public FenetreDetails(Personne pers) {
		
		this.personne = pers;
		
		/* Fenêtre */
		this.setTitle(Langue.getTraduction("information_about") + " " + personne);
		this.setSize(800,600);
		contentPane = new JPanel();
		contentPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 5, 10));
		contentPane.setLayout(new BorderLayout(0, 0));
		this.add(contentPane);
		
		/* Label restant a payer */
		contentPane.add(new JLabel(Langue.getTraduction("left_to_pay") + " : " 
				+ personne.getRestantAPayer() + " euros"), "North");

		/* Tableau */
		tableau = new JTable(personne.getAchats());
		personne.getAchats().setTableau(tableau);
		tableau.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableau.setAutoCreateRowSorter(true);// Gestion des tableaux triables
		TableRowSorter<ListeAchats> sorter = new TableRowSorter<ListeAchats>((ListeAchats) tableau.getModel());   
		tableau.setRowSorter(sorter);
		sorter.setSortsOnUpdates(true);
		contentPane.add(new JScrollPane(tableau), "Center");
		
		TableColumn col = tableau.getColumnModel().getColumn(0);        
        col.setPreferredWidth(200);
		
        /* BarreOutils */
		contentPane.add(new BarreOutilsDetails(this, personne.getAchats(), tableau), "South");
		
		/* Menu Contextuel */
		tableau.setComponentPopupMenu(new MenuContextuelDetails(personne.getAchats(), tableau));

		/* Affichage de la fenetre */
		this.afficherFenetre();
	}
	
	public Personne getPersonne() {
		return personne;
	}
}
