package ihm.fenetres;

import ihm.barresOutils.BarreOutilsBillets;
import ihm.barresOutils.BarreOutilsPersonnes;

import java.awt.BorderLayout;
import java.awt.EventQueue;
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

import modele.Billeterie;
import modele.ListePersonnes;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class FenetrePrincipale extends JFrame {
	@SuppressWarnings("unused")
	private Billeterie billeterie;
	/**
	 * Premiere version de la fenetre principale
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private boolean opt;
	private JTable tableau;
	
	

	/**
	 * Create the frame.
	 */
	public FenetrePrincipale(Billeterie billeterie) {
		this.billeterie = billeterie;
		billeterie.setFenetre(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.X_AXIS));
		JTabbedPane Onglets = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(Onglets);
		
		/* Onglet Personnes */
		JPanel OngletPersonne = new JPanel();
		tableau = new JTable(billeterie.getListePersonnes());
		tableau.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		tableau.setAutoCreateRowSorter(true);// Gestion des tableaux triables
		TableRowSorter<ListePersonnes> sorter = new TableRowSorter<ListePersonnes>((ListePersonnes) tableau.getModel());   
		tableau.setRowSorter(sorter);
		//sorter.set
		sorter.setSortsOnUpdates(true);
		
		OngletPersonne.setLayout(new BorderLayout(0, 0));
		OngletPersonne.add(new BarreOutilsPersonnes(billeterie), "North");
		OngletPersonne.add(new JScrollPane(tableau), "Center");
		
		Onglets.addTab("Personnes", null, OngletPersonne, null);
		
		/* Onglet Billets */
		JPanel OngletBillets = new JPanel();
		OngletBillets.setLayout(new BorderLayout(0, 0));
		OngletBillets.add(new BarreOutilsBillets(), "North");
		
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
	}

	public JTable getTableau() {
		return tableau;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FenetrePrincipale frame = new FenetrePrincipale(new Billeterie("database.sqlite"));
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
