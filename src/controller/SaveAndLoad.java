package controller;

import java.io.*;

//import java.util.HashMap;
//
//import org.json.simple.JSONObject;
//import org.json.simple.parser.JSONParser;
//
//import com.google.gson.Gson;
//import com.google.gson.GsonBuilder;

import model.Dice;
import model.Player;
import model.PlayerTurnModule;
import model.Tile;
import model.Unit;
import model.BoardModel;
import model.Score;

/**
 * This class implements functionality of saving the game and load the old game after exiting
 */
public class SaveAndLoad {


    private FileWriter fileWriter;
    Dice dice;
    Player player;
    Tile tile;
    Unit unit;
    BoardModel boardmodel;
    Score score;
    PlayerTurnModule playerturnmodule;

    GameController gameController;

    /**
     * Constructor used while loading the game
     */
    public SaveAndLoad() {

    }

    /**
     * Constructor used while Saving the existing game
     *
     * @param gameController is GameController object
     */
    public SaveAndLoad(GameController gameController) {
        super();
        this.gameController = gameController;
    }

    /**
     * This method gets executed when user wants to save the existing game
     *
     * @param file is any file in which we want to store game object
     * @return boolean whether game is saved or not
     */
    public boolean saveGame(String file) {
        try {
            ObjectOutputStream ow = new ObjectOutputStream(new FileOutputStream(file));
            ow.writeObject(this.gameController);
            ow.close();
        } catch (IOException ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * This method gets executed when user wants to load existing game
     *
     * @param file is any file in which we want to store game object
     * @return GameController object which resumes the game
     * @throws ClassNotFoundException ClassNotFoundException
     * @throws IOException            IOException
     */
    public GameController loadGame(String file) throws IOException, ClassNotFoundException {
        ObjectInputStream oi = new ObjectInputStream(new FileInputStream(file));
        Object obj = oi.readObject();
        GameController gc = (GameController) obj;
        oi.close();
        return gc;
    }

    /**
     * Getter method for Player Object
     *
     * @return Player Object
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * Setter method for Player Object
     *
     * @param player is Player Object
     */
    public void setPlayer(Player player) {
        this.player = player;
    }

    /**
     * Getter method for Dice Object
     *
     * @return Dice Object
     */
    public Dice getDice() {
        return dice;
    }

    /**
     * Setter method for Dice Object
     *
     * @param dice is Dice Object
     */
    public void setDice(Dice dice) {
        this.dice = dice;
    }

    /**
     * Getter method for Tile Object
     *
     * @return Tile Object
     */
    public Tile getTile() {
        return tile;
    }

    /**
     * Setter method for Tile Object
     *
     * @param tile is Tile Object
     */
    public void setTile(Tile tile) {
        this.tile = tile;
    }

    /**
     * Getter method for Unit Object
     *
     * @return Unit Object
     */
    public Unit getUnit() {
        return unit;
    }

    /**
     * Setter method for Unit Object
     *
     * @param unit is Unit Object
     */
    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    /**
     * Getter method for BoardModel Object
     *
     * @return BoardModel Object
     */
    public BoardModel getBoardModel() {
        return boardmodel;
    }

    /**
     * Setter method for BoardModel Object
     *
     * @param boardmodel is Board Model Object
     */
    public void setBoardModel(BoardModel boardmodel) {
        this.boardmodel = boardmodel;
    }

    /**
     * Getter method for Score Object
     *
     * @return Score Object
     */
    public Score getScore() {
        return score;
    }

    /**
     * Setter method for Score Object
     *
     * @param score is Score Object
     */
    public void setScore(Score score) {
        this.score = score;
    }

    /**
     * Getter method for PlayerTurnModule Object
     *
     * @return PlayerTurnModule Object
     */
    public PlayerTurnModule getPlayerTurnModule() {
        return playerturnmodule;
    }

    /**
     * Setter method for Score Object
     *
     * @param playerturnmodule is player turn module Object
     */
    public void setScore(PlayerTurnModule playerturnmodule) {
        this.playerturnmodule = playerturnmodule;
    }


}
