package model;
import java.math.*;

public class Dice
{
	private int number_of_dice;
	Dice(int number_of_dice)
		{
			this.number_of_dice = number_of_dice;
		}	
		public int diceroll(int number_of_dice)
		{
			int diceOutput = (int) Math.random();
			return diceOutput;
	    }			
}
