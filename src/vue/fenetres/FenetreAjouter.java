package vue.fenetres;

import general.Langue;

import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;

import modele.ListeBillets;
import modele.ListeObjet;
import vue.outils.Champs;
import controleur.basique.ValiderAjouterAction;
import controleur.modifier.TypeBilletListener;

@SuppressWarnings("serial")
public class FenetreAjouter extends Fenetre {
	
	private Champs champs;
	ListeObjet listeObjet;
	String titre;

	
	/** Fenetre permettant l'ajout d'un billet ou d'une personne
	 * Si la listeObjet est une ListeBillet elle ajout un champ de selection Billet sub/Billet normal.
	 * Par défaut cela créé un billet subventionne.
	 * @param listeObjet la liste des billets ou des personnes
	 * @param titre le titre de la fenetre
	 * @see Fenetre
	 */
	public FenetreAjouter(ListeObjet listeObjet, String titre) {
		this.listeObjet = listeObjet;
		this.titre = titre;
		
		//Fenetre
		this.setTitle(titre);
		JPanel contentPane = new JPanel(new BorderLayout());
		contentPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 5, 10));
		this.add(contentPane);
		
		if (listeObjet instanceof ListeBillets) {//Champs de selection billet normal ou subventionne
			JPanel north = new JPanel();
			JComboBox<String> jcb = new JComboBox<String>();
			jcb.addItem(Langue.getTraduction("ticket_subsidized"));
			jcb.addItem(Langue.getTraduction("ticket_normal"));
			north.add(jcb);
			north.add(new JButton(new TypeBilletListener(this, jcb)));
			contentPane.add(north, "North");
		}
		
		//Champs
		champs = new Champs(listeObjet.getAttributs());

		contentPane.add(champs, "Center");
		ValiderAjouterAction listener = new ValiderAjouterAction(this, listeObjet, true);
		champs.ajouterListener(listener);
		
		//Bouton Valider
		JButton button = new JButton(listener);
		JPanel panelSouth = new JPanel();
		panelSouth.add(button);
		contentPane.add(panelSouth, "South");
		
		this.afficherDialog();
	}
	
	/** Fenetre permettant l'ajout d'un billet ou d'une personne
	 * Si la listeObjet est une ListeBillet elle ajout un champ de selection Billet sub/Billet normal.
	 * Ce constructeur permet de creer une fenetre de creation pour un billet 
	 * -> subventionne si sub = true
	 * -> normal si sub = false
	 * @param listeObjet la liste des billets ou des personnes
	 * @param titre le titre de la fenetre
	 * @see Fenetre
	 */
	public FenetreAjouter(ListeObjet listeObjet, String titre, boolean sub) {
		this.listeObjet = listeObjet;
		this.titre = titre;
		
		//Fenetre
		this.setTitle(titre);
		JPanel contentPane = new JPanel(new BorderLayout());
		contentPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 5, 10));
		this.add(contentPane);
		
		// Choix billet normal ou sub
		JPanel north = new JPanel();
		JComboBox<String> jcb = new JComboBox<String>();
		jcb.addItem(Langue.getTraduction("ticket_subsidized"));
		jcb.addItem(Langue.getTraduction("ticket_normal"));
		north.add(jcb);
		north.add(new JButton(new TypeBilletListener(this, jcb)));
		contentPane.add(north, "North");

		
		//Champs
		if (sub) {
			champs = new Champs(listeObjet.getAttributs());
			jcb.setSelectedIndex(0);
		} else  {
			champs = new Champs(listeObjet.getAttributsRed());
			jcb.setSelectedIndex(1);
		}

		contentPane.add(champs, "Center");
		ValiderAjouterAction listener = new ValiderAjouterAction(this, listeObjet, sub);
		champs.ajouterListener(listener);
		
		//Bouton Valider
		JButton button = new JButton(listener);
		JPanel panelSouth = new JPanel();
		panelSouth.add(button);
		contentPane.add(panelSouth, "South");
		
		this.afficherDialog();
	}

	public Champs getChamps() {
		return champs;
	}
	public ListeObjet getListeObjet() {
		return listeObjet;
	}
	public String getTitre() {
		return titre;
	}
}