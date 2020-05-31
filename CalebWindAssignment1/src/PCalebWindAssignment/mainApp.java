// Caleb Wind
// TO DO:
// sorting and searching

package PCalebWindAssignment;

import java.io.IOException;
import java.util.ArrayList;

public class mainApp
{
	public static ArrayList<Location> locations = new ArrayList<Location>();
	
	public static void main(String[] args) throws IOException
	{
		DataReader dr = new DataReader();
		locations = dr.readIn();
		GUI gui = new GUI(locations);
		gui.setVisible(true);
	}
	
}


