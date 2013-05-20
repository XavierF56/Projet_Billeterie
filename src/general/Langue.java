package general;

public class Langue {
	public final static int FRANCAIS = 100;
	public final static int ENGLISH = 101;
	
	public static int currentLangage = FRANCAIS;
	
	public static String titreOngletPersonne = "";
	public static String titreOngletBillet = "";
	public static String titreOngletAPropos = "";
	public static String annuler = "";
	public static String erreurAchat = "";
	public static String erreur = "";
	public static String cloturerCommande = "";
	
	
	
	public static void majLangue() {
		switch(currentLangage) {
		case FRANCAIS:
			titreOngletPersonne = "Personnes";
			titreOngletBillet = "Billets";
			titreOngletAPropos = "A propos de " + Constantes.nomLogiciel;
			annuler = "Annuler";
			erreurAchat = "Une erreur s'est produite lors de votre achat\nLa commande a été annulée";
			erreur = "Erreur";
			cloturerCommande = "Cloturer la commande";
			break;
		case ENGLISH:
			titreOngletPersonne = "Persons";
			titreOngletBillet = "Tickets";
			titreOngletAPropos = "About " + Constantes.nomLogiciel;
			annuler = "Cancel";
			erreurAchat = "An error has occurred while processing your purchase\nThe order was canceled";
			erreur = "Error";
			cloturerCommande = "Close ordering";
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
}
