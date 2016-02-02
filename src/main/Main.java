package main;

import java.util.Calendar;
import comparator.Comparator;
import supply.*;
import demand.*;
public class Main {

	public static void main(String[] args) {
		
		// Initialisation des champs choix possibles.
		SLifeTime.Init();
		SDifficulty.Init();
		SAccessory.Init();
		SGameSupport.Init();
		SStoryType.Init();
		
		
		
		Calendar cal1 = Calendar.getInstance();
		Calendar cal2 = Calendar.getInstance();
		
		cal1.set(Calendar.YEAR,2008 );
		cal2.set(Calendar.YEAR,2013 );
		
		String[] Construct = {"Nintendo", "Nintendo"," Microsoft"};
		String[] Name = {"WiiU", "Wii", "Xbox360"};
		String[] Access = {"WiiMote","GamePad","Xbox360"};
		int[] type = {0,0,0};
		
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
				new DGameSupport(Construct, Name, type), 
				new DAccessory(Construct, Access, type),
				null ,0);
		Supply[] s = new Supply[5];
		
		cal1.set(2009,8,0,0,0);
		String[] construct2 =  {"Apple","Nintendo"," Microsoft", "Nintendo"};
		String[] name2 = { "Mac", "WiiU", "Xbox360" , "Wii"};
		String[] Type2 = {"PC","ConsoleSalon","ConsoleSalon","ConsoleSalon"};
		s[0] = new Supply(
				new STitle("Guiald Guild Wars 2"), 
				new SDescription(" "), 
				new SEditor("ArenaNet"), 
				new SMark(1),
				new SReleaseDate(cal1), 
				new SGameType(1), 
				new SBuyMethod(new SPrice(75), 1), 
				new SDifficulty(0), 
				new SLifeTime(0),
				new SGameStyle("A-RPG"),
				new SStoryType(),
				new SGameSupport(construct2, name2, Type2),
				new SAccessory(null, null, null)
			);
		cal1.set(2006,7,0,0,0);
		s[1] = new Supply(
				new STitle("Galkjuild Wars 2"), 
				new SDescription(" "), 
				new SEditor("ArenaNet"), 
				new SMark(10),
				new SReleaseDate(cal1),
				new SGameType(0),
				new SBuyMethod(
						new SPrice(45), 0),
				new SDifficulty(1),
				new SLifeTime(1),	
				new SGameStyle("MMORPG"),
				new SStoryType(),
				new SGameSupport(construct2, name2, Type2),
				new SAccessory(null, null, null)
			);
		cal1.set(2005,6,0,0,0);
		
		s[2] = new Supply(
				new STitle("Guild Wars 2"), 
				new SDescription(" "), 
				new SEditor("ArenaNet"),
				new SMark(18),
				new SReleaseDate(cal1),
				new SGameType(0),
				new SBuyMethod(
						new SPrice(35), 0),
				new SDifficulty(2),
				new SLifeTime(2), 
				new SGameStyle("Fiction Intéractive"),
				new SStoryType(),
				new SGameSupport(construct2, name2, Type2),
				new SAccessory(null, null, null)
				);
		cal1.set(2008,5,0,0,0);
		String[] construct1 =  {"Nintendo", "Microsoft"};
		String[] name1 = {"WiiU", "Portable"};
		String[] Type1 = {"ConsoleSalon","PC"};
		s[3] = new Supply(
				new STitle("Guild Wars 2"), 
				new SDescription(" "), 
				new SEditor("ArenaNet"), 
				new SMark(19),
				new SReleaseDate(cal1),
				new SGameType(1),
				new SBuyMethod(
						new SPrice(25), 1),
				new SDifficulty(3),
				new SLifeTime(3),
				new SGameStyle("Visual Novels"),
				new SStoryType(),
				new SGameSupport(construct1, name1, Type1),
				new SAccessory(null, null, null)
			);
		cal1.set(2012,5,0,0,0);
		String[] construct =  {"Nintendo", "Nintendo"," Microsoft","Apple"};
		String[] name = {"WiiU", "Wii", "Xbox360", "Mac"};
		String[] Type = {"ConsoleSalon","ConsoleSalon","ConsoleSalon", "PC"};
		s[4] = new Supply(
				new STitle("Guild Guild Wars 2"), 
				new SDescription("Meilleur jeu de l'année"), 
				new SEditor("AreaNet"), 
			    new SMark(16),
			    new SReleaseDate(cal1),
				new SGameType(0),
				new SBuyMethod(
						new SPrice(45), 1),
				new SDifficulty(2),
				new SLifeTime(2),
				new SGameStyle("MMORPG"),
				new SStoryType("Horreur", "Aventure"),
				new SGameSupport(construct, name, Type),
				new SAccessory(new String[] {"Nintendo", "Nintendo"," Microsoft"}, new String[] {"WiiMote","GamePad","Xbox360"}, new String[]{"Manette", "Manette", "Manette"})
			);
		Comparator c = new Comparator(s, 5, d);
		c.compare();
		c.afficherScore();
	}
}
