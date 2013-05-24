package controleur.basique;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JComboBox;

import modele.ListeObjet;
import vue.fenetres.FenetreAjouter;

@SuppressWarnings("serial")
public class TypeBilletListener extends AbstractAction {
	FenetreAjouter fenetre;
	JComboBox<String> jcb;
	
	public TypeBilletListener(FenetreAjouter fenetre, JComboBox<String> jcb) {
		super("OK");
		this.fenetre = fenetre;
		this.jcb = jcb;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		ListeObjet list = fenetre.getListeObjet();
		String titre = fenetre.getTitre();
		boolean bool = jcb.getSelectedItem().equals("Billet normal");
		if(bool) {
			new FenetreAjouter(list, titre, false);
		} else {
			new FenetreAjouter(list, titre, true);
		}
		fenetre.dispose();
	}

}
