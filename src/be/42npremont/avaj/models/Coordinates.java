package be.42npremont.avaj.models;

public class Coordinates
{
	private int longitude;
	private int latitude;
	private int height;

	public Coordinates(int longitude, int latitude, int height)
	{
		this.longitude = longitude;
		this.latitude = latitude;
		this.height = height;
	}

	public getLongitude()
	{
		return longitude;
	}

	public getLatitude()
	{
		return latitude;
	}
	
	public getHeight()
	{
		return height;
	}
}
