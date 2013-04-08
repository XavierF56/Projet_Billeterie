package Modele;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.table.AbstractTableModel;

public class ListePersonnes extends AbstractTableModel {
	private static final long serialVersionUID = 1L;
	private Billeterie billeterie;	
	private List<Personne> listePersonnes;
	private List<Personne> listePersonnesSauvegarde;
	
	
	/********** Constructeur ************/
	/**
	 * Crée l'objet en mettant en mémoire l ensemble des billets de la bdd
	 * @param billeterie 
	 */
	public ListePersonnes(Billeterie billeterie) {
		this.billeterie = billeterie;
		listePersonnes = new ArrayList<Personne>();
		this.metEnMemoire();
	}
	
	
	/********** Methodes ************/
	/**
	 * Met en memoire l'ensemble des billets.
	 */
	public void metEnMemoire() {
		try {
			List<Map<String, Object>> list = billeterie.getBdd().query("SELECT * from personne"); //NOM BDD
			for (int i = 0; i < list.size(); i++){
				listePersonnes.add(new Personne(list.get(i), billeterie));
			}
			Personne.setProchainId((Integer)list.get(listePersonnes.size() - 1).get("id") + 1);
			this.sauvegarde();
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
		List<Personne> resul= new ArrayList<Personne>();
		
		try {
			String query = "SELECT id FROM personne WHERE nom LIKE '" + chaine + "%' OR prenom Like '" + chaine + "%'"; //NOM BDD
			List<Map<String, Object>> liste = billeterie.getBdd().query(query);
			if(!liste.isEmpty()){
				for (int i = 0; i < listePersonnes.size(); i++) {
					int Id = listePersonnes.get(i).getId();
					boolean stop = false;
					for (int j = 0; j < liste.size() && !stop; j++) { //OPTIMIZE
						if (Id == (Integer)liste.get(j).get("id")) {
							resul.add(listePersonnes.get(i));
							stop = true;
						}
					}
				}
				listePersonnes = resul;
			}
			fireTableDataChanged();
		} catch (SQLException e){
			e.printStackTrace();
		}
	}
	
	/**
	 * Ajoute une personne dans la liste
	 * @param billet
	 */
	public void ajoutPersonne(int id, Personne pers) {
		reinitialise();
		listePersonnes.add(pers);
		fireTableDataChanged();
		//fireTableRowsInserted(getRowCount() -1, getRowCount() -1);
		sauvegarde();
	}
	
	/**
	 * Supprimer une personne de la liste
	 * @param personne
	 */
	public void supprimer(Personne personne) {
		//reinitialise();
		listePersonnes.remove(personne);
		listePersonnesSauvegarde.remove(personne);
		fireTableDataChanged();
		//sauvegarde();
	}
	
	/**
	 * Lors de la modification d'une personne, il faut mettre a jour le modele de donnees
	 */
	public void modifier() {
		fireTableDataChanged();
	}
	
	public int getId(Personne personne) {
		int res = -1;
		for (int i = 0; i < listePersonnes.size(); i++) {
			if (listePersonnes.get(i).equals(personne)) {
				res = i;
				i = listePersonnes.size();
			}
		}
		return res;
	}
	
	/**
	 * Cette methode permet de sauvegarder la liste des personnes
	 * Par exemple lorsque l'on fait une recherche, listePersonnes sera remplace 
	 * par une liste de personnes trouves.
	 */
	public void sauvegarde() {
		List<Personne> liste = new ArrayList<Personne>();
		for (int i = 0; i < listePersonnes.size(); i++) {
			liste.add(listePersonnes.get(i));
		}
		listePersonnesSauvegarde = liste;
	}
	
	/**
	 * Permet de remplacer la liste de personnes par la liste de personnes d'origine
	 */
	public void reinitialise() {
		listePersonnes = listePersonnesSauvegarde;
		sauvegarde();
	}
	
	
	/********** Methodes de base************/
	public Personne getPersonne(int id) throws Exception {
		Personne personne = null;
		boolean stop = false;
		for (int i = 0; i < listePersonnes.size() && !stop; i++) {
			if (id == listePersonnes.get(i).getId()) {
				personne = listePersonnes.get(i);
				stop = true;
			}
		}
		if (personne == null){
			throw new Exception("Personne non existante");
		}
		return personne;
	}
	
	public Personne getPersonneIndex(int i){
		return listePersonnes.get(i);
	}
	
	public String toString () {
		return listePersonnes.toString();
	}
	
	
	/********** Methodes pour la gestion de l'affichage ************/
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
    	return listePersonnes.get(rowIndex).getHashMap().get(getColumnName(columnIndex));    	
    }


	
}
