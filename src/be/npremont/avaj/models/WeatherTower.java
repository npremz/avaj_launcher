package be.npremont.avaj.models;

import be.npremont.avaj.services.WeatherProvider;

public class WeatherTower extends Tower
{
	public String	getWeather(Coordinates p_coordinates)
	{
		WeatherProvider instance = WeatherProvider.getInstance();
		return instance.getCurrentWeather(p_coordinates);
	}

	public void		ChangeWeather()
	{
		conditionsChanged();
	}
}
