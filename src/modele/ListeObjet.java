package modele;


import general.Constantes;
import general.Langue;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

@SuppressWarnings("serial")
public abstract class ListeObjet extends AbstractTableModel{

	protected Billetterie billeterie;	
	protected List<Objet> listeObjet = new ArrayList<Objet>();
	protected List<Objet> listeObjetSauvegarde = new ArrayList<Objet>();
	protected JTable tableau;
	protected List<Attribut> attributs = new ArrayList<Attribut>();
	protected String table;

	
	/**
	 * Constructeur
	 * @param billeterie
	 */
	public ListeObjet(Billetterie billeterie) {
		this.billeterie = billeterie;
	}
	
	/**
	 * Cette methode permet de mettre en memoire les objets a partir de la bdd
	 */
	public abstract void metEnMemoire();
	
	/**
	 * Ajoute un objet dans la liste
	 * @param objet
	 */
	public abstract void ajouter(Map<String, Object> map, boolean sub);
	
	/**
	 * Renvoie l'ensemble des personnes lies a la recherche
	 * @param chaine a trouver dans les attributs de l'objet
	 * @return la liste des billets
	 */
	public void recherche(String chaine) {
		reinitialise();
		List<Objet> resul= new ArrayList<Objet>();
		
		String query = requete(chaine);
		List<Map<String, Object>> list = billeterie.getBdd().getObjets(query);
		if(!list.isEmpty()) {
			for (int i = 0; i< listeObjet.size(); i++) {
				int Id = listeObjet.get(i).getId();
				boolean stop = false;
				for (int j = 0; j < list.size() && !stop; j++) {
					if (Id == (Integer)list.get(j).get("id")) {
						resul.add(listeObjet.get(i));
						stop = true;
					}
				}
			}
			listeObjet = resul;
		}
		fireTableDataChanged();
	}
	
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
	 * @param index
	 * @return L'objet situe a l'index index
	 * @throws Exception 
	 */
	public Objet getObjetByIndex(int index) throws Exception{
		Objet objet = null;
		objet = listeObjet.get(index);
		if (objet == null){
			throw new Exception(Langue.getTraduction("object_index") + " " + index
					+ " " + Langue.getTraduction("non_existent"));
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
			throw new Exception(Langue.getTraduction("object_id") + " " + id
					+ " " + Langue.getTraduction("non_existent"));
		}
		return objet;
	}
	
	
	/********** Methodes privees ************/
	/**
	 * Cette methode permet de sauvegarder la liste des billets
	 * Par exemple lorsque l'on fait une recherche, listeBillets sera remplacee
	 * par une liste de billets trouves.
	 */
	protected void sauvegarde() {
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
	 * @param chaine provenant de la recherche
	 * @return la chaine qui permet de realiser la requete pour la recherche
	 */
	private String requete (String chaine) {
		String retour = "SELECT id FROM " + table + " WHERE ";
		boolean premier = true;
		List<Attribut> list = getAttributs();
		String[] st = chaine.split("\\s+");
		
		for (int j = 0; j < st.length; j++) {
			for (int i = 0; i < list.size() ; i++) {
				if(list.get(i).getType() == Constantes.STRING) {
					String aAjouter = list.get(i).getNomBDD() + " Like '"+st[j]+"%' ";
					if(!premier) {
						retour = retour.concat(" OR ");
					}
					retour = retour.concat(aAjouter);
					premier = false;
				}
			}
		}
		return retour;
	}
	
	
	/********** Methodes pour la gestion de l'affichage ************/
	public int getRowCount() {
    	return listeObjet.size();
    }
    public int getColumnCount() {
    	return getAttributs().size();
    }
    public String getColumnName(int columnIndex) {
    	return attributs.get(columnIndex).getNomInterface();
    }
    public Object getValueAt(int rowIndex, int columnIndex) {
    	return listeObjet.get(rowIndex).getHashMap().get(attributs.get(columnIndex).getNomBDD());    	
    }
    
	/********** getters & Setters ************/
	public Billetterie getBilleterie() {
		return billeterie;
	}
	public List<Attribut> getAttributs() {
		return attributs;
	}
	public JTable getTableau() {
		return tableau;
	}
	public void setTableau(JTable tableau) {
		this.tableau = tableau;
	}
	public String toString () {
		return listeObjet.toString();
	}
	public List<Objet> getListeObjet() {
		reinitialise();
		return listeObjet;
	}
	public List<Attribut> getAttributsRed() {
		return null;
	}
}
