package ihm.fenetres;

import ihm.barresOutils.BarreOutilsBillets;
import ihm.barresOutils.BarreOutilsPersonnes;

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
import javax.swing.UIManager.LookAndFeelInfo;

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
		
		try {
		    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		        if ("Nimbus".equals(info.getName())) {
		            UIManager.setLookAndFeel(info.getClassName());
		            break;
		        }
		    }
		} catch (Exception e) {
		    // If Nimbus is not available, you can set the GUI to another look and feel.
		}
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.X_AXIS));
		JTabbedPane Onglets = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(Onglets);
		
		/* Onglet Personnes */
		JPanel OngletPersonne = new JPanel();
		tableauPersonnes = new JTable(billeterie.getListePersonnes());
		billeterie.getListePersonnes().setTableau(tableauPersonnes);
		tableauPersonnes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		tableauPersonnes.setAutoCreateRowSorter(true);// Gestion des tableaux triables
		TableRowSorter<ListePersonnes> sorter = new TableRowSorter<ListePersonnes>((ListePersonnes) tableauPersonnes.getModel());   
		tableauPersonnes.setRowSorter(sorter);
		sorter.setSortsOnUpdates(true);
		
		OngletPersonne.setLayout(new BorderLayout(0, 0));
		BarreOutilsPersonnes barre = new BarreOutilsPersonnes(billeterie);
		OngletPersonne.add(barre, "North");
		OngletPersonne.add(new JScrollPane(tableauPersonnes), "Center");
		
		Onglets.addTab("Personnes", null, OngletPersonne, null);
		
		/* Onglet Billets */
		JPanel OngletBillets = new JPanel();
		tableauBillets = new JTable(billeterie.getListeBillets());
		tableauBillets.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		billeterie.getListeBillets().setTableau(tableauBillets);
		
		tableauBillets.setAutoCreateRowSorter(true);// Gestion des tableaux triables
		TableRowSorter<ListeBillets> sorter2 = new TableRowSorter<ListeBillets>((ListeBillets) tableauBillets.getModel());   
		tableauBillets.setRowSorter(sorter2);
		sorter2.setSortsOnUpdates(true);
		
		OngletBillets.setLayout(new BorderLayout(0, 0));
		OngletBillets.add(new BarreOutilsBillets(billeterie), "North");
		OngletBillets.add(new JScrollPane(tableauBillets), "Center");
		
		Onglets.addTab("Billets", null, OngletBillets, null);
		
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
