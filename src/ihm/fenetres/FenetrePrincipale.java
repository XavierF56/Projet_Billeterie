package ihm.fenetres;

import general.Constantes;
import general.Langue;
import general.MultiLineLabel;
import ihm.actions.OptionSelectionMultipleListener;
import ihm.barresOutils.BarreOutilsBillets;
import ihm.barresOutils.BarreOutilsPersonnes;
import ihm.barresOutils.MenuContextuelBillet;
import ihm.barresOutils.MenuContextuelPersonne;

import java.awt.BorderLayout;

import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableRowSorter;

import modele.Billeterie;
import modele.ListeBillets;
import modele.ListePersonnes;



@SuppressWarnings("serial")
public class FenetrePrincipale extends Fenetre {
	
	private Billeterie billeterie;
	private JPanel contentPane;
	private JTable tableauPersonnes;
	private JTable tableauBillets;
	
	/**
	 * Create the frame.
	 */
	public FenetrePrincipale(Billeterie billets) {
		
		this.billeterie = billets;
		billeterie.setFenetre(this);
		
		/* Theme */
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			/*for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
				UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
				break;
				}
			} */
		} catch (Exception e) {
			Constantes.afficherException(e);
		}
		
		/* Langue */
		Langue.majLangue();
		
		/* Fenetre */
		this.setTitle(Constantes.nomLogiciel);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.X_AXIS));
		JTabbedPane Onglets = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(Onglets);
		

		
		/* Onglet Personnes */
		JPanel ongletPersonne = new JPanel();
		tableauPersonnes = new JTable(billeterie.getListePersonnes());
		billeterie.getListePersonnes().setTableau(tableauPersonnes);
		tableauPersonnes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		tableauPersonnes.setAutoCreateRowSorter(true);// Gestion des tableaux triables
		TableRowSorter<ListePersonnes> sorter = new TableRowSorter<ListePersonnes>((ListePersonnes) tableauPersonnes.getModel());   
		tableauPersonnes.setRowSorter(sorter);
		sorter.setSortsOnUpdates(true);
		
		ongletPersonne.setLayout(new BorderLayout(0, 0));
		BarreOutilsPersonnes barre = new BarreOutilsPersonnes(billeterie);
		ongletPersonne.add(barre, "North");
		tableauPersonnes.setComponentPopupMenu(new MenuContextuelPersonne(billeterie.getListePersonnes(), tableauPersonnes));
		ongletPersonne.add(new JScrollPane(tableauPersonnes), "Center");
		
		Onglets.addTab(Langue.titreOngletPersonne, null, ongletPersonne, null);
		
		
		/* Onglet Billets */
		JPanel ongletBillet = new JPanel();
		tableauBillets = new JTable(billeterie.getListeBillets());
		tableauBillets.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		billeterie.getListeBillets().setTableau(tableauBillets);
		
		tableauBillets.setAutoCreateRowSorter(true);// Gestion des tableaux triables
		TableRowSorter<ListeBillets> sorter2 = new TableRowSorter<ListeBillets>((ListeBillets) tableauBillets.getModel());   
		tableauBillets.setRowSorter(sorter2);
		sorter2.setSortsOnUpdates(true);
		
		ongletBillet.setLayout(new BorderLayout(0, 0));
		ongletBillet.add(new BarreOutilsBillets(billeterie), "North");
		tableauBillets.setComponentPopupMenu(new MenuContextuelBillet(billeterie.getListeBillets(), tableauBillets));
		ongletBillet.add(new JScrollPane(tableauBillets), "Center");
		
		Onglets.addTab(Langue.titreOngletBillet, null, ongletBillet, null);
		
		
		/* Onglet Options */
		JPanel OngletOptions = new JPanel();
		JCheckBox chckbxSelectionMultiple = new JCheckBox("Utiliser la selection multiple");
		chckbxSelectionMultiple.addActionListener(new OptionSelectionMultipleListener(chckbxSelectionMultiple, billeterie));
		OngletOptions.add(chckbxSelectionMultiple, "North");
		Onglets.addTab("Options", null, OngletOptions, null);
		
		/* Onglet A propos */
		JPanel OngletAPropos = new JPanel();
		MultiLineLabel multiLineLabel = new MultiLineLabel(Langue.aPropos());
		OngletAPropos.add(multiLineLabel);
		Onglets.addTab(Langue.titreOngletAPropos, null, OngletAPropos, null);
		
		
		this.afficher();
	}

	public JTable getTableauPersonnes() {
		return tableauPersonnes;
	}
	public JTable getTableauBillets() {
		return tableauBillets;
	}
}
