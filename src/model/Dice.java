package model;

public class Dice
{
	private int noOfDice;
	Dice(int noOfDice)
		{
			this.noOfDice = noOfDice;
		}	
		public int diceroll(int noOfDice)
		{
			int diceOutput = (int) Math.random();
			return diceOutput;
	    }			
}
