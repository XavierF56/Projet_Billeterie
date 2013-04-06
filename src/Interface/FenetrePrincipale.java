package Interface;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import java.awt.GridLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;

import Modele.Billeterie;

public class FenetrePrincipale extends JFrame {
	private Billeterie billeterie;
	/**
	 * Premiere version de la fenetre principale
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
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

	/**
	 * Create the frame.
	 */
	public FenetrePrincipale(Billeterie billeterie) {
		this.billeterie = billeterie;
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
		JTable tableau = new JTable(new TablePersonnes(billeterie));
		OngletPersonne.setLayout(new BorderLayout(0, 0));
		OngletPersonne.add(new BarreOutilsPersonnes(), "North");
		OngletPersonne.add(tableau, "Center");
		
		Onglets.addTab("Personnes", null, OngletPersonne, null);
		
		/* Onglet Billets */
		JPanel OngletBillets = new JPanel();
		OngletBillets.setLayout(new BorderLayout(0, 0));
		OngletBillets.add(new BarreOutilsBillets(), "North");
		
		Onglets.addTab("Billets", null, OngletBillets, null);
		
		/* Onglet Options */
		JPanel OngletOptions = new JPanel();
		
		Onglets.addTab("Options", null, OngletOptions, null);
		
		JCheckBox chckbxVerrouillerLaSuppression = new JCheckBox("Verrouiller la suppression");
		GroupLayout gl_OngletOptions = new GroupLayout(OngletOptions);
		gl_OngletOptions.setHorizontalGroup(
			gl_OngletOptions.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_OngletOptions.createSequentialGroup()
					.addContainerGap()
					.addComponent(chckbxVerrouillerLaSuppression)
					.addContainerGap(546, Short.MAX_VALUE))
		);
		gl_OngletOptions.setVerticalGroup(
			gl_OngletOptions.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_OngletOptions.createSequentialGroup()
					.addGap(43)
					.addComponent(chckbxVerrouillerLaSuppression)
					.addContainerGap(567, Short.MAX_VALUE))
		);
		OngletOptions.setLayout(gl_OngletOptions);
	}
}
