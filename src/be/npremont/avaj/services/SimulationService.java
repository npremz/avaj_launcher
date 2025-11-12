package be.npremont.avaj.services;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import be.npremont.avaj.exceptions.*;
import be.npremont.avaj.interfaces.Flyable;
import be.npremont.avaj.models.Coordinates;
import be.npremont.avaj.models.WeatherTower;

public class SimulationService
{
	private AircraftFactory factory;
	private WeatherTower w_tower;
	private List<Flyable> l_flyables;

	public SimulationService()
	{
		this.factory = AircraftFactory.getInstance();
		this.w_tower = new WeatherTower();
		this.l_flyables = new ArrayList<>();
	}

	public void run(String src_file)
		throws IOException, InvalidCoordinatesException, InvalidFormatException,
			InvalidScenarioException, IllegalArgumentException
	{
		List<String> lines = readFile(src_file);
		if (lines.isEmpty())
			throw new InvalidScenarioException("Scenario file is empty.");

		int iterations = Integer.parseInt(lines.get(0).trim());
		if (iterations <= 0)
			throw new InvalidScenarioException("The number of iterations must be positive");

		for (int i = 1; i < lines.size(); i++)
		{
			createAircraft(lines.get(i));
		}

		for (int i = 0; i < iterations; i++)
		{
			w_tower.ChangeWeather();
		}
	}

	private void createAircraft(String line)
		throws InvalidFormatException, InvalidCoordinatesException,
			IllegalArgumentException
	{
		String[] parts = line.trim().split("\\s+"); // all whitespaces multiple or not
		if (parts.length != 5)
			throw new InvalidFormatException("Invalid format: " + line);

		int longitude = Integer.parseInt(parts[2]);
		int latitude = Integer.parseInt(parts[3]);
		int height = Integer.parseInt(parts[4]);

		if (longitude < 0 || latitude < 0 || height < 0 || height > 100)
			throw new InvalidCoordinatesException("Invalid coordinates: " + line);

		Coordinates coor = new Coordinates(longitude, latitude, height);
		Flyable flyable = factory.newAircraft(parts[0], parts[1], coor);
		flyable.registerTower(w_tower);
		l_flyables.add(flyable);
	}

	private List<String> readFile(String src_file) throws IOException
	{
		List<String> lines = new ArrayList<>();
		BufferedReader reader = new BufferedReader(new FileReader(src_file));
		String line;

		while ((line = reader.readLine()) != null)
		{
			if (!line.trim().isEmpty())
			{
				lines.add(line);
			}
		}
		reader.close();
		return lines;
	}
}
