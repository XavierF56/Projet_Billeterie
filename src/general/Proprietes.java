package general;

import java.util.Locale;
import java.util.ResourceBundle;

public class Proprietes {
	private static Locale locale;
	private static ResourceBundle res;
	
	public static void proprietesInit() throws Exception{
		locale = new Locale("");
		res = ResourceBundle.getBundle("Options", locale);
	}
	
	public static String getOption(String option){
		String result = "";
		try {
			result = res.getString(option);
		} catch (Exception e) {
			Constantes.afficherAvetissementException(e, "Error properties");
		}
		return result;
	}
}
