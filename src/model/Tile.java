package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class Tile implements Serializable {

    private int x, y;
    private String nameOfTile;
    private String type;
    private HashMap<String, Integer> internalValue = new HashMap<String, Integer>();
    private ArrayList<Unit> unit = new ArrayList<Unit>();
    private ArrayList<Tile> neighbourTile = new ArrayList<Tile>();
    private HashMap<String, Integer> playerLog;
    private Player currentPlayer;
    private Player mainPlayer;


    /**
     * @param nameOfTile is a unique name assigned to current tile
     * @param X          is the x coordinate of the current tile
     * @param Y          is the y coordinate of the current tile
     * @param type       tile type
     */
    public Tile(String nameOfTile, int X, int Y, String type) {
        this.nameOfTile = nameOfTile;
        this.x = X;
        this.y = Y;
        this.type = type;
        this.mainPlayer = null;
    }

    public Tile() {

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
        if (this.playerLog.containsKey(player.getName())) {
            int temp = playerLog.get(player.getName());
            playerLog.put(player.getName(), temp + 1);
        } else {
            playerLog.put(player.getName(), 1);
        }

    }

    /**
     * @return is a player who owns this tile
     */
    public Player getMainPlayer() {
        return this.mainPlayer;
    }

    public void setMainPlayer(Player playerName) {
        this.mainPlayer = playerName;
    }

    /**
     * @return is a player who just landed on current plot
     */
    public Player getPlayer() {
        return currentPlayer;
    }

    /**
     * @return is a name of the tile
     */
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

    /**
     * @return is a list of units associated with current tile
     */
    public ArrayList<Unit> getUnits() {
        return this.unit;
    }

    public void setTileCoordinates(String coordinates) {
        String[] coo = coordinates.split(" ");
        this.x = Integer.valueOf(coo[0]);
        this.y = Integer.valueOf(coo[1]);
    }

    /**
     * @return is a list of all the neighbours of the current tile
     */
    public ArrayList<Tile> getNeighbours() {
        return neighbourTile;
    }

    public void addNeigbour(Tile tile) {
        neighbourTile.add(tile);
    }

    public void removeNeigbour(Tile tile) {
        neighbourTile.remove(tile);
    }

    public String getType() {
        return type;
    }

    public HashMap<String, Integer> getInternalValue() {
        return internalValue;
    }

}