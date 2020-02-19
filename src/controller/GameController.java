package controller;

import java.util.ArrayList;

import model.BoardModel;
import model.Card;
import model.Player;
import model.PlayerTurnModule;
import model.Score;
import model.Unit;

public class GameController {
	ArrayList<Player> list = new ArrayList<Player>();
	BoardModel bc;
	Card cm;
	GameController gc;
	Score score;
	PlayerTurnModule<Player> turn;
	Unit[] units;

	public GameController(BoardModel bc, Card cm, ArrayList<Player> list, Score score,
			PlayerTurnModule<Player> turn, Unit[] units) {
		// TODO Auto-generated constructor stub
		this.bc = bc;
		this.cm = cm;
		this.list = list;
		this.score = score;
		this.turn = turn;
		this.units = units;
				
		fortification(list, units);
		
	}

	private void reinforcement() {
		// TODO Auto-generated method stub
		
	}

	private void fortification(ArrayList<Player> list, Unit[] units) {
		// TODO Auto-generated method stub
		for(Player player : list) {
			for(Unit u : units) {
				if(u.getName().equalsIgnoreCase("money")) {
					Unit unit = u;
					u.setAmount((int)(u.getAmount()/list.size()));
					player.setBalance(unit);
				}
			}
		}
	}

}
