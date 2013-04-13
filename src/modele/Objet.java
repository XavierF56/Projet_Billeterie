package modele;

import java.util.HashMap;
import java.util.Map;

public abstract class Objet {
	protected Map<String,Object> map = new HashMap<String,Object>(); // le champ id n'est pas present dans cette map
	protected Billeterie billeterie;
	public int getId() {
		return 0;
	}

	public abstract Map<String, Object> getHashMap();
	
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
