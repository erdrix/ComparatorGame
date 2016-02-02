package supply;

import score.Score;

public class Supply {
	
		// ATTRIBUTS
	protected int score;			// Score de l'offre par rapport à une demande.
	protected int length_C;			// Nombre de critère présent dans l'offre.
	private Score<?> criterion[];	// Ensemble des critères correspondant à l'offre.
	private SPrice price;
	
		// CONSTRUCTEUR
	public Supply(STitle title, SDescription desc, SEditor edit, SMark mark, SReleaseDate rd, SGameType gm, SBuyMethod bm, SDifficulty diff, SLifeTime lt, SGameStyle gst, SStoryType st, SGameSupport gs, SAccessory acce)
	{
		length_C = 13;
		criterion = new Score[length_C];
		
		////////////////////////////////////////////
		// A SUPPRIMER UNE FOIS GAMESTYLE OK !!!!!//
		for(int i=0; i < length_C; i++)           //
			criterion[i] = null;                  //
		////////////////////////////////////////////
		
		price = bm.getPrice();
		
		criterion[0] = title;
		criterion[1] = desc;
		criterion[2] = edit;
		criterion[3] = mark;
		criterion[4] = rd;
		criterion[5] = gm;
		criterion[6] = bm;
		criterion[7] = diff;
		criterion[8] = lt;
		criterion[9] = gst; 
		criterion[10]= st;
		criterion[11]= gs;
		criterion[12]= acce;
		score = 0;
	}
		
		// METHODES
	/**
	 * Fonction servant à comparer chaque critère de l'offre avec une demande
	 * @param myDemand : DemandMethods Interface implémenté par une demande.
	 */
	public void compare(DemandMethods myDemand)
	{
		for (int i=0; i< length_C; i++)
			if(criterion[i]!= null)
				score += criterion[i].getScore(myDemand);
	}
	
	/**
	 * Fonction retournant le score d'une offre
	 * @return score : int représentant le score d'une offre.
	 */
	public int getScore()
	{
		return score;
	}
	
	/**
	 * Surdéfinition de la méthode toString() afin d'afficher le score de notre offre lors de l'affichage.
	 */
	public String toString()
	{
		return "\t- Title : "+criterion[0]
			   +"\n\t- Description : "+criterion[1]
	           +"\n\t- Editeur : "+criterion[2]
	           +"\n-------- -------- -------- -------- \n"
	           +"\n\t- Note : "+criterion[3]
	           +"\n\t- Date de sortie : "+criterion[4]
	           +"\n\t- Mode de jeu : "+criterion[5]
	           +"\n\t- Forme de paiement : "+criterion[6]
	           +"\n\t\t-Prix : "+price
	           +"\n-------- -------- -------- -------- \n"
	           +"\n\t- Difficulté : "+criterion[7]
	           +"\n\t- Durée de jeu : "+criterion[8]
	           +"\n\t- Style de jeu : "+criterion[9]
	           +"\n\t- Style d'histoire : "+criterion[10]
	           +"\n\t- Support possibles : "+criterion[11]
	           +"\n\t- Accessoires : "+criterion[12]
	           +"\n-------- -------- -------- -------- "
			   +"\n-------- Score : "+score+" -------- "
		 	   +"\n-------- -------- -------- -------- ";
	}
}
