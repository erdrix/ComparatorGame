package score;

import java.util.ArrayList;

import supply.DemandMethods;

public abstract class BinaryScore extends Score<Integer>{
		// ATTRIBUTS
	ArrayList<String> elements;	// Contients les deux choix possibles pour un critère.
	int val;					// Valeur encapsulée par l'offre.
	
		// CONSTRUCTEURS
	public BinaryScore(int value, String...item)
	{
		super();
		elements = new ArrayList<String>();
		// Création de la correspondance entre 0 et 1 et signification.
		for(String c : item)
			elements.add(c);
		val         = value;
		scoreMax    = 50;
	}
	
		// METHODES
	/**
	 * Définition de la méthode hérité de Score.
	 * @return score : int correspondant au score de ce champ.
	 */
	public int getScore(DemandMethods myDemand) {
		Integer field = extractD(myDemand);
		//Vérifie si le critère de l'offre correspond à la demande.
		return score = (val == field)? scoreMax+getScoreSpe(myDemand) : 0+getScoreSpe(myDemand);	
	}
	
	public String toString(){
		return val+"("+score+")";
	}
	
	public abstract int getScoreSpe(DemandMethods myDemand);
}
