package ihm.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JCheckBox;
import javax.swing.ListSelectionModel;

import modele.Billeterie;

@SuppressWarnings("serial")
public class OptionListener extends AbstractAction {

	private JCheckBox box;
	private Billeterie billeterie;
	
	public OptionListener(JCheckBox box, Billeterie billeterie) {
		this.box = box;
		this.billeterie = billeterie;
		
	}

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
