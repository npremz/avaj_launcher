package be.42npremont.avaj.models;

import be.42npremont.avaj.coordinates.Coordinates;

public class Aircraft
{
	protected long			id;
	protected String		name;
	protected Coordinates	coor;

	private id_count = 0

	protected Aircraft(long p_id, String p_name, Coordinates p_coor)
	{
		this.id = getNextId();
		this.name = name;
		this.coor = coor
	}

	private getNextId()
	{
		return id_count++;
	}
}
