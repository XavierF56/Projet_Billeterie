package Interface;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Modele.Billeterie;
import Modele.Personne;

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
		btnModifier = new JButton("Modifier");
		
		this.billeterie = billeterie;
		this.add(textRecherche);
		this.add(new JButton(new RechercheAction()));
		this.add(new JButton(new AjouterAction()));
		this.add(btnModifier);
		this.add(new JButton(new SupprimerAction()));
	}
	
	class AjouterAction extends AbstractAction {
        private AjouterAction() {
            super("Ajouter");
        }
 
        public void actionPerformed(ActionEvent e) {
        	Map<String,Object> map = new HashMap<String,Object>();
    		map.put("nom", "Marty");
    		map.put("prenom", "Burno");
    		
    		Personne newPerso = new Personne(map, billeterie, 0);
        }
    }
	
	class SupprimerAction extends AbstractAction {
        private SupprimerAction() {
            super("Supprimer");
        }
 
        public void actionPerformed(ActionEvent e) {
            int selection = billeterie.getFenetre().getTableau().getSelectedRow();
            int selectionCorrige = billeterie.getFenetre().getTableau().getRowSorter().convertRowIndexToModel(selection);
            billeterie.getListePersonnes().getPersonneIndex(selectionCorrige).supprimer();
        }
    }
	
	class RechercheAction extends AbstractAction {
        private RechercheAction() {
            super("Rechercher");
        }
 
        public void actionPerformed(ActionEvent e) {
            billeterie.getListePersonnes().recherche(textRecherche.getText());
        }
    }
	
	class TextRecherche extends JTextField  implements KeyListener {
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
