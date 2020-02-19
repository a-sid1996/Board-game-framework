package model;

import java.util.ArrayList;
import java.util.List;

public class Player {
	/**
	 * @param name        represents player's name
	 * @param currentTile shows tiles that are owned by current player.
	 * @param Balance     represents players possesion or unit. For instance, in
	 *                    monopoly it is money and in Risk it is Army/Troops.
	 * @param score       is an object of Score class.
	 * @param cardList    stores list of cards player posseses.
	 */

	private String name;
	private Tile currentTile;
	private int balance;
	private List<Card> cardList = new ArrayList<Card>();
	
	Score score;


	public Player() {

	}

	/**
	 *@return returns name of the player
	 * 
	 */
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		if (!score.PlayerName.containsKey(this)) {
			score.PlayerName.put(this, name);
		}
	}

	/**
	 *@return returns balance of current player
	 * 
	 */
	public int getBalance() {
		return balance;
	}

	// Setter method to set the balance of the player
	public void setBalance(int balance) {
		this.balance = balance;

		if (!score.PlayerBalance.containsKey(this)) {
			// score.PlayerBalance.put(this, balance);
		} else {
			score.PlayerBalance.put(this, balance);
		}
	}

	/**
	 *@return returns currentTile of current player
	 * 
	 */
	public Tile getCurrentTile() {
		return currentTile;
	}

	// This method updates the location of the player based on the number rolled by
	// him.
	public void updateCurrentTile(int diceNumber, Tile currentTile) {

		this.currentTile = currentTile;

		if (!score.PlayerCurrentPosition.containsKey(this)) {
			score.PlayerCurrentPosition.put(this, currentTile);
		} else {
			score.PlayerCurrentPosition.put(this, currentTile);
		}
	}

	/**
	 *@return returns list of cards possessed by current player
	 * 
	 */
	public List<Card> getCardList() {
		return this.cardList;
	}

	public void setCardList(Card card) {
		this.cardList.add(card);
		if (!score.PlayerCards.containsKey(this)) {
			score.PlayerCards.put(this, cardList);
		} else {
			score.PlayerCards.put(this, cardList);
		}

	}

}