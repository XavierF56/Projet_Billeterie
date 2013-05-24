package modele;

import general.Langue;

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
		table = "personne";
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
		resul.add(new Attribut("nom", Langue.getTraduction("name"), map.get("nom")));
		map.remove("nom");
		resul.add(new Attribut("prenom", Langue.getTraduction("firstname"), map.get("prenom")));
		map.remove("prenom");
		resul.add(new Attribut("mail", Langue.getTraduction("mail"), map.get("mail")));
		map.remove("mail");
		
		Set<String> set = map.keySet();
		Iterator<String> it = set.iterator();
		while (it.hasNext()) {
			String nom = it.next();
			resul.add(new Attribut(nom, nom, map.get(nom)));
		}

		this.attributs = resul;
	}
	
	
	
	/**
	 * Cette methode permet d'ajouter une Personne dans la liste
	 * @param la liste des attributs sous forme d'une map
	 */
	public void ajouter(Map<String, Object> map, boolean sub) {
		reinitialise();
		Personne personne = new Personne(map, billeterie, 1);
		listeObjet.add(personne);
		fireTableDataChanged();
		sauvegarde();
	}
}
