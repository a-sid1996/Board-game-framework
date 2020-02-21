package controller;

import java.util.ArrayList;

import model.BoardModel;
import model.Card;
import model.Player;
import model.PlayerTurnModule;
import model.Score;
import model.Unit;

/**
 * This controller class is the main controller of the framework which initializes all model objects and
 */
public class GameController {
    /**
<<<<<<< HEAD
     * list has a list of all the players
     * bc is an object of Board model
     * cm is  an object of Card
     * Score is an object of Score module
     * turn is an object of Player turn module which is of type player
     * units is an object of unit class
=======
     * @param list has a list of all the players
     * @param bc is an object of Board model
     * @param cm is an object of Card
     * @param score is an object of Score module
     * @param turn is an object of Player turn module which is of type player
     * @param units is an object of unit class
>>>>>>> bdcd5e7c53b32f21d78b755f02219a20f1694aa8
     */
    ArrayList<Player> list = new ArrayList<Player>();
    BoardModel bc;
    Card cm;
    GameController gc;
    Score score;
    PlayerTurnModule<Player> turn;
    Unit[] units;

    /**
     * It starts the execution of the startup phase. starts reinforcement phase
     *
     * @param bc    is an object of board model
     * @param cm    is an object of card model
     * @param list  represents list of player objects playing the game
     * @param turn  represents current turn of the player and he will roll the dice
     * @param units are total units used in game
     */
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

    /**
     * It starts the execution of reinforcement phase.
     * Most common reinforcement strategy in all board game is the distribution of units equally among players
     *
     * @param bc    is an object of board model
     * @param cm    is an object of card model
     * @param list  represents list of player objects playing the game
     * @param turn  represents current turn of the player and he will roll the dice
     * @param units are total units used in game
     */
    private void reinforcement(ArrayList<Player> list, Unit[] units) {
        // TODO Auto-generated method stub
        for (Player player : list) {
            for (Unit u : units) {
                player.setAsset(new Unit(u.getUnitType(), u.getAmount() / list.size()));
                /*if (u.getUnitType().equalsIgnoreCase(Unit.UnitType.MONEY.toString())) {
                    break;
                }*/
            }
        }
    }

    /**
     * It starts the execution of fortification phase.
     * Most common fortification strategy in all board game is passing of assets between players according to the rules of the game.
     *
     * @param player1 is a player who is giving an  asset
     * @param player2 is a player who is receiving an asset
     * @param amount  is the money to be transferred between players
     * @return true: if fortification was successful. false otherwise.
     */
    public boolean fortification(Player player1, Player player2, int amount) {
        boolean isMoneyDeductedFromPlayer1 = player1.deductMoney(amount);
        if (isMoneyDeductedFromPlayer1) {
            return player2.addMoney(amount);
        }
        return false;
    }
}

/*Dummy function for future build
	public void performpayment(List<Player> list, Player player, int amount)
	{
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) == player) {
				continue;
			} else {
				player.setMoney(player.getMoney() - amount);
				list.get(i).setMoney(list.get(i).getMoney() + amount);
			}

		}

	}*/