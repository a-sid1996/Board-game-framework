package model;

import java.util.HashMap;
import java.util.Random;

public class Card {

	private int noOfCards;
	private HashMap<Integer, String> descOfCards;
	
	public Card(int num){
		this.noOfCards = num;
		for(int i=0; i<num; i++) {
			this.descOfCards.put(i, "Empty");
		}
	}
	
	public void setDesc(int num, String desc) {
		descOfCards.put(num, desc);
	}
	
	public String getDesc() {
		Random random = new Random();
		int rand = random.nextInt(noOfCards);
		
		return descOfCards.get(rand);
		
	}
	
}
