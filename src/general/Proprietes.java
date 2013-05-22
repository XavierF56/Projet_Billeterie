package general;

import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;

public class Proprietes {
	public static String currentLangage;
	public static ArrayList<String> otherLangages;
	
	private static Locale locale;
	private static ResourceBundle res;
	
	public static void proprietesInit() throws Exception{
		locale = new Locale("");
		res = ResourceBundle.getBundle("Options", locale);
		currentLangage = Proprietes.getOption("langage_curr");
		otherLangages = new ArrayList<String>();
		otherLangages.add(Proprietes.getOption("other_langage_0"));
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
	
	public static void setCurrentLangage(String s) {
		Proprietes.otherLangages.add(Proprietes.currentLangage);
		Proprietes.otherLangages.remove(s);
		Proprietes.currentLangage = s;
	}
}
