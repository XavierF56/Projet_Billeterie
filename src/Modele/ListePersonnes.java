package Modele;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.swing.table.AbstractTableModel;

public class ListePersonnes extends AbstractTableModel {
	private Billeterie billeterie;	
	private Map<Integer, Personne> listePersonnes = new HashMap<Integer, Personne>();
	private List<Integer> listId;
	
	
	/********** Constructeur ************/
	/**
	 * Crée l'objet en mettant en mémoire l ensemble des billets de la bdd
	 * @param billeterie 
	 */
	public ListePersonnes(Billeterie billeterie) {
		this.billeterie = billeterie;
		this.metEnMemoire();
		listId = getListId();
	}
	
	
	/********** Methodes ************/
	/**
	 * Met en memoire l'ensemble des billets.
	 */
	public void metEnMemoire() {
		try {
			List<Map<String, Object>> list = billeterie.getBdd().query("SELECT * from personne"); //NOM BDD
			for (int i = 0; i < list.size(); i++){
				listePersonnes.put((Integer)list.get(i).get("id"),new Personne(list.get(i), billeterie));
			}
			Personne.setProchainId((Integer)list.get(listePersonnes.size() - 1).get("id") + 1);
		} catch (SQLException e){
			e.printStackTrace();
		}
	}
	
	/**
	 * Renvoie l'ensemble des billets lies a la recherche
	 * @param chaine la chaine a trouver dans le billet
	 * @return la liste des billets
	 */
	public Map<Integer, Personne> recherche(String chaine) {
		//A develloper ! 
		Map<Integer, Personne> resul= new HashMap<Integer, Personne>();
		
		try {
			String query = "SELECT id FROM personne WHERE nom LIKE '" + chaine +"%'"; //NOM BDD
			List<Map<String, Object>> list = billeterie.getBdd().query(query);
			for (int i = 0; i < list.size(); i++) {
				int valI = (Integer)list.get(i).get("id");
				if (listePersonnes.containsKey(valI)) {
					resul.put(valI, listePersonnes.get(valI));
				}
			}
		} catch (SQLException e){
			e.printStackTrace();
		}
		
		return resul;
	}
	
	/**
	 * Ajoute une personne dans la liste
	 * @param billet
	 */
	public void ajoutPersonne(int id, Personne pers) {
		listePersonnes.put(id, pers);
		listId = getListId();
	}
	
	
	/********** Methodes de base************/
	public Personne getPersonne(int id) throws Exception {
		if (listePersonnes.containsKey(id)){
			return listePersonnes.get(id);
		} else {
			throw new Exception("Personne non existante");
		}
	}
	public String toString () {
		return listePersonnes.toString();
	}
	
	/********** Methodes pour la gestion de l'affichage ************/
	public List<Integer> getListId() {
		List<Integer> res = new ArrayList<Integer>();
		Set set = listePersonnes.keySet();
		Iterator it = set.iterator();
		while (it.hasNext()) {
			res.add((Integer) it.next());
		}
		return res;
	}
	
	public int getRowCount() {
    	return listePersonnes.size();
    }
 
    public int getColumnCount() {
    	return billeterie.getColonnesPersonnes().size();
    }
 
    public String getColumnName(int columnIndex) {
    	return billeterie.getColonnesPersonnes().get(columnIndex);
    }
 
    public Object getValueAt(int rowIndex, int columnIndex) {
    	return listePersonnes.get(listId.get(rowIndex)).getHashMap().get(getColumnName(columnIndex));    	
    }
}
