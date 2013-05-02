package ihm.fenetres;

import ihm.barresOutils.BarreOutilsBillets;
import ihm.barresOutils.BarreOutilsPersonnes;
import ihm.barresOutils.MenuContextuelBillet;
import ihm.barresOutils.MenuContextuelPersonne;

import java.awt.BorderLayout;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableRowSorter;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;

import modele.Billeterie;
import modele.ListeBillets;
import modele.ListePersonnes;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


@SuppressWarnings("serial")
public class FenetrePrincipale extends Fenetre {
	
	@SuppressWarnings("unused")
	private Billeterie billeterie;
	private JPanel contentPane;
	private boolean opt;
	private JTable tableauPersonnes;
	private JTable tableauBillets;
	
	/**
	 * Create the frame.
	 */
	public FenetrePrincipale(Billeterie billeterie) {
		this.billeterie = billeterie;
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
		}
		
		/* Fenetre */
		this.setTitle("Billeterie INSA");
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
		tableauPersonnes.setComponentPopupMenu(new MenuContextuelPersonne(billeterie.getListePersonnes()));
		ongletPersonne.add(new JScrollPane(tableauPersonnes), "Center");
		
		Onglets.addTab("Personnes", null, ongletPersonne, null);
		
		
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
		tableauBillets.setComponentPopupMenu(new MenuContextuelBillet(billeterie.getListeBillets()));
		ongletBillet.add(new JScrollPane(tableauBillets), "Center");
		
		Onglets.addTab("Billets", null, ongletBillet, null);
		
		
		/* Onglet Options */
		JPanel OngletOptions = new JPanel();
		JCheckBox chckbxVerrouillerLaSuppression = new JCheckBox("Verrouiller la suppression");
		chckbxVerrouillerLaSuppression.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(opt);
			}
		});
		OngletOptions.add(chckbxVerrouillerLaSuppression, "North");
		Onglets.addTab("Options", null, OngletOptions, null);
		
		
		this.afficher();
	}

	public JTable getTableau() {
		return tableauPersonnes;
	}
}
