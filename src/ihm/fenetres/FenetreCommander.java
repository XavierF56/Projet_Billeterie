package ihm.fenetres;

import general.Langue;
import ihm.actions.CloturerCommanderAction;
import ihm.barresOutils.BarreOutilsCommande;
import ihm.barresOutils.MenuContextuelCommande;

import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
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
	private JLabel label;
	private JPanel southPane;
	private Billeterie billeterie;
	public FenetreCommander(Personne personne, Billeterie billeterie) {
		
		//Initialisation des attributs de la classe
		this.contentPane = new JPanel();
		this.southPane = new JPanel();
		this.commande = new Commande(personne);
		this.billeterie = billeterie;
		
		//Initialisation de la fenetre
		this.setTitle(Langue.getTraduction("ticket_order_for") + personne);
		this.setSize(800,600);
		contentPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 5, 10));
		this.add(contentPane);
		
		//Initialisation du tableau de billets
		tableauBillets = new JTable(billeterie.getListeBillets());
		tableauBillets.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableauBillets.setAutoCreateRowSorter(true);
		TableRowSorter<ListeBillets> sorter2 = new TableRowSorter<ListeBillets>((ListeBillets) tableauBillets.getModel());   
		tableauBillets.setRowSorter(sorter2);
		sorter2.setSortsOnUpdates(true);
		
		// Ajout des elements de la fenetre
		contentPane.setLayout(new BorderLayout(0, 0));
		JScrollPane scrollPane = new JScrollPane(tableauBillets);
		contentPane.add(scrollPane, "Center");
		contentPane.add(new BarreOutilsCommande(this, billeterie, tableauBillets, commande), "North");
		label = new JLabel(commande.toString());
		
		southPane.add(label);
		southPane.add(new JButton(new CloturerCommanderAction(this, commande)));	
		contentPane.add(southPane, "South");
		
		//Menu Contextuel
		tableauBillets.setComponentPopupMenu(new MenuContextuelCommande(this, billeterie.getListeBillets(), tableauBillets, commande));
		
		//Affichage de la fenetre
		this.afficherFenetre();
	}
	
	public void majLabel() {
		label.setText(commande.toString());
	}

	public Billeterie getBilleterie() {
		return billeterie;
	}
}
