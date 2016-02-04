package ihm;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class LabelPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public LabelPanel(String classname){
		if(classname=="DTitle") add(new JLabel("Titre du jeu :"));
		if(classname=="DDescription") add(new JLabel("Mots-clés :"));
		if(classname=="DEditor") add(new JLabel("Éditeur :"));
		if(classname=="DPrice") add(new JLabel("Prix :"));
		if(classname=="DReleaseDate") add(new JLabel("Date de sortie :"));
	}

}
