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

    public SaveAndLoad() {

    }

    public SaveAndLoad(GameController gameController) {
        super();
        this.gameController = gameController;
    }

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

    public GameController loadGame(String file) throws IOException, ClassNotFoundException {
            ObjectInputStream oi = new ObjectInputStream(new FileInputStream(file));
            Object obj = oi.readObject();
            GameController gc = (GameController) obj;
            oi.close();
            return gc;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    //
    public Dice getDice() {
        return dice;
    }

    public void setDice(Dice dice) {
        this.dice = dice;
    }

    //
    public Tile getTile() {
        return tile;
    }

    public void setTile(Tile tile) {
        this.tile = tile;
    }

    //
    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    //
    public BoardModel getBoardModel() {
        return boardmodel;
    }

    public void setBoardModel(BoardModel boardmodel) {
        this.boardmodel = boardmodel;
    }

    public Score getScore() {
        return score;
    }

    public void setScore(Score score) {
        this.score = score;
    }

    public PlayerTurnModule getPlayerTurnModule() {
        return playerturnmodule;
    }

    public void setScore(PlayerTurnModule playerturnmodule) {
        this.playerturnmodule = playerturnmodule;
    }


}
