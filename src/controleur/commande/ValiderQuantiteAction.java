package controleur.commande;

import general.Langue;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Map;

import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import vue.fenetres.FenetreCommander;
import vue.fenetres.FenetreCommanderErreur;
import vue.fenetres.FenetreCommandeAjouter;
import vue.outils.Champs;

import modele.AchatException;
import modele.Billet;
import modele.Commande;

@SuppressWarnings("serial")
public class ValiderQuantiteAction extends AbstractAction implements KeyListener {
	
		private FenetreCommandeAjouter fenetre;
		private FenetreCommander fenetreCommande;
		private Billet billet;
		private Commande commande;
		private Champs champs;
		
		/**
		 * Cette classe permet la gestion de la validation d'une quantite de billets par l'utilisteur.
		 * 
		 * @param fenetreCommande la fenetre commande en cours
		 * @param fenetre la fenetre CommandeAjout en cours
		 * @param commande la commande en cours
		 * @param billet le billet a commander
		 * @see FenetreCommander la fenetre
		 * @see FenetreCommandeAjouter
		 * @see Commande
		 * @see Billet
		 */
		public ValiderQuantiteAction(FenetreCommander fenetreCommande, FenetreCommandeAjouter fenetre, Commande commande, Billet billet, Champs champs) {
		    super(Langue.getTraduction("validate"));
		    this.fenetreCommande = fenetreCommande;
		    this.fenetre = fenetre;
		    this.billet = billet;
		    this.commande = commande;
		    this.champs = champs;
		}
		
		/** Methode requise par l'heritage de la classe AbstractAction
	     * 
	     * @see AbstractAction
		 */
		public void actionPerformed(ActionEvent e) {
			validerQuantite();
		}
		
		private void validerQuantite(){
			try {
				Map<String, Object>  map = champs.getDonnees();
				boolean sub;
				if (billet.getSub()) // Si le billet n'est pas subventionne, il n'y a pas de champs sub
					sub = (Boolean) map.get("subventionne");
				else 
					sub = false;
				
				commande.ajoutCommande(billet, (Integer) map.get("quantite"), (Boolean) map.get("paye"), (Boolean) map.get("donne"), sub);
				fenetreCommande.majLabel();
		    	fenetreCommande.getBilleterie().getFenetre().getOngletStats().majLabel();
			} catch (AchatException ae) {
				new FenetreCommanderErreur(commande, ae.toString(), fenetreCommande, ae.getId() == 0);
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(new JFrame(), e1, Langue.getTraduction("error") , JOptionPane.ERROR_MESSAGE);
			}
			fenetre.dispose();
			
		}

		public void keyTyped(KeyEvent e) {
		}

		public void keyPressed(KeyEvent e) {
	        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
		    	validerQuantite();
	        }
		}

		public void keyReleased(KeyEvent e) {
		}
	}