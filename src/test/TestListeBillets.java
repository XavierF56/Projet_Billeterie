package test;

import java.util.HashMap;
import java.util.Map;

import junit.framework.TestCase;

import modele.Billet;
import modele.Billeterie;


public class TestListeBillets extends TestCase {
	
	Billeterie bill;
	Billet billet, billet1, billet2;
	protected void setUp() {
		bill = new Billeterie("database.sqlite");

		try {
			billet = (Billet) bill.getListeBillets().getObjetById(100);
			billet1 = (Billet) bill.getListeBillets().getObjetById(100);
			billet2 = (Billet) bill.getListeBillets().getObjetById(101);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	public void testListeBillets() {
		//OK
	}

	public void testMetEnMemoire() {
		//OK
	}

	public void testRecherche() {
		//OK
	}

	public void testAjoutBillet() {
		//OK
	}

}
