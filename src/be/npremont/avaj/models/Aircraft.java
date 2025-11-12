package be.npremont.avaj.models;

public class Aircraft
{
	protected long			id;
	protected String		name;
	protected Coordinates	coor;

	private static long id_count = 0;

	protected Aircraft(String p_name, Coordinates p_coor)
	{
		this.id = id_count++;
		this.name = p_name;
		this.coor = p_coor;
	}
}
