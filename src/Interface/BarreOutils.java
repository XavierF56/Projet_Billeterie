package Interface;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class BarreOutils extends JPanel {
	/**
	 * Premiere version de la barre d'outils
	 */
	private static final long serialVersionUID = 1L;

	BarreOutils (){
		super();
		
		JButton btnRechercher = new JButton("Rechercher");
		JButton btnAjouterQte = new JButton("Ajouter Qte");
		JButton btnModifier = new JButton("Modifier");
		JButton btnSupprimer = new JButton("Supprimer");
		JTextField txtRechercher = new JTextField();
		txtRechercher.setText("Rechercher...");
		
		this.add(txtRechercher);
		this.add(btnRechercher);
		this.add(btnAjouterQte);
		this.add(btnModifier);
		this.add(btnSupprimer);
	}
}
