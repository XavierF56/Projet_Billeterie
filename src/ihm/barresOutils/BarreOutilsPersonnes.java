package ihm.barresOutils;

import ihm.fenetres.FenetreModifiePersonne;
import ihm.fenetres.FenetreNouvellePersonne;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import modele.Billeterie;


public class BarreOutilsPersonnes extends JPanel {
	Billeterie billeterie;
	protected JButton btnModifier;
	private TextRecherche textRecherche;
	/**
	 * Premiere version de la barre d'outils d'onglet Personnes
	 */
	private static final long serialVersionUID = 1L;

	public BarreOutilsPersonnes(Billeterie billeterie) {
		super();
		textRecherche = new TextRecherche();
		
		this.billeterie = billeterie;
		this.add(textRecherche);
		this.add(new JButton(new RechercheAction()));
		this.add(new JButton(new AjouterAction()));
		this.add(new JButton(new ModifierAction()));
		this.add(new JButton(new SupprimerAction()));
	}
	
	class AjouterAction extends AbstractAction {
		private static final long serialVersionUID = 1L;

		private AjouterAction() {
            super("Ajouter");
        }
 
        public void actionPerformed(ActionEvent e) {
        	new FenetreNouvellePersonne(billeterie);
        }
    }
	
	class SupprimerAction extends AbstractAction {
		private static final long serialVersionUID = 1L;

		private SupprimerAction() {
            super("Supprimer");
        }
 
        public void actionPerformed(ActionEvent e) {
            try {
            	int selection = billeterie.getFenetre().getTableau().getSelectedRow();
            	int selectionCorrige = billeterie.getFenetre().getTableau().getRowSorter().convertRowIndexToModel(selection);
            	billeterie.getListePersonnes().getPersonneIndex(selectionCorrige).supprimer();
            } catch (Exception e1) {
            	
            }
        }
    }
	
	class ModifierAction extends AbstractAction {
		private static final long serialVersionUID = 1L;

		private ModifierAction() {
            super("Modifier");
        }
 
        public void actionPerformed(ActionEvent e) {
            try {
            	int selection = billeterie.getFenetre().getTableau().getSelectedRow();
            	int selectionCorrige = billeterie.getFenetre().getTableau().getRowSorter().convertRowIndexToModel(selection);
            	new FenetreModifiePersonne(billeterie, billeterie.getListePersonnes().getPersonneIndex(selectionCorrige));
            } catch (Exception e1) {
            	
            }
        }
    }
	
	class RechercheAction extends AbstractAction {
		private static final long serialVersionUID = 1L;

		private RechercheAction() {
            super("Rechercher");
        }
 
        public void actionPerformed(ActionEvent e) {
            billeterie.getListePersonnes().recherche(textRecherche.getText());
        }
    }
	
	class TextRecherche extends JTextField  implements KeyListener {
		private static final long serialVersionUID = 1L;
		public TextRecherche() {
	    	super();
	    	this.setColumns(20);
	        addKeyListener(this);
	    }
	    public void keyTyped(KeyEvent e) {
	    }
	    public void keyPressed(KeyEvent e) {
	        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
	        	billeterie.getListePersonnes().recherche(this.getText());
	        }
	    }
	    public void keyReleased(KeyEvent e) {
	    }
	}
}
