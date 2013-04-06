package Interface;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class BarreOutils extends JPanel {
	/**
	 * Premiere version de la barre d'outils
	 */
	private static final long serialVersionUID = 1L;
	protected JButton btnRechercher;
	protected JButton btnAjouter;
	protected JButton btnModifier;
	protected JButton btnSupprimer;
	protected JTextField txtRechercher;

	BarreOutils (){
		super();
		
		btnRechercher = new JButton("Rechercher");
		btnAjouter = new JButton("Ajouter");
		btnModifier = new JButton("Modifier");
		btnSupprimer = new JButton("Supprimer");
		txtRechercher = new JTextField();		
		
		txtRechercher.setText("Rechercher...");
	}
}
