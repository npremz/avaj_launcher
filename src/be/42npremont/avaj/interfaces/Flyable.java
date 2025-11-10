package be.42npremont.avaj.interfaces;

import be.42npremont.avaj.models;

public interface Flyable
{
	public abstract void updateConditions();
	public void registerTower(WeatherTower p_tower);
}
