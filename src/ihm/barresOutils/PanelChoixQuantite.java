package ihm.barresOutils;

import ihm.actions.ValiderQuantiteAction;

import java.text.NumberFormat;

import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;

@SuppressWarnings("serial")
public class PanelChoixQuantite extends JPanel {
	
	public PanelChoixQuantite (ValiderQuantiteAction keyValiderAction) {
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		
		JTextPane txtpn = new JTextPane();
		txtpn.setText("Choisissez la quantité de billets à commander");
		JTextField textField = new JFormattedTextField(NumberFormat.getIntegerInstance());
		textField.setColumns(20);
		textField.addKeyListener(keyValiderAction);
		JCheckBox chckbxSubventionne = new JCheckBox("Subventionné");
			
		this.add(txtpn);
		this.add(textField);
		this.add(chckbxSubventionne);
	}
}
