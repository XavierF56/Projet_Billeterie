package Modele;

import java.util.Map;

public class Commande {
	private Personne personne;
	int nbArticle;
	int prixTotal;
	
	/* Un achat peut soit avoir un prix reduit soit non et pas les deux !
	 * lors d'une commande, on peut ajouter un billet a la commande(ajoutCommande()), 
	 * si la personne a depasse son quota de billet, on balance une exception
	 * il faut alors valider (valide()) ou annuler si on ne veut pas valider
	 */
	
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
	public void faireAchat(Billet billet, Map<String,Object> map, boolean forcer) throws AchatException {
		
	}
	
	
	/**
	 * Cloture la commande en ajoutant dans listeAchats de la Persone et dans la bdd les achats realises 
	 */
	public void cloturer() {
		
	}
	
	
	/**
	 * Verifie si cette personne peut profiter d un prix reduit
	 * @return
	 */
	public boolean prixReduit(Billet bill, int qt) {
		return true;
	}
}
