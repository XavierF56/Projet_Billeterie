package ihm.fenetres;

import ihm.barresOutils.Champs;

import java.awt.event.ActionEvent;
import java.util.Map;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import modele.ListeObjet;

@SuppressWarnings("serial")
public class FenetreNouvelleObjet extends Fenetre {

	private ListeObjet listeObjet;
	private Champs champs;
	
	/**
	 * Constructeur
	 * @param billeterie
	 */
	public FenetreNouvelleObjet(ListeObjet listeObjet, String titre) {
		this.listeObjet = listeObjet;
		champs = new Champs(listeObjet.getAttributs());
		setBounds(100, 100, 450, 300);
		this.add(champs, "Center");
		this.add(new JButton(new ValiderAction(this)), "South");
		this.setTitle(titre);
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
		FenetreNouvelleObjet fenetre;
        private ValiderAction(FenetreNouvelleObjet fenetre) {
            super("Valider");
            this.fenetre = fenetre;
        }
 
        public void actionPerformed(ActionEvent e) {
			try {
				Map<String, Object>  map = fenetre.getChamps().getDonnees();
				listeObjet.ajouter(map);
	        	fenetre.setVisible(false);
			} catch (Exception e1) {
				String message = "\"Erreur lors de l'ajout\"\n"
			            + "Tous les champs n'ont pas ete renseignes\n";
				JOptionPane.showMessageDialog(new JFrame(), message, "Dialog", JOptionPane.ERROR_MESSAGE);
			}
        }
    }
}