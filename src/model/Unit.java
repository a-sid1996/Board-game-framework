package model;

import java.util.HashMap;
/**
 * This method class represents units characteristics, like movement types, life, price, etc. 
 */
public class Unit {

	/**
	 * @param name is a name of the unit
	 * @param amount is any value associated with the Unit
	 * @param property stores unit type and its unique property such as House, Hotel
	 * @param Tile is a tile associated with current unit
	 */
	private String name;
	private int amount;
	private HashMap<String, String> property;
	private Tile tile;
	
	/**
	 * @param is a name of the unit
	 */
	public Unit(String name) {
		this.name = name;
		this.property = new HashMap<>();
	}
	
	/**
	 * @return is a tile on which this unit is located
	 */
	public Tile getTile() {
		return this.tile;
	}
	
	public void setTile(Tile tile) {
		this.tile = tile;
	}
	
	/**
	 * @return is an amount associated with this unit
	 */
	public int getAmount() {
		return this.amount;
	}
	
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	/**
	 * @return is a name of the unit
	 */
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * @return is a map that stores unit type and its unique property such as House, Hotel
	 */
	public HashMap<String, String> getProperty() {
		return this.property;
	}
	
	public void setProperty(String key, String property) 
	{
		this.property.put(key, property);
	}

	public void clearProp() {
		// TODO Auto-generated method stub
		this.property.clear();
	}
	
}
