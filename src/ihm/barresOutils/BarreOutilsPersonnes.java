package ihm.barresOutils;

import java.awt.event.ActionEvent;

import ihm.actions.AjouterAction;
import ihm.actions.ModifierAction;
import ihm.actions.RechercheAction;
import ihm.actions.SupprimerAction;
import ihm.actions.TextRecherche;
import ihm.fenetres.FenetreDetailsPersonne;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JPanel;

import modele.Billeterie;
import modele.ListeObjet;
import modele.Personne;

public class BarreOutilsPersonnes extends JPanel {
	Billeterie billeterie;
	private TextRecherche textRecherche;

	private static final long serialVersionUID = 1L;

	public BarreOutilsPersonnes(Billeterie billeterie) {
		this.billeterie = billeterie;

		textRecherche = new TextRecherche(billeterie.getListePersonnes());
		
		this.add(textRecherche);
		this.add(new JButton(new RechercheAction(billeterie.getListePersonnes(), textRecherche)));
		this.add(new JButton(new AjouterAction(billeterie.getListePersonnes())));
		this.add(new JButton(new ModifierAction(billeterie.getListePersonnes())));
		this.add(new JButton(new SupprimerAction(billeterie.getListePersonnes())));
		this.add(new JButton(new VoirAction(billeterie.getListePersonnes())));
	}
	
	public class VoirAction extends AbstractAction {
		private static final long serialVersionUID = 1L;
		private ListeObjet listeObjet;
		
		public VoirAction(ListeObjet listeObjet) {
	        super("Details");
	    	this.listeObjet = listeObjet;
	    }

	    public void actionPerformed(ActionEvent e) {
	    	int selection = listeObjet.getTableau().getSelectedRow();
        	int selectionCorrige = listeObjet.getTableau().getRowSorter().convertRowIndexToModel(selection);
	    	try {
				new FenetreDetailsPersonne((Personne) listeObjet.getObjetByIndex(selectionCorrige));
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	    }
	}
}
