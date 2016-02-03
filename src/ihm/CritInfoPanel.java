package ihm;

import javax.swing.JPanel;

public class CritInfoPanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CritInfoPanel(String[] criterions){
		for(int i = 0; i < criterions.length; i++){
			if(	criterions[i].equals("DTitle") 
			|| 	criterions[i].equals("DEditor")
			||	criterions[i].equals("DDescription"))
				add(new KeywordPanel(criterions[i]));
		}
	}
	
}
