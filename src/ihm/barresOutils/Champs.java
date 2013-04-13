package ihm.barresOutils;

import general.Constantes;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

//TODO Verifier que les champs de text ne contiennent pas de caracteres etranges, "'" par ex
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
	}
	
	public void setValeurs(Map<String, Object> map) {
		Set<String> set = map.keySet();
		Iterator<String> it = set.iterator();
		while(it.hasNext()) {
			String nom = it.next();
			JComponent compo = listeChamps.get(nom);
			if(compo instanceof JFormattedTextField) {
				((JFormattedTextField) compo).setValue(map.get(nom));
			} else if (compo instanceof JCheckBox) {
				((JCheckBox)compo).setSelected((Boolean) map.get(nom));
			}
		}
	}
	
	/**
	 * @return les donnees saisi dans les champs
	 * @throws Exception 
	 */
	public Map<String, Object> getDonnees() throws Exception {
		Map<String, Object> resultat = new HashMap<String, Object>();
		Set<String> set = listeChamps.keySet();
		Iterator<String> it = set.iterator();
		while (it.hasNext()) {
			String nom = it.next();
			resultat.put(nom, this.getValeur(nom));
		}
		return resultat;
	}
	
	private JComponent nouveauChamp(int type){
		JComponent champ;
		switch (type) {
		case Constantes.INTEGER : champ = new JFormattedTextField(NumberFormat.getIntegerInstance()); 
								((JFormattedTextField) champ).setColumns(20);break;
		case Constantes.FLOAT : champ = new JFormattedTextField(NumberFormat.getNumberInstance()); 
								((JFormattedTextField) champ).setColumns(20);break;
		case Constantes.STRING : champ = new JFormattedTextField(); 
								((JFormattedTextField) champ).setColumns(20);break;
		case Constantes.BOOLEAN : champ = new JCheckBox(); break;
		default : champ = null;
		}

		return champ;
	}
	
	private Object getValeur(String nom) throws Exception {
		Object res;
		JComponent champ = listeChamps.get(nom);
		int type = listeAttributs.get(nom);
		try {
		switch (type) {
			case Constantes.INTEGER : System.out.println("Entier " + nom);res = Integer.parseInt(((JTextField)champ).getText()); break;
			case Constantes.FLOAT : System.out.println("Float " + nom);res = strToFloat(((JTextField)champ).getText()); break;
			case Constantes.STRING : System.out.println("String " + nom);res = ((JTextField)champ).getText(); break;
			case Constantes.BOOLEAN : System.out.println("BOOl " + nom);res = ((JCheckBox)champ).isSelected(); break;
			default : res = null;
			}
		} catch (Exception e) {
			throw new Exception("Les champs ne sont pas remplis");
		}
		if(res instanceof String && res.equals("")) {
			throw new Exception("Les champs ne sont pas remplis");
		}
		return res;
	}
	
	private static float strToFloat(String s){
     	s = s.replace(',', '.');
     	return Float.parseFloat(s);
    }
}
