package be.npremont.avaj.interfaces;

import be.npremont.avaj.models.WeatherTower;

public interface Flyable
{
	public abstract void updateConditions();
	public void registerTower(WeatherTower p_tower);
}
