/**
 * 
 */
package demand;
import supply.Triplet;

/**
 * @author guitt
 *
 */
public abstract class DEquipement {
		// ATTRIBUTS
	protected Triplet<String, String, Integer>[] equipements;	// Contient l'ensemble des équipements souhaités (constructeur, nom, type).
		
		// CONSTRUCTEUR 
	@SuppressWarnings("unchecked")
	public DEquipement (String[] c, String[] n, int[] t)
	{
		if(t == null)
		{
			equipements = null;
		}
		else
		{
			equipements = new Triplet[t.length];
			for (int i=0; i < t.length; i++)
			{
				equipements[i] = new Triplet<String, String, Integer>(c[i], n[i], t[i]);
			}
		}
	}
		
		// METHODES 
	/**
	 * Fonction getName retourne le nom de l'accessoire.
	 * @return string : nom de l'accessoire.
	 */
	public Triplet<String, String, Integer>[] getEquipements()
	{
		return equipements;
	}
}
