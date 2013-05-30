package vue.fenetres;

import general.Langue;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.text.MaskFormatter;

import modele.Billetterie;
import controleur.option.ModifierDateAction;

@SuppressWarnings("serial")
public class OngletStats extends JPanel {
	
	private Billetterie billeterie;
	private GridBagConstraints gridBagConstraints;
	private JLabel totalArticles;
	private JLabel moisArticles;
	private JLabel totalPrix;
	private JLabel moisPrix;
	private JLabel intituleMois;
	
	private int y;
	
	/**
	 * Cette classe permet la gestion de l'affichage de l'onglet Statistiques dans la fenêtre Principale.
	 * 
	 * @param billeterie la billeterie en cours
	 */
	public OngletStats(Billetterie billeterie) {
		super();
		this.billeterie = billeterie;
		createLabel();
		y = 0;
		
		gridBagConstraints = new GridBagConstraints();
		this.setLayout(new GridBagLayout());
		
		label(Langue.getTraduction("statistics_generals") + "        ", 0, 0);
		
		label(Langue.getTraduction("recipe") + " : ", 0, 1);
		label(totalPrix);
		
		label(Langue.getTraduction("orders_fulfilled") + " :         ", 0, 1);
		label(totalArticles);
		
		ligneBlanche();
		ligneBlanche();
		
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = y;
		add(intituleMois, gridBagConstraints);
		
		modifierDate();
		
		label(Langue.getTraduction("recipe") + " : ", 0, 1);
		label(moisPrix);
		
		label(Langue.getTraduction("orders_fulfilled") + " :         ", 0, 1);
		label(moisArticles);
		
		ligneBlanche();
		ligneBlanche();
		
		
	}
	
	private void modifierDate() {
		MaskFormatter formatter = null;
        try {
            formatter = new MaskFormatter("##/##/####");
        } catch (java.text.ParseException exc) {
        	exc.printStackTrace();
        }
        JFormattedTextField field = new JFormattedTextField(formatter);
        ModifierDateAction listener = new ModifierDateAction(billeterie, field);

		field.setText(billeterie.getAchatsGeneral().getDate());
		field.addKeyListener(listener);
		gridBagConstraints.gridx = 1;
		add(field, gridBagConstraints);
		
		gridBagConstraints.gridx = 2;
		add(new JButton(listener), gridBagConstraints);
		y++;
	}
	
	private void ligneBlanche() {
		gridBagConstraints.gridy = y;
		add(new JLabel(" "), gridBagConstraints);
		y++;
	}
	
	private void label(String string, int dy, int x) {
		gridBagConstraints.gridx = x;
		gridBagConstraints.gridy = y;
		gridBagConstraints.anchor = GridBagConstraints.LINE_START;
		add(new JLabel(string), gridBagConstraints);
		y += dy;
	}
	
	private void label(JLabel jLabel) {
		gridBagConstraints.gridx = 2;
		gridBagConstraints.gridy = y;
		gridBagConstraints.anchor = GridBagConstraints.LINE_START;
		add(jLabel, gridBagConstraints);
		y++;
	}
	
	/**
	 * Permet la mise à jour des labels
	 */
	public void majLabel() {
		intituleMois.setText(Langue.getTraduction("statistics_since"));
		totalArticles.setText(billeterie.getAchatsGeneral().getTotalArticles() + "");
		moisArticles.setText(billeterie.getAchatsGeneral().getMoisArticle() + "");
		totalPrix.setText(billeterie.getAchatsGeneral().getTotalPrix() + " euros");
		moisPrix.setText(billeterie.getAchatsGeneral().getMoisPrix() + " euros");
	}
	
	private void createLabel() {
		intituleMois = new JLabel(Langue.getTraduction("statistics_since"));
		totalArticles = new JLabel(billeterie.getAchatsGeneral().getTotalArticles() + "");
		moisArticles = new JLabel(billeterie.getAchatsGeneral().getMoisArticle() + "");
		totalPrix = new JLabel(billeterie.getAchatsGeneral().getTotalPrix() + " euros");
		moisPrix = new JLabel(billeterie.getAchatsGeneral().getMoisPrix() + " euros");
	}
}
