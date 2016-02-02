package supply;

import java.util.Calendar;
import score.IntervalleScore;

public class SReleaseDate extends IntervalleScore{
		// CONSTRUCTEUR
	public SReleaseDate(Calendar d)
	{
		super(d.getTimeInMillis());
		desc = false;
	}
	
		// METHODES
	public Intervalle extractD(DemandMethods myDemand)
	{
		return myDemand.getReleaseDate();
	}
}
