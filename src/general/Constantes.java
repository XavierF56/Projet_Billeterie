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
	public final static int FRANCAIS = 100;
	public final static int ENGLISH = 101;
	public final static Object[] options = {"Annuler", "Non", "Oui"};
	public final static String nomLogiciel = "Firebox";
	public final static String versionLogiciel = "Alpha - 0.7";
	public static int currentLangage = Constantes.FRANCAIS;
	
	
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
	 */
	public static void afficherException (Exception e) {
		JOptionPane.showMessageDialog(new JFrame(), "Une erreur inattendue s'est produite :\n"+ e.toString(), "Erreur - Exception", JOptionPane.ERROR_MESSAGE);
	}
	
	public static String aPropos() {
		String text = "";
		if(Constantes.currentLangage == Constantes.FRANCAIS) {
			text += "Version du logiciel : "+ Constantes.versionLogiciel +"\n \n" +
					"Auteurs :\n";
		} else if(Constantes.currentLangage == Constantes.ENGLISH) {
			text += "Software versus : "+ Constantes.versionLogiciel +"\n \n" +
					"Authors :\n";
		}		
		text +=	"Raphael Baron - raphael.baron@insa-rennes.fr\n" +
				"Xavier Fraboulet - xavier.fraboulet@insa-rennes.fr\n" +
				"Bruno Matry - bruno.matry@insa-rennes.fr\n" +
				"Paul-Mehdy M’Rabet - paul-mehdy.mrabet@insa-rennes.fr";
		return text;
	}	 
}
