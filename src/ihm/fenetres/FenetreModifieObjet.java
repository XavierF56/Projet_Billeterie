package ihm.fenetres;

import ihm.actions.ValiderAction2;
import ihm.barresOutils.Champs;

import javax.swing.JButton;

import modele.ListeObjet;
import modele.Objet;


@SuppressWarnings("serial")
public class FenetreModifieObjet extends Fenetre {
	private Objet objetTraite;
	private Champs champs;
	private ListeObjet objets;
	
	public FenetreModifieObjet(Objet objetTraite, ListeObjet listeObjet) {
		this.setTitle("Modifier");
		this.objetTraite = objetTraite;
		this.objets = listeObjet;
		
		champs = new Champs(objets.getAttributs());
		champs.setValeurs(objetTraite.getHashMap());
		this.add(champs, "Center");
		this.add(new JButton(new ValiderAction2(this)), "South");
		
		this.afficher();
	}
	
	public Champs getChamps() {
		return champs;
	}
	
	public Objet getObjetTraite() {
		return objetTraite;
	}
	
	public ListeObjet getObjets() {
		return objets;
	}
}