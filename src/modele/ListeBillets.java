package modele;

import general.Constantes;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.swing.table.AbstractTableModel;

public class ListeBillets extends AbstractTableModel{
	private static final long serialVersionUID = 1L;
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
		List<Map<String, Object>> list = billeterie.getBdd().getObjets("SELECT * from billet"); //NOM BDD
		for (int i = 0; i < list.size(); i++){
			listeBillets.add(new Billet(list.get(i), billeterie));
		}
		Billet.setProchainId((Integer)list.get(listeBillets.size() - 1).get("id")+1);
	}
	
	/**SQLInterface
	 * Methode creant une requete pour la recherche
	 */
	public String requete (String chaine) {
		String retour = "SELECT id FROM billet WHERE ";//NOM BDD
		boolean premier = true;
		Map<String, Integer> attributs = billeterie.getColonnesTypeBillets();
		Set<String> set = attributs.keySet();
		Iterator<String> it = set.iterator();
		while (it.hasNext()) {
			String attribut = it.next();
			if(attributs.get(attribut) == Constantes.STRING) {
				String aAjouter = attribut + " Like '"+chaine+"%' ";
				if(!premier) {
					retour = retour.concat(" OR ");
				}
				retour = retour.concat(aAjouter);
				premier = false;
			}
		}
		return retour;
	}
	
	/**
	 * Renvoie l'ensemble des billets lies a la recherche
	 * @param chaine la chaine a trouver dans le billet
	 * @return la liste des billets
	 */
	public void recherche(String chaine) {
		reinitialise();
		List<Billet> resul= new ArrayList<Billet>();
		
		String query = requete(chaine);
		List<Map<String, Object>> list = billeterie.getBdd().getObjets(query);
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
	}
	
	/**
	 * Ajoute un billet dans la liste
	 * @param billet
	 */
	public void ajoutBillet(int id, Billet billet) {
		reinitialise();
		listeBillets.add(billet);
		fireTableDataChanged();
		sauvegarde();
	}
	
	/**
	 * Supprime un billet dans la liste
	 * @param billet
	 */
	public void supprimer(Personne personne) {
		listeBillets.remove(personne);
		listeBilletsSauvegarde.remove(personne);
		fireTableDataChanged();
	}
	
	/**
	 * Lors de la modification d'une personne, il faut mettre a jour le modele de donnees
	 */
	public void modifier() {
		fireTableDataChanged();
	}
	
	public int getId(Personne personne) {
		int res = -1;
		for (int i = 0; i < listeBillets.size(); i++) {
			if (listeBillets.get(i).equals(personne)) {
				res = i;
				i = listeBillets.size();
			}
		}
		return res;
	}
	
	/**
	 * Cette methode permet de sauvegarder la liste des billets
	 * Par exemple lorsque l'on fait une recherche, listeBillets sera remplacee
	 * par une liste de billets trouves.
	 */
	public void sauvegarde() {
		List<Billet> list = new ArrayList<Billet>();
		for (int i = 0; i < listeBillets.size(); i++) {
			list.add(listeBillets.get(i));
		}
		listeBilletsSauvegarde = list;
	}
	
	/**
	 * Permet de remplacer la liste de billets par la liste de billets d'origine
	 */
	public void reinitialise() {
		listeBillets = listeBilletsSauvegarde;
		sauvegarde();
	}

	
	/********** Methodes de base ************/
	public Billet getBillet(int id) throws Exception {
		Billet billet = null;
		boolean stop = false;
		for (int i = 0; i < listeBillets.size() && !stop; i++) {
			if (id == listeBillets.get(i).getId()) {
				billet = listeBillets.get(i);
				stop = true;
			}
		}
		if (billet == null){
			throw new Exception("Personne non existante");
		}
		return billet;
	}
	
	public Billet getBilletIndex(int i){
		return listeBillets.get(i);
	}
	
	public String toString () {
		return listeBillets.toString();
	}

	
	/********** Methodes pour la gestion de l'affichage ************/
	public int getRowCount() {
		return listeBillets.size();
	}

	public int getColumnCount() {
		return billeterie.getColonnesBillets().size();
	}
	
	public String getColumnName(int columnIndex) {
		return billeterie.getColonnesBillets().get(columnIndex);
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		return listeBillets.get(rowIndex).getHashMap().get(getColumnName(columnIndex));    
	}
}
