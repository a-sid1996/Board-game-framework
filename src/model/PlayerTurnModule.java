package model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PlayerTurnModule<Player> {

	/** Iterator for list. */
	private Iterator<Player> iterator;

	/** Generic list. */
	private ArrayList<Player> list;

	public PlayerTurnModule(ArrayList<Player> list) {
		this.list = list;
		iterator = list.iterator();
	}

	public Player next() {
		// if we get to the end, start again
		if (!iterator.hasNext()) {
			iterator = list.iterator();
		}
		return iterator.next();
	}

	public Player update(Player item) {
		Player p = null;
		while (iterator.hasNext()) {
			p = iterator.next();
			if (item.equals(p)) {
				break;
			}
		}
		return p;
	}

	public List<Player> getList() {
		return list;
	}

	public void setList(ArrayList<Player> list) {
		this.list = list;
	}
}
