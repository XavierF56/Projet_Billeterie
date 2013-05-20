package ihm.actions.valider;

import general.Langue;
import ihm.fenetres.FenetreModifier;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Map;

import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class ValiderModifierAction extends AbstractAction implements KeyListener {

	private FenetreModifier fenetre;
	
	/**
	 * Constructeur
	 * @param fenetreModifiePersonne
	 */
	public ValiderModifierAction(FenetreModifier fenetreModifiePersonne) {
	    super(Langue.getTraduction("modify"));
	    this.fenetre = fenetreModifiePersonne;
	}
	
    /**
     * Cette fonction valide l'action
     */
    private void valider() {
		try {
			Map<String, Object>  map = fenetre.getChamps().getDonnees();
			fenetre.getObjetTraite().modifie(map);
	    	fenetre.dispose();
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(new JFrame(), Langue.getTraduction("error_modifying"), 
					Langue.getTraduction("error"), JOptionPane.ERROR_MESSAGE);
		}
    }
    
    /** Listeners **/
    public void actionPerformed(ActionEvent e) {
		valider();
    }
    public void keyTyped(KeyEvent e) {
    }
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
	    	valider();
        }
    }
    public void keyReleased(KeyEvent e) {
    }
}