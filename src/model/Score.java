package model;

import java.util.*;

/**
 * This is a model class for score module that stores different score parameters
 * of different players
 */
public class Score {

    /**
     * @param playerList            Stores list of all players
     * @param playerName            Stores player object with its name
     * @param playerBalance         stores players with their respective balance
     * @param PlayerCurrentPosition stores player and their current respective position
     * @param PlayerCards           stores player and list of cards they posses
     */

    public ArrayList<Player> PlayerList = new ArrayList<Player>();
    public HashMap<Player, String> PlayerName = new HashMap<Player, String>();
    public HashMap<Player, ArrayList<Unit>> PlayerBalance = new HashMap<Player, ArrayList<Unit>>();
    public HashMap<Player, ArrayList<Tile>> PlayerCurrentPosition = new HashMap<Player, ArrayList<Tile>>();
    public HashMap<Player, List<Card>> PlayerCards = new HashMap<Player, List<Card>>();
    
    

}