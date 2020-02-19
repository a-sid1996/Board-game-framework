package model;

import java.util.ArrayList;
import java.util.List;

public class Player {

	    // Key attribute which holds the name of the player
		private String name;

		// key attribute which holds the current location of the player that is set to 1
		// initially.
		private Tile currentTile;

		// key attribute which holds the balance of the player that is set to 1500$ initially.=
		private int balance;

		// Object of Score class
		Score score ;
		
		//Object of Card
		/** Card List */
		private List<Card> cardList = new ArrayList<Card>();
		
		public Player() 
		{
		
		}

		// Getter method to get the name of the player
		public String getName() {
			return name;
		}
		
		public void setName(String name) {
			this.name = name;
			if (!score.PlayerName.containsKey(this)) {
				score.PlayerName.put(this, name);
			}
		}
		
		// Getter method to get the balance of the player
		public int getBalance() {
			return balance;
		}

		// Setter method to set the balance of the player
		public void setBalance(int balance) 
		{
			this.balance = balance;
			
			if (!score.PlayerBalance.containsKey(this)) 
			{
			//	score.PlayerBalance.put(this, balance);
			} else 
			{
				score.PlayerBalance.put(this,balance);
			}
		}
		
		// Getter method to get the current tile location of the player
		public Tile getCurrentTile() {
			return currentTile;
		}

		// This method updates the location of the player based on the number rolled by
		// him.
		public void updateCurrentTile(int diceNumber, Tile currentTile)
		{
			
			this.currentTile = currentTile;

			if (!score.PlayerCurrentPosition.containsKey(this)) {
				score.PlayerCurrentPosition.put(this,currentTile);
			} else {
				score.PlayerCurrentPosition.put(this,currentTile);
			}
		}
		
		public List<Card> getCardList() {
			return this.cardList;
		}

		public void setCardList(Card card) 
		{			
			this.cardList.add(card);
			if(!score.PlayerCards.containsKey(this))
			{
				score.PlayerCards.put(this,cardList);
			}
			else
			{
				score.PlayerCards.put(this,cardList);
			}
			
			
		}
		
		
	
}