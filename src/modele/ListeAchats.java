package modele;

import general.Constantes;

import java.util.List;
import java.util.Map;

public class ListeAchats extends ListeObjet{
	private static final long serialVersionUID = 1L;
	private Personne personne;
	private int nbAchats;
	
	
	/********** Constructeur ************/
	public ListeAchats(Personne perso) {
		super(perso.getBilleterie());
		this.personne = perso;
		attributsType = billeterie.getBdd().getAttributs("Achat");
		attributs = Constantes.mapVersList(attributsType);
		metEnMemoire();
	}
	
	
	/********** Methodes ************/
	/**
	 * Met en memoire listeAchats a partir de la BDD
	 */
	public void metEnMemoire() {
		String query = "SELECT * from achat WHERE id_personne=" + personne.getId(); //NOM BDD
		List<Map<String, Object>> list = personne.getBilleterie().getBdd().getObjets(query); 
		System.out.println(">>>>>>>>>"+list);
		for (int i = 0; i < list.size(); i++){
			listeObjet.add(new Achat(list.get(i), personne));
			nbAchats++;
		}
		System.out.println("ddd<<<<<<"+listeObjet);
		personne.setAchatEnMem(true);
		sauvegarde();
	}
	
	/**
	 * Ajoute un achat a la listeAchats
	 * @param achat
	 */
	public void ajouter(Achat achat) {
		if(!personne.isAchatEnMem()) {
			metEnMemoire();
		}
		listeObjet.add(achat);
		nbAchats++;
	}
	
	public void ajouter(Map<String, Object> map) {
		// Not Implemented
	}

	public void recherche(String chaine) {
		// Not Implemented
	}
	
	/********** Methodes de base ************/
	public List<Objet> getListeAchats() {
		if(!personne.isAchatEnMem()) {
			metEnMemoire();
		}
		return listeObjet;
	}
	public int getNbAchats() {
		return nbAchats;
	}
	public String toString() {
		return listeObjet.toString();
	}

	/********** Methodes pour la gestion de l'affichage ************/
	public int getRowCount() {
		System.out.println(">"+listeObjet.size());
    	return listeObjet.size();
    }
    public int getColumnCount() {
    	System.out.println(">"+getAttributs().size());
    	return getAttributs().size();
    }
    public String getColumnName(int columnIndex) {
    	return getAttributs().get(columnIndex);
    }
    public Object getValueAt(int rowIndex, int columnIndex) {
    	System.out.println(">"+listeObjet.get(rowIndex).getHashMap().get(getColumnName(columnIndex)));
    	return listeObjet.get(rowIndex).getHashMap().get(getColumnName(columnIndex));    	
    }
}
