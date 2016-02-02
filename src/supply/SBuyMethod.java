/**
 * 
 */
package supply;
import score.BinaryScore;

/**
 * @author guitt
 *
 */
public class SBuyMethod extends BinaryScore{
		//	ATTRIBUTS
	protected SPrice price;
	
		//CONSTRUCTEURS
	/**
	 * Constructeur par défaut.
	 * @param prix : prix du jeu.
	 * @param c    : forme de paiement pour ce jeu.c
	 */
	public SBuyMethod(SPrice prix, int c)
	{
		super(c, "Abonnement", "Licence");
		price = prix;
	}

		// METHODES
	/**
	 * Methode permettant d'extraire la valeur du critère correspondant dans la demande.
	 * @return myDemand.getDBuyMethod() : int correspondant au choix du client pour la forme de paiement.
	 */
	public Integer extractD(DemandMethods myDemand)
	{
		return myDemand.getDBuyMethod();
	}
	
	/**
	 * Methode permettant d'appeler la methode getScore() de l'objet SPrice encapsulé par cette classe.
	 * @return price.getScore(myDemand) : int représentant le score du prix de l'offre par rapport à la demande.
	 */
	public int getScoreSpe(DemandMethods myDemand) {
		return price.getScore(myDemand);
	}
	
	/**
	 * Méthode donnant accè à l'objet SPrice encapsulé.
	 * @return price : SPrice étant le prix de l'offre.
	 */
	public SPrice getPrice()
	{
		return price;
	}
	

}
