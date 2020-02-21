package model;

import java.util.ArrayList;
import java.util.List;

public class Player {
    /**
     * @param name        represents player's name
     * @param currentTile shows tiles that are owned by current player.
     * @param Balance     represents players possesion or unit. For instance, in
     * monopoly it is money and in Risk it is Army/Troops.
     * @param score       is an object of Score class.
     * @param cardList    stores list of cards player posseses.
     */

    // Key attribute which holds the name of the player
    private String name;

    // key attribute which holds the current location of the player that is set to 1
    // initially.
    private ArrayList<Tile> currentTile;

    // key attribute which holds the balance of the player that is set to 1500$
    // initially.=
    private ArrayList<Unit> asset;

    // Object of Score class
    Score score;

    // Object of Card
    /**
     * Card List
     */
    private List<Card> cardList = new ArrayList<Card>();

    public Player(String name, Unit[] units) {
        this.name = name;
        this.asset = new ArrayList<>();
        for (Unit unit : units) {
            Unit u = new Unit(unit.getUnitType());
            this.asset.add(u);
        }
    }

    // Getter method to get the name of the player
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        if (!score.PlayerName.containsKey(this)) {
            score.PlayerName.put(this, name);
        }
    }

    /**
     * @return returns balance of current player
     */
    public Unit getAsset(String unitType, Tile tile) {
        for (Unit u : this.asset) {
            if (u.getUnitType().equalsIgnoreCase(unitType) && u.getTile() == tile) {
                return u;
            }
        }
        return null;
    }

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

    public void setMoney(int amt) {
        for (Unit u : this.asset) {
            if (u.getUnitType().equalsIgnoreCase(Unit.UnitType.MONEY.toString())) {
                u.setAmount(amt);
            }
        }
    }

    public int getMoney() {
        for (Unit u : this.asset) {
            if (u.getUnitType().equalsIgnoreCase(Unit.UnitType.MONEY.toString())) {
                return u.getAmount();
            }
        }
        return -1;
    }

    // Setter method to set the balance of the player
    public void setAsset(Unit balance) {

        this.asset.add(balance);

        if (!score.PlayerBalance.containsKey(this)) {
            // score.PlayerBalance.put(this, balance);
        } else {
            score.PlayerBalance.put(this, this.asset);
        }

    }

    /**
     * @return returns currentTile of current player
     */
    public ArrayList<Tile> getCurrentTile() {
        return currentTile;
    }

    // This method updates the location of the player based on the number rolled by
    // him.
    public void updateCurrentTile(int diceNumber, Tile currentTile) {
        /* Logic of set plot needs to be changed */
        /*
         * if(Math.abs(currentPlot+diceNumber)>24) currentPlot=
         * (Math.abs(currentPlot+diceNumber))%24; else
         * currentPlot=Math.abs(currentPlot+diceNumber);
         */
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

    public void setCardList(Card card) {
        this.cardList.add(card);
        if (!score.PlayerCards.containsKey(this)) {
            score.PlayerCards.put(this, cardList);
        } else {
            score.PlayerCards.put(this, cardList);
        }

    }

}