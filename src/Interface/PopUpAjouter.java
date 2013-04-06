package Interface;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Window.Type;
import General.Constantes;
public class PopUpAjouter extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PopUpAjouter frame = new PopUpAjouter();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PopUpAjouter() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		
	}
	
	private void afficherHashMap () {
		// for each
		int type = -1; //recuperer le type
		String nom = "Attribut 1"; //recuperer le nom de l'attribut
		
		switch(type){

		case Constantes.ENTIER:
			break;
		case Constantes.DECIMAL:
			break;
		case Constantes.BOOLEEN:
			break;
		case Constantes.CHAINE:
			break;
		}
	}
}
