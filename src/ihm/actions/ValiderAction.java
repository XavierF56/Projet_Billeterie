package ihm.actions;

import ihm.fenetres.Fenetre;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

import modele.Billeterie;

@SuppressWarnings("serial")
public class ValiderAction extends AbstractAction {
	
	@SuppressWarnings("unused")
	private Billeterie billeterie;
	private Fenetre fenetre;
	
    private ValiderAction(Fenetre fenetre, Billeterie billeterie) {
        super("Valider");
        this.fenetre = fenetre;
        this.billeterie = billeterie;
    }

    public void actionPerformed(ActionEvent e) {
		try {
			//Map<String, Object>  map = fenetre.getChamps().getDonnees();
			//Personne newPerso = new Personne(map, billeterie, 0);
        	fenetre.dispose();
		} catch (Exception e1) {
			e1.printStackTrace();
			//TODO Doit afficher une popup d'erreur
		}
    }
}