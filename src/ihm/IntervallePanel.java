package ihm;

import javax.swing.JPanel;


public class IntervallePanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public IntervallePanel(String classname){
		if(classname.equals("DPrice")){
			add(new MyRangeSlider(0,100,25,50));
		}
		if(classname.equals("DReleaseDate")){
			add(new MyRangeSlider(1950,2016,1975,2000));
		}
	}
}
