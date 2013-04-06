package Interface;

public class BarreOutilsPersonnes extends BarreOutils {

	/**
	 * Premiere version de la barre d'outils d'onglet Personnes
	 */
	private static final long serialVersionUID = 1L;

	public BarreOutilsPersonnes() {
		super();
		this.add(txtRechercher);
		this.add(btnRechercher);
		this.add(btnAjouter);
		this.add(btnModifier);
		this.add(btnSupprimer);
	}
	
}
