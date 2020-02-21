package controller;

import java.util.ArrayList;
import java.util.List;

import model.BoardModel;
import model.Card;
import model.Player;
import model.PlayerTurnModule;
import model.Score;
import model.Unit;

/**
 * This controller class is the main controller of the framework which initializes all model objects and  
 * 
 * */
public class GameController {
	/**
	 * list has a list of all the players
	 * bc is an object of Board model
	 * cm is  an object of Card
	 * socre is an object of Score module
	 * turn is an object of Player turn module which is of type player
	 * units is an object of unit class
	 */
	ArrayList<Player> list = new ArrayList<Player>();
	BoardModel bc;
	Card cm;
	GameController gc;
	Score score;
	PlayerTurnModule<Player> turn;
	Unit[] units;

	public GameController(BoardModel bc, Card cm, ArrayList<Player> list, Score score, PlayerTurnModule<Player> turn,
			Unit[] units) {
		// TODO Auto-generated constructor stub
		this.bc = bc;
		this.cm = cm;
		this.list = list;
		this.score = score;
		this.turn = turn;
		this.units = units;

		reinforcement(list, units);

		for (Player play : list) {
			System.out.println(play.getName() + ": " + play.getMoney());
		}

	}

	private void reinforcement(ArrayList<Player> list, Unit[] units) {
		// TODO Auto-generated method stub
		for (Player player : list) {
			for (Unit u : units) {
				if (u.getName().equalsIgnoreCase("money")) {
					player.setMoney((int) (u.getAmount() / list.size()));
					break;
				}
			}
		}
	}

	private void fortification(Player player1, Player player2, int amount) 
	{
			if (player1.getMoney() > amount && player1.getMoney() > 0 && amount > 0) 
			{
				player1.setMoney(player1.getMoney() - amount);
				player2.setMoney(player2.getMoney() + amount);
			}
	}
		
}



//Dummy function for future build 
//	public void performpayment(List<Player> list, Player player, int amount) 
//	{
//		for (int i = 0; i < list.size(); i++) {
//			if (list.get(i) == player) {
//				continue;
//			} else {
//				player.setMoney(player.getMoney() - amount);
//				list.get(i).setMoney(list.get(i).getMoney() + amount);
//			}
//
//		}
//
//	}


