package Modele;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Personne {
	private int id;
	private Map<String,Object> map = new HashMap<String,Object>();
	
	// id utilise par la prochaine personne cree
	private static int prochainId; 
	
	public Personne (Map<String,Object> map){
		//TODO
	}
	
	public List<Achat> Achats (){
		//TODO
		// utiliser la methode qui transforme un Resultset en List de Map
		return null;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public void enregistre() {
		// TODO Auto-generated method stub
		
	}
	
}
