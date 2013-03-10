package Modele;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Personne {
	/********** Attributs ************/
	private Map<String,Object> map = new HashMap<String,Object>(); // le champ id n'est pas present dans cette map
	private Billeterie bill;
	
	private ListeAchats achats;
	// Booleen permettant de savoir si il faut recuperrer/maj les achats depuis la bdd
	private boolean achatEnMem;

	// id utilise par le prochain billet cree
	private static int prochainId; 
	
	/********** Constructeurs ************/
	
	/**
	 * Constructeur d'une personne deja presente dans la bdd, 
	 * La map contient l'ensemble des attributs de l'objet ainsi que son id
	 * @param map
	 * @param bill
	 */
	public Personne (Map<String, Object> map, Billeterie bill){
		this.map = map;
		this.bill = bill;
		this.achatEnMem = false;
		this.achats = new ListeAchats(this);
	}
	
	/**
	 * Constructeur d'une personne qui n'est pas present dans la bdd. La personne a ete creee par l'utilisateur
	 * La map contient l'ensemble des attributs de l'objet mais pas son Id. Cet Id sera ajouté par le constructeur
	 * @param map
	 * @param bill
	 * @param useless ce param sert juste a diffrencier les deux constructeurs
	 */
	public Personne(Map<String,Object> map, Billeterie bill, int useless) {
		this.map = map;
		this.bill = bill;
		this.achatEnMem = false;
		this.achats = new ListeAchats(this);
		
		// Attribue un Id a ce nouveau billet
		if (!map.containsKey("id")) {
			map.put("id", prochainId);
			prochainId++;
		}
		
		// Enregistre le nouveau billet dans la bdd
		try {
			bill.getBdd().ajoutBDD("people", map); //NOM BDD
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		// Ajoute le billet a la listeBillets
		bill.getListePersonnes().ajoutPersonne(this.getId(), this);
	}
	
	/**
	 *  Cette methode modifie un billet et l'enregistre dans la bdd
	 *  @param map
	 */
	@SuppressWarnings("unused")
	private void modifie(Map<String,Object> nouvelleMap) {
		try {
			// Remplace l'ancienne map par la nouvelle en ajoutant l'id si celui-ci n'est pas present dans la nouvelle
			int ancId = this.getId();
			this.map = nouvelleMap;
			if (!map.containsKey("id")) {
				map.put("id", ancId);
			}
			
			// Sauvegarde les modifs dans la bdd
			bill.getBdd().enregistreBDD("people", map); //NOM BDD
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Realise un achat si cela est possible
	 * @param billet
	 * @param quantite
	 * @param paye
	 * @return vrai si l operation a reussie
	 * @throws AchatException 
	 */
	public void faireAchat(Billet billet, int qtRed, int qtNor, boolean paye, boolean donne,boolean forcer) throws AchatException {
		if (!achatEnMem) {
			achats.metEnMemoire();
		}
		
		//A REFAIRE :
		if ((qtRed == 0) || forcer || prixReduit(billet, qtRed)) {
			if (billet.getNbPlace() >= qtRed + qtNor) {
				
			} else {
				throw new AchatException(1);
			}
		} else {
			throw new AchatException(0);
		}
		
		achatEnMem = false;
		//Doit balancer des exceptions => afficher des messages d erreurs
	}
	
	/**
	 * Verifie si cette personne peut profiter d un prix reduit
	 * @return
	 */
	public boolean prixReduit(Billet bill, int qt) {
		return true;
	}

	
	
	

	public Billeterie getBilleterie() { return this.bill;}
	public static int getProchainId() {return prochainId;}
	public static void setProchainId(int prochainId) {Personne.prochainId = prochainId;}
	public int getId() {return (Integer) map.get("id");}
	public boolean equal(Personne pers) {return this.getId() == pers.getId();}
	public String toString () {return map +"\n";}
}