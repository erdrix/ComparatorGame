package criterions_ihm;


import javax.swing.JPanel;

public class KeywordPanel extends JPanel{

	private static final long serialVersionUID = 1L;
	private KeywordField kf;
	
	public KeywordPanel(String classname){
		if(classname.equals("DTitle") || classname.equals("DEditor") || classname.equals("DDescription")){
			kf = new KeywordField(16);
			kf.setName(classname);
			add(kf);
		}
	}
}
