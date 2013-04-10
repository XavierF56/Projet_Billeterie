package ihm.fenetres;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import general.Constantes;
import ihm.barresOutils.BarreOutilsValiderAnnuler;

public class FenetrePopUp extends JDialog {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FenetrePopUp frame = new FenetrePopUp("oho");
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
	public FenetrePopUp(String nom) {
		setTitle(nom);
		setBounds(100, 100, 450, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(new BarreOutilsValiderAnnuler(this), BorderLayout.SOUTH);
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		afficherChamps();
	}
	
	private void afficherChamps() {
		
		// for each
		int type = -1; //recuperer le type
		String nom = "Attribut 1"; //recuperer le nom de l'attribut
		
		switch(type){

		case Constantes.INTEGER :
			break;
		case Constantes.FLOAT :
			break;
		case Constantes.BOOLEAN:
			break;
		case Constantes.STRING:
			break;
		}
	}
}
