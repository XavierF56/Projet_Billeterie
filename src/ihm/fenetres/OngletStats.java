package ihm.fenetres;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import modele.Billeterie;

@SuppressWarnings("serial")
public class OngletStats extends JPanel {
	private Billeterie billeterie;
	private GridBagConstraints gridBagConstraints;
	private JLabel totalArticles;
	private JLabel moisArticles;
	private JLabel totalPrix;
	private JLabel moisPrix;
	
	private int y;
	
	public OngletStats(Billeterie billeterie) {
		super();
		this.billeterie = billeterie;
		createLabel();
		y = 0;
		
		gridBagConstraints = new GridBagConstraints();
		this.setLayout(new GridBagLayout());
		
		label("Statistiques generales", 0, 0);
		
		label("Recette : ", 0, 1);
		label(totalPrix);
		
		label("Commandes effectuees : ", 0, 1);
		label(totalArticles);
		
		ligneBlanche();
		ligneBlanche();
		
		label("Statistiques depuis un mois              ", 0, 0);

		label("Recette : ", 0,1);
		label(moisPrix);
		
		label("Commandes effectuees : ", 0,1);
		label(moisArticles);
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
	
	public void majLabel() {
		totalArticles.setText(billeterie.getAchatsGeneral().getTotalArticles() + "");
		moisArticles.setText(billeterie.getAchatsGeneral().getMoisArticle() + "");
		totalPrix.setText(billeterie.getAchatsGeneral().getTotalPrix() + " euros");
		moisPrix.setText(billeterie.getAchatsGeneral().getMoisPrix() + " euros");
	}
	
	private void createLabel() {
		totalArticles = new JLabel(billeterie.getAchatsGeneral().getTotalArticles() + "");
		moisArticles = new JLabel(billeterie.getAchatsGeneral().getMoisArticle() + "");
		totalPrix = new JLabel(billeterie.getAchatsGeneral().getTotalPrix() + " euros");
		moisPrix = new JLabel(billeterie.getAchatsGeneral().getMoisPrix() + " euros");
	}
}
