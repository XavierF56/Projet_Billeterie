package Interface;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.swing.table.AbstractTableModel;

import Modele.Billeterie;
import Modele.Personne;

public class TablePersonnes extends AbstractTableModel {
    private Map<Integer, Personne> donnees = new HashMap<Integer, Personne>();
    private List<String> nomColonnes;
    private List<Integer> listId;
    private Billeterie billeterie;
 
    public TablePersonnes(Billeterie billeterie) {
        super();
        
        this.billeterie = billeterie;
        donnees = billeterie.getListePersonnes().getListe();
        setDonnees(donnees);
    }
    
	public List<Integer> getListId() {
		List<Integer> res = new ArrayList<Integer>();
		Set set = donnees.keySet();
		java.util.Iterator it = set.iterator();
		while (it.hasNext()) {
			res.add((Integer) it.next());
		}
		return res;
	}
 
    public int getRowCount() {
    	return donnees.size();
    }
 
    public int getColumnCount() {
    	return nomColonnes.size();
    }
 
    public String getColumnName(int columnIndex) {
    	return nomColonnes.get(columnIndex);
    }
 
    public Object getValueAt(int rowIndex, int columnIndex) {
    	return donnees.get(listId.get(rowIndex)).getHashMap().get(getColumnName(columnIndex));    	
    }
 
    public void setDonnees (Map<Integer, Personne> infos) {
    	donnees = infos;
    	if (donnees.isEmpty()) {
        	nomColonnes = new ArrayList<String>();
    	} else {
    		nomColonnes = donnees.get(Personne.getProchainId()-1).getNomColonne();
    	}
        listId = getListId();
    }
    
    public void ajouter() {
<<<<<<< HEAD
    	Map<String,Object> map = new HashMap<String,Object>();
		map.put("nom", "Marty");
		map.put("prenom", "Burno");
		
		Personne newPerso = new Personne(map, billeterie, 0);
		donnees = billeterie.getListePersonnes().getListe();
		listId = getListId();
		
		fireTableRowsInserted(getRowCount() -1, getRowCount() -1);
=======
    	//billeterie
>>>>>>> d06fc3db927663d294eba002cf0b74f0bdab6ff1
    }
}
