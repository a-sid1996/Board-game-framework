package model;

import java.util.HashMap;
import java.util.Random;

/**
 * This is a model class is for card module that defines common functionalities
 * of cards for Board games. of different players
 */
public class Card {

	/**
	 * @param noOfCards   defines specific ID assigned to all cards
	 * @param descOfCards defines description stored in all cards
	 */
	private int noOfCards;
	private HashMap<Integer, String> descOfCards;

	/**
	 * @param 
	 */
	public Card(int num) {
		this.noOfCards = num;
		this.descOfCards = new HashMap<>();
		for(int i=0; i<num; i++) {
			descOfCards.put(i, "Empty");
		}
	}

	public void setDesc(int num, String desc) {
		descOfCards.put(num, desc);
	}

	/**
	 * @return description associated with each picked card
	 */
	public String getDesc() {
		Random random = new Random();
		int rand = random.nextInt(noOfCards);

		return descOfCards.get(rand);

	}

}
