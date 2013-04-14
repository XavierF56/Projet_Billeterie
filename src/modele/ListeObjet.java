package modele;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

public abstract class ListeObjet extends AbstractTableModel{
	private static final long serialVersionUID = 1L;
	protected Billeterie billeterie;	
	protected List<Objet> listeObjet = new ArrayList<Objet>();
	protected List<Objet> listeObjetSauvegarde = new ArrayList<Objet>();
	protected JTable tableau;
	protected Map<String, Integer> attributsType = new HashMap<String, Integer>();
	protected List<String> attributs = new ArrayList<String>();


	/**
	 * Constructeur
	 * @param billeterie
	 */
	public ListeObjet(Billeterie billeterie) {
		this.billeterie = billeterie;
	}
	
	/**
	 * Cette methode permet de mettre en memoire les objets a partir de la bdd
	 */
	public abstract void metEnMemoire();
	
	/**
	 * Ajoute un billet dans la liste
	 * @param billet
	 */
	public abstract void ajouter(Map<String, Object> map);
	
	/**
	 * Renvoie l'ensemble des billets lies a la recherche
	 * @param chaine la chaine a trouver dans le billet
	 * @return la liste des billets
	 */
	public abstract void recherche(String chaine);
	
	/**
	 * Cette methode met a jour le modele de donnes lors de suppressions
	 * @param objet
	 */
	public void supprimer(Objet objet) {
		listeObjet.remove(objet);
		listeObjetSauvegarde.remove(objet);
		fireTableDataChanged();
	}
	
	/**
	 * Cette methode met a jour le modele de donnes lors de modifications
	 */
	public void modifier() {
		reinitialise();
		fireTableDataChanged();
		sauvegarde();
	}
	
	/**
	 * Cette methode permet de sauvegarder la liste des billets
	 * Par exemple lorsque l'on fait une recherche, listeBillets sera remplacee
	 * par une liste de billets trouves.
	 */
	public void sauvegarde() {
		List<Objet> list = new ArrayList<Objet>();
		for (int i = 0; i < listeObjet.size(); i++) {
			list.add(listeObjet.get(i));
		}
		listeObjetSauvegarde = list;
	}
	
	/**
	 * Permet de remplacer la liste de billets par la liste de billets d'origine
	 */
	public void reinitialise() {
		listeObjet = listeObjetSauvegarde;
		sauvegarde();
	}
	
	
	
	/**
	 * @param index
	 * @return L'objet situe a l'index index
	 * @throws Exception 
	 */
	public Objet getObjetByIndex(int index) throws Exception{
		Objet objet = null;
		objet = listeObjet.get(index);
		if (objet == null){
			throw new Exception("Personne non existante");
		}
		return objet;
	}
	
	/**
	 * @param id
	 * @return l'objet d'id id
	 * @throws Exception
	 */
	public Objet getObjetById(int id) throws Exception {
		Objet objet = null;
		boolean stop = false;
		for (int i = 0; i < listeObjet.size() && !stop; i++) {
			if (id == listeObjet.get(i).getId()) {
				objet = listeObjet.get(i);
				stop = true;
			}
		}
		if (objet == null){
			throw new Exception("Personne non existante");
		}
		return objet;
	}
	
	/********** Methodes de base ************/
	public String toString () {
		return listeObjet.toString();
	}
	public Billeterie getBilleterie() {
		return billeterie;
	}
	public List<String> getAttributs() {
		return attributs;
	}
	public Map<String, Integer> getAttributsType() {
		return attributsType;
	}
	public JTable getTableau() {
		return tableau;
	}
	public void setTableau(JTable tableau) {
		this.tableau = tableau;
	}
	
	/********** Methodes pour la gestion de l'affichage ************/
	public abstract int getRowCount();

	public abstract int getColumnCount();

	public abstract Object getValueAt(int rowIndex, int columnIndex);
}
