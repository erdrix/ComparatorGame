package ihm;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class KeywordPanel extends JPanel{

	private static final long serialVersionUID = 1L;
	private JLabel jl;
	private JTextField jtf;
	
	public KeywordPanel(String classname){
		if(classname.equals("DTitle")){
			jl = new JLabel("Nom du jeu : ");
			jtf = new JTextField(12);
			add(jl);
			add(jtf);
		}		
		if(classname.equals("DEditor")){
			jl = new JLabel("Editeur : ");
			jtf = new JTextField(12);
			add(jl);
			add(jtf);
		}
	}

}
