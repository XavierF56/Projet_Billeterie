package controleur.option;


import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.AbstractAction;
import javax.swing.JFormattedTextField;

import modele.Billeterie;
import vue.fenetres.Fenetre;

@SuppressWarnings("serial")
public class ModifierDateAction extends AbstractAction implements KeyListener {
	
	private Billeterie billeterie;
	private JFormattedTextField date;
	
	/** Permet d'annuler une action en cours en fermant la fenetre en parametre
	 * 
	 * @param fenetre la fenetre a fermer
	 * @param titre le titre de l'action
	 * @see AbstractAction
	 * @see Fenetre
	 */
    public ModifierDateAction(Billeterie billeterie, JFormattedTextField date) {
    	super("OK");
        this.billeterie = billeterie;
        this.date = date;
    }
    
	public void action() {
		String source = date.getText();	
		SimpleDateFormat dateStandard = new SimpleDateFormat("dd/MM/yyyy");
		try {
			billeterie.getAchatsGeneral().setDate(dateStandard.parse(source));
			System.out.println(dateStandard.parse(source));
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
		action();
	}
	
	public void keyPressed(KeyEvent e) {
	   if (e.getKeyCode() == KeyEvent.VK_ENTER) {
	       action();
	   }
	}
	public void keyTyped(KeyEvent e) {}
	public void keyReleased(KeyEvent e) {}
}
