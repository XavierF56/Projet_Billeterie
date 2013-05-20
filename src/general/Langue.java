package general;

import ihm.fenetres.FenetrePrincipale;

import java.awt.Component;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JComboBox;

import modele.Billeterie;

public class Langue {	
	/* Initialises en anglais */
	
	public static Locale locale;
	public static ResourceBundle res;
	
	public static void langueInit() throws Exception{
		try {
			locale = Locale.getDefault();
			res = ResourceBundle.getBundle("Messages", locale);
		} catch (Exception e) {
			/* Cas ou la langue habituelle de l'utilisateur n'est pas geree */
			locale = new Locale("en", "US");
			res = ResourceBundle.getBundle("Messages", locale);
		}
	}
	
	public static String getTraduction(String traduction){
		String result = "";
		try {
			result = res.getString(traduction);
		} catch (Exception e) {
			Constantes.afficherAvetissementException(e, getTraduction("error_traduction"));
		}
		return result;
	}
	
	public static String aPropos() {
		String text = " \n \n";
		if (locale.equals(Locale.getDefault())) {	
			text += "Version du logiciel : "+ Constantes.versionLogiciel +"\n \n" +
					"Auteurs :\n";
		} else {
			text += "Software versus : "+ Constantes.versionLogiciel +"\n \n" +
					"Authors :\n";
		}	
		text +=	"Raphael Baron - raphael.baron@insa-rennes.fr\n" +
				"Xavier Fraboulet - xavier.fraboulet@insa-rennes.fr\n" +
				"Bruno Matry - bruno.matry@insa-rennes.fr\n" +
				"Paul-Mehdy M’Rabet - paul-mehdy.mrabet@insa-rennes.fr";
		return text;
	}

	public static String erreurAffichageIcone() {
		String res = "erreur "+ " - ";
		return res;
	}

	public static Component choixLangueMenu(final FenetrePrincipale fenetrePrincipale) {
		JComboBox<String> jcb = new JComboBox<String>();
		jcb.addItem("Francais");
		jcb.addItem("English");
		jcb.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent e) {
				if (e.getItem().equals("Francais")) {
					locale = new Locale("fr", "FR");
					res = ResourceBundle.getBundle("Messages", locale);
				} else if (e.getItem().equals("English")) {
					locale = new Locale("en", "US");
					res = ResourceBundle.getBundle("Messages", locale);
				}
				
				fenetrePrincipale.dispose();
				FenetrePrincipale frame = new FenetrePrincipale(new Billeterie("database.sqlite"));
				frame.setVisible(true);
			}
		});
		return jcb;
	}
}
