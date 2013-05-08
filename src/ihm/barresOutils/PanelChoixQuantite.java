package ihm.barresOutils;

import ihm.actions.ValiderQuantiteAction;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.NumberFormat;

import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class PanelChoixQuantite extends JPanel implements ItemListener {
	
	private boolean subventionne, paye, donne;
	private int quantite;
	private JCheckBox chckSubventionne, chckPaye, chckDonne;
	private JFormattedTextField textField;
	
	public PanelChoixQuantite (ValiderQuantiteAction keyValiderAction) {

		// Initialisation du panel et des attributs de la classe
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		this.subventionne = false;
		this.paye = false;
		this.donne = false;
		this.quantite = 0;
		
		// Label
		JLabel label = new JLabel("Choisissez la quantité de billets à commander", JLabel.CENTER);
		
		// Choix de la quantite de billets a commander
		textField = new JFormattedTextField(NumberFormat.getIntegerInstance());
		textField.setValue(1);
		textField.setColumns(20);
		textField.addKeyListener(keyValiderAction);
		
		// Creation des Checkbox
		chckSubventionne = new JCheckBox("Subventionne");
		chckSubventionne.setSelected(false);
		chckSubventionne.addItemListener(this);
		chckPaye = new JCheckBox("Paye");
		chckPaye.setSelected(false);
		chckPaye.addItemListener(this);
		chckDonne = new JCheckBox("Donne");
		chckDonne.setSelected(false);
		chckDonne.addItemListener(this);
		
		// Ajout des composants du panel
		this.add(label);
		this.add(textField);
		this.add(chckSubventionne);
		this.add(chckPaye);
		this.add(chckDonne);
	}

	public boolean getSubventionne() {
		return subventionne;
	}
	
	public boolean getPaye() {
		return paye;
	}
	
	public boolean getDonne() {
		return donne;
	}
	
	/**
	 * @return la quantite de billets commandes
	 */
	public int getQuantite() {
		quantite = Integer.parseInt(textField.getText());
		return quantite;
	}
	
	/** Methode requise lors de l'implementation de l'interface ItemListener
	 * Cette méthode est appelee lors du changement d'etat d'un composant.
	 * Elle met à jour les booleens associes aux Checkbox.
	 * 
	 * @param e
	 * @see ItemListener
	 */
	public void itemStateChanged(ItemEvent e) {
        Object source = e.getItemSelectable();
        boolean selectionne = (e.getStateChange() == ItemEvent.SELECTED);
        
        if (source == chckSubventionne) {
        	subventionne = selectionne;
        } else if (source == chckPaye) {
        	paye = selectionne;
        } else if (source == chckDonne) {
            donne = selectionne;
        }
    }
}
