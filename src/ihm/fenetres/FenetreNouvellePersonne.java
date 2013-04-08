package ihm.fenetres;

import java.awt.event.ActionEvent;
import java.util.HashMap;
import java.util.Map;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import modele.Billeterie;
import modele.Personne;


public class FenetreNouvellePersonne extends JFrame {
	private static final long serialVersionUID = 1L;
	Billeterie billeterie;
	JTextField champPrenom;
	JTextField champNom;
	
	public FenetreNouvellePersonne(Billeterie billeterie) {
		this.billeterie = billeterie;
		JPanel champs = new JPanel();
		champPrenom = new JTextField();
		champPrenom.setColumns(20);
		champNom = new JTextField();
		champNom.setColumns(20);
		champs.add(champPrenom);
		champs.add(champNom);
		setBounds(100, 100, 450, 300);
		this.add(champs, "Center");
		this.add(new JButton(new ValiderAction(this)), "South");
		this.setVisible(true);
	}
	
	class ValiderAction extends AbstractAction {
		private static final long serialVersionUID = 1L;
		FenetreNouvellePersonne fenetre;
        private ValiderAction(FenetreNouvellePersonne fenetre) {
            super("Valider");
            this.fenetre = fenetre;
        }
 
        public void actionPerformed(ActionEvent e) {
        	Map<String,Object> map = new HashMap<String,Object>();
    		map.put("nom", champPrenom.getText());
    		map.put("prenom", champNom.getText());
    		@SuppressWarnings("unused")
			Personne newPerso = new Personne(map, billeterie, 0);
        	fenetre.setVisible(false);
        }
    }
	
	public static void main(String[] args) {
		new FenetreNouvellePersonne(new Billeterie("database.sqlite"));
	}
}