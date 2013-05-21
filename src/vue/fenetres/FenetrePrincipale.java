package vue.fenetres;

import general.Constantes;
import general.Langue;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableRowSorter;

import controleur.option.OptionSelectionMultipleListener;

import vue.barreOutils.BarreOutilsBillets;
import vue.barreOutils.BarreOutilsPersonnes;
import vue.menuContextuel.MenuContextuelBillet;
import vue.menuContextuel.MenuContextuelPersonne;
import vue.outils.MultiLineLabel;

import modele.Billeterie;
import modele.ListeBillets;
import modele.ListePersonnes;


@SuppressWarnings("serial")
public class FenetrePrincipale extends Fenetre {
	
	private Billeterie billeterie;
	private JPanel contentPane;
	private JTable tableauPersonnes;
	private JTable tableauBillets;
	private OngletStats ongletStats;
	
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
		
		/* Fenetre */
		this.setTitle(Constantes.nomLogiciel /*+ Langue.getTraduction("annuler")*/);
		setSize(1000, 600);
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
		
		tableauPersonnes.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS );
		
		ongletPersonne.setLayout(new BorderLayout(0, 0));
		BarreOutilsPersonnes barre = new BarreOutilsPersonnes(billeterie);
		ongletPersonne.add(barre, "North");
		tableauPersonnes.setComponentPopupMenu(new MenuContextuelPersonne(billeterie.getListePersonnes(), tableauPersonnes));
		ongletPersonne.add(new JScrollPane(tableauPersonnes), "Center");
		
		Onglets.addTab(Langue.getTraduction("persons"), null, ongletPersonne, null);
		
		
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
		
		Onglets.addTab(Langue.getTraduction("tickets"), null, ongletBillet, null);
		
		
		/* Onglet Options */
		GridBagConstraints gridBagConstraints = new GridBagConstraints();
		JPanel ongletOptions = new JPanel();
		ongletOptions.setLayout(new GridBagLayout());
		gridBagConstraints.anchor = GridBagConstraints.LINE_START;
		
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 0;
		ongletOptions.add(new JLabel(Langue.getTraduction("option_multiselection")), gridBagConstraints);
		gridBagConstraints.gridx = 1;
		JCheckBox chckbxSelectionMultiple = new JCheckBox("");
		chckbxSelectionMultiple.addActionListener(new OptionSelectionMultipleListener(chckbxSelectionMultiple, billeterie));
		ongletOptions.add(chckbxSelectionMultiple, gridBagConstraints);
		
		gridBagConstraints.gridy = 1;
		gridBagConstraints.gridx = 0;
		ongletOptions.add(new JLabel(Langue.getTraduction("option_language")), gridBagConstraints);
		gridBagConstraints.gridx = 1;
		ongletOptions.add(Langue.choixLangueMenu(this), gridBagConstraints);
		
		Onglets.addTab("Options", null, ongletOptions, null);
		
		/* Onglet Statistique */
		ongletStats = new OngletStats(billeterie);
		Onglets.addTab(Langue.getTraduction("statistics"), null, ongletStats, null);
		
		/* Onglet A propos */
		JPanel ongletAPropos = new JPanel();
		MultiLineLabel multiLineLabel = new MultiLineLabel(Langue.aPropos());
		ongletAPropos.add(multiLineLabel);
		Onglets.addTab(Langue.getTraduction("about") + Constantes.nomLogiciel, null, ongletAPropos, null);
		
		
		this.afficherFenetre();
	}

	public JTable getTableauPersonnes() {
		return tableauPersonnes;
	}
	public JTable getTableauBillets() {
		return tableauBillets;
	}
	public OngletStats getOngletStats() {
		return ongletStats;
	}
}
