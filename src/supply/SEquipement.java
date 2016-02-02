/**
 * 
 */
package supply;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeMap;
import score.MultipleScore;

/**
 * @author guitt
 *
 */
public abstract class SEquipement extends MultipleScore<Triplet<String, String, Integer>[]>{
		// ATTRIBUTS
	protected TreeMap<String, ArrayList<Couple<String, String>>> equipements;
	//protected Triplet<String, String, String>[] equipements;
	
		// CONSTRUCTEUR
	public SEquipement(String[] c, String[] n, String[] t)
	{
		super();
		ArrayList<Couple<String, String>> init = new ArrayList<Couple<String, String>>();
		equipements = new TreeMap<String, ArrayList<Couple<String, String>>>();
		
		// Création du TreeMap contenant en clé les noms des type d'équipements et en valeur un ArrayList de couple représentant le Constructeur et le nom.
		if(t == null)
			equipements = null;
		
		for(int i=0; t!=null && i < t.length  ; i++)
		{
			// Si on rencontre pour la première fois ce type d'équipement.
			if(!equipements.containsKey(t[i]))
			{
				init.add(new Couple<String, String>(c[i], n[i]));	
				equipements.put(t[i],init);	// On initialise la nouvelle entrée avec un premier couple (constructeur, nom).
			}
			else // Sinon 
			{
				equipements.get(t[i]).add(new Couple<String, String>(c[i], n[i]));	// On ajoute un couple (constructeur, nom).
			}
		}
	}
	
		// METHODES
	public abstract ArrayList<String> getTypeE();
	
	public boolean compareField(String type, String c, String n)
	{
		boolean ok = false;
		Iterator<Couple<String, String>> it = equipements.get(type).iterator();
		Couple<String, String> recept;
		while(it.hasNext())
		{
			recept = it.next();
			if(recept.getFirst() == c && recept.getSecond()==n)
				ok = true;
		}
		return ok;
	}
	public int getScore(DemandMethods myDemand) {
		// On récupère l'ensemble des choix du client
		
		Triplet<String, String, Integer>[] fields = extractD(myDemand);
		ArrayList<String> typeE = getTypeE();
		String type;
		int cpt = 0; // Compteur servant à connaitre le nombre d'élément de la demande présent dans équipement.
		
		
		if(fields != null && equipements != null)
		{
			// Pour chaque choix du client
			for(Triplet<String, String, Integer> f : fields)
			{
				type = typeE.get(f.getThird());

				// Si l'équipement contient au moins un objet du type voulu et que le couple(constructeur, nom) appartient à l'arrayList associé.
				if(equipements.containsKey(type) && compareField(type, f.getFirst(), f.getSecond()))
					cpt++;
			}
			
			double s = 1.0*scoreMax;
			
			return score =(int) (cpt*(s/fields.length));
		}
		else 
			return score = 0;
	}	
}
