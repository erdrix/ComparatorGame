package main;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.TreeMap;
import bd.Connexion;
import comparator.Comparator;
import supply.*;
import demand.*;
public class Main {

	public static void main(String[] args) {
		Connexion connexion = new Connexion();
		connexion.connect();
		
		// Initialisation des champs choix possibles.
		SBuyMethod.Init("Abonnement", "Licence");
		SDifficulty.Init("Débutant", "Intermédiaire", "Confirmé", "Expérimenté");
		SGameType.Init("Hors Ligne", "En Ligne");
		SLifeTime.Init("Courte", "Moyenne", "Longue", "Infinie");
		SGameStyle.Init(
				new Couple<String, String>("Fiction Intéractive", "Aventure, Sous-Aventure"),
				new Couple<String, String>("Visual Novel", "Aventure, Sous-Aventure"),
				new Couple<String, String>("Infiltration", "Action Aventure, Sous-Action, Sous-Aventure"),
				new Couple<String, String>("Survival Horror", "Action Aventure, Sous-Action, Sous-Aventure")
				);
		SAccessory.Init(connexion.getAccessories());
		SGameSupport.Init(connexion.getSupports());
		SStoryType.Init();		
		
		Calendar cal1 = Calendar.getInstance();
		Calendar cal2 = Calendar.getInstance();
		
		cal1.set(Calendar.YEAR,2008 );
		cal2.set(Calendar.YEAR,2013 );
		
		TreeMap<String, String> s1 = new TreeMap<>();
		s1.put("type", "0");s1.put("nomEditeur", "Nintendo"); s1.put("nomSupport", "WiiU");
		TreeMap<String, String> s2 = new TreeMap<>();
		s2.put("type", "0");s2.put("nomEditeur", "Nintendo"); s2.put("nomSupport", "Wii");
		TreeMap<String, String> s3 = new TreeMap<>();
		s3.put("type", "0");s3.put("nomEditeur", "Microsoft"); s3.put("nomSupport", "Xbox360");
		
		
		TreeMap<String, String> a1 = new TreeMap<>();
		a1.put("type", "2"); a1.put("nomEditeur", "Nintendo"); a1.put("nomAccessoire", "WiiMote");
		TreeMap<String, String> a2 = new TreeMap<>();
		a2.put("type", "2");a2.put("nomEditeur", "Nintendo"); a2.put("nomAccessoire", "GamePad");
		TreeMap<String, String> a3 = new TreeMap<>();
		a3.put("type", "2");a3.put("nomEditeur", "Microsoft"); a3.put("nomAccessoire", "Xbox360");
		
		ArrayList<TreeMap<String, String>>supports = new ArrayList<>();
		supports.add(s1); supports.add(s2); supports.add(s3);
		
		ArrayList<TreeMap<String, String>> accessories = new ArrayList<>();
		accessories.add(a1); accessories.add(a2); accessories.add(a3);
		System.out.println(accessories);
		Demand d = new Demand(
				new DTitle("Guild Guild Wars 2"), 
				new DDescription("Meilleur jeu de l'année"), 
				new DEditor("AreaNet"), 
				new DMark(16, 18), 
				new DReleaseDate(cal1, cal2), 
				new DGameType(0), 
				new DBuyMethod(new DPrice(30, 70), 1), 
				new DDifficulty(2), 
				new DLifeTime(2), 
				new DGameStyle("A-RPG"), 
				new DStoryType(0,2), 
				new DGameSupport(supports), 
				new DAccessory(accessories),
				null ,0);
		Supply[] s = new Supply[5];
		
		cal1.set(2009,8,0,0,0);
		

		
		/*s[0] = new Supply(
				new STitle("Guiald Guild Wars 2"), 
				new SDescription(" "), 
				new SEditor("ArenaNet"), 
				new SMark(1),
				new SReleaseDate(cal1), 
				new SGameType("En Ligne"), 
				new SBuyMethod(new SPrice(75), "Licence"), 
				new SDifficulty("Débutant"), 
				new SLifeTime("Courte"),
				new SGameStyle("A-RPG"),
				new SStoryType(),
				new SGameSupport(null),
				new SAccessory(null)
			);
		cal1.set(2006,7,0,0,0);
		s[1] = new Supply(
				new STitle("Galkjuild Wars 2"), 
				new SDescription(" "), 
				new SEditor("ArenaNet"), 
				new SMark(10),
				new SReleaseDate(cal1),
				new SGameType("Hors Ligne"),
				new SBuyMethod(
						new SPrice(45), "Licence"),
				new SDifficulty("Intermédiaire"),
				new SLifeTime("Moyenne"),	
				new SGameStyle("MMORPG"),
				new SStoryType(),
				new SGameSupport(supports),
				new SAccessory(null)
			);
		cal1.set(2005,6,0,0,0);
		s1 = new TreeMap<String, String> ();
		s1.put("type", "PC");s1.put("nomEditeur", "Apple"); s1.put("nomSupport", "Mac");
		s2 = new TreeMap<String, String>();
		s2.put("type", "ConsoleSalon");s2.put("nomEditeur", "Nintendo"); s2.put("nomSupport", "Wii");
		s3 = new TreeMap<String, String>();
		s3.put("type", "ConsoleSalon");s3.put("nomEditeur", "Microsoft"); s3.put("nomSupport", "Xbox360");
		s4 = new TreeMap<String, String>();
		s4.put("type", "ConsoleSalon");s4.put("nomEditeur", "Microsoft"); s4.put("nomSupport", "Xbox360");
		
		supports = new ArrayList<>();
		supports.add(s1); supports.add(s4); supports.add(s2); supports.add(s3);
		
		a1 = new TreeMap<String, String>();
		a1.put("type", "Manette");a1.put("nomEditeur", "Nintendo"); a1.put("nomSupport", "WiiMote");
		a2 = new TreeMap<String, String>();
		a2.put("type", "Manette");a2.put("nomEditeur", "Nintendo"); a2.put("nomSupport", "GamePAd");
		a3 = new TreeMap<String, String>();
		a3.put("type", "Manette");a3.put("nomEditeur", "Microsoft"); a3.put("nomSupport", "Xbox360");

		accessories = new ArrayList<>();
		accessories.add(a1); accessories.add(a2); accessories.add(a3);
		s[2] = new Supply(
				new STitle("Guild Wars 2"), 
				new SDescription(" "), 
				new SEditor("ArenaNet"),
				new SMark(18),
				new SReleaseDate(cal1),
				new SGameType("Hors Ligne"),
				new SBuyMethod(
						new SPrice(35), "Abonnement"),
				new SDifficulty("Confirmé"),
				new SLifeTime("Longue"), 
				new SGameStyle("Fiction Intéractive"),
				new SStoryType(),
				new SGameSupport(supports),
				new SAccessory(null)
				);
		cal1.set(2008,5,0,0,0);
		s[3] = new Supply(
				new STitle("Guild Wars 2"), 
				new SDescription(" "), 
				new SEditor("ArenaNet"), 
				new SMark(19),
				new SReleaseDate(cal1),
				new SGameType("En Ligne"),
				new SBuyMethod(
						new SPrice(25), "Abonnement"),
				new SDifficulty("Expérimenté"),
				new SLifeTime("Infinie"),
				new SGameStyle("Visual Novels"),
				new SStoryType(),
				new SGameSupport(null),
				new SAccessory(null)
			);*/
		cal1.set(2012,5,0,0,0);
		System.out.println("Accessoire :"+SAccessory.getOptions());
		System.out.println("Support :"+SGameSupport.getOptions());
		s1 = new TreeMap<String, String> ();
		s1.put("type", "PC");s1.put("nomEditeur", "Apple"); s1.put("nomSupport", "Mac");
		s2 = new TreeMap<String, String>();
		s2.put("type", "ConsoleSalon");s2.put("nomEditeur", "Nintendo"); s2.put("nomSupport", "Wii");
		s3 = new TreeMap<String, String>();
		s3.put("type", "ConsoleSalon");s3.put("nomEditeur", "Microsoft"); s3.put("nomSupport", "Xbox360");
		TreeMap<String, String> s4 = new TreeMap<String, String>();
		s4.put("type", "ConsoleSalon");s4.put("nomEditeur", "Microsoft"); s4.put("nomSupport", "Xbox360");
		
		supports = new ArrayList<>();
		supports.add(s1); supports.add(s4); supports.add(s2); supports.add(s3);
		
		a1 = new TreeMap<String, String>();
		a1.put("type", "Manette");a1.put("nomEditeur", "Nintendo"); a1.put("nomAccessoire", "WiiMote");
		a2 = new TreeMap<String, String>();
		a2.put("type", "Manette");a2.put("nomEditeur", "Nintendo"); a2.put("nomAccessoire", "GamePad");
		a3 = new TreeMap<String, String>();
		a3.put("type", "Manette");a3.put("nomEditeur", "Microsoft"); a3.put("nomAccessoire", "Xbox360");
		accessories = new ArrayList<>();
		accessories.add(a1); accessories.add(a2);
		
		
		s[0] = new Supply(
				new STitle("Guild Guild Wars 2"), 
				new SDescription("Meilleur jeu de l'année"), 
				new SEditor("AreaNet"), 
			    new SMark(16),
			    new SReleaseDate(cal1),
				new SGameType("Hors Ligne"),
				new SBuyMethod(
						new SPrice(45), "Abonnement"),
				new SDifficulty("Confirmé"),
				new SLifeTime("Longue"),
				new SGameStyle("MMORPG"),
				new SStoryType("Horreur", "Aventure"),
				new SGameSupport(null),
				new SAccessory(accessories)
			);
		Comparator c = new Comparator(s, 1, d);
		
		c.compare();
		c.afficherScore();
		
		s[0].addAccessory(a3);
		
		c.compare();
		c.afficherScore();
		a3 = new TreeMap<String, String>();
		a3.put("type", "Manette");a3.put("nomEditeur", "Microsoft"); a3.put("nomAccessoire", "Xbox360");
		s[0].deleteAccessory(a3);
		
		c.compare();
		c.afficherScore();
		
		connexion.close();
	}
}
