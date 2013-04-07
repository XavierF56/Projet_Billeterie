package Modele;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;


/*
 * This is the main class where you can launch the application
 * 
 */

public class Billeterie {
	private ListePersonnes listePersonnes;
	private ListeBillets listeBillets;
	private SQLInterface bdd;
	private Map<String, Integer> colonnesTypePersonnes;
	private Map<String, Integer> colonnesTypeBillets;
	private List<String> colonnesPersonnes;
	private List<String> colonnesBillets;
		
	/* TODO ajouter une map<String, type> pour avoir les attributs de chaque objet (sans les id)
	 * La methode doit pouvoir marcher meme si la bdd est vide
	 * Elle enverra des exception si certains para necessaire ne sont pas presents (para de base)
	 */
	
	
	/********** Constructeur ************/
	public Billeterie (String nomBdd) {
		try{
			bdd = new SQLiteImpl(nomBdd);
		} catch (Exception e) {
			//TODO
		}
		listePersonnes = new ListePersonnes(this);
		listeBillets = new ListeBillets(this);
		colonnesTypePersonnes = ((SQLiteImpl) bdd).getColonnes("Personne");
		colonnesTypeBillets = ((SQLiteImpl) bdd).getColonnes("Billet");
		colonnesPersonnes = mapVersList(colonnesTypePersonnes);
		colonnesBillets = mapVersList(colonnesTypeBillets);
	}
	
	/********** Methodes ************/
	public List<String> mapVersList (Map<String, Integer> map) {
		List<String> resul = new ArrayList<String>(); 
		Set set = map.keySet();
		Iterator it = set.iterator();
		while (it.hasNext()) {
			resul.add((String) it.next());
		}
		return resul;
	}
	
	
	/********** Getters ************/
	public ListePersonnes getListePersonnes() {
		return listePersonnes;
	}
	public ListeBillets getListeBillets() {
		return listeBillets;
	}
	public SQLInterface getBdd() {
		return bdd;
	}
	public Map<String, Integer> getColonnesTypeBillets() {
		return colonnesTypeBillets;
	}
	public Map<String, Integer> getColonnesTypePersonnes() {
		return colonnesTypePersonnes;
	}
	public List<String> getColonnesBillets() {
		return colonnesBillets;
	}
	public List<String> getColonnesPersonnes() {
		return colonnesPersonnes;
	}

	public static void main (String[] args){
		long start; 
		start = System.nanoTime();
		
		Billeterie bill = new Billeterie("database.sqlite");
			
		long duree = System.nanoTime() - start;
		System.out.println(duree);
		System.out.println(bill.getColonnesBillets());
		System.out.println(bill.getColonnesPersonnes());

	}
}
