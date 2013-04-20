package ihm.actions;

import ihm.fenetres.FenetreModifieObjet;

import java.awt.event.ActionEvent;
import java.util.Map;

import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

	//TODO Classe provisoire en attendant renommage ou refonte

@SuppressWarnings("serial")
public class ValiderAction2 extends AbstractAction {
	FenetreModifieObjet fenetre;
	public ValiderAction2(FenetreModifieObjet fenetreModifiePersonne) {
	    super("Valider");
	    this.fenetre = fenetreModifiePersonne;
	}
	
	public void actionPerformed(ActionEvent e) {
		try {
			Map<String, Object>  map = fenetre.getChamps().getDonnees();
			fenetre.getObjetTraite().modifie(map);
	    	fenetre.setVisible(false);
		} catch (Exception e1) {
			String message = "\"Erreur lors de la modification\"\n"
			            + "Tous les champs n'ont pas ete renseignes\n";
			JOptionPane.showMessageDialog(new JFrame(), message, "Dialog", JOptionPane.ERROR_MESSAGE);
		}
	}
}