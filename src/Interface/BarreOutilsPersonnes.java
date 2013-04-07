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
		this.add(new JButton(new RechercheAction()));
		this.add(new JButton(new AjouterAction()));
		this.add(btnModifier);
		this.add(new JButton(new SupprimerAction()));
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
	
	class SupprimerAction extends AbstractAction {
        private SupprimerAction() {
            super("Supprimer");
        }
 
        public void actionPerformed(ActionEvent e) {
            int selection = billeterie.getFenetre().getTableau().getSelectedRow();
            int selectionCorrige = billeterie.getFenetre().getTableau().getRowSorter().convertRowIndexToModel(selection);
            billeterie.getListePersonnes().getPersonneIndex(selectionCorrige).supprimer();
        }
    }
	
	class RechercheAction extends AbstractAction {
        private RechercheAction() {
            super("Rechercher");
        }
 
        public void actionPerformed(ActionEvent e) {
            billeterie.getListePersonnes().recherche(txtRechercher.getText());
        }
    }
}
