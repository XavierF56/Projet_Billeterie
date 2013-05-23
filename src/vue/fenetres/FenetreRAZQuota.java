package vue.fenetres;

import general.Langue;

import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import modele.ListeObjet;
import controleur.basique.AnnulerAction;
import controleur.basique.ValiderRAZQuotaAction;

@SuppressWarnings("serial")
public class FenetreRAZQuota extends Fenetre {
	
	/**
	 * 
	 * @param listeObjet
	 */
	public FenetreRAZQuota(ListeObjet listeObjets) {
		
		//Fenetre
		this.setTitle(Langue.getTraduction("reset_Confirmation"));
		JPanel fenetre = new JPanel(new BorderLayout());
		fenetre.setBorder(BorderFactory.createEmptyBorder(10, 10, 5, 10));
		this.add(fenetre);
		
		//Boutons Valider et Annuler
		JButton buttonAnnuler = new JButton(new AnnulerAction(this, Langue.getTraduction("cancel")));
		JButton buttonQuota = new JButton(new ValiderRAZQuotaAction(this, listeObjets));
		JPanel panelSouth = new JPanel();
		panelSouth.add(buttonQuota);
		panelSouth.add(buttonAnnuler);
		fenetre.add(panelSouth, "South");
		
		//Message
		JLabel label = new JLabel(Langue.getTraduction("reset_query"));
		fenetre.add(label, "Center");
		
		this.afficherDialog();
	}
}