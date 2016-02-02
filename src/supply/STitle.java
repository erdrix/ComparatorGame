package supply;

public class STitle extends SKeywords{
	
	public STitle(String s){
		super(s);
		scoreMax = 200;
	}	
	public String extractD(DemandMethods myDemand)
	{
		return myDemand.getTitle();
	}
}
