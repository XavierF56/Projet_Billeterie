package ihm.fenetres;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;

import ihm.barresOutils.BarreOutilsValiderAnnuler;

import java.awt.Color;

@SuppressWarnings("serial")
public class FenetreAvertissement extends JFrame {
	private JPanel contentPane;

	public FenetreAvertissement(String nom, String texte) {
		setTitle(nom);
		setBounds(100, 100, 280, 130);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		BarreOutilsValiderAnnuler barreOutilsValiderAnnuler = new BarreOutilsValiderAnnuler();
		barreOutilsValiderAnnuler.setBackground(Color.WHITE);
		contentPane.add(barreOutilsValiderAnnuler, BorderLayout.CENTER);
		
		JTextPane txt = new JTextPane();
		txt.setEditable(false);
		txt.setText(texte);
		contentPane.add(txt, BorderLayout.NORTH);
	}
}
