package supply;

import score.IntervalleScore;

public class SPrice extends IntervalleScore{
		// CONSTRUCTEUR
	public SPrice(float item)
	{
		super(item);
		desc = true;
	}
		
		// METHODES
	public Intervalle extractD(DemandMethods myDemand)
	{
		return myDemand.getPrice();
	}
}
