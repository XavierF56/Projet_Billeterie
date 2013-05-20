package modele;

import general.Constantes;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class AchatsGeneral {
	protected List<Attribut> attributsAchats = new ArrayList<Attribut>();
	Billeterie billeterie;
	
	public AchatsGeneral(Billeterie billeterie) {
		this.billeterie = billeterie;
		attributsAchats();
	}

	/**
	 * Methode permettant de mettre en memoire les attributs de l'objet Achat
	 */
	private void attributsAchats() {
		Map<String, Integer> map = billeterie.getBdd().getAttributs("Achat");
		List<Attribut> resul = new ArrayList<Attribut>();
		resul.add(new Attribut("Description", "Description", Constantes.STRING));
		
		Set<String> set = map.keySet();
		Iterator<String> it = set.iterator();
		while (it.hasNext()) {
			String nom = it.next();
			resul.add(new Attribut(nom, nom, map.get(nom)));
		}
		this.attributsAchats = resul;
	}

	public List<Attribut> getAttributsAchats() {
		return attributsAchats;
	}
}
