package vue.fenetres;

import general.Constantes;
import general.Langue;
import general.Proprietes;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
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

import modele.Billetterie;
import modele.ListeBillets;
import modele.ListePersonnes;
import vue.barreOutils.BarreOutilsBillets;
import vue.barreOutils.BarreOutilsPersonnes;
import vue.menuContextuel.MenuContextuelBillet;
import vue.menuContextuel.MenuContextuelPersonne;
import vue.outils.MultiLineLabel;
import controleur.option.OptionSelectionMultipleListener;


@SuppressWarnings("serial")
public class FenetrePrincipale extends Fenetre {
	
	private Billetterie billeterie;
	private JPanel contentPane;
	private JTable tableauPersonnes;
	private JTable tableauBillets;
	private OngletStats ongletStats;
	
	/**
	 * Cette classe permet la gestion de l'affichage de la fenêtre Principale.
	 * Cette fenêtre constitue le coprs de l'application et permet à l'utilisteur d'accéder à différents onglets.
	 * 
	 * @param billets la billeterie en cours
	 * @see Billetterie
	 */
	public FenetrePrincipale(Billetterie billets) {
		
		this.billeterie = billets;
		billeterie.setFenetre(this);

		/* Gestion du thème */
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
		this.setTitle(Proprietes.getOption("nomLogiciel"));
		setSize(1000, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.X_AXIS));
		JTabbedPane onglets = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(onglets);
		

		
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
		try {
			onglets.addTab(Langue.getTraduction("persons"), new ImageIcon(this.getClass().getResource("icon_personne.png")), ongletPersonne, null);
		} catch (Exception e) {
			onglets.addTab(Langue.getTraduction("persons"), null, ongletPersonne, null);
		}
		
		
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
		
		try {
			onglets.addTab(Langue.getTraduction("tickets"), new ImageIcon(this.getClass().getResource("icon_ticket.png")), ongletBillet, null);
		} catch (Exception e) {
			onglets.addTab(Langue.getTraduction("tickets"), null, ongletBillet, null);
		}
		
		
		
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
		try {
			onglets.addTab(Langue.getTraduction("options"),new ImageIcon(this.getClass().getResource("icon_option.png")), ongletOptions, null);		
		} catch (Exception e) {
			onglets.addTab(Langue.getTraduction("options"), null, ongletOptions, null);
		}
		
		/* Onglet Statistique */
		ongletStats = new OngletStats(billeterie);
		try {
			onglets.addTab(Langue.getTraduction("statistics"),new ImageIcon(this.getClass().getResource("icon_stats.png")), ongletStats, null);		
		} catch (Exception e) {
			onglets.addTab(Langue.getTraduction("statistics"), null, ongletStats, null);
		}
		
		/* Onglet A propos */
		JPanel ongletAPropos = new JPanel();
		MultiLineLabel multiLineLabel = new MultiLineLabel(Langue.aPropos());
		ongletAPropos.add(multiLineLabel);
		onglets.addTab(Langue.getTraduction("about") + Proprietes.getOption("nomLogiciel"), null, ongletAPropos, null);
		
		/* Affichage de la fenetre */
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
