package Modele;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Billet {
	/********** Attributs ************/
	private int id;
	private HashMap<String,Object> map = new HashMap<String,Object>(); // le champ id n'est pas present dans cette map
	private Billeterie bill;
	
	// id utilise par le prochain billet cree
	private static int prochainId; 
	
	
	/********** Methodes ************/
	/*
	 * A partir de la Map, ce constructeur renseigne le champ id(contenu dans la map) et map
	 * @param map
	 */
	public Billet (HashMap<String,Object> map){
		this.map = map;
	}
	
	
	/*
	 * Cette methode retourne l'ensemble des achats lies a un billet
	 * @return liste des achats
	 */
	public List<Achat> Achats (){
		//TODO
		return null;
	}
	
	
	/*
	 *  Cette methode enregistre un billet en memoire grace a une requete update
	 */
	public void enregistre() {
		// TODO Auto-generated method stub
	}
	
	
	/*
	 *  Cette methode enregistre un billet en memoire grace a une requete insert
	 */
	public void ajoutBDD(){
		bill.getBdd().ajoutBDD("billets", id, map);
	}

	
	
	/********** Methodes de base ************/
	public static int getProchainId() {return prochainId;}
	public static void setProchainId(int prochainId) {Billet.prochainId = prochainId;}
	public int getId() {return id;}
	public void setId(int id) {this.id = id;}
	public String toString () {return "Billet numero " + id + " : " + map;}


	public Billeterie getBill() {
		return bill;
	}


	public void setBill(Billeterie bill) {
		this.bill = bill;
	}
}
