package Modele;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListePersonnes {
	private Billeterie billeterie;	
	private Map<Integer, Personne> listePersonnes = new HashMap<Integer, Personne>();
	
	
	/* 
	 * Crée l'objet en mettant en mémoire l ensemble des billets de la bdd
	 * @param billeterie 
	 */
	public ListePersonnes (Billeterie billeterie) {
		this.billeterie = billeterie;
		this.metEnMemoire();
	}
	
	/*
	 * Met en memoire l'ensemble des billets.
	 */
	public void metEnMemoire() {
		try {
			// Execute une requete sur la bdd pour obtenir un ResultSet
			ResultSet set = billeterie.getBdd().query("select * from personnes");
			
			// Ce Result Set est transforme en une Map associant id à billet. ID etant le premier parametre du ResultSet
			//TODO
			
			// Cloture le ResultSet
			set.close();
		} catch (SQLException e){
			//TODO
			e.printStackTrace();
		}
	}
	
	
	/*
	 * Renvoie l'ensemble des personnes lies a la recherche
	 * @param chaine la chaine a trouver dans le billet
	 * @return la liste des billets
	 */
	public HashMap<Integer, Personne> recherche(String chaine){
		//TODO
		return null;
	}
	
	
	/*
	 * Ajoute une Personne dans la liste et enregistre dans la bdd
	 * @param billet le billet à ajouter
	 * @return vrai si l'ajout est effectue, faux sinon
	 */
	public boolean ajoutPersonne(Personne personne){
		//TODO
		return true;
	}
	
	/*
	 * Retourne la personne correspondant a l id 
	 * @param id du personne
	 * @return le personnne
	 */
	public Personne cherchePersonne (int id){
		//TODO
		return null;
	}
	
	public String toString () {
		//TODO
		return null;
	}
}
