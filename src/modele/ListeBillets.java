package modele;

import general.Langue;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;


@SuppressWarnings("serial")
public class ListeBillets extends ListeObjet{
	protected List<Attribut> attributsRed = new ArrayList<Attribut>();
	
	/********** Constructeur ************/
	/**
	 * Crée l'objet en mettant en mémoire l ensemble des billets de la bdd
	 * @param billeterie 
	 */
	public ListeBillets(Billeterie billeterie) {
		super(billeterie);
		attributs();
		this.metEnMemoire();
		table = "billet";
	}
	
	
	/********** Methodes ************/
	/**
	 * Met en memoire l'ensemble des billets.
	 */
	public void metEnMemoire() {
		List<Map<String, Object>> list = billeterie.getBdd().getObjets("SELECT * from billet"); //NOM BDD
		for (int i = 0; i < list.size(); i++){
			listeObjet.add(new Billet(list.get(i), billeterie));
		}
		
		if(listeObjet.size() != 0) {
			Billet.setProchainId((Integer)list.get(listeObjet.size() - 1).get("id")+1);
		} else { // cas ou la bdd est vide
			Billet.setProchainId(0);
		}
		
		this.sauvegarde();
	}
	
	/**
	 * Cette methode permet de récuperer la liste des attributs pour l'objet Billet (billet subventionne)
	 */
	private void attributs() {
		Map<String, Integer> map = billeterie.getBdd().getAttributs("Billet");
		List<Attribut> resul = new ArrayList<Attribut>();
		map.remove("date");
		map.remove("sub");
		resul.add(new Attribut("categorie", Langue.getTraduction("category"), map.get("categorie"))); map.remove("categorie");
		resul.add(new Attribut("sous_categorie", Langue.getTraduction("subcategory"), map.get("sous_categorie"))); map.remove("sous_categorie");
		resul.add(new Attribut("prix", Langue.getTraduction("price"), map.get("prix"))); map.remove("prix");
		resul.add(new Attribut("nb_total", Langue.getTraduction("qt"), map.get("nb_total"))); map.remove("nb_total");
		resul.add(new Attribut("prix_sub", Langue.getTraduction("price_sub"), map.get("prix_sub"))); map.remove("prix_sub");
		resul.add(new Attribut("nb_sub_par_personne", Langue.getTraduction("qt_sub_per"), map.get("nb_sub_par_personne"))); map.remove("nb_sub_par_personne");
		resul.add(new Attribut("nb_sub", Langue.getTraduction("qt_sub"), map.get("nb_sub"))); map.remove("nb_sub");
		
		Set<String> set = map.keySet();
		Iterator<String> it = set.iterator();
		while (it.hasNext()) {
			String nom = it.next();
			resul.add(new Attribut(nom, nom, map.get(nom)));
		}
		this.attributs = resul;
		attributsRed();
	}
	
	/**
	 * Cette methode permet de récuperer la liste des attributs pour l'objet Billet (billet normal)
	 */
	private void attributsRed() {
		Map<String, Integer> map = billeterie.getBdd().getAttributs("Billet");
		List<Attribut> resul = new ArrayList<Attribut>();
		map.remove("date");
		map.remove("sub");
		resul.add(new Attribut("categorie", Langue.getTraduction("category"), map.get("categorie"))); map.remove("categorie");
		resul.add(new Attribut("sous_categorie", Langue.getTraduction("subcategory"), map.get("sous_categorie"))); map.remove("sous_categorie");
		resul.add(new Attribut("prix", Langue.getTraduction("price"), map.get("prix"))); map.remove("prix");
		resul.add(new Attribut("nb_total", Langue.getTraduction("qt"), map.get("nb_total"))); map.remove("nb_total");
		map.remove("prix_sub");
		map.remove("nb_sub_par_personne");
		map.remove("nb_sub");
		Set<String> set = map.keySet();
		Iterator<String> it = set.iterator();
		while (it.hasNext()) {
			String nom = it.next();
			resul.add(new Attribut(nom, nom, map.get(nom)));
		}
		this.attributsRed = resul;
	}

	
	/**
	 * Cette methode permet d'ajouter un Billet dans la liste
	 * @param la liste des attributs sous forme d'une map
	 */
	public void ajouter(Map<String, Object> map, boolean sub) {
		reinitialise();
		Billet billet = new Billet(map, billeterie, sub);
		listeObjet.add(billet);
		fireTableDataChanged();
		sauvegarde();
	}
	
	public List<Attribut> getAttributsRed() {
		return attributsRed;
	}
}
