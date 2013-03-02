package Modele;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Personne {
	private int id;
	private Map<String,Object> map = new HashMap<String,Object>();
	private static int prochainId; // id utilise par la prochaine personne cree
	
	public Personne (Map<String,Object> map){
		//TODO
	}
	
	/*
	 * Cette methode retourne l'ensemble des achats effectues par une personne
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
		//TODO
		
	}
}
