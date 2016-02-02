/**
 * 
 */
package supply;

import java.util.ArrayList;

import score.EcartScore;

/**
 * @author guitt
 *
 */
public class SLifeTime extends EcartScore{
	private static ArrayList<String> options = new ArrayList<String>();
		// CONSTRUCTEUR
	public SLifeTime(int c)
	{	
		super(c,0.3,options);
	}
	
		// METHODE
	/**
	 * Methode permettant d'extraire la valeur du critère correspondant dans la demande.
	 * @return myDemand.getDifficulty() : int correspondant à la difficulté demandé par le client.
	 */
	public Integer extractD(DemandMethods myDemand)
	{
		return myDemand.getDLifeTime();
	}
	
	static public void Init()
	{
		options.add("Courte");
		options.add("Moyenne");
		options.add("Longue");
		options.add("Infinie");
	}

}
