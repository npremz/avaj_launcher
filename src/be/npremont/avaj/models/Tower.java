package be.npremont.avaj.models;

import java.util.List;
import java.util.ArrayList;
import be.npremont.avaj.interfaces.Flyable;

public class Tower
{
	private	List<Flyable> observers;

	public Tower()
	{
		this.observers = new ArrayList<>();
	}

	public void register(Flyable p_flyable)
	{
		observers.add(p_flyable);
		System.out.println("Tower says: " + p_flyable + "registered to weather tower.");
	}

	public void unregister(Flyable p_flyable)
	{
		observers.remove(p_flyable);
		System.out.println("Tower says: " + p_flyable + "unregistered to weather tower.");
	}

	protected void conditionsChanged()
	{
		List<Flyable> observersCopy = new ArrayList<>(observers);

		for (Flyable flyable : observersCopy)
		{
			flyable.updateConditions();
		}
	}
}
