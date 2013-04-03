package Test;

import static org.junit.Assert.*;

import org.junit.Test;

import Modele.AchatException;
import Modele.Billet;
import Modele.Billeterie;
import Modele.Commande;
import Modele.Personne;

public class TestCommande {
	Billeterie bill;
	Personne personne;
	Commande com;
	Billet billet1, billet2, billet3;
	protected void setUp() {
		bill = new Billeterie("database.sqlite");

		try {
			personne = bill.getListePersonnes().getPersonne(3);
			billet1 = bill.getListeBillets().getBillet(100);
			billet2 = bill.getListeBillets().getBillet(101);
			billet3 = bill.getListeBillets().getBillet(102);
			com = new Commande(personne);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}


	@Test
	public void testAjoutCommande() {
		setUp();
		try {
			int nbBillet = billet1.getNbPlace();
			int nbBilletSub = billet1.getNbPlaceSub();
			int nb = personne.nbBilletsAchete(billet1);
			com.ajoutCommande(billet1, 5, true, true, true);
			assertEquals(nb+5, personne.nbBilletsAchete(billet1));
			assertEquals(nbBillet - 5, billet1.getNbPlace());
			assertEquals(nbBilletSub - 5, billet1.getNbPlaceSub());
		} catch (AchatException e) {
			com.valider();
		}
	}

	@Test
	public void testValider() {
		setUp();
		int nb = personne.nbBilletsAchete(billet1);
		try {
			com.ajoutCommande(billet1, billet1.getNbPlacePerso(), true, true, true);
		} catch (AchatException e) {
			com.valider();
			System.out.println("valider");
		}
		assertEquals(nb+billet1.getNbPlacePerso(), personne.nbBilletsAchete(billet1));

	}

	@Test
	public void testAnnuler() {
		setUp();
		int nb = personne.nbBilletsAchete(billet1);
		try {
			com.ajoutCommande(billet1, billet1.getNbPlacePerso(), true, true, true);
		} catch (AchatException e) {
			com.annuler();
			System.out.println("annuler");
		}
		assertEquals(nb, personne.nbBilletsAchete(billet1));
	}
}
