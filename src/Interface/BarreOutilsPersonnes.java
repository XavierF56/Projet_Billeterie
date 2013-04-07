package Interface;

import java.awt.event.ActionEvent;
import java.util.HashMap;
import java.util.Map;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Modele.Billeterie;
import Modele.Personne;

public class BarreOutilsPersonnes extends JPanel {
	Billeterie billeterie;
	protected JButton btnRechercher;
	protected JButton btnAjouter;
	protected JButton btnModifier;
	protected JButton btnSupprimer;
	protected JTextField txtRechercher;
	/**
	 * Premiere version de la barre d'outils d'onglet Personnes
	 */
	private static final long serialVersionUID = 1L;

	public BarreOutilsPersonnes(Billeterie billeterie) {
		super();
		
		btnRechercher = new JButton("Rechercher");
		btnAjouter = new JButton("Ajouter");
		btnModifier = new JButton("Modifier");
		btnSupprimer = new JButton("Supprimer");
		txtRechercher = new JTextField();	
		txtRechercher.setText("Rechercher...");
		
		this.billeterie = billeterie;
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
        	Map<String,Object> map = new HashMap<String,Object>();
    		map.put("nom", "Marty");
    		map.put("prenom", "Burno");
    		
    		Personne newPerso = new Personne(map, billeterie, 0);
        }
    }
}
