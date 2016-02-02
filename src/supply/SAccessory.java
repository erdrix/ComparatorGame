/**
 * 
 */
package supply;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * @author guitt
 *
 */
public class SAccessory extends SEquipement {
		// ATTRIBUTS
	static protected ArrayList<String> typeE;
	static protected TreeMap<String, ArrayList<Couple<String, String>>> assoc;
	
		// CONSTRUCTEUR
	public SAccessory(String[] c, String[] n, String[] t) {
		super(c, n, t);
	}
	
		// METHODES
	static public void Init()
	{
		assoc = new TreeMap<String, ArrayList<Couple<String, String>>>();
		typeE = new ArrayList<String>();
		File f = new File(".\\src\\supply\\Accessories.txt");
		Scanner sc = null;
		try {
			sc = new Scanner(f);
			while(sc.hasNext())
			{
				String current = sc.nextLine();
				String fields[] = current.split(" ");
				
				ArrayList<Couple<String, String>> init = new ArrayList<Couple<String, String>>();

				// Si c'est la première fois que l'on rencontre cet équipement
				if(!assoc.containsKey(fields[0]))
				{
					// On l'ajoute à typeE.
					typeE.add(fields[0]);
					init.add(new Couple<String, String>(fields[1], fields[2]));
					
					assoc.put(fields[0],init);
				}
				else
				{
					assoc.get(fields[0]).add(new Couple<String, String>(fields[1], fields[2]));
				}
			}
			sc.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

	
	public ArrayList<String> getTypeE()
	{
		return typeE;
	}
	@Override
	public Triplet<String, String, Integer>[] extractD(DemandMethods myDemand) {
		return myDemand.getAccessoryEquipements();
	}
}
