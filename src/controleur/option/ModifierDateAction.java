package controleur.option;


import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.AbstractAction;
import javax.swing.JFormattedTextField;

import modele.Billetterie;

@SuppressWarnings("serial")
public class ModifierDateAction extends AbstractAction implements KeyListener {
	
	private Billetterie billeterie;
	private JFormattedTextField champ;
	
	/**
	 * Cette classe permet la gestion de la modification de la date dans l'onglet Statistiques de la fenêtre Principale.
	 * 
	 * @param billeterie la billeterie en cours
	 * @param champ la date à définir
	 * @see Billetterie
	 * @see JFormattedTextField
	 */
    public ModifierDateAction(Billetterie billeterie, JFormattedTextField champ) {
    	super("OK");
        this.billeterie = billeterie;
        this.champ = champ;
    }
    
    /**
     * Permet de valider l'action
     */
	public void valider() {
		String source = champ.getText();	
		SimpleDateFormat dateStandard = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			Date date = dateStandard.parse(source);
			billeterie.getAchatsGeneral().setDate(date);
			champ.setText(dateStandard.format(date));
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
