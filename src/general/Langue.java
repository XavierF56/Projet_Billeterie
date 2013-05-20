package general;

import java.awt.Component;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JComboBox;

public class Langue {
	public final static int FRANCAIS = 100;
	public final static int ENGLISH = 101;
	
	public static int currentLangage = FRANCAIS;
	
	public static String titreOngletPersonne = "";
	public static String titreOngletBillet = "";
	public static String titreOngletAPropos = "";
	public static String annuler = "";
	public static String erreurAchat = "";
	public static String cloturerCommande = "";
	public static String rechercher = "";
	public static String ajouter ="";
	public static String commanderBillet = "";
	public static String personneSelectionne = "";
	public static String selectionVide = "";
	public static String details ="";
	public static String modifier ="";
	public static String ajouterPanier ="";
	public static String supprimer = "";
	
	/* Initialises en anglais */
	public static String erreurInattendue = "Caution, an unexpected error occurred :\n";
	public static String erreur = "Error";
	public static String avertissement = "Warning";
	
	public static Locale locale;
	public static ResourceBundle res;
	
	public static void langueInit() throws Exception{
		try {
			locale = Locale.getDefault();
			res = ResourceBundle.getBundle("Messages", locale);
		} catch (Exception e) {
			/* Cas ou la langue habituelle de l'utilisateur n'est pas geree */
			locale = new Locale("en", "US");
			System.out.println(locale);
			res = ResourceBundle.getBundle("Messages", locale);
			
		}
		majLangue();
	}
	
	public static String getTraduction(String traduction){
		return res.getString(traduction);
	}
	
	
	public static void majLangue() {
		switch(currentLangage) {
		case FRANCAIS:
			titreOngletPersonne = "Personnes";
			titreOngletBillet = "Billets";
			titreOngletAPropos = "A propos de " + Constantes.nomLogiciel;
			annuler = "Annuler";
			erreurAchat = "Une erreur s'est produite lors de votre achat\nLa commande a été annulée";
			cloturerCommande = "Cloturer la commande";
			rechercher = "Rechercher";
			ajouter = "Ajouter";
			commanderBillet = "Commander Billet";
			personneSelectionne = "Vous n'avez sélectionnée personne";
			selectionVide = "La selection est vide";
			details = "Details";
			modifier = "Modifier";
			ajouterPanier = "Ajouter au panier";
			supprimer = "Supprimer";
			
			erreurInattendue = "Attention, une erreur inattendue s'est produite :\n";
			erreur = "Erreur";
			avertissement = "Attention";
			
			break;
			
		case ENGLISH:
			titreOngletPersonne = "Persons";
			titreOngletBillet = "Tickets";
			titreOngletAPropos = "About " + Constantes.nomLogiciel;
			annuler = "Cancel";
			erreurAchat = "An error has occurred while processing your purchase\nThe order was canceled";
			cloturerCommande = "Close ordering";
			rechercher = "Search";
			ajouter = "Add";
			commanderBillet = "Order Ticket";
			personneSelectionne = "You have not selected person";
			selectionVide = "The selection is empty";
			details = "Details";
			modifier = "Modify";
			ajouterPanier = "Add to shopping";
			supprimer = "Delete";
			
			erreurInattendue = "Caution, an unexpected error occurred :\n";
			erreur = "Error";
			avertissement = "Warning";
			break;
			
		default:
			Constantes.afficherException(new Exception("Langage non reconnu"));
			break;
		}
	}
	
	
	
	public static String aPropos() {
		String text = " \n \n";
		switch(currentLangage) {
		case FRANCAIS:	
			text += "Version du logiciel : "+ Constantes.versionLogiciel +"\n \n" +
					"Auteurs :\n";
			break;
		case ENGLISH:
			text += "Software versus : "+ Constantes.versionLogiciel +"\n \n" +
					"Authors :\n";
			break;
		default:
			Constantes.afficherException(new Exception("Langage non reconnu"));
			break;
		}		
		text +=	"Raphael Baron - raphael.baron@insa-rennes.fr\n" +
				"Xavier Fraboulet - xavier.fraboulet@insa-rennes.fr\n" +
				"Bruno Matry - bruno.matry@insa-rennes.fr\n" +
				"Paul-Mehdy M’Rabet - paul-mehdy.mrabet@insa-rennes.fr";
		return text;
	}

	public static String erreurAffichageIcone() {
		String res = erreur + " - ";
		return res;
	}

	public static Component choixLangueMenu() {
		JComboBox<String> jcb = new JComboBox<String>();
		jcb.addItem("Francais");
		jcb.addItem("Anglais");
		jcb.addItemListener(new ItemListener(){
			public void itemStateChanged(ItemEvent e) {
				System.out.println("Changement de langue");
				if (e.getItem().equals("Francais")) {
					currentLangage = FRANCAIS;
					System.out.println("fr");
				} else if (e.getItem().equals("Anglais")) {
					currentLangage = ENGLISH;
					System.out.println("eng");
				}
				majLangue();
				System.out.println("maj");
			}
		});
		return jcb;
	}
}
