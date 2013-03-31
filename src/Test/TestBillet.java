package Test;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import Modele.Billet;
import Modele.Billeterie;
import Modele.Commande;
import Modele.Personne;

public class TestBillet {
	Billeterie bill;
	Billet billet, billet1, billet2;
	protected void setUp() {
		bill = new Billeterie("database.sqlite");

		try {
			billet = bill.getListeBillets().getBillet(100);
			billet1 = bill.getListeBillets().getBillet(100);
			billet2 = bill.getListeBillets().getBillet(101);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
 	@Test
	public void testModifieQt() {
 		setUp();
 		int sub = billet.getNbPlaceSub();
 		int nonSub = billet.getNbPlace();
 		billet.modifieQt(4, true);
 		assertEquals(sub + 4, billet.getNbPlaceSub());
 		billet.modifieQt(6, false);
 		assertEquals(sub + 4, billet.getNbPlaceSub());
 		assertEquals(nonSub + 10, billet.getNbPlace());
 		
 		billet.modifieQt(-100000, false);
 		assertEquals(0, billet.getNbPlaceSub());
 		assertEquals(0, billet.getNbPlace());
 		
 		billet.modifieQt(500, false);
 		billet.modifieQt(200, true);
 		assertEquals(200, billet.getNbPlaceSub());
 		assertEquals(700, billet.getNbPlace());
	}

	@Test
	public void testGetPrixRed() {
		setUp();
		assertEquals(4, billet.getPrixRed(), 0);
	}

	@Test
	public void testGetPrixNor() {
		setUp();
		assertEquals(5, billet.getPrixNor(), 0);
	}

	@Test
	public void testBillet() {
		setUp();
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("id", Billet.getProchainId());
		map.put("categorie", "Musique");
		map.put("prix", 5.0);
		map.put("prix_sub", 4.0);
		map.put("sous_categorie", "jeune");
		map.put("nb_sub_par_personne", 5);
		map.put("nb_total", 500);
		map.put("nb_sub", 200);
		Billet newBill = new Billet(map, bill, 0);
 		assertEquals(200, billet.getNbPlaceSub());
 		assertEquals(700, billet.getNbPlace());
	}


	@Test
	public void testGetId() {
		setUp();
		assertEquals(100, billet.getId());
	}

	@Test
	public void testEqual() {
		setUp();
		assertTrue(billet.equals(billet1));
		assertFalse(billet.equals(billet2));
	}
}
