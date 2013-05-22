package general;


import java.awt.Component;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import vue.fenetres.FenetrePrincipale;

import modele.Billeterie;

public class Langue {	
	
	private static Locale locale;
	private static ResourceBundle res;
	
	/**
	 * Initialisation de la langue
	 * @throws Exception
	 */
	public static void langueInit() {
		try {
			/* Recuperation de la langue dans le fichier de proprietes */
			locale = new Locale(Proprietes.getOption("langage"));
			res = ResourceBundle.getBundle("Messages", locale);
		} catch (Exception e) {
			/* Langue par defaut */
			locale = new Locale("en");
			res = ResourceBundle.getBundle("Messages", locale);
			
		}
	}
	
	public static String getTraduction(String traduction){
		String result = "";
		try {
			result = res.getString(traduction);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(new JFrame(), "Error unexpected\n" 
					+ "Error : traduction of \"" + traduction + "\"\n" + e.toString(), "Warning", JOptionPane.INFORMATION_MESSAGE);
			result = traduction;
		}
		return result;
	}
	
	public static String aPropos() {
		return Langue.getTraduction("software_versus") + Proprietes.getOption("versionLogiciel") 
				+ Langue.getTraduction("authors") + Proprietes.getOption("authors_names");
	}

	/**
	 * Gestion du menu deroulant du choix des langues
	 * @param fenetrePrincipale
	 * @return
	 */
	public static Component choixLangueMenu(final FenetrePrincipale fenetrePrincipale) {
		JComboBox<String> jcb = new JComboBox<String>();
		
		jcb.addItem(Proprietes.currentLangage);
		for(String s : Proprietes.otherLangages){
			jcb.addItem(s);
		}
		
		jcb.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent e) {
				for(String s : Proprietes.otherLangages){
					if(e.getItem().equals(s)) {
						locale = new Locale(Proprietes.getOption(s));
						res = ResourceBundle.getBundle("Messages", locale);
						
						Proprietes.setCurrentLangage(s);
						fenetrePrincipale.dispose();
						FenetrePrincipale frame = new FenetrePrincipale(new Billeterie("database.sqlite"));
						frame.setVisible(true);
					}
				}
			}
		});
		return jcb;
	}
}
