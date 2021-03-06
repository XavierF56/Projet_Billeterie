package modele;

import general.Constantes;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Cette class represente un billet, elle est associee a la table Billets dans la bdd.
 * Cahque billet est represente par differents attributs stockes dans une HashMap(afin
 * de pouvoir rajouter des attributs). Ces billets sont stockes dans la ListeBillet.
 * @author xavier
 *
 */
public class Billet extends Objet {
	private static int prochainId; 	// id utilise par le prochain billet cree

	
	/********** Constructeurs ************/
	/**
	 * Constructeur d'un billet deja present dans la bdd, 
	 * La map contient l'ensemble des attributs de l'objet ainsi que son id
	 * @param map
	 * @param bill
	 */
	public Billet(Map<String,Object> map, Billetterie bill) {
		super();
		this.map = map;
		this.billeterie = bill;
	}
	
	/**
	 * Constructeur d'un billet qui n'est pas present dans la bdd. Le billet a ete cree par l'utilisateur
	 * La map doit contenir l'ensemble des attributs de l'objet MAIS PAS SON ID. Cet Id sera ajouté par le constructeur
	 * @param map
	 * @param bill
	 * @param useless ce param sert juste a diffrencier les deux constructeurs
	 */
	public Billet(Map<String,Object> map, Billetterie bill, boolean sub) {
		super();
		this.map = map;
		this.billeterie = bill;
		
		if (!sub) {
			map.put("prix_sub", 0);
			map.put("nb_sub_par_personne", 0);
			map.put("nb_sub", 0);
		}
		
		map.put("sub", sub);
		
		// Attribue un Id a ce nouveau billet
		if (!map.containsKey("id")) { //NOM BDD
			map.put("id", prochainId);
			prochainId++;
		}
		
		Date maDateAvecFormat=new Date();
		SimpleDateFormat dateStandard = new SimpleDateFormat("dd/MM/yyyy-HH-mm");
		map.put("date", dateStandard.format(maDateAvecFormat));
		
		// Enregistre le nouveau billet dans la bdd
		try {
			bill.getBdd().ajoutBDD("billet", map); //NOM BDD
		} catch (SQLException e) {
			Constantes.afficherException(e);
		}
	}
	
	
	/********** Methodes ************/
	/**
	 *  Cette methode enregistre un billet en memoire grace a une requete update
	 *  @param map
	 */
	public void modifie(Map<String,Object> nouvelleMap) {
		try {
			// Remplace l'ancienne map par la nouvelle en ajoutant l'id si celui-ci n'est pas present dans la nouvelle
			Set<String> set = nouvelleMap.keySet();
			Iterator<String> it = set.iterator();
			while (it.hasNext()) {
				String key = it.next();
				map.put(key, nouvelleMap.get(key));
			}
			
			// Sauvegarde les modifs dans la bdd
			billeterie.getBdd().enregistreBDD("billet", map); //NOM BDD
		} catch (SQLException e) {
			Constantes.afficherException(e);
		}
		billeterie.getListeBillets().modifier();
	}
	
	/**
	 * Cette methode supprimer un billet de la memoire ainsi que dans la ListeBillets
	 */
	public void supprimer() {
		billeterie.getBdd().supprimer("Billet", this.getId()+"");
		billeterie.getListeBillets().supprimer(this);
		List<Objet> listeObjet = billeterie.getListePersonnes().getListeObjet();
		for (int i = 0; i < listeObjet.size(); i++) {
			((Personne) listeObjet.get(i)).supprimerAchat(this);
		}
	}
	
	/**
	 * Augmente ou diminue le nombre de billet restant, 
	 * subventionne permet de savoir si les billets à enlever sont des billets subventionnes
	 * Si qt > 0, cela ajoute des billets
	 * Quand on ajoute des billets sub, on ajoute aussi la meme quantite de billet non sub
	 * @param qt
	 * @param subventionne
	 */
	public void modifieQt(int qt, boolean subventionne) {
		if(subventionne) {
			map.put("nb_sub", getNbPlaceSub()+qt);
			map.put("nb_total", getNbPlace()+qt);
		} else {
			map.put("nb_total", getNbPlace()+qt);
		}	
		if((Integer) map.get("nb_sub") < 0) {
			map.put("nb_sub", 0);
		}
		if((Integer) map.get("nb_total") < 0) {
			map.put("nb_total", 0);
		}
		if((Integer) map.get("nb_total") < (Integer) map.get("nb_sub")) {
			map.put("nb_sub", (Integer) map.get("nb_total"));
 		}
		modifie(this.map);
	}
	
	/**
	 * Cette methode permet de remettre a zero le quota associe a ce billet.
	 * Elle change le champ date du billet par la date actuelle.
	 * Ainsi l'ensemble des achats ralises avant cette date ne seront plus pris en
	 * compte par la suite.
	 */
	public void razQuota() {
		Date maDateAvecFormat=new Date();
		SimpleDateFormat dateStandard = new SimpleDateFormat("dd/MM/yyyy-HH-mm");
		map.put("date", dateStandard.format(maDateAvecFormat));
		modifie(this.map);
	}
	
	
	/********** Getters sur les attributs de la BDD ************/
	public int getNbPlace() {
		return (Integer) map.get("nb_total");
	}
	public int getNbPlaceSub() {
		return (Integer) map.get("nb_sub");
	}
	public double getPrixRed() {
		return (Double) map.get("prix_sub");
	}
	public double getPrixNor() {
		return (Double) map.get("prix");
	}
	public int getNbPlacePerso() {
		return (Integer) map.get("nb_sub_par_personne");
	}
	public Date getDateQuota() {
		SimpleDateFormat dateStandard = new SimpleDateFormat("dd/MM/yyyy-HH-mm");
		try {
			return dateStandard.parse((String) map.get("date"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public boolean getSub() {
		return (Boolean) Boolean.valueOf(map.get("sub").toString());
	}
	
	/********** Getters & Setters ************/
	public static int getProchainId() {
		return prochainId;
	}
	public static void setProchainId(int prochainId) {
		Billet.prochainId = prochainId;
	}
	public boolean equal(Billet bill) {
		return this.getId() == bill.getId();
	}
	public String toString () { //NOM BDD
		return map.get("categorie") + " : " + map.get("sous_categorie");
	}
}
