package be.npremont.avaj.models;

import be.npremont.avaj.interfaces.Flyable;

public class Helicopter extends Aircraft implements Flyable
{
	private WeatherTower w_tower;

	public Helicopter(String p_name, Coordinates p_coordinates)
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
			System.out.println(this + ": This is hot.");
			new_longitude += 10;
			new_height += 2;
			if (new_height > 100)
				new_height = 100;
		}
		else if (weather == "RAIN")
		{
			System.out.println(this + ": It's raining. Better watch out for lightings");
			new_longitude += 5;
		}
		else if (weather == "FOG")
		{
			System.out.println(this + ": The fog is reducing visibility.");
			new_longitude += 1;
		}
		else if (weather == "SNOW")
		{
			System.out.println(this + ": My rotor is going to freeze");
			new_height -= 12;
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
		return "Helicopter#" + name + "(" + id + ")";
	}
}
