package ihm.fenetres;

import ihm.actions.ValiderPaiementAction;

import java.awt.BorderLayout;
import java.text.NumberFormat;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;

import modele.Personne;

@SuppressWarnings("serial")
public class FenetrePayerBillets extends Fenetre {
	
	private JPanel contentPane;
	private JFormattedTextField textField;
	
	public FenetrePayerBillets(Personne  personne, ValiderPaiementAction keyValiderAction) {
		
		//Fenetre
		this.setTitle("Paiement des billets de " + personne);
		contentPane = new JPanel();
		contentPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 5, 10));
		contentPane.setLayout(new BorderLayout(0, 0));
		
		contentPane.add(new JLabel("Restant a payer pour "+ personne +" : " + personne.restantAPayer() + "euros."), "North");
		
		// Choix de la somme payee
		JPanel centerPane = new JPanel();
		centerPane.setLayout(new BorderLayout(0, 0));
		
		centerPane.add(new JLabel("Somme payee : "), "West");
				
		textField = new JFormattedTextField(NumberFormat.getIntegerInstance());
		textField.setValue(personne.restantAPayer());
		textField.setColumns(20);
		textField.addKeyListener(keyValiderAction);
		centerPane.add(textField, "East");
			
		contentPane.add(centerPane, "Center");
		
		// TODO bouton valider paiement
		contentPane.add(new JButton("Valider"), "South");
		
		this.add(contentPane);
		
		this.afficher();
	}
}
