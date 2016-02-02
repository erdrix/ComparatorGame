package supply;

import score.IntervalleScore;

public class SMark extends IntervalleScore{
		// CONSTRUCTEUR
	public SMark(float m)
	{
		super(m);
		desc = false;
	}
	
		// METHODE
	public Intervalle extractD(DemandMethods myDemand)
	{
		return myDemand.getMark();
	}
}
