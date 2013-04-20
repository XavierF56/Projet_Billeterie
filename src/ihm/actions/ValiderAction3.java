package ihm.actions;

import ihm.fenetres.FenetreNouvelleObjet;

import java.awt.event.ActionEvent;
import java.util.Map;

import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import modele.ListeObjet;

//TODO Classe provisoire en attendant renommage ou refonte

@SuppressWarnings("serial")
public class ValiderAction3 extends AbstractAction {
	private FenetreNouvelleObjet fenetre;
	private ListeObjet listeObjet;
	
    public ValiderAction3(FenetreNouvelleObjet fenetre, ListeObjet listeObjet) {
        super("Valider");
        this.fenetre = fenetre;
        this.listeObjet = listeObjet;
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