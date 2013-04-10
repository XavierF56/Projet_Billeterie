package modele;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.table.AbstractTableModel;



public class ListeBillets extends AbstractTableModel{
	/********** Attributs ************/
	private Billeterie billeterie;	
	private List<Billet> listeBillets;
	private List<Billet> listeBilletsSauvegarde;
	
	/********** Constructeur ************/
	/**
	 * Crée l'objet en mettant en mémoire l ensemble des billets de la bdd
	 * @param billeterie 
	 */
	public ListeBillets(Billeterie billeterie) {
		this.billeterie = billeterie;
		listeBillets = new ArrayList<Billet>();
		this.metEnMemoire(); 
	}
	
	
	/********** Methodes ************/
	/**
	 * Met en memoire l'ensemble des billets.
	 */
	public void metEnMemoire() {
		try {
			List<Map<String, Object>> list = billeterie.getBdd().query("SELECT * from billet"); //NOM BDD
			for (int i = 0; i < list.size(); i++){
				listeBillets.add(new Billet(list.get(i), billeterie));
			}
			Billet.setProchainId((Integer)list.get(listeBillets.size() - 1).get("id")+1);
		} catch (SQLException e){
			e.printStackTrace();
		}
	}
	
	/**
	 * Renvoie l'ensemble des billets lies a la recherche
	 * @param chaine la chaine a trouver dans le billet
	 * @return la liste des billets
	 */
	public void recherche(String chaine) {
		//A develloper ! 
		reinitialise();
		List<Billet> resul= new ArrayList<Billet>();
		
		try {
			String query = "SELECT id FROM billet WHERE categorie LIKE '" + chaine +"%'"; //NOM BDD
			List<Map<String, Object>> list = billeterie.getBdd().query(query);
			if(!list.isEmpty()) {
				for (int i = 0; i< listeBillets.size(); i++) {
					int Id = listeBillets.get(i).getId();
					boolean stop = false;
					for (int j = 0; j < list.size() && !stop; j++) {
						if (Id == (Integer)list.get(j).get("id")) {
							resul.add(listeBillets.get(i));
							stop = true;
						}
					}
				}
			}
			listeBillets = resul;
			fireTableDataChanged();
		} catch (SQLException e){
			e.printStackTrace();
		}
	}
	
	/**
	 * Ajoute un billet dans la liste
	 * @param billet
	 */
	public void ajoutBillet(int id, Billet billet) {
		listeBillets.put(id, billet);
	}

	
	/********** Methodes de base ************/
	public Billet getBillet(int id) throws Exception {
		if (listeBillets.containsKey(id)){
			return listeBillets.get(id);
		} else {
			throw new Exception("Billet non existant");
		}
	}
	public String toString () {
		return listeBillets.toString();
	}

	
	/********** Methodes pour la gestion de l'affichage ************/
	public int getRowCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public String getColumnName(int columnIndex) {return "v";}

	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return null;
	}
}
