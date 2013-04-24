package ihm.fenetres;

import ihm.actions.ValiderCommandeAction;
import ihm.barresOutils.BarreOutilsCommande;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableRowSorter;

import modele.Billeterie;
import modele.ListeBillets;
import modele.Personne;

@SuppressWarnings("serial")
public class FenetreCommande extends Fenetre {
	private JPanel contentPane;
	private Billeterie billeterie;
	private JTable tableauBillets;
	
	public FenetreCommande(Personne personne, Billeterie billets) {
		this.setTitle("Commande de billet pour "+ personne);
		this.billeterie = billets;
		this.billeterie.setFenetre(this);
		
		contentPane = new JPanel();
		setContentPane(contentPane);
		
		tableauBillets = new JTable(billeterie.getListeBillets());
		tableauBillets.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		billeterie.getListeBillets().setTableau(tableauBillets);
		
		tableauBillets.setAutoCreateRowSorter(true);// Gestion des tableaux triables
		TableRowSorter<ListeBillets> sorter2 = new TableRowSorter<ListeBillets>((ListeBillets) tableauBillets.getModel());   
		tableauBillets.setRowSorter(sorter2);
		sorter2.setSortsOnUpdates(true);
		
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(new JScrollPane(tableauBillets), "Center");
		contentPane.add(new JButton(new ValiderCommandeAction(this)), "South");
		
		contentPane.add(new BarreOutilsCommande(billeterie), "North");
		
		this.afficher();
	}
}
