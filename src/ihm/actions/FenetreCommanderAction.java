package ihm.actions;

import ihm.fenetres.FenetreCommander;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import modele.Billeterie;
import modele.ListeObjet;
import modele.Objet;
import modele.Personne;

@SuppressWarnings("serial")
public class FenetreCommanderAction extends AbstractAction {
	private ListeObjet listeObjet;
	private Billeterie billeterie;

	public FenetreCommanderAction(ListeObjet listeObjet, Billeterie billeterie) {
		super("Commander Billet");
		this.listeObjet = listeObjet;
		this.billeterie = billeterie;
	}

	public void actionPerformed(ActionEvent e) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					boolean select = true;
					int selectionCorrige = 0;
					int selection = listeObjet.getTableau().getSelectedRow();
					try {
	            	selectionCorrige = listeObjet.getTableau().getRowSorter().convertRowIndexToModel(selection);
					} catch (Exception e) {	
						select = false;
						JOptionPane.showMessageDialog(new JFrame(), 
								"Vous n'avez sélectionnée personne", "Attention", JOptionPane.INFORMATION_MESSAGE);
	            	}
					if(select) {
						Objet objet = listeObjet.getObjetByIndex(selectionCorrige);
						new FenetreCommander((Personne) objet, billeterie);
					}
				} catch (Exception e) {		
					e.printStackTrace();
				}
			}
		});
	}
}
