package ihm.fenetres;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import modele.Billeterie;

@SuppressWarnings("serial")
public class OngletStats extends JPanel {
	Billeterie billeterie;
	GridBagConstraints gridBagConstraints;
	
	public OngletStats(Billeterie billeterie) {
		super();
		this.billeterie = billeterie;
		
		gridBagConstraints = new GridBagConstraints();
		this.setLayout(new GridBagLayout());
		
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.anchor = GridBagConstraints.LINE_END;
		add(new JLabel("Statistiques generales : "), gridBagConstraints);
		
		gridBagConstraints.gridy = 1;
		add(new JLabel(" "), gridBagConstraints);
		
		
		gridBagConstraints.gridy = 2;
		add(new JLabel("Recette : "), gridBagConstraints);
		gridBagConstraints.gridx = 1;
		add(new JLabel(billeterie.getAchatsGeneral().getTotalPrix() + " euros"), gridBagConstraints);
		gridBagConstraints.gridx = 0;
		
		gridBagConstraints.gridy = 3;
		add(new JLabel("Commandes effectuees : "), gridBagConstraints);
		gridBagConstraints.gridx = 1;
		add(new JLabel(billeterie.getAchatsGeneral().getTotalArticles() + ""), gridBagConstraints);
		gridBagConstraints.gridx = 0;
		
		gridBagConstraints.gridy = 4;
		add(new JLabel(" "), gridBagConstraints);
		gridBagConstraints.gridy = 5;
		add(new JLabel(" "), gridBagConstraints);
		
		gridBagConstraints.gridy = 6;
		add(new JLabel("Statistiques depuis un mois : "), gridBagConstraints);
		
		gridBagConstraints.gridy = 7;
		add(new JLabel(" "), gridBagConstraints);
		
		gridBagConstraints.gridy = 8;
		add(new JLabel("Recette : "), gridBagConstraints);
		gridBagConstraints.gridx = 1;
		add(new JLabel(billeterie.getAchatsGeneral().getMoisPrix() + " euros"), gridBagConstraints);
		gridBagConstraints.gridx = 0;
		
		gridBagConstraints.gridy = 9;
		add(new JLabel("Commandes effectuees : "), gridBagConstraints);
		gridBagConstraints.gridx = 1;
		add(new JLabel(billeterie.getAchatsGeneral().getMoisArticle() + ""), gridBagConstraints);
		gridBagConstraints.gridx = 0;
		
		

	}
}
