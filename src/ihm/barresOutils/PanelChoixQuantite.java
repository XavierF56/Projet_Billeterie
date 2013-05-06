package ihm.barresOutils;

import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class PanelChoixQuantite extends JPanel {
	
	public PanelChoixQuantite () {
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		
		JTextField textField = new JTextField();
		JCheckBox chckbxSubventionne = new JCheckBox("Subventionné");
		
		this.add(textField);
		this.add(chckbxSubventionne);
	}
}
