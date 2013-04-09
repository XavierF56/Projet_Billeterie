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
@SuppressWarnings("unused")


public class FenetreModifiePersonne extends JFrame {
	private static final long serialVersionUID = 1L;
	Billeterie billeterie;
	Personne personne;
	Champs champs;
	
	/**
	 * Constructeur
	 * @param billeterie
	 */
	public FenetreModifiePersonne(Billeterie billeterie, Personne personne) {
		this.billeterie = billeterie;
		this.personne = personne;
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
	
	public Personne getPersonne() {
		return personne;
	}
	
	private class ValiderAction extends AbstractAction {
		private static final long serialVersionUID = 1L;
		FenetreModifiePersonne fenetre;
        private ValiderAction(FenetreModifiePersonne fenetreModifiePersonne) {
            super("Valider");
            this.fenetre = fenetreModifiePersonne;
        }
 
        public void actionPerformed(ActionEvent e) {
			try {
				Map<String, Object>  map = fenetre.getChamps().getDonnees();
				fenetre.getPersonne().modifie(map);
	        	fenetre.setVisible(false);
			} catch (Exception e1) {
				new PopUpErreur("Erreur lors de la modification", "Tous les champs n'ont pas ete renseignes");
			}
        }
    }
	
	public static void main(String[] args) {
		new FenetreNouvellePersonne(new Billeterie("database.sqlite"));
	}
}