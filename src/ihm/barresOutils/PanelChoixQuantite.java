package ihm.barresOutils;

import ihm.actions.ValiderQuantiteAction;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.NumberFormat;

import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;

@SuppressWarnings("serial")
public class PanelChoixQuantite extends JPanel implements ItemListener{
	private boolean subventionne;
	private boolean paye;
	private boolean donne;
	private int quantite;
	private JCheckBox chckSubventionne;
	private JCheckBox chckPaye;
	private JCheckBox chckDonne;
	
	public PanelChoixQuantite (ValiderQuantiteAction keyValiderAction) {
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		
		this.subventionne = false;
		this.paye = false;
		this.donne = false;
		this.quantite = 0;
		
		JTextPane txtpn = new JTextPane();
		txtpn.setText("Choisissez la quantité de billets à commander");
		JTextField textField = new JFormattedTextField(NumberFormat.getIntegerInstance());
		textField.setColumns(20);
		textField.addKeyListener(keyValiderAction);
		checkBoxInit(chckSubventionne, "Subventionne");
		checkBoxInit(chckPaye, "Paye");
		checkBoxInit(chckDonne, "Donne");
				
		this.add(txtpn);
		this.add(textField);
		this.add(chckSubventionne);
		this.add(chckPaye);
		this.add(chckDonne);
	}
	
	private void checkBoxInit (JCheckBox item, String nom) {
		item = new JCheckBox(nom);
		item.setSelected(false);
		item.addItemListener(this);
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
	
	public int getQuantite() {
		return quantite;
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
        Object source = e.getItemSelectable();

        if (source == chckSubventionne) {

        } else if (source == glassesButton) {

        } else if (source == hairButton) {

        } else if (source == teethButton) {
       
        }

        //Now that we know which button was pushed, find out
        //whether it was selected or deselected.
        if (e.getStateChange() == ItemEvent.DESELECTED) {
            c = '-';
        }

        //Apply the change to the string.
        choices.setCharAt(index, c);

        updatePicture();
    }

}
