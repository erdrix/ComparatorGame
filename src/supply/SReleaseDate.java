package supply;

import score.IntervalleScore;
import java.util.Calendar;

public class SReleaseDate extends IntervalleScore{
		// CONSTRUCTEUR
	public SReleaseDate(Calendar d){super(d.getTimeInMillis()); desc = false;}
	
		// METHODES
	public Intervalle extractD(DemandMethods myDemand){return myDemand.getReleaseDate();}

	public Calendar getReleaseDate(){
		Calendar c = Calendar.getInstance();
		c.setTimeInMillis((long) val);
		return c;
	}
	public void setReleaseDate(Calendar value){val = value.getTimeInMillis();}
}
