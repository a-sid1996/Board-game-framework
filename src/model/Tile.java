package model;

import java.util.ArrayList;
import java.util.HashMap;

public class Tile {

    /**
     * @param int x and y  are the coordinates of tile on the board
     * @param nameofTile defines tile name
     * @param internalValue stores amount associated with specific tile.
     * @param unit is any object that can be associated with current tile.For instance, Money, house, hotel etc.
     * @param neighbourTile stores neighbor tiles of the current tile.
     * @param playerlog monitors players activity on current tile such as how many times player has been to this tile.
     * @param CurrentPlayer defines current player who has landed on this tile.
     * @param mainPlayer is the player who owns this tile.
     */
	
    private int x, y;
    private String nameOfTile;
    private HashMap<String, Integer> internalValue = new HashMap<String, Integer>();
    private ArrayList<Unit> unit = new ArrayList<Unit>();
    private ArrayList<Tile> neighbourTile = new ArrayList<Tile>();
    private HashMap<String, Integer> playerLog;
    private Player currentPlayer;
    private String mainPlayer;
    
    

    /**
     * @param nameOfTile is a unique name assigned to current tile
     * @param x          is the x coordinate of the current tile
     * @param y          is the y coordinate of the current tile
     */
    public Tile(String nameOfTile, int X, int Y) {
        this.nameOfTile = nameOfTile;
        this.x = X;
        this.y = Y;
    }

    /**
     * @return is coordiantes of the current tile in the plane
     */
    public String getTileCoordinates() {
        return Integer.toString(x) + " " + Integer.toString(y);
    }

    public void setValue(String key, int value) {
        this.internalValue.put(key, value);
    }

    /**
     * @return is internal value associated with current tile
     */
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
    public String getMainPlayer() {
        return this.mainPlayer;
    }

    public void setMainPlayer(String playerName) {
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


}