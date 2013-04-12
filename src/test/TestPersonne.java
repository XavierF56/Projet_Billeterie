package test;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import modele.Billeterie;
import modele.Personne;

import org.junit.Test;


public class TestPersonne {
	Billeterie bill;
	Personne personne1, personne2, personne3;
	protected void setUp() {
		bill = new Billeterie("database.sqlite");

		try {
			personne1 = bill.getListePersonnes().getPersonne(3);
			personne2 = bill.getListePersonnes().getPersonne(4);
			personne3 = bill.getListePersonnes().getPersonne(5);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	@Test
	public void testPersonne() {
		setUp();
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("nom", "Le Loup");
		map.put("prenom", "Pierre");
		Personne newPerso = new Personne(map, bill, 0);
		Personne init;
		try {
			init = bill.getListePersonnes().getPersonne(Personne.getProchainId()-1);
			assertTrue(newPerso.equals(init));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testModifie() {
		setUp();
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("nom", "Loup");
		map.put("prenom", "Jean");
		
		Personne modif;
		try {
			modif = bill.getListePersonnes().getPersonne(0);
			modif.modifie(map);
			assertEquals("Loup", modif.getNom());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testNbBilletsAchete() {
		setUp();
		try {
			Personne perso = bill.getListePersonnes().getPersonne(1);
			assertEquals(20, perso.nbBilletsAchete(bill.getListeBillets().getBillet(101)));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testRestantAPayer() {
		setUp();
		Personne perso;
		try {
			perso = bill.getListePersonnes().getPersonne(1);
			assertEquals(40, perso.restantAPayer(),0);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
