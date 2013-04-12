package test;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import modele.Billet;
import modele.Billeterie;

import org.junit.Test;


public class TestListeBillets {
	
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
	public void testListeBillets() {
		//OK
	}

	@Test
	public void testMetEnMemoire() {
		//OK
	}

	@Test
	public void testRecherche() {
		setUp();
		Map<Integer, Billet> listeBillets = bill.getListeBillets().recherche("cin");
		
		try {
			assertTrue(bill.getListeBillets().getBillet(102).equals(listeBillets.get(102)));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testAjoutBillet() {
		setUp();
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("categorie", "Musique");
		map.put("prix", 5.0);
		map.put("prix_sub", 4.0);
		map.put("sous_categorie", "jeune");
		map.put("nb_sub_par_personne", 5);
		map.put("nb_total", 500);
		map.put("nb_sub", 200);
		Billet newBill = new Billet(map, bill, 0);

		try {
			assertTrue(bill.getListeBillets().getBillet(Billet.getProchainId()-1).equals(newBill));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
