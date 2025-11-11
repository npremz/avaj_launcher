package be.npremont.avaj.services;

import be.npremont.avaj.models.Coordinates;

public class WeatherProvider
{
	private static WeatherProvider	instance;
	private String[]				weathers;

	private WeatherProvider()
	{
		this.weathers = new String[]{"RAIN", "FOG", "SUN", "SNOW"};
	}

	public static WeatherProvider getInstance()
	{
		if (instance == null)
		{
			instance = new WeatherProvider();
		}
		return instance;
	}
	
	public String getCurrentWeather(Coordinates p_coordinates)
	{
		int longitude = p_coordinates.getLongitude();
		int latitude = p_coordinates.getLatitude();
		int height = p_coordinates.getHeight();

		int seed = (longitude + latitude + height) * 19 / 42;
		return weathers[Math.abs(seed) % weathers.length];
	}
}
