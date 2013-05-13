package ihm.fenetres;

import ihm.actions.AnnulerAction;
import ihm.actions.ValiderDonBilletAction;
import ihm.actions.ValiderPaiementAction;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.text.NumberFormat;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;

import modele.Personne;

@SuppressWarnings("serial")
public class FenetrePayerDonnerBillets extends Fenetre {
	
	private JPanel contentPane;
	private JFormattedTextField textField;
	
	public FenetrePayerDonnerBillets(Personne  personne) {
		
		ValiderPaiementAction keyPayerAction = new ValiderPaiementAction(this);
		ValiderDonBilletAction keyDonBilletAction = new ValiderDonBilletAction(this);
		
		//Fenetre
		this.setTitle("Paiement des billets de " + personne);
		contentPane = new JPanel();
		contentPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 5, 10));
		contentPane.setLayout(new BorderLayout(0, 0));
		
		contentPane.add(new JLabel("Restant a payer pour "+ personne +" : " + personne.restantAPayer() + "euros."), "North");
		
		// Choix de la somme payee
		JPanel centerPane = new JPanel();
		centerPane.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		centerPane.add(new JLabel("Somme payee : "), "West");
				
		textField = new JFormattedTextField(NumberFormat.getIntegerInstance());
		textField.setValue(personne.restantAPayer());
		textField.setColumns(20);
		textField.addKeyListener(keyPayerAction);
		centerPane.add(textField, "East");
			
		contentPane.add(centerPane, "Center");
		
		// TODO bouton payer / donner
		JPanel southPane = new JPanel();
		southPane.setLayout(new FlowLayout(FlowLayout.CENTER));
		southPane.add(new JButton(keyPayerAction));
		southPane.add(new JButton(keyDonBilletAction));
		southPane.add(new JButton(new AnnulerAction(this)));
		
		contentPane.add(southPane, "South");
		
		
		this.add(contentPane);
		
		this.afficher();
	}
}
