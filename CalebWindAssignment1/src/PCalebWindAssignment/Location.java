package PCalebWindAssignment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class Location implements Comparable<Location>{
	public String locationName; 
	public ArrayList<Double> temperatures;
	
	
	public Location(String locationName, ArrayList<Double> temperatures)
	{
		this.locationName = locationName;
		this.temperatures = temperatures;
	}
	
	
	public ArrayList<Double> getTemperatures()
	{
		return temperatures;
	}
	
	public void setTemperatures(ArrayList<Double> newTemperatures)
	{
		temperatures = newTemperatures;
	}
	
	public String getLocationName()
	{
		return locationName;
	}
	
	public void setLocationName(String newLocationName)
	{
		locationName = newLocationName;
	}
	
	public double calcYearAverage()
	{
		int total = 0;
		
		for (Double temp : temperatures)
		{
			total += temp;
		}
		return total / 12;
	}
	
	@Override
	public String toString()
	{
		return locationName + " " + temperatures.toString();
	}

	@Override
	public int compareTo(Location loc1)
	{
		//setting up natural sort order
		return locationName.compareTo(loc1.getLocationName());
	}
}
