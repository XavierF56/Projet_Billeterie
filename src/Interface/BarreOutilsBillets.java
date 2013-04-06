package Interface;

import javax.swing.JButton;

public class BarreOutilsBillets extends BarreOutils {
	/**
	 * Premiere version de la barre d'outils d'onglet Billets
	 */
	private static final long serialVersionUID = 1L;
	
	private JButton btnAjouterQte;
	
	public BarreOutilsBillets() {
		super();
		btnAjouterQte = new JButton("Ajouter Qte");
		this.add(txtRechercher);
		this.add(btnRechercher);
		this.add(btnAjouter);
		this.add(btnAjouterQte);
		this.add(btnModifier);
		this.add(btnSupprimer);
	}

}
