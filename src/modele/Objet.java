package modele;

import java.util.HashMap;
import java.util.Map;

public abstract class Objet {
	protected Map<String,Object> map = new HashMap<String,Object>(); // le champ id n'est pas present dans cette map
	protected Billetterie billeterie;

	/********** Methodes abstract ************/
	/**
	 * Cette methode supprimer un objet de la memoire ainsi que dans la ListeObjet
	 */
	public abstract void supprimer();

	/**
	 *  Cette methode enregistre un billet en memoire grace a une requete update
	 *  @param map
	 */
	public abstract void modifie(Map<String, Object> map);
	
	
	/********** Getters & Setters ************/
	public int getId() {
		try {
			return (Integer) map.get("id");
		} catch (Exception e) {
			return Integer.valueOf((String) map.get("id"));
		}
	}
	public Billetterie getBilleterie() {
		return this.billeterie;
	}
	public Map<String, Object> getHashMap() {
		return map;
	}
	public boolean getSub() {
		return true;
	}
}
