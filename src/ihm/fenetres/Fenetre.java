package ihm.fenetres;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public abstract class Fenetre extends JFrame{
	protected void afficher() {
		pack();
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((screen.width - this.getSize().width)/2,(screen.height - this.getSize().height)/2);
		setVisible(true);
	}
}
