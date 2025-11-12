package be.npremont.avaj.models;

import be.npremont.avaj.interfaces.Flyable;

public class Baloon extends Aircraft implements Flyable
{
	private WeatherTower w_tower;

	public Baloon(String p_name, Coordinates p_coordinates)
	{
		super(p_name, p_coordinates);
	}

	@Override
	public void registerTower(WeatherTower weather_tower)
	{
		this.w_tower = weather_tower;
		weather_tower.register(this);
	}

	@Override
	public void updateConditions()
	{
		String weather = w_tower.getWeather(coor);

		int new_longitude = coor.getLongitude();
		int new_latitude = coor.getLatitude();
		int new_height = coor.getHeight();

		if (weather == "SUN")
		{
			System.out.println(this + ": Let's enjoy the good weather and take some pics.");
			new_longitude += 2;
			new_height += 4;
			if (new_height > 100)
				new_height = 100;
		}
		else if (weather == "RAIN")
		{
			System.out.println(this + ": Damn you rain! You messed up my balloon.");
			new_height -= 5;
		}
		else if (weather == "FOG")
		{
			System.out.println(this + ": The fog is reducing visibility.");
			new_height -= 3;
		}
		else if (weather == "SNOW")
		{
			System.out.println(this + ": It's snowing. We're gonna crash.");
			new_height -= 15;
			if (new_height < 0)
				new_height = 0;
		}
		
		coor = new Coordinates(new_longitude, new_latitude, new_height);
		
		if (coor.getHeight() == 0)
		{
			System.out.println(this + " landing.");
			w_tower.unregister(this);
		}
	}

	@Override
	public String toString()
	{
		return "Baloon#" + name + "(" + id + ")";
	}
}
