package model;

import java.math.*;
import java.util.Random;

/**
 * This is a model class for score module that stores different score parameters
 * of different players
 */
public class Dice {
    private int noOfDice;

    Dice(int noOfDice) {
        this.noOfDice = noOfDice;
    }

    /**
     * @param noOfDice displays total numbers of dice user need for their game
     * @return Method returns random numbers between 1 and appropriate number as per
     * noOfDice added
     */
    public static int[] diceroll(int noOfDice) {
        Random rand = new Random();
        int[] result = new int[noOfDice];
        for (int i = 0; i < noOfDice; i++) {
            result[i] = rand.nextInt(5) + 1;
        }
        return result;
    }
}

