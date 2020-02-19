package model;

import java.math.*;
import java.util.Random;

/**
 * This is a model class for score module that stores different score parameters
 * of different players
 */
public class Dice {

	private int number_of_dice;

	Dice(int number_of_dice) {
		this.number_of_dice = number_of_dice;
	}

	/**
	 * @param number_of_dice displays total numbers of dice user need for their game
	 * @return Method returns random numbers between 1 and appropriate number as per
	 *         number_of_dice added
	 */
	public int diceroll(int number_of_dice) {
		Random rand = new Random();
		int sum = 0;
		for (int i = 0; i < number_of_dice; i++) {
			int diceOutput = rand.nextInt(5) + 1;
			sum = +diceOutput;
		}
		return sum;
	}
}
