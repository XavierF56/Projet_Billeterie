package Test;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import Modele.Billet;
import Modele.Billeterie;
import Modele.Personne;

public class TestListePersonnes {
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
	public void testListePersonnes() {
		//OK
	}

	@Test
	public void testMetEnMemoire() {
		//OK
	}

	@Test
	public void testRecherche() {
		setUp();
		Map<Integer, Personne> listePersonnes = bill.getListePersonnes().recherche("stark");
		
		try {
			assertTrue(bill.getListePersonnes().getPersonne(6).equals(listePersonnes.get(6)));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testAjoutPersonne() {
		setUp();
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("nom", "Le Loup");
		map.put("prenom", "Pierre");
		Personne newPerso = new Personne(map, bill, 0);
		try {
			assertTrue(bill.getListePersonnes().getPersonne(Personne.getProchainId()-1).equals(newPerso));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testGetPersonne() {
		//OK
	}

}
