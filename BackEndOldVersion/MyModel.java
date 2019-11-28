
package BackEnd;
import java.util.ArrayList;

public class MyModel {
	private ArrayList<String> names;
	
	public MyModel()
	{
		names = new ArrayList<>();
	}
	/**
	 * Accessor that returns all the names 
	 * @return
	 */
	public String nameList()
	{
		String a= "";
		for(int i =0; i < names.size(); i++)
		{
			a = a + names.get(i) + "\n"; 
		}
		return a;
	}
	/**
	 * Mutator 
	 * @param newName 
	 */
	public void addName(String newName)
	{
		names.add(newName);
	}
}
