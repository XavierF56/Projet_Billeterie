package controleur.modifier;

import general.Langue;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JComboBox;

import modele.ListeObjet;
import vue.fenetres.FenetreAjouter;

@SuppressWarnings("serial")
public class TypeBilletListener extends AbstractAction {
	
	private FenetreAjouter fenetre;
	private JComboBox<String> jcb;
	
	/**
	 * Cette classe permet 
	 * 
	 * @param fenetre la fenetre en cours
	 * @param jcb
	 */
	public TypeBilletListener(FenetreAjouter fenetre, JComboBox<String> jcb) {
		super(Langue.getTraduction("ok"));
		this.fenetre = fenetre;
		this.jcb = jcb;
	}

	/** Methode requise par l'heritage de la classe AbstractAction
     * 
     * @see AbstractAction
	 */
	public void actionPerformed(ActionEvent e) {
		ListeObjet list = fenetre.getListeObjet();
		String titre = fenetre.getTitre();
		boolean bool = jcb.getSelectedItem().equals(Langue.getTraduction("ticket_normal"));
		if(bool) {
			new FenetreAjouter(list, titre, false);
		} else {
			new FenetreAjouter(list, titre, true);
		}
		fenetre.dispose();
	}

}
