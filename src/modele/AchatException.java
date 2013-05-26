package modele;

import general.Langue;

/**
 * Cette class permet de gérer les exceptions de type achat
 */

@SuppressWarnings("serial")
public class AchatException extends Exception {
	private int type;
	private String[] lien = {
			Langue.getTraduction("error_buying_reduced_tickets"), 
			Langue.getTraduction("error_buying_not_enought_tickets"),
			Langue.getTraduction("error_buying_not_enought_reduced_tickets")};
	
	public AchatException(int i) {
		this.type = i; 
	}
	
	public String toString() {
		return Langue.getTraduction("error_buying") + " : " + lien[type];
	}
	
	public int getId() {
		return type;
	}
}
