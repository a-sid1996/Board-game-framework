package model;

import java.util.HashMap;

/**
 * This method class represents units characteristics, like movement types, life, price, etc.
 */
public class Unit {
    public enum UnitType {
        PROPERTY("property"), HOTEL("hotel"), MONEY("money");

        public String unitType;

        UnitType(String unitType) {
            this.unitType = unitType;
        }

        @Override
        public String toString() {
            return unitType;
        }
    }

    /**
     * @param name is a name of the unit
     * @param amount is any value associated with the Unit
     * @param property stores unit type and its unique property such as House, Hotel
     * @param Tile is a tile associated with current unit
     */
    private String unitType;
    private int amount;
    private HashMap<String, String> property;
    private Tile tile;

    /**
     * @param unitType is a name of the unit
     * @param tile unit type
     */
    public Unit(String unitType, Tile tile) {
        this.unitType = unitType;
        this.property = new HashMap<>();
        this.tile = tile;
    }

    public Unit(String unitType, int amount) {
        this.unitType = unitType;
        this.property = new HashMap<>();
        this.amount = amount;
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
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    /**
     * @return is a type of the unit
     */
    public String getUnitType() {
        return this.unitType;
    }

    public void setUnitType(String unitType) {
        this.unitType = unitType;
    }

    /**
     * @return is a map that stores unit type and its unique property such as House, Hotel
     */
    public HashMap<String, String> getProperty() {
        return this.property;
    }

    public void setProperty(String key, String property) {
        this.property.put(key, property);
    }

    public void clearProp() {
        // TODO Auto-generated method stub
        this.property.clear();
    }
}
