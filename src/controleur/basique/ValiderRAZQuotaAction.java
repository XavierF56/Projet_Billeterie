package controleur.basique;

import general.Langue;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import modele.Billet;
import modele.ListeObjet;
import vue.fenetres.Fenetre;

@SuppressWarnings("serial")
public class ValiderRAZQuotaAction extends AbstractAction {

	private Fenetre fenetre;
	private ListeObjet listeObjet;
	
	/**
	 * Constructeur
	 * @param fenetre
	 * @param listeObjet
	 */
    public ValiderRAZQuotaAction(Fenetre fenetre, ListeObjet listeObjet) {
        super(Langue.getTraduction("validate"));
        this.fenetre = fenetre;
        this.listeObjet = listeObjet;
    }
    
    /**
     * Cette fonction valide l'action
     */
    public void valider() {
    	try {
			 int[] i = listeObjet.getTableau().getSelectedRows();
			 int j = listeObjet.getTableau().getRowSorter().convertRowIndexToModel(i[0]);
			 ((Billet) listeObjet.getObjetByIndex(j)).razQuota();
			 
        	fenetre.dispose();
		} catch (Exception e1) {
			System.out.println(e1);
			JOptionPane.showMessageDialog(new JFrame(), Langue.getTraduction("error_adding"),
					Langue.getTraduction("error"), JOptionPane.ERROR_MESSAGE);
		}
    }
    
    /** Listeners **/
    public void actionPerformed(ActionEvent e) {
		valider();
    }
}