package PCalebWindAssignment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


/**
 * 
 * This is the class that stores the name of the town and the temperatures for each month.
 * @author Caleb Wind
 * 
 * 
 * @param locationName This is the name of the town.
 * @param temperatures This is the ArrayList that stores a series of doubles, one for each of the months in the year.
 * 
 *
 */
public class Location implements Comparable<Location>{
	public String locationName; 
	public ArrayList<Double> temperatures;
	public double yearAverage;
	
	
	/**
	 * This is the method that constructs the location.
	 * @param locationName This is the name of the town.
	 * @param temperatures This is the ArrayList that stores a series of doubles, one for each of the months in the year.
	 */
	public Location(String locationName, ArrayList<Double> temperatures)
	{
		this.locationName = locationName;
		this.temperatures = temperatures;
	}
	
	
	/**
	 * This is the method that returns the temperatures.
	 * @return the temperatures.
	 */
	public ArrayList<Double> getTemperatures()
	{
		return temperatures;
	}
	
	/**
	 * This is the method used to update the temperatures.
	 * @param newTemperatures The set of temperatures that can be input to update the list.
	 */
	public void setTemperatures(ArrayList<Double> newTemperatures)
	{
		temperatures = newTemperatures;
	}
	
	/**
	 * This is the method that returns the name of the town.
	 * @return The location name.
	 */
	public String getLocationName()
	{
		return locationName;
	}
	
	/**
	 * This method is used to update the year average.
	 * @param newYearAverage The new year average for the location.
	 */
	public void setYearAverage(double newYearAverage)
	{
		yearAverage = newYearAverage;
	}
	
	/**
	 * This method is used to return the year average.
	 * @return The year average.
	 */
	public Double getYearAverage() {
		return yearAverage;
	}
	
	/**
	 * This method is used to update the location name.
	 * @param newLocationName The new name for the location.
	 */
	public void setLocationName(String newLocationName)
	{
		locationName = newLocationName;
	}
	
	/**
	 * This method calculates the year average.
	 * @return The calculated year average.
	 */
	public double calcYearAverage()
	{
		int total = 0;
		
		for (Double temp : temperatures)
		{
			total += temp;
		}
		yearAverage = total / 12;
		return yearAverage;
	}
	
	
	
	/**
	 * This is a method that overrides the ToString function. It will instead format the output a bit more attractively.
	 */
	@Override
	public String toString()
	{
		return locationName + " " + temperatures.toString();
	}

	/**
	 * This method creates a compare to so that the Collections.Sort method can be used.
	 */
	@Override
	public int compareTo(Location loc1)
	{
		//setting up natural sort order
		return locationName.compareTo(loc1.getLocationName());
	}
}
