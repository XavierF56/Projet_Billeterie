package ihm.fenetres;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableRowSorter;

import modele.ListeAchats;
import modele.Personne;

@SuppressWarnings("serial")
public class FenetreDetails extends Fenetre {
	private JPanel contentPane;
	private JTable tableau;
	Personne personne;
	
	public FenetreDetails(Personne personne) {
		this.setTitle("Informations sur les achat de " + personne);
		this.personne = personne;
		contentPane = new JPanel();
		setContentPane(contentPane);
		
		tableau = new JTable(personne.getAchats());
		personne.getAchats().setTableau(tableau);
		tableau.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		tableau.setAutoCreateRowSorter(true);// Gestion des tableaux triables
		TableRowSorter<ListeAchats> sorter = new TableRowSorter<ListeAchats>((ListeAchats) tableau.getModel());   
		tableau.setRowSorter(sorter);
		sorter.setSortsOnUpdates(true);
		add(new JScrollPane(tableau), "Center");
		add(new JLabel("Restant à payer : " + personne.restantAPayer() + "€"), "North");
		
		this.afficher();
	}
}
