package modele;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

public class ListeObjet extends AbstractTableModel{
	private static final long serialVersionUID = 1L;
	protected Billeterie billeterie;	
	protected List<ObjetB> listeObjet = new ArrayList<ObjetB>();
	protected List<ObjetB> listeObjetSauvegarde = new ArrayList<ObjetB>();
	protected JTable tableau;
	protected Map<String, Integer> attributsType;
	protected List<String> attributs = new ArrayList<String>();


	
	public ListeObjet(Billeterie billeterie) {
		this.billeterie = billeterie;
		listeObjet = new ArrayList<ObjetB>();
		this.metEnMemoire(); 
	}
	
	public void metEnMemoire() {
	}
	
	/**
	 * Ajoute un billet dans la liste
	 * @param billet
	 */
	public void ajouter(Map<String, Object> map) {
	}
	
	/**
	 * Supprime un billet dans la liste
	 * @param objet
	 */
	public void supprimer(ObjetB objet) {
		listeObjet.remove(objet);
		listeObjetSauvegarde.remove(objet);
		fireTableDataChanged();
	}
	
	/**
	 * Lors de la modification d'une personne, il faut mettre a jour le modele de donnees
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
		List<ObjetB> list = new ArrayList<ObjetB>();
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
	 * Renvoie l'ensemble des billets lies a la recherche
	 * @param chaine la chaine a trouver dans le billet
	 * @return la liste des billets
	 */
	public void recherche(String chaine) {
	}
	
	public int getId(ObjetB objet) {
		int res = -1;
		for (int i = 0; i < listeObjet.size(); i++) {
			if (listeObjet.get(i).equals(objet)) {
				res = i;
				i = listeObjet.size();
			}
		}
		return res;
	}
	
	public ObjetB getObjetByIndex(int i){
		return listeObjet.get(i);
	}
	
	public ObjetB getObjetById(int id) throws Exception {
		ObjetB objet = null;
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
	
	/********** Methodes pour la gestion de l'affichage ************/
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	public JTable getTableau() {
		return tableau;
	}
	
	public void setTableau(JTable tableau) {
		this.tableau = tableau;
	}
}
