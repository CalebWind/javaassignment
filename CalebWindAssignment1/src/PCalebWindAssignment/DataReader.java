package PCalebWindAssignment;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * This class reads in the data from the CSV file using the Buffered Reader function.
 * @author Caleb Wind
 * 
 *
 */
public class DataReader {
	
	public DataReader() {
	}
	
	/**
	 * This is the method that reads in from the CSV file.
	 * @return An ArrayList of Locations 
	 * @throws IOException
	 */
	public ArrayList<Location> readIn() throws IOException
	{
		ArrayList<Location> locations = new ArrayList<Location>();
		
		BufferedReader csvReader = new BufferedReader(new FileReader("temperature.csv"));
		
		String line;
		String locationName;
		
		csvReader.readLine(); //this will skip the first line which has the titles in it
		
		while ((line = csvReader.readLine()) != null)
		{
			String[] values = line.split(",");
			locationName = values[0];
			ArrayList<Double> readinnums = new ArrayList<Double>();
			for (int i = 1; i < 13; i++)
			{
				readinnums.add(Double.valueOf(values[i]));
			}
			
			locations.add(new Location(locationName, readinnums));
		}
		
		return locations;

	}
}
