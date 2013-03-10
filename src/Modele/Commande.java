package Modele;

import java.util.Map;

public class Commande {
	private Personne personne;
	private int nbArticle;
	private int prixTotal;
	
	
	public Commande(Personne personne) {
		this.personne = personne;
		this.nbArticle = 0;
		this.prixTotal = 0;
	}
	
	
	
	/**
	 * Realise un achat si cela est possible
	 * @param TODO
	 * @return vrai si l operation a reussie
	 * @throws AchatException 
	 */
	public void ajoutCommande(Billet billet, Map<String,Object> map) throws AchatException {
		
	}
	
	/**
	 * Si le message d'erreur quota depasse est lance par la commande ajoutCommande. 
	 * Une boite de dialogue est affichee pour valider cette action normalement non autorisee
	 * Cette methode valide la derniere commande
	 */
	public void valider() {
		
	}
	
	/**
	 * Si le message d'erreur quota depasse est lance par la commande ajoutCommande. 
	 * Une boite de dialogue est affichee pour valider cette action normalement non autorisee
	 * Cette methode annule la derniere commande en l'enlevant de la liste
	 */
	public void annuler() {
		
	}
	
	/**
	 * Cloture la commande en ajoutant dans listeAchats de la Persone et dans la bdd les achats realises 
	 */
	public void cloturer() {
		
	}
	
	
	
}
