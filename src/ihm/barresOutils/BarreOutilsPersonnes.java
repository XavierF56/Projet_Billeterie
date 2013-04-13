package ihm.barresOutils;

import ihm.fenetres.FenetreModifiePersonne;
import ihm.fenetres.FenetreNouvellePersonne;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import modele.Billeterie;
import modele.ListeObjet;
import modele.ObjetB;

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
		textRecherche = new TextRecherche(billeterie.getListePersonnes());
		
		this.billeterie = billeterie;
		this.add(textRecherche);
		this.add(new JButton(new RechercheAction(billeterie.getListePersonnes())));
		this.add(new JButton(new AjouterAction(billeterie.getListePersonnes())));
		this.add(new JButton(new ModifierAction(billeterie.getListePersonnes())));
		this.add(new JButton(new SupprimerAction(billeterie.getListePersonnes())));
	}
	
	class AjouterAction extends AbstractAction {
		private static final long serialVersionUID = 1L;
		private ListeObjet listeObjet;
		
		private AjouterAction(ListeObjet listeObjet) {
            super("Ajouter");
	    	this.listeObjet = listeObjet;
        }
 
        public void actionPerformed(ActionEvent e) {
        	new FenetreNouvellePersonne(listeObjet);
        }
    }
	
	class SupprimerAction extends AbstractAction {
		private static final long serialVersionUID = 1L;
		private ListeObjet listeObjet;
		
		private SupprimerAction(ListeObjet listeObjet) {
            super("Supprimer");
	    	this.listeObjet = listeObjet;
        }
 
        public void actionPerformed(ActionEvent e) {
            try {
            	int selection = listeObjet.getTableau().getSelectedRow();
            	int selectionCorrige = listeObjet.getTableau().getRowSorter().convertRowIndexToModel(selection);
            	listeObjet.getObjetByIndex(selectionCorrige).supprimer();
            } catch (Exception e1) {
            	
            }
        }
    }
	
	class ModifierAction extends AbstractAction {
		private static final long serialVersionUID = 1L;
		private ListeObjet listeObjet;
		
		private ModifierAction(ListeObjet listeObjet) {
            super("Modifier");
	    	this.listeObjet = listeObjet;
        }
 
        public void actionPerformed(ActionEvent e) {
        	EventQueue.invokeLater(new Runnable() {
    			public void run() {
    				try {
    					int selection = listeObjet.getTableau().getSelectedRow();
    	            	int selectionCorrige = listeObjet.getTableau().getRowSorter().convertRowIndexToModel(selection);
    	            	ObjetB objet = listeObjet.getObjetByIndex(selectionCorrige);
    					new FenetreModifiePersonne(billeterie, objet, listeObjet);
    				} catch (Exception e) {
    					e.printStackTrace();
    				}
    			}
    		});
        }
    }
	
	class RechercheAction extends AbstractAction {
		private ListeObjet listeObjet;
		private static final long serialVersionUID = 1L;

		private RechercheAction(ListeObjet listeObjet) {
            super("Rechercher");
	    	this.listeObjet = listeObjet;
        }
 
        public void actionPerformed(ActionEvent e) {
            listeObjet.recherche(textRecherche.getText());
        }
    }
	
	class TextRecherche extends JTextField  implements KeyListener {
		private static final long serialVersionUID = 1L;
		private ListeObjet listeObjet;
		public TextRecherche(ListeObjet listeObjet) {
	    	super();
	    	this.setColumns(20);
	    	this.listeObjet = listeObjet;
	        addKeyListener(this);
	    }
	    public void keyTyped(KeyEvent e) {
	    }
	    public void keyPressed(KeyEvent e) {
	        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
	        	listeObjet.recherche(this.getText());
	        }
	    }
	    public void keyReleased(KeyEvent e) {
	    }
	}
}
