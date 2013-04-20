package ihm.fenetres;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableRowSorter;

import modele.ListeAchats;
import modele.Personne;

public class FenetreDetailsPersonne extends Fenetre {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tableau;
	Personne personne;
	
	public FenetreDetailsPersonne(Personne personne) {
		this.personne = personne;
		setBounds(100, 100, 700, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		tableau = new JTable(personne.getAchats());
		personne.getAchats().setTableau(tableau);
		tableau.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		tableau.setAutoCreateRowSorter(true);// Gestion des tableaux triables
		TableRowSorter<ListeAchats> sorter = new TableRowSorter<ListeAchats>((ListeAchats) tableau.getModel());   
		tableau.setRowSorter(sorter);
		sorter.setSortsOnUpdates(true);
		add(new JScrollPane(tableau), "Center");
		this.ajusterEtCentrer();
		setVisible(true);
	}
	
}
