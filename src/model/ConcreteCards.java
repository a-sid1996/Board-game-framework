package model;

import java.util.Random;

import controller.GameController;
import model.Card;
import model.Player;

public class ConcreteCards {

	Card card;
	Dice dice;
	GameController gameController;
	public ConcreteCards() 
	{
		card = new Card(12);
		card.setDesc(1, "Move To Go");
		card.setDesc(2, "Bank error in your favor. Collect $125");
		card.setDesc(3, "You have won a CrossWord Competition. Collect $100");
		card.setDesc(4, "You have been elected as the Chairman of the Board. Pay each player $50");
		card.setDesc(5, "Building loan matures. Collect $150 from Bank");
		card.setDesc(6, "Go To Jail. Do not pass Go. Do not collect $100");
		card.setDesc(7, "You inherit $100");
		card.setDesc(8, "Hospital fees. Pay $50");
		card.setDesc(9, "Grand Opera Night. Collect $50 from every player for opening night seats");
		card.setDesc(10, "You are assessed for street repairs. Pay $40 per plot");
		card.setDesc(11, "Go to Jail. Pay $50 to the bank");
		card.setDesc(12, "Advance to go. Collect 200$ from bank");
		
	}
	
	public String pickCard()
	{
		
		String description = card.getDesc();
		return description;
		
	}	
	
	public void cardAction(String description, Player currentPlayer, Player banker, GameController gameController) 
	{
		
	    switch(description) 
	    {
	       case("Move To Go") :
	       {
	    	   gameController.fortification(banker,currentPlayer, 100);
	       }  
	       case("Bank error in your favor. Collect $125") :
	       {
	    	   gameController.fortification(banker,currentPlayer, 125);
	       }
	       case("You have won a CrossWord Competition. Collect $100") :
	       {
	    	   gameController.fortification(banker,currentPlayer, 100);
	       }
	       case("You have been elected as the Chairman of the Board. Pay each player $50") :
	       {
	    	   gameController.fortification(currentPlayer, banker, 50);
	       }
	       case("Building loan matures. Collect $150 from Bank") :
	       {
	    	   gameController.fortification(banker,currentPlayer, 150);
	       }
	       case("Go To Jail. Pay bank $100") :
	       {
	    	   gameController.fortification(currentPlayer, banker, 100);
	       }
	       case("You inherit $100") :
	       {
	    	   gameController.fortification(banker,currentPlayer, 100);
	       }
	       case("Hospital fees. Pay $50") :
	       {
	    	   gameController.fortification(currentPlayer, banker, 50);
	       }
	       case("Grand Opera Night. Collect $50 from every player for opening night seat") :
	       {
	    	   //MultiPlayer Object function remaining
	       }
	       case("You are assessed for street repairs. Pay $40 per plot") :
	       {
	    	   gameController.fortification(currentPlayer, banker, 40);
	       }
	       case("Go to Jail. Pay $50 to the bank") :
	       {
	    	   gameController.fortification(currentPlayer, banker, 50);
	       }
	       case("Advance to go. Collect 200$ from bank") :
	       {
	    	   gameController.fortification(banker,currentPlayer, 200);
	       }     	    
	    }
		
		
		
	}
	
}
