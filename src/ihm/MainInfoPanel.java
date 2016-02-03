package ihm;

import java.awt.BorderLayout;
import javax.swing.JLabel;

public class MainInfoPanel extends InfoPanel{

	private static final long serialVersionUID = 1L;
	public MainInfoPanel(String[] criterions){
		super(criterions);
		setLayout(new BorderLayout());
		add(new JLabel("Informations principales : "),BorderLayout.NORTH);
		add(new CritInfoPanel(criterions), BorderLayout.CENTER);
		
		
	}

}
