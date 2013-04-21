package modele;

import java.util.HashMap;
import java.util.Map;

public abstract class Objet {
	protected Map<String,Object> map = new HashMap<String,Object>(); // le champ id n'est pas present dans cette map
	protected Billeterie billeterie;

	public Map<String, Object> getHashMap() {
		return map;
	}
	
	public int getId() {
		return (Integer) map.get("id");
	}
	
	public Billeterie getBilleterie() {
		return this.billeterie;
	}
	
	/**
	 * Cette methode supprimer un objet de la memoire ainsi que dans la ListeObjet
	 */
	public abstract void supprimer();

	/**
	 *  Cette methode enregistre un billet en memoire grace a une requete update
	 *  @param map
	 */
	public abstract void modifie(Map<String, Object> map);
}
