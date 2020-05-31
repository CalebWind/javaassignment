// Caleb Wind
// TO DO:
//java docs

package PCalebWindAssignment;

import java.io.IOException;
import java.util.ArrayList;

/**
 * This class is the main class and used the DataReader class to read in the data and the GUI class to create the User Interface
 * @author Caleb Wind
 */
public class mainApp
{
	public static ArrayList<Location> locations = new ArrayList<Location>();
	
	/**
	 * This is the main class for the main app class.
	 * @param args
	 * @throws IOException
	 * 
	 */
	public static void main(String[] args) throws IOException
	{
		DataReader dr = new DataReader();
		locations = dr.readIn();
		GUI gui = new GUI(locations);
		gui.setVisible(true);
	}
	
}