package controleur.option;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JCheckBox;
import javax.swing.ListSelectionModel;

import modele.Billetterie;

@SuppressWarnings("serial")
public class OptionSelectionMultipleListener extends AbstractAction {

	private JCheckBox box;
	private Billetterie billeterie;
	
	/**
	 * Cette classe permet la gestion de l'option permettant la sélection mutliple par l'utilisteur.
	 * 
	 * @param box la checkbox liée à cette option
	 * @param billeterie la billeterie en cours
	 */
	public OptionSelectionMultipleListener(JCheckBox box, Billetterie billeterie) {
		this.box = box;
		this.billeterie = billeterie;
		
	}

	/** Methode requise par l'heritage de la classe AbstractAction
     * 
     * @see AbstractAction
	 */
	public void actionPerformed(ActionEvent e) {
		if(box.isSelected()) {
			billeterie.getFenetre().getTableauBillets().setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
			billeterie.getFenetre().getTableauPersonnes().setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		} else {
			billeterie.getFenetre().getTableauBillets().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			billeterie.getFenetre().getTableauPersonnes().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		}
	}
}
