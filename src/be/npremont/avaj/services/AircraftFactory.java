package be.npremont.avaj.services;

import be.npremont.avaj.models.Coordinates;
import be.npremont.avaj.models.JetPlane;
import be.npremont.avaj.models.Baloon;
import be.npremont.avaj.models.Helicopter;
import be.npremont.avaj.interfaces.Flyable;

public class AircraftFactory
{
	private static AircraftFactory instance;

	private AircraftFactory()
	{}

	public static AircraftFactory getInstance()
	{
		if (instance == null)
		{
			instance = new AircraftFactory();
		}
		return instance;
	}

	public Flyable newAircraft(String p_type, String p_name, Coordinates p_coordinates)
		throws IllegalArgumentException
	{
		switch (p_type) {
			case "Baloon":
				return new Baloon(p_name, p_coordinates);
			case "JetPlane":
				return new JetPlane(p_name, p_coordinates);
			case "Helicopter":
				return new Helicopter(p_name, p_coordinates);
			default:
				throw new IllegalArgumentException("Unknown aircraft type: " + p_type);
		}
	}
}
