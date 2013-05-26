package vue.outils;

import java.util.StringTokenizer;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

	@SuppressWarnings("serial")
	public class MultiLineLabel extends JPanel {
		 
		/**
		 * Cette classe permet l'affichage sous forme de label d'un texte à plusieurs lignes
		 * 
		 * @param text le texte à traiter
		 */
		public MultiLineLabel(String text) {
		      super();
		      this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		      StringTokenizer st = new StringTokenizer(text, "\n" );
		      while(st.hasMoreTokens()) {
		            add(new JLabel(st.nextToken()));
		      }
		} 
	}
