package test;

import junit.framework.TestCase;

import modele.Billet;
import modele.Billetterie;


public class TestListeBillets extends TestCase {
	
	Billetterie bill;
	Billet billet, billet1, billet2;
	protected void setUp() {
		bill = new Billetterie("database.sqlite");

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
