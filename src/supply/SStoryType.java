package supply;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import score.MultipleScore;

public class SStoryType extends MultipleScore<int[]>{
	
		//ATTRIBUTS
	protected String[] storyType;
	static private ArrayList<String> typeS;
	
		// CONSTRUCTEUR
	public SStoryType(String ...type)
	{
		super();
		storyType = (type.length == 0)? null : type;
	}
	
		// METHODES
	public static void Init()
	{
		typeS = new ArrayList<String>();
		File f = new File(".\\src\\supply\\StoryTypes.txt");
		Scanner sc = null;
		try {
			sc = new Scanner(f);
			while(sc.hasNext())
			{
				String current = sc.next();

				// On évite les occurences.
				if(!typeS.contains(current))
					typeS.add(current);
			}
			
			sc.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public int getScore(DemandMethods myDemand) {

		int[] field = extractD(myDemand);
		
		int cpt = 0;
		boolean find;
		
		if(field == null ||storyType == null) return 0;
		
		for(int i : field)
		{
			find = false;
			for(String s : storyType)
			{
				
				if(	s.equals(typeS.get(i)) && !find)
				{
					cpt++;
					find = true; // On se protège contre la présence de doublon dans l'offre.
				}
			}
		}
		return score = (100*cpt)/field.length;
	}

	@Override
	public int[] extractD(DemandMethods myDemand) {
		return myDemand.getStoryType();
	}
}
