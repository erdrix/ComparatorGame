package supply;

import score.StyleScore;

public class SGameStyle extends StyleScore{

	public SGameStyle(String s1) {
		super(s1);
	}
	
	public String extractD(DemandMethods myDemand) {
		// TODO Auto-generated method stub
		return myDemand.getGameStyle();
	} 

}