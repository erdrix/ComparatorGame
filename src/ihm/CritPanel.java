package ihm;

import java.awt.GridLayout;

import javax.swing.JPanel;


public class CritPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public CritPanel(){
		setLayout(new GridLayout(2,0) );
		String[] main_crit = {"DTitle","DBuyMethod"};
		String[] aux_crit = {"DMark","DEditor"};
		add(new MainInfoPanel(main_crit));
		add(new AuxInfoPanel(aux_crit));
		validate();
	}
	
}
