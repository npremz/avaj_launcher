package be.npremont.avaj.models;

public class Aircraft
{
	protected long			id;
	protected String		name;
	protected Coordinates	coor;

	private int id_count = 0;

	protected Aircraft(String p_name, Coordinates p_coor)
	{
		this.id = getNextId();
		this.name = p_name;
		this.coor = p_coor;
	}

	private int getNextId()
	{
		return id_count++;
	}
}
