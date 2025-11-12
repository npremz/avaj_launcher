package be.npremont.avaj.exceptions;

public class InvalidCoordinatesException extends Exception
{
	public InvalidCoordinatesException(String error_msg)
	{
		super(error_msg);
	}
}
