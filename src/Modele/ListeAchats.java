package Modele;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ListeAchats {
	List<Achat> listeAchats = new ArrayList<Achat>();
	Personne personne;
	
	public ListeAchats(Personne perso) {
		this.personne = perso;
	}
	
	public void metEnMemoire() {
		try {
			String query = "SELECT * from purchase WHERE id=" + personne.getId(); //NOM BDD
			List<Map<String, Object>> list = personne.getBilleterie().getBdd().query(query); 
			for (int i = 0; i < list.size(); i++){
				listeAchats.add(new Achat(list.get(i), this));
			}
		} catch (SQLException e){
			e.printStackTrace();
		}
	}
}
