package test;

import junit.framework.TestCase;
import modele.AchatException;
import modele.Billet;
import modele.Billetterie;
import modele.Commande;
import modele.Personne;



public class TestCommande extends TestCase {
	Billetterie bill;
	Personne personne;
	Commande com;
	Billet billet1, billet2, billet3;
	protected void setUp() {
		bill = new Billetterie("database.sqlite");

		try {
			personne = (Personne) bill.getListePersonnes().getObjetById(3);
			billet1 = (Billet) bill.getListeBillets().getObjetById(100);
			billet2 = (Billet) bill.getListeBillets().getObjetById(101);
			billet3 = (Billet) bill.getListeBillets().getObjetById(102);
			com = new Commande(personne);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}


	public void testAjoutCommande() {
		setUp();
		try {
			System.out.println(billet1);
			int nbBillet = billet1.getNbPlace();
			int nbBilletSub = billet1.getNbPlaceSub();
			int nb = personne.getNbBilletsAchete(billet1);
			com.ajoutCommande(billet1, 5, true, true, true);
			assertEquals(nb+5, personne.getNbBilletsAchete(billet1));
			assertEquals(nbBillet - 5, billet1.getNbPlace());
			assertEquals(nbBilletSub - 5, billet1.getNbPlaceSub());
		} catch (AchatException e) {
			com.valider();
		}
	}

	public void testValider() {
		setUp();
		int nb = personne.getNbBilletsAchete(billet1);
		try {
			com.ajoutCommande(billet1, billet1.getNbPlacePerso(), true, true, true);
		} catch (AchatException e) {
			com.valider();
		}
		assertEquals(nb+billet1.getNbPlacePerso(), personne.getNbBilletsAchete(billet1));

	}
}
