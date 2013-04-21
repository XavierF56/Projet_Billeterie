package test;

import junit.framework.TestCase;

import modele.Billeterie;
import modele.Personne;


public class TestListePersonnes extends TestCase {
	Billeterie bill;
	Personne personne1, personne2, personne3;
	protected void setUp() {
		bill = new Billeterie("database.sqlite");

		try {
			personne1 = (Personne) bill.getListePersonnes().getObjetById(3);
			personne2 = (Personne) bill.getListePersonnes().getObjetById(4);
			personne3 = (Personne) bill.getListePersonnes().getObjetById(5);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	
	public void testListePersonnes() {
		//OK
	}

	public void testMetEnMemoire() {
		//OK
	}

	public void testRecherche() {
		setUp();
		/*Map<Integer, Personne> listePersonnes = bill.getListePersonnes().recherche("stark");
		
		try {
			assertTrue(bill.getListePersonnes().getPersonne(6).equals(listePersonnes.get(6)));
		} catch (Exception e) {
			e.printStackTrace();
		}*/
	}

	public void testAjoutPersonne() {
		//OK
	}

	public void testGetPersonne() {
		//OK
	}

}
