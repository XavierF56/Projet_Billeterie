package modele;

import general.Constantes;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Cette class permet d'obtenir des informations sur les achats :
 * - elle stock et recupere les attributs d'un achat(pour que ce ne soit effectue qu'une fois)
 * - elle permet d'obtenir des statistiques sur les achats
 * @author xavier
 */

public class AchatsGeneral {
	private List<Attribut> attributsAchats = new ArrayList<Attribut>();
	private Billeterie billeterie;
	private Date date;
	
	
	
	/********** Constructeur ************/
	public AchatsGeneral(Billeterie billeterie) {
		this.billeterie = billeterie;
		attributsAchats();
		
		date=new Date();
	}

	
	
	/********** Methodes ************/
	/**
	 * Methode permettant de mettre en memoire les attributs de l'objet Achat
	 */
	private void attributsAchats() {
		Map<String, Integer> map = billeterie.getBdd().getAttributs("Achat");
		List<Attribut> resul = new ArrayList<Attribut>();
		resul.add(new Attribut("Description", "Description", Constantes.STRING));
		
		resul.add(new Attribut("quantite", "Quantite", map.get("quantite"))); map.remove("quantite");
		resul.add(new Attribut("prix_unitaire", "Prix Unite", map.get("prix_unitaire"))); map.remove("prix_unitaire");
		resul.add(new Attribut("prix_total", "Prix Total", map.get("prix_total"))); map.remove("prix_total");
		resul.add(new Attribut("date", "Date", map.get("date"))); map.remove("date");
		resul.add(new Attribut("paye", "Paye", map.get("paye"))); map.remove("paye");
		resul.add(new Attribut("donne", "Donne", map.get("donne"))); map.remove("donne");
		resul.add(new Attribut("subventionne", "Subventionne", map.get("subventionne"))); map.remove("subventionne");
		
		Set<String> set = map.keySet();
		Iterator<String> it = set.iterator();
		while (it.hasNext()) {
			String nom = it.next();
			resul.add(new Attribut(nom, nom, map.get(nom)));
		}
		this.attributsAchats = resul;
	}
	
	/**
	 * @return la recette depuis le debut
	 */
	public double getTotalPrix() {
		List<Objet> list = billeterie.getListePersonnes().getListeObjet();
		double result = 0;
		for (int i = 0; i < list.size(); i++) {
			Personne personne = (Personne) list.get(i);
			result += personne.getTotalPrix();
		}
		return result;
	}
	
	/**
	 * @return la recette depuis la date (attribut de la class)
	 */
	public double getMoisPrix() {
		List<Objet> list = billeterie.getListePersonnes().getListeObjet();
		double result = 0;
		for (int i = 0; i < list.size(); i++) {
			Personne personne = (Personne) list.get(i);
			result += personne.getMoisPrix(date);
		}
		return result;
	}
	
	/**
	 * @return le nombre de commande effectuees depuis le debut
	 */
	public int getTotalArticles() {
		List<Objet> list = billeterie.getListePersonnes().getListeObjet();
		int result = 0;
		for (int i = 0; i < list.size(); i++) {
			Personne personne = (Personne) list.get(i);
			result += personne.getTotalArticles();
		}
		return result;
	}
	
	/**
	 * @return le nombre de commande effectuees depuis la date (attribut de la class)
	 */
	public int getMoisArticle() {
		List<Objet> list = billeterie.getListePersonnes().getListeObjet();
		int result = 0;
		for (int i = 0; i < list.size(); i++) {
			Personne personne = (Personne) list.get(i);
			result += personne.getDateArticles(date);
		}
		return result;
	}

	
	
	/********** Getters & Setters ************/
	public List<Attribut> getAttributsAchats() {
		return attributsAchats;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getDate() {
		SimpleDateFormat dateStandard = new SimpleDateFormat("dd/MM/yyyy");
		return dateStandard.format(date);
	}
}
