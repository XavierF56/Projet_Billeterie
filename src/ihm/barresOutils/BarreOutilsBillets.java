package ihm.barresOutils;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class BarreOutilsBillets extends JPanel {
	protected JButton btnRechercher;
	protected JButton btnAjouter;
	protected JButton btnModifier;
	protected JButton btnSupprimer;
	protected JTextField txtRechercher;
	
	/**
	 * Premiere version de la barre d'outils d'onglet Billets
	 */
	private static final long serialVersionUID = 1L;
	
	private JButton btnAjouterQte;
	
	public BarreOutilsBillets() {
		super();
		
		btnRechercher = new JButton("Rechercher");
		btnAjouter = new JButton("Ajouter");
		btnModifier = new JButton("Modifier");
		btnSupprimer = new JButton("Supprimer");
		txtRechercher = new JTextField();		
		
		txtRechercher.setText("Rechercher...");
		btnAjouterQte = new JButton("Ajouter Qte");
		this.add(txtRechercher);
		this.add(btnRechercher);
		this.add(btnAjouter);
		this.add(btnAjouterQte);
		this.add(btnModifier);
		this.add(btnSupprimer);
	}

}
