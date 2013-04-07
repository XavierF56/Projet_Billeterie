package Interface;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class BarreOutilsPersonnes extends JPanel {
	FenetrePrincipale fenetre;
	protected JButton btnRechercher;
	protected JButton btnAjouter;
	protected JButton btnModifier;
	protected JButton btnSupprimer;
	protected JTextField txtRechercher;
	/**
	 * Premiere version de la barre d'outils d'onglet Personnes
	 */
	private static final long serialVersionUID = 1L;

	public BarreOutilsPersonnes(FenetrePrincipale fenetre) {
		super();
		
		btnRechercher = new JButton("Rechercher");
		btnAjouter = new JButton("Ajouter");
		btnModifier = new JButton("Modifier");
		btnSupprimer = new JButton("Supprimer");
		txtRechercher = new JTextField();	
		txtRechercher.setText("Rechercher...");
		
		this.fenetre = fenetre;
		this.add(txtRechercher);
		this.add(btnRechercher);
		this.add(new JButton(new AjouterAction()));
		this.add(btnModifier);
		this.add(btnSupprimer);
	}
	class AjouterAction extends AbstractAction {
        private AjouterAction() {
            super("Ajouter");
        }
 
        public void actionPerformed(ActionEvent e) {
            fenetre.getModelePersonnes().ajouter();
        }
    }
}
