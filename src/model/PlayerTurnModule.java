package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PlayerTurnModule<Player> implements Serializable {

	private int turnOfPlayer = 0;
	private ArrayList<Player> list;

	public PlayerTurnModule(ArrayList<Player> list) {
		this.list = list;
		turnOfPlayer = 0;
	}

	/**
	 * @return is a player object whose turn is next 
	 */
	public Player next() {
		turnOfPlayer = (turnOfPlayer + 1) % list.size();
		return list.get(turnOfPlayer);
	}

	/**
	 * @param item is an object of player whose turn has to be skipped
	 * @return is a player object after skipping an initial turn
	 */
	public Player update(Player item) 
	{
		/*Player p = null;
		while (iterator.hasNext()) {
			p = iterator.next();
			if (item.equals(p)) {	
				break;
			}
		}*/
		return null;
	}

	/**
	 * @return is a list of players
	 */
	public List<Player> getList() {
		return list;
	}

	public void setList(ArrayList<Player> list) {
		turnOfPlayer--;
		this.list = list;
	}
}
