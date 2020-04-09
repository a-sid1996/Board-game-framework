package model;

import java.util.Random;
import model.Card;

public class ConcreteCards {

	Card card;
	Dice dice;
	public ConcreteCards() 
	{
		card = new Card(10);
		card.setDesc(1, "Move To Go");
		card.setDesc(2, "Bank error in your favor. Collect $125");
		card.setDesc(3, "You have won a CrossWord Competition. Collect $100");
		card.setDesc(4, "You have been elected as the Chairman of the Board. Pay each player $50");
		card.setDesc(5, "Building loan matures. Collect $150 from Bank");
		card.setDesc(6, "Go To Jail. Do not pass Go. Do not collect $100");
		card.setDesc(7, "You inherit $100");
		card.setDesc(8, "Hospital fees: Pay $50");
		card.setDesc(9, "Grand Opera Night: Collect $50 from every player for opening night seats");
		card.setDesc(10, "You are assessed for street repairs. Pay $40 per plot");
		
	}
	
	public int pickCard()
	{
		
		dice = new Dice(2);
		int diceNumber  = dice.diceroll(2);
		return diceNumber;
		
	}	
	
	public void cardAction(int diceNumber) 
	{
		
	    switch(diceNumber) 
	    {
	       case(1) :
	       {
	    	   
	       }
	       case(2) :
	       {
	    	   
	       }
	       case(3) :
	       {
	    	   
	       }
	       case(4) :
	       {
	    	   
	       }
	       case(5) :
	       {
	    	   
	       }
	       case(6) :
	       {
	    	   
	       }
	       case(7) :
	       {
	    	   
	       }
	       case(8) :
	       {
	    	   
	       }
	       case(9) :
	       {
	    	   
	       }
	       case(10) :
	       {
	    	   
	       }
	       case(11) :
	       {
	    	   
	       }
	       case(12) :
	       {
	    	   
	       }
	       
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    }
		
		
		
	}
	
}
