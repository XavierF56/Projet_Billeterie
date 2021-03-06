package modele;

import general.Constantes;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * Cette class represente l'objet Achat present dans la bdd dans la table Achats.
 * Les achats sont regroupes dans des ListeAchats. Chaque personne possede une ListeAchats,
 * afin de garder en memoire les achats passes.
 * @author xavier
 */
public class Achat extends Objet {
	private Personne personne;
	private Billet billet;

	
	
	/********** Constructeurs ************/
	/**
	 * Constructeur d'un achat deja present dans la bdd, 
	 * La map contient l'ensemble des attributs de l'objet ainsi que les id Billet et Personne. 
	 * @param map
	 * @param personne
	 */
	public Achat(Map<String,Object> map, Personne perso) {
		super();
		this.map = map;
		this.billeterie = perso.getBilleterie();
		this.personne = perso;
		try {
			billet =  (Billet) personne.getBilleterie().getListeBillets().getObjetById((Integer) map.get("id_billet"));
		} catch (Exception e) {
			Constantes.afficherException(e);
		}
		map.put("Description", billet.toString());
	}
	
	/**
	 * Cration d'un nouvel achat, non présent dans la bdd
	 * @param map
	 * @param perso
	 * @param billet
	 */
	public Achat (Map<String,Object> map, Personne perso, Billet billet){
		super();
		super.map = map;
		super.billeterie = perso.getBilleterie();
		this.personne = perso;
		this.billet= billet;
		
		// Attribue un Id a cette nouvelle personne
		if (!map.containsKey("id")) {
			map.put("id", billet.getId() + "0" + personne.getId() + "0" + personne.getAchats().getNbAchats());
			map.put("id_personne", personne.getId());
			map.put("id_billet", billet.getId());
		}
		
		// Enregistre l'achat dans la bdd
		try {
			personne.getBilleterie().getBdd().ajoutBDD("achat", map); //NOM BDD
		} catch (SQLException e) {
			Constantes.afficherException(e);
		}
				
		// Ajoute l'achat à la liste d'achats de la personne
		personne.getAchats().ajouter(this);
		map.put("Description", billet.toString());
		
		// Repercute l'achat sur la liste des billets
		this.repercuter();
	}
	
	
	
	/********** Methodes ************/
	/**
	 *  Cette methode modifie un Achat dans la bdd
	 *  @param map
	 */
	private void modifie() {
		try {
			String nom = (String) map.get("Description");
			map.remove("Description");
			personne.getBilleterie().getBdd().enregistreBDD("achat", map); //NOM BDD
			map.put("Description", nom);
		} catch (SQLException e) {
			Constantes.afficherException(e);
		}
		personne.getAchats().modifier();
	}
	
	/**
	 * Cette fonction modifie le billet liee a cet achat en diminuant la quantite
	 */
	private void repercuter() {
		try {
			((Billet)personne.getBilleterie().getListeBillets().getObjetById(
					(Integer) map.get("id_billet"))).modifieQt(-(Integer) map.get("quantite"), 
							(Boolean) map.get("subventionne"));
		} catch (Exception e) {
			Constantes.afficherException(e);
		}
	}
	
	/**
	 * Cette methode supprimer un achat
	 */
	public void supprimer() {
		billeterie.getBdd().supprimer("achat", this.getId()+"");
		personne.getAchats().supprimer(this);
	}

	public void modifie(Map<String, Object> map) {
		// Not Implemented
	}
	
	/**
	 * Modifie l'attribut "paye" de l'achat 
	 * Cela signifie que les billets ont ete payes
	 */
	public void setPayer(boolean bl) {
		map.put("paye", bl);
		this.modifie();
	}
	
	/**
	 * Modifie l'attribut "donne" de l'achat 
	 * Cela signifie que les billets ont ete donnes a la personne
	 */
	public void setDonner(boolean bl) {
		map.put("donne", bl);
		this.modifie();
	}	

	
	/********** Getters sur les attributs de la BDD ************/
	public boolean getPaye() {
		return (Boolean) Boolean.valueOf(map.get("paye").toString());
	}
	public boolean getDonne() {
		return (Boolean) Boolean.valueOf(map.get("donne").toString());
	}
	public boolean getSubventionne() {
		return (Boolean) Boolean.valueOf(map.get("subventionne").toString());
	}
	public int getQt() {
		return (Integer) map.get("quantite");
	}
	public int getPrixUnitaire() {
		return (Integer) map.get("prix_unitaire");
	}
	public double getPrixTotal() {
		return (Double) map.get("prix_total");
	}
	public Date getDate() {
		SimpleDateFormat dateStandard = new SimpleDateFormat("dd/MM/yyyy-HH-mm");
		try {
			return dateStandard.parse((String) map.get("date"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	public boolean isQuotaEnCours() {
		return billet.getDateQuota().before(this.getDate()) || billet.getDateQuota().equals(this.getDate());
	}
	
	/********** Getters & Setters ************/
	public Personne getPersonne() {
		return personne;
	}
	public String toString () {
		return map +"\n";
	}
	public Billet getBillet() {
		return billet;
	}
}
