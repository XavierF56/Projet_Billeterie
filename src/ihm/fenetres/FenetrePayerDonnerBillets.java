package ihm.fenetres;

import ihm.barresOutils.BarreOutilsDetails;

import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableRowSorter;

import modele.ListeAchats;
import modele.Personne;

@SuppressWarnings("serial")
public class FenetrePayerDonnerBillets extends Fenetre {

private JPanel contentPane;

public FenetrePayerDonnerBillets(Personne personne) {

//Fenetre
this.setTitle("Paiement des billets de " + personne);
contentPane = new JPanel();
contentPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 5, 10));
contentPane.setLayout(new BorderLayout(0, 0));

contentPane.add(new JLabel("Restant a payer pour "+ personne +" : " + personne.restantAPayer() + "euros."), "North");

// Choix de la somme payee
// Tableau
JTable tableau = new JTable(personne.getAchats());
personne.getAchats().setTableau(tableau);
tableau.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
tableau.setAutoCreateRowSorter(true);// Gestion des tableaux triables
TableRowSorter<ListeAchats> sorter = new TableRowSorter<ListeAchats>((ListeAchats) tableau.getModel());
tableau.setRowSorter(sorter);
sorter.setSortsOnUpdates(true);
contentPane.add(new JScrollPane(tableau), "Center");

// boutons payer / donner / annuler
contentPane.add(new BarreOutilsDetails(this), "South");


this.add(contentPane);

this.afficher();
}
}