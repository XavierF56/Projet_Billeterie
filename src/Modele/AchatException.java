package Modele;

public class AchatException extends Exception {
	private int type;
	private String[] lien = {"Cette personne a deja achete trop de ticket a prix reduit", "Il n'a pas assez de billet en stock"};
	
	public AchatException(int i) {
		this.type = i; 
	}
	
	public String toString() {
		return "Erreur d'achat : " + lien[type];
	}

}
