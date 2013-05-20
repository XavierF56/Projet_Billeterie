package modele;

import general.Constantes;

import java.util.ArrayList;
import java.util.Date;
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
	
	public double getTotalPrix() {
		List<Objet> list = billeterie.getListePersonnes().getListeObjet();
		double result = 0;
		for (int i = 0; i < list.size(); i++) {
			Personne personne = (Personne) list.get(i);
			result += personne.getTotalPrix();
		}
		return result;
	}
	
	@SuppressWarnings("deprecation")
	public double getMoisPrix() {
		List<Objet> list = billeterie.getListePersonnes().getListeObjet();
		Date date = new Date();
		date.setMonth((date.getMonth()-1)%12);
		double result = 0;
		for (int i = 0; i < list.size(); i++) {
			Personne personne = (Personne) list.get(i);
			result += personne.getMoisPrix(date);
		}
		return result;
	}
	
	public int getTotalArticles() {
		List<Objet> list = billeterie.getListePersonnes().getListeObjet();
		int result = 0;
		for (int i = 0; i < list.size(); i++) {
			Personne personne = (Personne) list.get(i);
			result += personne.getTotalArticles();
		}
		return result;
	}
	
	@SuppressWarnings("deprecation")
	public int getMoisArticle() {
		List<Objet> list = billeterie.getListePersonnes().getListeObjet();
		Date date = new Date();
		date.setMonth((date.getMonth()-1)%12);
		int result = 0;
		for (int i = 0; i < list.size(); i++) {
			Personne personne = (Personne) list.get(i);
			result += personne.getMoisArticles(date);
		}
		return result;
	}
}
