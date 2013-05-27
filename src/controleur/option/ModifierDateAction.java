package controleur.option;


import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.AbstractAction;
import javax.swing.JFormattedTextField;

import modele.Billeterie;

@SuppressWarnings("serial")
public class ModifierDateAction extends AbstractAction implements KeyListener {
	
	private Billeterie billeterie;
	private JFormattedTextField date;
	
	/**
	 * Cette classe permet la gestion de la modification de la date dans l'onglet Statistiques de la fenêtre Principale.
	 * 
	 * @param billeterie la billeterie en cours
	 * @param date la date à définir
	 * @see Billeterie
	 * @see JFormattedTextField
	 */
    public ModifierDateAction(Billeterie billeterie, JFormattedTextField date) {
    	super("OK");
        this.billeterie = billeterie;
        this.date = date;
    }
    
    /**
     * Permet de valider l'action
     */
	public void valider() {
		String source = date.getText();	
		SimpleDateFormat dateStandard = new SimpleDateFormat("dd/MM/yyyy");
		try {
			billeterie.getAchatsGeneral().setDate(dateStandard.parse(source));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		billeterie.getFenetre().getOngletStats().majLabel();
	}
    
	/** Methode requise par l'heritage de la classe AbstractAction
     * 
     * @see AbstractAction
	 */
	public void actionPerformed(ActionEvent e) {
		valider();
	}
	
	public void keyPressed(KeyEvent e) {
	   if (e.getKeyCode() == KeyEvent.VK_ENTER) {
		   valider();
	   }
	}
	public void keyTyped(KeyEvent e) {}
	public void keyReleased(KeyEvent e) {}
}
