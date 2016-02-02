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
public class SDifficulty extends EcartScore{
		// CONSTRUCTEUR
	private static ArrayList<String> options = new ArrayList<String>();
	public SDifficulty(int c) {
		super(c,0.3, options);	
	}
	
		// METHODE
	/**
	 * Methode permettant d'extraire la valeur du critère correspondant dans la demande.
	 * @return myDemand.getDifficulty() : int correspondant à la difficulté demandé par le client.
	 */
	public Integer extractD(DemandMethods myDemand)
	{
		return myDemand.getDifficulty();
	}
	
	static public void Init()
	{
		options.add("Débutant"); 
		options.add("Intermédiaire");
		options.add("Confirmé");
		options.add("Expérimenté");
	}
}
