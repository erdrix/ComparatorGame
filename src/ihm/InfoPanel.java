package ihm;

import java.lang.reflect.Field;
import java.util.TreeMap;

import javax.swing.JPanel;

public class InfoPanel extends JPanel{
	protected static Field[] field;
	protected static String[] fname_array;
	protected static TreeMap<String, Object> criterions_list;

	private static final long serialVersionUID = 1L;
	public InfoPanel(String[] criterions){
		// R�cup�ration du nom de chaque attribut
			try {
				field = Class.forName("demand.Demand").getDeclaredFields();
				fname_array = new String[field.length];
				criterions_list = new TreeMap<>();
				int i = 0;
				for(Field f : field){
					String[] temp = f.getType().toString().split("demand.");
					temp = temp[1].split(";");
					fname_array[i] = temp[0];
					i++;
				}
				for(i = 0; i < criterions.length; i++ ){
					for(int j = 0; j < fname_array.length; j++){
						if(criterions[i].equals(fname_array[j])) System.out.println(criterions[i]+"!");
					}
				}				
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			setCriterions_List();
	}
	
	public void setCriterions_List(){
		for(int i = 0; i < fname_array.length; i++){
			if(fname_array[i].equals("DTitle") || fname_array[i].equals("DDescription") || fname_array[i].equals("DEditor"))
				criterions_list.put(fname_array[i], "KeywordPanel");
			if(fname_array[i].equals("DLifeTIme") || fname_array[i].equals("DDifficulty"))
				criterions_list.put(fname_array[i], "EcartPanel");
			if(fname_array[i].equals("DMark") || fname_array[i].equals("DPrice") || fname_array[i].equals("DReleaseDate"))
				criterions_list.put(fname_array[i], "IntervallePanel");
			if(fname_array[i].equals("DBuyMethod") || fname_array[i].equals("DGameType"))
				criterions_list.put(fname_array[i], "BinaryPanel");
			if(fname_array[i].equals("DAccessory") || fname_array[i].equals("DStoryType") || fname_array[i].equals("DGameSupport"))
				criterions_list.put(fname_array[i], "MultiplePanel");
			if(fname_array[i].equals("DGameStyle"))
					criterions_list.put(fname_array[i], "StylePanel");
		}
	}
}
