package criterions_ihm;

import javax.swing.JTextField;

public class KeywordField extends JTextField{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@SuppressWarnings("unused")
	private String name;
	public KeywordField(int columns){
		super(columns);
	}
	
	public void setName(String s){
		name = s;
	}

}
