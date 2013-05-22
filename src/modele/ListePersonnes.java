package modele;

import general.Constantes;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class ListePersonnes extends ListeObjet {
	private static final long serialVersionUID = 1L;

	
	/********** Constructeur ************/
	/**
	 * Crée l'objet en mettant en mémoire l ensemble des billets de la bdd
	 * @param billeterie 
	 */
	public ListePersonnes(Billeterie billeterie) {
		super(billeterie);
		attributs();
		metEnMemoire();
	}
	
	/********** Methodes ************/
	/**
	 * Met en memoire l'ensemble des billets.
	 */
	public void metEnMemoire() {
		List<Map<String, Object>> list = billeterie.getBdd().getObjets("SELECT * from personne"); //NOM BDD

		for (int i = 0; i < list.size(); i++){
			listeObjet.add(new Personne(list.get(i), billeterie));
		}
	    
		if(listeObjet.size() != 0) {
			Personne.setProchainId((Integer)list.get(listeObjet.size() - 1).get("id") + 1);
		} else { // cas ou la bdd est vide
			Personne.setProchainId(0);
		}

		this.sauvegarde();
	}
	
	/**
	 * Cette methode permet de récuperer la liste des attributs pour l'objet Personne
	 */
	private void attributs() {
		Map<String, Integer> map = billeterie.getBdd().getAttributs("Personne");
		List<Attribut> resul = new ArrayList<Attribut>();
		
		// Formatage a la main
		resul.add(new Attribut("nom", "Nom", map.get("nom")));
		map.remove("nom");
		resul.add(new Attribut("prenom", "Prenom", map.get("prenom")));
		map.remove("prenom");
		
		Set<String> set = map.keySet();
		Iterator<String> it = set.iterator();
		while (it.hasNext()) {
			String nom = it.next();
			resul.add(new Attribut(nom, nom, map.get(nom)));
		}

		this.attributs = resul;
	}
	
	/**
	 * Renvoie l'ensemble des personnes lies a la recherche
	 * @param chaine a trouver dans les attributs de l'objet
	 * @return la liste des billets
	 */
	public void recherche(String chaine) {
		reinitialise();
		List<Objet> resul= new ArrayList<Objet>();
		
		String query = requete(chaine);
		List<Map<String, Object>> list = billeterie.getBdd().getObjets(query);
		if(!list.isEmpty()) {
			for (int i = 0; i< listeObjet.size(); i++) {
				int Id = listeObjet.get(i).getId();
				boolean stop = false;
				for (int j = 0; j < list.size() && !stop; j++) {
					if (Id == (Integer)list.get(j).get("id")) {
						resul.add(listeObjet.get(i));
						stop = true;
					}
				}
			}
			listeObjet = resul;
		}
		fireTableDataChanged();
	}
	
	/**
	 * Cette methode permet d'ajouter une Personne dans la liste
	 * @param la liste des attributs sous forme d'une map
	 */
	public void ajouter(Map<String, Object> map) {
		reinitialise();
		Personne personne = new Personne(map, billeterie, 1);
		listeObjet.add(personne);
		fireTableDataChanged();
		sauvegarde();
	}
	
	/**
	 * Methode creant une requete pour la recherche
	 */
	private String requete (String chaine) {
		String retour = "SELECT id FROM personne WHERE ";
		boolean premier = true;
		List<Attribut> list = getAttributs();
		String[] st = chaine.split("\\s+");
		
		for (int j = 0; j < st.length; j++) {
			for (int i = 0; i < list.size() ; i++) {
				if(list.get(i).getType() == Constantes.STRING) {
					String aAjouter = list.get(i).getNomBDD() + " Like '"+st[j]+"%' ";
					if(!premier) {
						retour = retour.concat(" OR ");
					}
					retour = retour.concat(aAjouter);
					premier = false;
				}
			}
		}
		return retour;
	}
}
