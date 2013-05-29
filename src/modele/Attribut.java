package modele;

/**
 * Triplet de donnees permettant de stocker des informations sur un attribut de la bdd :
 * - son nom dans la BDD
 * - son nom dans l'IHM (affiche a l'ecran)
 * - son type
 * @author xavier
 */

public class Attribut {
	private String nomBDD;
	private String nomInterface;
	private int type;
	
	/**
	 * Constrcuteur d'un attribut
	 * @param nomBDD
	 * @param nomInterface
	 * @param type
	 */
	public Attribut(String nomBDD, String nomInterface, int type) {
		super();
		this.nomBDD = nomBDD;
		this.nomInterface = nomInterface;
		this.type = type;
	}
	
	/********** Getters & Setters ************/
	public String getNomBDD() {
		return nomBDD;
	}
	public String getNomInterface() {
		return nomInterface;
	}
	public int getType() {
		return type;
	}
	public String toString() {
		return "Attribut [nomBDD=" + nomBDD + ", nomInterface=" + nomInterface
				+ ", type=" + type + "]";
	}
}
