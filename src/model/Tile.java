package model;

import java.util.ArrayList;

public class Tile {
	private int x, y;
	private String nameOfTile;
	private ArrayList<Unit> unit = new ArrayList<Unit>();
	private ArrayList<Tile> neighbourTile = new ArrayList<Tile>();
	
	public Tile(String nameOfTile, int X, int Y) {
		this.nameOfTile = nameOfTile;
		this.x = X;
		this.y = Y;
	}
	
	public String getTileCoordinates() {
		return Integer.toString(x) + " " + Integer.toString(y);
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