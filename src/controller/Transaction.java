package controller;

import java.util.List;

import model.Player;

public class Transaction {

	// This method is called when player has to pay money to the banker
	public void performpayment(Player player1, Player player2, int amount) {

		player1.setMoney(player1.getMoney() - amount);
		player2.setMoney(player2.getMoney() + amount);

	}

	// This method is called when player has to pay certain amount to all other
	// players abased on cards(Somehow need to store all the player Objects
	// Together so that they can be used over here)
	public void performpayment(List<Player> list, Player player, int amount) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) == player) {
				continue;
			} else {
				player.setMoney(player.getMoney() - amount);
				list.get(i).setMoney(list.get(i).getMoney() + amount);
			}

		}

	}
}