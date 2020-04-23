package controller;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

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

	public SaveAndLoad() {

    }
	
	public SaveAndLoad(Player player, Dice dice, Tile tile, Unit unit, BoardModel boardmodel, Score score,PlayerTurnModule playerturnmodule) 
	{
		super();
		this.player = player;
		this.dice = dice;
		this.tile = tile;
		this.unit = unit;
		this.boardmodel = boardmodel;
		this.score = score;
		this.playerturnmodule =  playerturnmodule;
	 }
	
    public boolean saveGame() 
    {
		JSONObject game = new JSONObject();
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String playerString = gson.toJson(player);
		String diceString = gson.toJson(dice);
		String tileString = gson.toJson(tile);
		String unitString = gson.toJson(unit);
		String boardmodelString = gson.toJson(boardmodel);
		String scoreString = gson.toJson(score);
		String playerturnmoduleString = gson.toJson(playerturnmodule);
	
		game.put("player", playerString);
		game.put("dice", diceString);
		game.put("tile", tileString);
		game.put("unit", unitString);
		game.put("boardmodel", boardmodelString);
		game.put("score", scoreString);
		game.put("PlayerTurnModule",playerturnmoduleString);
	
		String gameString = gson.toJson(game);
	
		try {
		    fileWriter = new FileWriter("riskGame_1.json");
		    fileWriter.write(gameString);
		    fileWriter.flush();
		    return true;
		} catch (IOException e) {
		    e.printStackTrace();
		}
		return false; 
    }
    
    
    public boolean loadGame() 
    {
    	try 
    	{
    		JSONParser parser = new JSONParser();
    	    Gson gson = new Gson();

    	    Object obj = parser.parse(new FileReader("riskGame_1.json"));
    	    JSONObject jsonObject = (JSONObject) obj;
 	    
    	    player = gson.fromJson(String.valueOf(jsonObject.get("player")), Player.class);
    	    dice = gson.fromJson(String.valueOf(jsonObject.get("dice")), Dice.class);
    	    tile = gson.fromJson(String.valueOf(jsonObject.get("tile")), Tile.class);
    	    unit = gson.fromJson(String.valueOf(jsonObject.get("unit")), Unit.class);
    	    boardmodel = gson.fromJson(String.valueOf(jsonObject.get("boardmodel")), BoardModel.class);
    	    score = gson.fromJson(String.valueOf(jsonObject.get("score")), Score.class);
    	    playerturnmodule = gson.fromJson(String.valueOf(jsonObject.get("playerturnmodule")), PlayerTurnModule.class);
    	     
    	}
    	catch (Exception e) 
    	{
    	    e.printStackTrace();
        }
    	return false;
    	
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
    	this.tile= tile;
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
    	this.boardmodel= boardmodel;
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
