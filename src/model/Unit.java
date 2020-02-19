package model;

import java.util.HashMap;

public class Unit {

	private String name;
	private int amount;
	private HashMap<String, String> property;
	
	public Unit(String name) {
		this.name = name;
	}
	
	public int getAmount() {
		return this.amount;
	}
	
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public HashMap<String, String> getProperty() {
		return this.property;
	}
	
	public void setProperty(String key, String property) {
		this.property.put(key, property);
	}
	
}
