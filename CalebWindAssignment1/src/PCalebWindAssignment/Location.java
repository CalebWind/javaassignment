package PCalebWindAssignment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class Location {
	public String locationName; 
	public ArrayList<Double> temperatures;
	
	public Double yearAverage;
	
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
	
	public Double getYearAverage()
	{
		return yearAverage;
	}
	
	public void setYearAverage(Double newYearAverage)
	{
		yearAverage = newYearAverage;
	}
	
	@Override
	public String toString()
	{
		return locationName + " " + temperatures.toString();
	}
	
	
	public int compareTo(Location f1)
	{
		//set up natural sort order
		
		if(locationName.equals(f1.getLocationName()))
		{
			return locationName.compareTo(f1.getLocationName());
		}
		else
		{
			return locationName.compareTo(f1.getLocationName());
		}
	}
}
