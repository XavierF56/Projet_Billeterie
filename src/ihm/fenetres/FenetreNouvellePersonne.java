package ihm.fenetres;

import ihm.barresOutils.Champs;

import java.awt.event.ActionEvent;
import java.util.HashMap;
import java.util.Map;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import modele.Billeterie;
import modele.Personne;

@SuppressWarnings("serial")
public class FenetreNouvellePersonne extends Fenetre {

	Billeterie billeterie;
	Champs champs;
	
	/**
	 * Constructeur
	 * @param billeterie
	 */
	public FenetreNouvellePersonne(Billeterie billeterie) {
		this.billeterie = billeterie;
		champs = new Champs(billeterie.getColonnesTypePersonnes());
		setBounds(100, 100, 450, 300);
		this.add(champs, "Center");
		this.add(new JButton(new ValiderAction(this)), "South");
		this.setTitle("Ajouter une nouvelle personne");
		this.setVisible(true);
	}
	
	/**
	 * @return les Champs de données
	 */
	public Champs getChamps() {
		return champs;
	}
	
	private class ValiderAction extends AbstractAction {
		private static final long serialVersionUID = 1L;
		FenetreNouvellePersonne fenetre;
        private ValiderAction(FenetreNouvellePersonne fenetre) {
            super("Valider");
            this.fenetre = fenetre;
        }
 
        public void actionPerformed(ActionEvent e) {
			try {
				Map<String, Object>  map = fenetre.getChamps().getDonnees();
				Personne newPerso = new Personne(map, billeterie, 0);
	        	fenetre.setVisible(false);
			} catch (Exception e1) {
				new PopUpErreur("Erreur lors de l'ajout", "Tous les champs n'ont pas ete renseignes");
			}
        }
    }
}