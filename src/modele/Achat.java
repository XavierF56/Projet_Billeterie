package modele;

import general.Constantes;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

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
	 * Cration d'un nouveau billet, non présent dans la bdd
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
			map.put("id", billet.getId() + "Z" + personne.getId() + "Z" + personne.getAchats().getNbAchats());
			map.put("id_personne", personne.getId());
			map.put("id_billet", billet.getId());
		}
	}
	
	
	
	/********** Methodes ************/
	/**
	 * Lorsqu'une commande a ete validee, cette methode permet d'enregistrer chaque achat 
	 * dans la liste des achats d'une personne ainsi que dans la bdd.
	 * Elle repercute les modifs sur le billet
	 */
	public void ajoute() {
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
	 * Cette fonction modifie le billet en diminuant sa quantite
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
	 * Cette methode supprimer un billet de la memoire ainsi que dans la ListeBillets
	 */
	public void supprimer() {
		billeterie.getBdd().supprimer("achat", this.getId());
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
	public Billet getBillet() {
		return billet;
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
		SimpleDateFormat dateStandard = new SimpleDateFormat("dd/MM/yyyy");
		try {
			return dateStandard.parse((String) map.get("date"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	
	
	/********** Getters & Setters ************/
	public Personne getPersonne() {
		return personne;
	}
	public String toString () {
		return map +"\n";
	}
}
