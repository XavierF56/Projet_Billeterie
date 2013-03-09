package Modele;

import java.util.HashMap;
import java.util.Map;

public class Achat {
	private Map<String,Object> map = new HashMap<String,Object>();
	ListeAchats liste;
	
	public Achat(Map<String,Object> map, ListeAchats liste) {
		this.map = map;
		this.liste = liste;
	}
}
