package modele;

public class AchatException extends Exception {
	private static final long serialVersionUID = 1L;
	private int type;
	private String[] lien = {
			"Cette personne a deja achete trop de ticket a prix reduit", 
			"Il n'y a pas assez de billets en stock",
			"Il n'y a pas assez de billets a prix reduit en stock"};
	
	public AchatException(int i) {
		this.type = i; 
	}
	
	public String toString() {
		return "Erreur d'achat : " + lien[type];
	}

}