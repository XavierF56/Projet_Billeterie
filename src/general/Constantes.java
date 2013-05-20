package general;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Constantes {
	public final static int INTEGER = 1;
	public final static int DOUBLE = 2;
	public final static int BOOLEAN = 3;
	public final static int STRING = 4;
	public final static Object[] options = {"Annuler", "Non", "Oui"};
	public final static String nomLogiciel = "Titi et gros Tickets";
	public final static String versionLogiciel = "Alpha - 0.7";
	
	
	/**
	 * Conversion d'une chaine de caractere en un entier associe
	 * @param st La chaine a convertir
	 * @return La constance associe a la chaine de caractere si elle existe, 0 sinon
	 */
	public static int stringToInt (String st) {
		int res = 0;
		if (st.equals("integer") || st.equals("INTEGER")) res = INTEGER;
		else if (st.equals("float") || st.equals("FLOAT")) res = DOUBLE;
		else if (st.equals("text") || st.equals("VARCHAR") || st.equals("TEXT")) res = STRING;
		else if (st.equals("bool") || st.equals("BOOL")) res = BOOLEAN;
		return res;
	}
	
	/**
	 * 
	 * @param map
	 * @return
	 */
	public static List<String> mapToList (Map<String, Integer> map) {
		List<String> resul = new ArrayList<String>(); 
		Set<String> set = map.keySet();
		Iterator<String> it = set.iterator();
		while (it.hasNext()) {
			resul.add((String) it.next());
		}
		return resul;
	}
	
	/** Permet l'affichage graphique sous forme d'une fenetre d'erreur d'une exception e
	 * 
	 * @param e l'exception a afficher
	 * @see JOptionPane
	 */
	public static void afficherException (Exception e) {
		JOptionPane.showMessageDialog(new JFrame(), "Une erreur inattendue s'est produite :\n"+ e.toString(), "Erreur - Exception", JOptionPane.ERROR_MESSAGE);
	}
	
	/** Permet l'affichage graphique sous forme d'une fenetre d'avertissement d'une exception e
	 * 
	 * @param e l'exception a afficher
	 * @see JOptionPane
	 */
	public static void afficherAvetissementException (Exception e) {
		JOptionPane.showMessageDialog(new JFrame(), "Attention, une erreur inattendue s'est produite :\n"+ e.toString(), "Avertissement - Exception", JOptionPane.INFORMATION_MESSAGE);
	}

	/**
	 * Permet l'affichage graphique sous forme d'une fenetre d'avertissement d'une exception e et d'un message
	 * 
	 * @param e l'exception a afficher
	 * @param message le message a affiche
	 * @see JOptionPane
	 */
	public static void afficherAvetissementException(Exception e, String message) {
		JOptionPane.showMessageDialog(new JFrame(), "Attention, une erreur inattendue s'est produite :\n" 
	+ message + "\n" + e.toString(), "Avertissement - Exception", JOptionPane.INFORMATION_MESSAGE);
	}
}
