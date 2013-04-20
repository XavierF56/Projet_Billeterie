package general;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Constantes {
	public final static int INTEGER = 1;
	public final static int FLOAT = 2;
	public final static int BOOLEAN = 3;
	public final static int STRING = 4;
	
	/**
	 * Conversion d'une chaine de caractere en un entier associe
	 * @param st La chaine a convertir
	 * @return La constance associe a la chaine de caractere si elle existe, 0 sinon
	 */
	public static int stringToInt (String st) {
		int res = 0;
		if (st.equals("integer")) res = INTEGER;
		else if (st.equals("float")) res = FLOAT;
		else if (st.equals("text")) res = STRING;
		else if (st.equals("bool")) res = BOOLEAN;
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
}
