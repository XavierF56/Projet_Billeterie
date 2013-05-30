package modele;

import general.Langue;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Cette class permet la gestion des commandes.
 * Elle permet d'ajouter des achats a la listeAchats d'une personne passe en prametre.
 * @author xavier
 */

public class Commande {
	private Personne personne;
	private int nbArticle;
	private double prixTotal;
	private List<Achat> listeValidee = new ArrayList<Achat>();
	
	private Billet billet;
	private int qt;
	private int qt_acceptable;
	private boolean donne;
	private boolean paye;
	private boolean subventionne;
	
	
	public Commande(Personne personne) {
		this.personne = personne;
		this.nbArticle = 0;
		this.prixTotal = 0;
		
		
	}
	
	/********** Methodes ************/
	/**
	 * Realise un achat si cela est possible
	 * @param billet
	 * @param qt
	 * @param paye
	 * @param donne
	 * @param subventionne
	 * @throws AchatException 
	 */
	public void ajoutCommande(Billet billet, int qt, boolean paye, boolean donne, boolean subventionne) throws AchatException {
		this.billet = billet;
		this.qt = qt;
		this.paye = paye;
		this.donne = donne;
		this.subventionne = subventionne;
		if (this.achatPossible()) {
			valider();
		}
	}
	
	/**
	 * Cette methode cree un nouvel achat et l'ajoute a la listeAchats de la 
	 * personne associe a cet commande.
	 * @param billet
	 * @param qt
	 * @param paye
	 * @param donne
	 * @param subventionne
	 */
	private void creer(Billet billet, int qt, boolean paye, boolean donne, boolean subventionne) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("quantite", qt);
		map.put("paye", paye);
		map.put("donne", donne);
		map.put("subventionne", subventionne);
		
		Date maDateAvecFormat=new Date();
		SimpleDateFormat dateStandard = new SimpleDateFormat("dd/MM/yyyy-HH-mm");
		map.put("date", dateStandard.format(maDateAvecFormat));
		
		if (subventionne) {
			map.put("prix_unitaire", billet.getPrixRed());
			map.put("prix_total", billet.getPrixRed() * qt);
		} else {
			map.put("prix_unitaire", billet.getPrixNor());
			map.put("prix_total", billet.getPrixNor() * qt);
		}
		Achat achatEnCours = new Achat(map, personne, billet);
		listeValidee.add(achatEnCours);
		prixTotal += achatEnCours.getPrixTotal();
		nbArticle++;
	}
	
	
	
	/**
	 * Cette methode valide l'achat d'un billet et l'ajoute à la listeAchats d'une personne
	 */
	public void valider() {
		this.creer(billet, qt, paye, donne, subventionne);		
	}
	
	/**
	 * Si le message d'erreur quota depasse est lance par la commande ajoutCommande.
	 * Cette methode permet d'acheter le nombre de billet subventionne autorise
	 * et de completer avec des billets non subventionne.
	 */
	public void completer() {
		if(qt_acceptable > 0)
			this.creer(billet, qt_acceptable, paye, donne, subventionne);
		if(qt_acceptable < 0)
			qt_acceptable = 0;
		this.creer(billet, qt-qt_acceptable, paye, donne, false);
	}
	
	/**
	 * Cette methode annule un achat
	 */
	public void annuler() {
		//Rien a faire pour l'instant
	}
	
	/**
	 * Vide la listeValidee :  clorture une commande
	 */
	public void cloturer() {
		listeValidee.clear();
	}
	
	/**
	 * Verifie si un achat est possible
	 * Si ce n'est pas possible, cette methode envoie des exceptions
	 * @param billet
	 * @param qt
	 * @param subventionne
	 * @return
	 * @throws AchatException
	 */
	public boolean achatPossible() throws AchatException{
		if (billet.getNbPlace() >= qt) {
			if(subventionne) {
				if (billet.getNbPlaceSub() >= qt) {
					qt_acceptable = billet.getNbPlacePerso() - personne.getNbBilletsAcheteSub(billet);
					if (qt_acceptable >= qt) {
						qt_acceptable = qt;
					} else {
						throw new AchatException(0);
					}
				} else {
					throw new AchatException(2);
				}
			}
		} else {
			throw new AchatException(1);
		}
		return true;
	}
	
	
	/********** Getters & Setters ************/
	public int getNbArticle() {
		return nbArticle;
	}
	public double getPrixTotal() {
		return prixTotal;
	}
	public String toString() {
		return Langue.getTraduction("shopping") + " : " + nbArticle + " " + 
				Langue.getTraduction("articles") + " | " + prixTotal + " euros";
	}
}
