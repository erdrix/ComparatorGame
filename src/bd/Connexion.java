package bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.TreeMap;


public class Connexion {
	
	private String DBPath= ".\\src\\bd\\VideoComparator.db";
	private Connection connection = null;
	private Statement statement = null;
	
	public void connect()
	{
		try{
			Class.forName("org.sqlite.JDBC");
			connection = DriverManager.getConnection("jdbc:sqlite:"+DBPath);
			statement = connection.createStatement();
			System.out.println("Connexion a"+DBPath+" avec succès");	
		}catch(ClassNotFoundException e)
		{
			e.printStackTrace();
			System.out.println("Erreur de connexion : "+e);
		}catch(SQLException e)
		{
			e.printStackTrace();
			System.out.println("Erreur de connexion : "+e);
		}
	}
	
	public void close(){
		try{
			connection.close();
		}catch(SQLException e)
		{
			e.printStackTrace();
			System.out.println("Erreur de connexion : "+e);
		}
	}
	
	public ResultSet query(String request)
	{
		ResultSet resultat = null;
		try{
			resultat = statement.executeQuery(request);
		}catch(SQLException e){
			e.printStackTrace();
			System.out.println("Erreur de requête : "+e);
		}
		
		return resultat;
	}
	
	public String getEditorById(int id)
	{
		ResultSet res = query("SELECT nom FROM Editors WHERE idEditeur ="+id);
		String name = "";
		try {
			while(res.next())
			{
				name = res.getString("nomEditeur");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return name;
	}
	
	public ArrayList<TreeMap<String, String>> getAccessories()
	{
		ArrayList<TreeMap<String, String>> retour = new ArrayList<>();
		ResultSet res = query("SELECT * FROM Accessories INNER JOIN Editors ON numEditeur=idEditeur");
		int nbColonnes = 0;
		
		
		try {
			ResultSetMetaData metadata = res.getMetaData();
			nbColonnes = metadata.getColumnCount();
			
			while(res.next())
			{
				TreeMap<String, String> current= new TreeMap<>();
				// Pour chaque colonnes présentes dans la table accessoire.
				for(int i=1; i <= nbColonnes; i++)
				{
					if(!metadata.getColumnName(i).equals("idAccessoire"))
						if(!metadata.getColumnName(i).equals("idEditeur") && !metadata.getColumnName(i).equals("numEditeur"))
							current.put(metadata.getColumnName(i), res.getString(i));
				}
				retour.add(current);
			}
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return retour;
	}
	
	public ArrayList<TreeMap<String, String>> getSupports()
	{
		ArrayList<TreeMap<String, String>> retour = new ArrayList<>();
		ResultSet res = query("SELECT * FROM Supports INNER JOIN Editors ON numEditeur=idEditeur");
		int nbColonnes = 0;
		
		
		try {
			ResultSetMetaData metadata = res.getMetaData();
			nbColonnes = metadata.getColumnCount();
			
			while(res.next())
			{
				TreeMap<String, String> current= new TreeMap<>();
				// Pour chaque colonnes présentes dans la table accessoire.
				for(int i=1; i <= nbColonnes; i++)
				{
					if(!metadata.getColumnName(i).equals("idSupport"))
						if(!metadata.getColumnName(i).equals("idEditeur") && !metadata.getColumnName(i).equals("numEditeur"))
							current.put(metadata.getColumnName(i), res.getString(i));
				}
				retour.add(current);
			}
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return retour;
	}
	/*public Supply[] getSupply()
	{
		ResultSet supp = query("SELECT * FROM Supplies");
		try{
			while(supp.next())
			{
				
				
				//System.out.println("Id : "+ res.getString("idAccess")+" | type : "+res.getString("type")+" | numEditeur : "+res.getString("numEditeur")+" | nom : "+res.getString("nom"));
			}
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
	}*/
	
	//public get
}