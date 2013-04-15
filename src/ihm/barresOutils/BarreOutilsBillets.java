package ihm.barresOutils;

import ihm.actions.AjouterAction;
import ihm.actions.ModifierAction;
import ihm.actions.RechercheAction;
import ihm.actions.SupprimerAction;
import ihm.actions.TextRecherche;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import modele.Billeterie;

public class BarreOutilsBillets extends JPanel {
	protected JButton btnRechercher;
	protected JButton btnAjouter;
	protected JButton btnModifier;
	protected JButton btnSupprimer;
	protected JTextField txtRechercher;
	
	/**
	 * Premiere version de la barre d'outils d'onglet Billets
	 */
	private static final long serialVersionUID = 1L;
	Billeterie billeterie;
	private TextRecherche textRecherche;
	
	public BarreOutilsBillets(Billeterie billeterie) {
		this.billeterie = billeterie;
		textRecherche = new TextRecherche(billeterie.getListeBillets());
		
		this.add(textRecherche);
		this.add(new JButton(new RechercheAction(billeterie.getListeBillets(), textRecherche)));
		this.add(new JButton(new AjouterAction(billeterie.getListeBillets(), "Ajouter un nouveau billet")));
		this.add(new JButton(new ModifierAction(billeterie.getListeBillets())));
		this.add(new JButton(new SupprimerAction(billeterie.getListeBillets())));
		this.add(new JButton("Modifier Qt"));
	}

}
