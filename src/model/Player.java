package model;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents a player object and its properties
 */
public class Player {
    /**
     * @param name        represents player's name
     * @param currentTile shows tiles that are owned by current player.
     * @param asset       represents players possession or unit. For instance, in
     * monopoly it is money and in Risk it is Army/Troops.
     * @param score       is an object of Score class.
     * @param cardList    stores list of cards player posseses.
     */

    private String name;
    private ArrayList<Tile> currentTile;
    private ArrayList<Unit> asset;
    Score score;


    /**
     * Card List
     */
    private List<Card> cardList = new ArrayList<Card>();

    public Player(String name, Unit[] units, Score score) {
        this.name = name;
        this.asset = new ArrayList<>();
        for (Unit unit : units) {
            Unit u = new Unit(unit.getUnitType());
            this.asset.add(u);
        }
        this.score = score;
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
     * @param bal  is the description of the unit that a user want to fetch that is
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
        for (Unit u : this.asset) {
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
            for (Unit u : this.asset) {
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
     * @param is a type of unit that we want to store as a player possession
     * @return amount or balance associated with this player
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
     * @param diceNumber is a current dice number player got
     * @param current    tile is the starting or current position of this player
     */
    public void updateCurrentTile(int diceNumber, Tile currentTile) {
        this.currentTile.add(currentTile);

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

}