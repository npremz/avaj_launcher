package be.npremont.avaj;

import be.npremont.avaj.services.SimulationService;

public class Simulator
{
	public static void main(String[] args)
	{
		if (args.length != 1)
		{
			System.out.println("Error: this program takes one .txt file as argument.");
			System.out.println("Usage: java Simulation <arg.txt>");
			return;
		}

		String src_file = args[0];

		try
		{
			SimulationService simulation = new SimulationService();
			simulation.run(src_file);
		}
		catch (Exception e)
		{
			System.out.println("Error: " + e.getMessage());
		}
	}
}
