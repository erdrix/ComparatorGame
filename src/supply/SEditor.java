package supply;

public class SEditor extends SKeywords{
	public SEditor(String s){
		super(s);
		scoreMax = 50;
	}
	public String extractD(DemandMethods myDemand)
	{
		return myDemand.getEditor();
	}
}
