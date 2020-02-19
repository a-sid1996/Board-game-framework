package controller;

import java.util.List;

import model.Player;

public class Transaction {

	// This method is called when player has to pay money to the banker
	public void performpayment(Player player1, Player player2, int amount) {

		player1.setBalance(player1.getBalance() - amount);
		player2.setBalance(player2.getBalance() + amount);

	}

	// This method is called when player has to pay certain amount to all other
	// players abased on cards(Somehow need to store all the player Objects
	// Together so that they can be used over here)
	public void performpayment(List<Player> list, Player player, int amount) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) == player) {
				continue;
			} else {
				player.setBalance(player.getBalance() - amount);
				list.get(i).setBalance(list.get(i).getBalance() + amount);
			}

		}

	}
}