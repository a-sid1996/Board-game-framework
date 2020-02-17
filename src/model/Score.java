package model;
import java.util.*;

public class Score 
{
	//This ArrayList stores list of all players
	public ArrayList<Player> PlayerList = new ArrayList<Player>();
	
	//This map stores Player Object and their names
	public HashMap<Player,String> PlayerName = new HashMap<Player,String>();
	
	//This map stores Player Object and their Score
	public  HashMap<Player,Integer> PlayerBalance = new HashMap<Player, Integer>();
	
	//This map stores Player Object and their current position
	public  HashMap<Player,Tile> PlayerCurrentPosition = new HashMap<Player,Tile>();
	
	//This Map stores Player and all the cards he possesses
	public  HashMap<Player, List<Card>> PlayerCards = new HashMap<Player, List<Card>>();	
	
}