package Modele;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Billet {
	private int id;
	private Map<String,Object> map = new HashMap<String,Object>();
	
	// id utilise par le prochain billet cree
	private static int prochainId; 
	
	/*
	 * A partir de la Map, ce constructeur renseigne le champ id(contenu dans la map) et map
	 * @param map
	 */
	public Billet (Map<String,Object> map){
		//TODO
	}
	
	/*
	 * Cette methode retourne l'ensemble des achats lies a un billet
	 * @return liste des achats
	 */
	public List<Achat> Achats (){
		//TODO
		return null;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
		
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
		
	}
}
