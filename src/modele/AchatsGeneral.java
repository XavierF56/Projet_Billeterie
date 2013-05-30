package modele;

import general.Constantes;
import general.Langue;

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
	private Billetterie billeterie;
	private Date date;
	
	/**
	 * Constructeur de AchatsGeneral
	 * @param billeterie
	 */
	public AchatsGeneral(Billetterie billeterie) {
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
		
		resul.add(new Attribut("quantite", Langue.getTraduction("qt"), map.get("quantite"))); map.remove("quantite");
		resul.add(new Attribut("prix_unitaire", Langue.getTraduction("price_uni"), map.get("prix_unitaire"))); map.remove("prix_unitaire");
		resul.add(new Attribut("prix_total", Langue.getTraduction("price_total"), map.get("prix_total"))); map.remove("prix_total");
		resul.add(new Attribut("date", Langue.getTraduction("date"), map.get("date"))); map.remove("date");
		resul.add(new Attribut("paye", Langue.getTraduction("paid"), map.get("paye"))); map.remove("paye");
		resul.add(new Attribut("donne", Langue.getTraduction("given"), map.get("donne"))); map.remove("donne");
		resul.add(new Attribut("subventionne", Langue.getTraduction("sub"), map.get("subventionne"))); map.remove("subventionne");
		
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
