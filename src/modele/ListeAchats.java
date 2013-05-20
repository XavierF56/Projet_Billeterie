package modele;


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
		attributs();
	}
	
	
	/********** Methodes ************/
	/**
	 * Met en memoire liste)Achats a partir de la BDD
	 */
	public void metEnMemoire() {
		personne.getBilleterie().getListeBillets().reinitialise();
		String query = "SELECT * from achat WHERE id_personne=" + personne.getId(); //NOM BDD
		List<Map<String, Object>> list = personne.getBilleterie().getBdd().getObjets(query); 
		for (int i = 0; i < list.size(); i++){
			listeObjet.add(new Achat(list.get(i), personne));
			nbAchats++;
		}
		sauvegarde();
	}
	
	/**
	 * Cette methode permet de récuperer la liste des attributs pour l'objet Achat
	 */
	private void attributs() {
		this.attributs = billeterie.getAchatsGeneral().getAttributsAchats();
	}
	
	/**
	 * Ajoute un achat a la listeAchats
	 * @param achat
	 */
	public void ajouter(Achat achat) {
		reinitialise();
		listeObjet.add(achat);
		nbAchats++;
		sauvegarde();
	}
	
	/** Methodes non implementees */
	public void ajouter(Map<String, Object> map) {}
	public void recherche(String chaine) {}
	
	/********** Getters & Setters ************/
	public List<Objet> getListeAchats() {
		return listeObjet;
	}
	public int getNbAchats() {
		return nbAchats;
	}
	public String toString() {
		return listeObjet.toString();
	}
}