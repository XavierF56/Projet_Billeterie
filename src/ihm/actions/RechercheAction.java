package ihm.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import modele.ListeObjet;

public class RechercheAction extends AbstractAction {
	private ListeObjet listeObjet;
	private static final long serialVersionUID = 1L;
	private TextRecherche textRecherche;

	public RechercheAction(ListeObjet listeObjet, TextRecherche textRecherche) {
        super("Rechercher");
        this.textRecherche = textRecherche;
    	this.listeObjet = listeObjet;
    }

    public void actionPerformed(ActionEvent e) {
        listeObjet.recherche(textRecherche.getText());
    }
}
