package model;

import controller.Strategy;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * This class represents a player object and its properties
 */
public class Player implements Serializable {
    private static final long serialVersionUID = 123L;
    private String name;
    private ArrayList<Tile> currentTile;
    private ArrayList<Unit> asset;
    private Score score;
    private String playerType;

    private List<Card> cardList = new ArrayList<Card>();

    public Player(String name, Unit[] units, Score score, ArrayList<Tile> currentTile) {
        this.name = name;
        this.asset = new ArrayList<>();
        for (Unit unit : units) {
            this.asset.add(unit);
        }
        this.score = score;
        this.currentTile = currentTile;
    }

    public Player(String name, Unit[] units, Score score, ArrayList<Tile> currentTile, String playerType) {
        this.name = name;
        this.asset = new ArrayList<>();
        for (Unit unit : units) {
            this.asset.add(unit);
        }
        this.score = score;
        this.currentTile = currentTile;
        this.playerType = playerType;
    }

    /**
     * @return is a name of the player
     */
    public String getName() {
        return name;
    }


    /**
     * This method sets the name of the player when a new player object is created
     * and at the same time updates the final score module
     *
     * @param name is a name of the player
     */
    public void setName(String name) {
        this.name = name;
        if (!score.PlayerName.containsKey(this)) {
            score.PlayerName.put(this, name);
        }
    }

    /**
     * It will return Unit on a this tile
     *
     * @param unitType is the description of the unit that a user want to fetch that is
     *             on current tile
     * @param tile is the tile owned by a player
     * @return returns asset or a unit owned by the current player on a tile passed
     */
    public Unit getAsset(String unitType, Tile tile) {
        for (Unit u : this.asset) {
            if (u.getUnitType().equalsIgnoreCase(unitType) && u.getTile() == tile) {
                return u;
            }
        }
        return null;
    }

    public ArrayList<Unit> getAssetList(String unitType) {
        ArrayList<Unit> temp = new ArrayList<>();
        for (Unit u : asset) {
            if (u.getUnitType().equalsIgnoreCase(unitType)) {
                temp.add(u);
            }
        }
        return temp;
    }

    /**
     * deductMoney deducts balance from a player's possession
     *
     * @param amount money that needs to be deducted
     * @return returns true if the amount is deducted
     */
    public boolean deductMoney(int amount) {
        if (amount >= 0) {
            for (Unit u : this.asset) {
                if (u.getUnitType().equalsIgnoreCase(Unit.UnitType.MONEY.toString())) {
                    if (u.getAmount() >= amount) {
                        u.setAmount(u.getAmount() - amount);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * addMoney adds balance to a player's possession
     *
     * @param amount money that needs to be added
     * @return returns true if the amount is added
     */
    public boolean addMoney(int amount) {
        if (amount >= 0) {
            for (Unit u : asset) {
                if (u.getUnitType().equalsIgnoreCase(Unit.UnitType.MONEY.toString())) {
                    u.setAmount(u.getAmount() + amount);
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * setMoney sets balance possessed by the current user
     *
     * @param amt money that a current player should possess
     */
    public void setMoney(int amt) {
        for (Unit u : this.asset) {
            if (u.getUnitType().equalsIgnoreCase(Unit.UnitType.MONEY.toString())) {
                u.setAmount(amt);
            }
        }
    }

    /**
     * getMoney returns balance of the current player
     *
     * @return amount or balance associated with this player
     */
    public int getMoney() {
        for (Unit u : this.asset) {
            if (u.getUnitType().equalsIgnoreCase(Unit.UnitType.MONEY.toString())) {
                return u.getAmount();
            }
        }
        return -1;
    }

    /**
     * setAsset sets assets possessed by current player such as plot, money, hotel
     * or any other unit
     *
     * @param balance is a type of unit that we want to store as a player possession
     */
    public void setAsset(Unit balance) {

        this.asset.add(balance);
        this.score.PlayerBalance.put(this, this.asset);

//        if (!this.score.PlayerBalance.containsKey(this)) {
//        } else {
//            this.score.PlayerBalance.put(this, this.asset);
//        }

    }

    /**
     * @return returns currentTile of current player
     */
    public ArrayList<Tile> getCurrentTile() {
        return currentTile;
    }

    public void removeCurrentTile(Tile currentTile) {
        if (this.currentTile.contains(currentTile)) {
            this.currentTile.remove(currentTile);
        }
    }

    /**
     * This method will be called after player will make a move and lands on a tile
     * other than its current tile It will simultaneously update score module
     *
     * @param currentTile tile is the starting or current position of this player
     * @param i is the index
     */
    public void updateCurrentTile(Tile currentTile, int i) {
    	if(i == 0) {
            this.currentTile.add(currentTile);
    	} else {
            this.currentTile.add(0, currentTile);
    	}
        if (!score.PlayerCurrentPosition.containsKey(this)) {
            score.PlayerCurrentPosition.put(this, this.currentTile);
        } else {
            score.PlayerCurrentPosition.put(this, this.currentTile);
        }
    }


    /**
     * @return returns list of cards possessed by current player
     */
    public List<Card> getCardList() {
        return this.cardList;
    }


    /**
     * @param card is card purchased by a player and has to added in players possession of cards
     */
    public void setCardList(Card card) {
        this.cardList.add(card);
        if (!score.PlayerCards.containsKey(this)) {
            score.PlayerCards.put(this, cardList);
        } else {
            score.PlayerCards.put(this, cardList);
        }

    }

    public String getPlayerType() {
        return playerType;
    }

    public void setPlayerType(String playerType) {
        this.playerType = playerType;
    }
}