package model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PlayerTurnModule<Player> 
{

	/**
	 * @param iterator object to iterate over List of players
	 * @param list of players
	 */
	private Iterator<Player>  iterator;
	private ArrayList<Player> list;

	public PlayerTurnModule(ArrayList<Player> list) {
		this.list = list;
		iterator = list.iterator();
	}

	/**
	 * @return is a player object whose turn is next 
	 */
	public Player next() {
		// if we get to the end, start again
		if (!iterator.hasNext()) 
		{
			iterator = list.iterator();
		}
		return iterator.next();
	}

	/**
	 * @param item is an object of player whose turn has to be skipped
	 * @return is a player object after skipping an initial turn
	 */
	public Player update(Player item) 
	{
		Player p = null;
		while (iterator.hasNext()) {
			p = iterator.next();
			if (item.equals(p)) {	
				break;
			}
		}
		return p;
	}

	/**
	 * @return is a list of players
	 */
	public List<Player> getList() {
		return list;
	}

	public void setList(ArrayList<Player> list) {
		this.list = list;
	}
}
