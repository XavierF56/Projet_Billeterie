package Interface;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import General.Constantes;
import Modele.Billeterie;

import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Champs extends JPanel{
	private static final long serialVersionUID = 1L;
	Map<String, JPanel> listeChamps = new HashMap<String, JPanel>();
	Map<String, Integer> listeAttributs;
	
	public Champs(Map<String, Integer> listeAttributs) {
		this.listeAttributs = listeAttributs;
		Set<String> set = listeAttributs.keySet();
		Iterator<String> it = set.iterator();
		while (it.hasNext()) {
			String nom = (String) it.next();
			System.out.println(nom + "//" + listeAttributs.get(nom));
			Champ champ = new Champ(nom, listeAttributs.get(nom));
			listeChamps.put(nom, champ);
			champ.setSize(300, 20);
			add(champ);
		}
		
	}
	
	public Map<String, Object> getDonnees() {
		Map<String, Object> resultat = new HashMap<String, Object>();
		Set<String> set = listeChamps.keySet();
		Iterator<String> it = set.iterator();
		while (it.hasNext()) {
			String nom = it.next();
			resultat.put(nom, listeChamps.get(nom));
		}
		return resultat;
	}
	
	class Champ extends JPanel{
		private static final long serialVersionUID = 1L;
		JComponent champ;
		
		public Champ(String nom, int type) {
			super();
			add(new JLabel(nom));
			
			switch (type) {
			case Constantes.INTEGER : champ = new JTextField(); break;
			case Constantes.FLOAT : champ = new JTextField(); break;
			case Constantes.STRING : champ = new JTextField(); break;
			case Constantes.BOOLEAN : champ = new JCheckBox(); break;
			}
			add(champ);
		}
		
		public Object getValeur() {
			if (champ instanceof JTextField) {
				return ((JTextField)champ).getText();
			} if (champ instanceof JCheckBox) {
				return ((JCheckBox)champ).getText();
			}
			return null;
		}
	}
	public static void main(String[] args) {
		Billeterie billeterie = new Billeterie("database.sqlite");
		JFrame frame = new JFrame();
		frame.add(new Champs(billeterie.getColonnesTypeBillets()));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 700, 700);
		frame.setVisible(true);
	}
}
