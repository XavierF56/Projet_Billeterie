package Interface;

import general.Constantes;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import modele.Billeterie;

public class Champs extends JPanel{
	private static final long serialVersionUID = 1L;
	Map<String, JComponent> listeChamps = new HashMap<String, JComponent>();
	Map<String, Integer> listeAttributs;
	GridBagConstraints gridBagConstraints;
	public int nb = 0;
	
	/**
	 * Constructeur d'un champs
	 * @param listeAttributs
	 */
	public Champs(Map<String, Integer> listeAttributs) {
		this.listeAttributs = listeAttributs;
		
		this.setLayout(new GridBagLayout());
		gridBagConstraints = new GridBagConstraints();
		
		Set<String> set = listeAttributs.keySet();
		Iterator<String> it = set.iterator();
		while (it.hasNext()) {
			String nom = (String) it.next();
			
			//Ajout de l'etiquette
			gridBagConstraints.gridx = 0;
			gridBagConstraints.gridy = nb;
			gridBagConstraints.anchor = GridBagConstraints.CENTER;
			JLabel etiquette = new JLabel(nom +" : ");
			add(etiquette,gridBagConstraints);
			
			//Ajout du champ
			gridBagConstraints.gridx = 1;
			JComponent champ = nouveauChamp(listeAttributs.get(nom));
			listeChamps.put(nom, champ);
			add(champ,gridBagConstraints);
			
			nb++;
		}
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = nb;
		gridBagConstraints.anchor = GridBagConstraints.CENTER;
		add(new JButton(new ValiderAction(this)),gridBagConstraints);
	}
	
	private JComponent nouveauChamp(int type) {
		JComponent champ;
		switch (type) {
		case Constantes.INTEGER : champ = new JFormattedTextField(NumberFormat.getIntegerInstance()); 
								((JFormattedTextField) champ).setColumns(20);break;
		case Constantes.FLOAT : champ = new JFormattedTextField(); 
								((JFormattedTextField) champ).setColumns(20);break;
		case Constantes.STRING : champ = new JFormattedTextField(); 
								((JFormattedTextField) champ).setColumns(20);break;
		case Constantes.BOOLEAN : champ = new JCheckBox(); break;
		default : champ = null;
		}
		return champ;
	}
	
	private Object getValeur(String nom) {
		Object res;
		JComponent champ = listeChamps.get(nom);
		int type = listeAttributs.get(nom);
		switch (type) {
		case Constantes.INTEGER : System.out.println("Entier " + nom);res = Integer.parseInt(((JTextField)champ).getText()); break;
		case Constantes.FLOAT : System.out.println("Float " + nom);res = Float.parseFloat(((JTextField)champ).getText()); break;
		case Constantes.STRING : System.out.println("String " + nom);res = ((JTextField)champ).getText(); break;
		case Constantes.BOOLEAN : System.out.println("BOOl " + nom);res = ((JCheckBox)champ).isSelected(); break;
		default : res = null;
		}
		return res;
	}
	
	/**
	 * @return les donnees saisi dans les champs
	 */
	public Map<String, Object> getDonnees() {
		Map<String, Object> resultat = new HashMap<String, Object>();
		Set<String> set = listeChamps.keySet();
		Iterator<String> it = set.iterator();
		while (it.hasNext()) {
			String nom = it.next();
			resultat.put(nom, this.getValeur(nom));
		}
		return resultat;
	}
	
	class ValiderAction extends AbstractAction {
		private static final long serialVersionUID = 1L;
		Champs champs;
		private ValiderAction(Champs champs) {
            super("Valider");
            this.champs = champs;
        }
 
        public void actionPerformed(ActionEvent e) {
        	System.out.println(champs.getDonnees());
        }
    }
	
	public static void main(String[] args) {
		Billeterie billeterie = new Billeterie("database.sqlite");
		JFrame frame = new JFrame();
		Map<String, Integer> map = billeterie.getColonnesTypeBillets();
		map.put("bool", 3);
		frame.add(new Champs(map));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 500, 400);
		frame.setVisible(true);
	}
}
