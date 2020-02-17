package model;

import java.util.ArrayList;
import java.util.HashMap;

public class Tile {
	private int x, y;
	private String nameOfTile;
	private HashMap<String, Integer> internalValue;
	private ArrayList<Unit> unit = new ArrayList<Unit>();
	private ArrayList<Tile> neighbourTile = new ArrayList<Tile>();
	private HashMap<String, Integer> playerLog;
	private Player currentPlayer;
	private String mainPlayer;
	
	public Tile(String nameOfTile, int X, int Y) {
		this.nameOfTile = nameOfTile;
		this.x = X;
		this.y = Y;
	}
	
	public String getTileCoordinates() {
		return Integer.toString(x) + " " + Integer.toString(y);
	}
	
	public void setValue(String key, int value) {
		this.internalValue.put(key, value);
	}
	
	public int getValue(String key) {
		return internalValue.get(key);
	}
	
	public void setPlayer(Player player) {
		
		this.currentPlayer = player;
		if ( this.playerLog.containsKey(player.getName()) ) {
			int temp = playerLog.get(player.getName());
			playerLog.put(player.getName(), temp+1);
		} else {
			playerLog.put(player.getName(), 1);
		}

	}
	
	public String getMainPlayer() {
		return this.mainPlayer;
	}
	
	public void setMainPlayer(String playerName) {
		this.mainPlayer = playerName;
	}
	
	public Player getPlayer() {
		return currentPlayer;
	}
	
	public String getTileName() {
		return nameOfTile;
	}
	
	public void setTileName(String nameOfTile) {
		this.nameOfTile = nameOfTile;
	}
	
	public void addUnit(Unit unit) {
		this.unit.add(unit);
	}
	
	public void removeUnit(Unit unit) {
		this.unit.remove(unit);
	}
	
	public ArrayList<Unit> getUnits() {
		return this.unit;
	}
	
	public void setTileCoordinates(String coordinates) {
		String[] coo = coordinates.split(" ");
		this.x = Integer.valueOf(coo[0]);
		this.y = Integer.valueOf(coo[1]);
	}
	
	public ArrayList<String> getNeighbours() {
		ArrayList<String> temp = new ArrayList<String>();
		for(Tile i : neighbourTile) {
			temp.add(i.nameOfTile);
		}
		return temp;
	}
	
	public void addNeigbour(Tile tile) {
		neighbourTile.add(tile);
	}
	
	public void removeNeigbour(Tile tile) {
		neighbourTile.remove(tile);
	}
	
	
}