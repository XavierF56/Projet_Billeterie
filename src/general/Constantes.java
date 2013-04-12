package general;

public class Constantes {
	public final static int INTEGER = 1;
	public final static int FLOAT = 2;
	public final static int BOOLEAN = 3;
	public final static int STRING = 4;
	
	public static int stringToInt (String st) {
		int res = 0;
		if (st.equals("integer")) res = INTEGER;
		else if (st.equals("float")) res = FLOAT;
		else if (st.equals("text")) res = STRING;
		else if (st.equals("bool")) res = BOOLEAN;
		return res;
	}
}
