package ihm.actions;

import ihm.fenetres.FenetreNouvelleObjet;

import java.awt.event.ActionEvent;
import java.util.Map;

import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import modele.ListeObjet;

@SuppressWarnings("serial")
public class ValiderAjoutAction extends AbstractAction {
	private FenetreNouvelleObjet fenetre;
	private ListeObjet listeObjet;
	
    public ValiderAjoutAction(FenetreNouvelleObjet fenetre, ListeObjet listeObjet) {
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
			System.out.println(e1);
			String message = "\"Erreur lors de l'ajout\"\n"
		            + "Tous les champs n'ont pas ete renseignes\n";
			JOptionPane.showMessageDialog(new JFrame(), message, "Dialog", JOptionPane.ERROR_MESSAGE);
		}
    }
}