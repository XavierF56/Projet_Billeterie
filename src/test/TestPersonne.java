package test;

import java.util.HashMap;
import java.util.Map;

import junit.framework.TestCase;

import modele.Billet;
import modele.Billetterie;
import modele.Personne;



public class TestPersonne extends TestCase {
	Billetterie bill;
	Personne personne1, personne2, personne3;
	protected void setUp() {
		bill = new Billetterie("database.sqlite");

		try {
			personne1 = (Personne) bill.getListePersonnes().getObjetById(3);
			personne2 = (Personne) bill.getListePersonnes().getObjetById(4);
			personne3 = (Personne) bill.getListePersonnes().getObjetById(5);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}

	public void testModifie() {
		setUp();
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("nom", "Loup");
		map.put("prenom", "Jean");
		
		Personne modif;
		try {
			modif = (Personne) bill.getListePersonnes().getObjetById(1);
			modif.modifie(map);
			assertEquals("Loup", modif.getNom());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void testNbBilletsAchete() {
		setUp();
		try {
			Personne perso = (Personne) bill.getListePersonnes().getObjetById(1);
			assertEquals(20, perso.getNbBilletsAchete((Billet) bill.getListeBillets().getObjetById(101)));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void testRestantAPayer() {
		setUp();
		Personne perso;
		try {
			perso = (Personne) bill.getListePersonnes().getObjetById(1);
			assertEquals(40, perso.getRestantAPayer(),0);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
