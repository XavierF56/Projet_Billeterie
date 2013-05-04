package ihm.fenetres;

import ihm.actions.ValiderCommanderAction;
import ihm.barresOutils.BarreOutilsCommande;

import java.awt.BorderLayout;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableRowSorter;

import modele.Billeterie;
import modele.Commande;
import modele.ListeBillets;
import modele.Personne;

@SuppressWarnings("serial")
public class FenetreCommander extends Fenetre {
	private JPanel contentPane;
	private JTable tableauBillets;
	private Commande commande;
	private JTextPane txtPane;
	private JPanel southPane;
	
	public FenetreCommander(Personne personne, Billeterie billeterie) {
		//Initialisation des attributs de la classe
		this.setTitle("Commande de billet pour "+ personne);
		this.contentPane = new JPanel();
		this.southPane = new JPanel();
		this.commande = new Commande(personne);
		contentPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 5, 10));
		this.add(contentPane);
		
		//Initialisation du tableau de billets
		tableauBillets = new JTable(billeterie.getListeBillets());
		tableauBillets.addMouseListener(new CliqueGauche(tableauBillets, billeterie.getListeBillets().getTableau().getSelectionModel()));
		tableauBillets.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableauBillets.setAutoCreateRowSorter(true);
		TableRowSorter<ListeBillets> sorter2 = new TableRowSorter<ListeBillets>((ListeBillets) tableauBillets.getModel());   
		tableauBillets.setRowSorter(sorter2);
		sorter2.setSortsOnUpdates(true);
		
		// Ajout des elements de la fenetre
		contentPane.setLayout(new BorderLayout(0, 0));
		JScrollPane scrollPane = new JScrollPane(tableauBillets);
		contentPane.add(scrollPane, "Center");
		contentPane.add(new BarreOutilsCommande(billeterie), "North");
		txtPane = new JTextPane();
		txtPane.setText(commande.toString());
		
		southPane.add(txtPane);
		southPane.add(new JButton(new ValiderCommanderAction(this, commande)));	
		contentPane.add(southPane, "South");
		
		//Affichage de la fenetre
		this.afficher();
	}
	
	/**
	 * La class CliqueGauche est utilise pour modifier la ligne selectionne lors d'un clique gauche.
	 * En effet, a cause de l'utilisation a deux reprises du même modele dans deux tableaux diffrents, 
	 * un bug avait lieu. Le tableau de fenetre commande utilisait la meme selection que celui present 
	 * dans l'onglet Billets. Ainsi, si on avait selectionne le billet numero x dans l'onglet Billets, 
	 * la fonction retournant la ligne selectionnee dans le tableau de FenetreCommande retournait x
	 * sans s'occuper de la ligne selectionner dans FenetreCommande.
	 */
	private class CliqueGauche extends MouseAdapter {
		JTable table;
		ListSelectionModel model;
        private CliqueGauche(JTable table, ListSelectionModel model) {
            super();
            this.table = table;
            this.model = model;
        }
 
        public void mousePressed (MouseEvent e) {
            int buttonDown = e.getButton();
         
            if (buttonDown == MouseEvent.BUTTON1) {
            	Point p = e.getPoint();
            	System.out.println("Point :" + p);

                if(p != null) {
                	int rowNumber = table.rowAtPoint(p);
                	System.out.println("ligne :" + rowNumber);
                	model.setSelectionInterval(rowNumber, rowNumber);
               	}
            } 
         }
    }
}
